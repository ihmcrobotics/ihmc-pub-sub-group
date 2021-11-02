package us.ihmc.pubsub.test;

import org.junit.jupiter.api.Test;
import us.ihmc.idl.generated.chat.ChatMessage;
import us.ihmc.idl.generated.chat.ChatMessagePubSubType;
import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.DomainFactory;
import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.*;
import us.ihmc.pubsub.common.MatchingInfo;
import us.ihmc.pubsub.common.Time;
import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.publisher.Publisher;
import us.ihmc.pubsub.subscriber.Subscriber;
import us.ihmc.pubsub.subscriber.SubscriberListener;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleParticipantsInSameProcessTest {



    private class SubscriberListenerImpl implements SubscriberListener
    {
        AtomicInteger counter;
        public SubscriberListenerImpl(AtomicInteger counter){
            this.counter = counter;
        }

        @Override
        public void onNewDataMessage(Subscriber subscriber)
        {
            ChatMessage chatMessage = (ChatMessage)subscriber.takeNextData();
            assertEquals(Integer.parseInt(chatMessage.getMsgAsString()), this.counter.getAndIncrement());
        }

        @Override
        public void onSubscriptionMatched(Subscriber subscriber, MatchingInfo info) {

        }
    }

    @Test
    public void TestMulitpleParticipantsInSameProcess() throws IOException, InterruptedException {
        AtomicInteger counter = new AtomicInteger(0);

        Domain domain = DomainFactory.getDomain(DomainFactory.PubSubImplementation.FAST_RTPS);

        TopicDataType topicDataType = new ChatMessagePubSubType();

        GenericPublisherAttributes genericPublisherAttributes = GenericPublisherAttributes.builder()
                .topicDataType(topicDataType)
                .topicName("Status")
                .reliabilityKind(ReliabilityKind.RELIABLE)
                .partitions(Collections.singletonList("us/ihmc"))
                .durabilityKind(DurabilityKind.TRANSIENT_LOCAL_DURABILITY_QOS)
                .historyQosPolicyKind(HistoryQosPolicy.HistoryQosPolicyKind.KEEP_LAST_HISTORY_QOS)
                .historyDepth(10)
                .publishModeKind(PublishModeKind.ASYNCHRONOUS_PUBLISH_MODE)
                .build();

        GenericSubscriberAttributes genericSubscriberAttributes = GenericSubscriberAttributes.builder()
                .topicDataType(topicDataType)
                .topicName("Status")
                .reliabilityKind(ReliabilityKind.RELIABLE)
                .partitions(Collections.singletonList("us/ihmc"))
                .durabilityKind(DurabilityKind.TRANSIENT_LOCAL_DURABILITY_QOS)
                .historyQosPolicyKind(HistoryQosPolicy.HistoryQosPolicyKind.KEEP_ALL_HISTORY_QOS)
                .build();

        List<Participant> participants = IntStream.rangeClosed(1,100)
                .mapToObj(i -> GenericParticipantAttributes.builder()
                        .domainId(215)
                        .discoveryLeaseDuration(Time.Infinite)
                        .name("StatusTest"+i)
                        .build())
                .map(attrs -> {
                    try {
                        return domain.createParticipant(attrs);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                }).filter(Objects::nonNull).collect(Collectors.toList());

        List<Publisher> publishers = participants.stream().map(p -> {
            try {
                return domain.createPublisher(p, genericPublisherAttributes, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }).filter(Objects::nonNull).collect(Collectors.toList());


        Subscriber subscriber = domain.createSubscriber(participants.get(0), genericSubscriberAttributes, new SubscriberListenerImpl(counter));


        //publish one message from each publisher in each participant
        Thread t = new Thread(() -> {
            AtomicInteger msgCounter = new AtomicInteger();
            publishers.forEach(p -> {
                try {
                    ChatMessage msg = new ChatMessage();
                    msg.setMsg(""+msgCounter.get());
                    p.write(msg);
                    Thread.sleep(1L); // Sleep a bit so FastDDS can deliver the message.
                    msgCounter.incrementAndGet();
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });
        t.start();
        t.join();

        assertEquals(100, counter.get());

        participants.forEach(domain::removeParticipant);
    }
}
