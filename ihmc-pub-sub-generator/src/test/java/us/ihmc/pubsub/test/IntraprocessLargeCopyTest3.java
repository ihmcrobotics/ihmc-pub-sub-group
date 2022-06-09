package us.ihmc.pubsub.test;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Collections;
import java.util.Random;

import org.gradle.internal.impldep.org.apache.commons.lang.mutable.MutableInt;
import org.junit.jupiter.api.Test;

import com.eprosima.xmlschemas.fastrtps_profiles.DurabilityQosKindType;
import com.eprosima.xmlschemas.fastrtps_profiles.HistoryQosKindType;
import com.eprosima.xmlschemas.fastrtps_profiles.PublishModeQosKindType;
import com.eprosima.xmlschemas.fastrtps_profiles.ReliabilityQosKindType;

import us.ihmc.idl.generated.test.BigMessage;
import us.ihmc.idl.generated.test.BigMessagePubSubType;
import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.DomainFactory;
import us.ihmc.pubsub.DomainFactory.PubSubImplementation;
import us.ihmc.pubsub.attributes.ParticipantAttributes;
import us.ihmc.pubsub.attributes.PublisherAttributes;
import us.ihmc.pubsub.attributes.SubscriberAttributes;
import us.ihmc.pubsub.common.LogLevel;
import us.ihmc.pubsub.common.MatchingInfo;
import us.ihmc.pubsub.common.SampleInfo;
import us.ihmc.pubsub.common.Time;
import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.participant.ParticipantDiscoveryInfo;
import us.ihmc.pubsub.participant.ParticipantListener;
import us.ihmc.pubsub.publisher.Publisher;
import us.ihmc.pubsub.publisher.PublisherListener;
import us.ihmc.pubsub.subscriber.Subscriber;
import us.ihmc.pubsub.subscriber.SubscriberListener;

/**
 * This test makes sure intraprocess doesn't have threading issues.
 *
 * Create a publisher and subscriber in this thread and send 80 messages with up to 100,000 longs.
 *
 * This one sends and expects to receive 80 messages while asserting no IndexOutOfBounds exceptions.
 *
 * i.e. asserts single thread executor
 *
 * @author Duncan Calvert
 */
public class IntraprocessLargeCopyTest3
{
   private static final int NUMBER_OF_MESSAGES_TO_SEND = 80;

   @Test// timeout = 30000
   public void testRepeatedLargeCopiesInFastRTPSCallbacks() throws IOException, InterruptedException
   {
      Random random = new Random(981239012380L);

      PubSubImplementation impl = PubSubImplementation.FAST_RTPS;
      
      performCopyTest(random, impl);
   }
   
   @Test// timeout = 30000
   public void testRepeatedLargeCopiesInIntraprocessCallbacks() throws IOException, InterruptedException
   {
      Random random = new Random(981239012380L);

      PubSubImplementation impl = PubSubImplementation.INTRAPROCESS;
      
      performCopyTest(random, impl);
   }

   private void performCopyTest(Random random, PubSubImplementation impl) throws InterruptedException, IOException
   {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

      PrintStream systemErr = System.err;

      System.setErr(new PrintStream(byteArrayOutputStream));

      MutableInt messagesReceived = new MutableInt(0);
      Subscriber subscriber = createSubscriber(impl, messagesReceived);

      Publisher publisher = createPublisher(impl);
      publishABunch(publisher, random);

      System.err.flush();

      System.setErr(systemErr);
      
      System.err.println(byteArrayOutputStream.toString());

      assertFalse(byteArrayOutputStream.toString().contains("IndexOutOfBoundsException"),
                                                   "Standard error contains java.lang.IndexOutOfBoundsException");

      while (messagesReceived.toInteger() < NUMBER_OF_MESSAGES_TO_SEND - 5)
      {
         Thread.yield();
      }
   }

   private Publisher createPublisher(PubSubImplementation impl) throws IOException
   {
      Domain domain = DomainFactory.getDomain(impl);

      domain.setLogLevel(LogLevel.INFO);

      ParticipantAttributes attributes = ParticipantAttributes.create()
        .domainId(215)
        .discoveryLeaseDuration(Time.Infinite)
        .name("StatusTest");

      Participant participant = domain.createParticipant(attributes, new ParticipantListenerImpl());

      BigMessagePubSubType dataType = new BigMessagePubSubType();
      domain.registerType(participant, dataType);

      PublisherAttributes genericPublisherAttributes = PublisherAttributes.create()
       .topicDataType(dataType)
       .topicName("Status")
       .reliabilityKind(ReliabilityQosKindType.RELIABLE)
       .partitions(Collections.singletonList("us/ihmc"))
       .durabilityKind(impl == PubSubImplementation.INTRAPROCESS ?
                             DurabilityQosKindType.VOLATILE
                             : DurabilityQosKindType.TRANSIENT_LOCAL)
       .historyQosPolicyKind(HistoryQosKindType.KEEP_ALL)
       .historyDepth(10) // does nothing unless keep_last
       .publishModeKind(PublishModeQosKindType.ASYNCHRONOUS);

      return domain.createPublisher(participant, genericPublisherAttributes, new PublisherListenerImpl());
   }

   private Subscriber createSubscriber(PubSubImplementation impl, MutableInt messagesReceived) throws IOException
   {
      Domain domain = DomainFactory.getDomain(impl);

      domain.setLogLevel(LogLevel.INFO);

      ParticipantAttributes attributes = ParticipantAttributes.create()
        .domainId(215)
        .discoveryLeaseDuration(Time.Infinite)
        .name("StatusTest");
      Participant participant = domain.createParticipant(attributes, new ParticipantListenerImpl());

      BigMessagePubSubType dataType = new BigMessagePubSubType();
      domain.registerType(participant, dataType);

      BigMessagePubSubType dataType2 = new BigMessagePubSubType();

      SubscriberAttributes subscriberAttributes = SubscriberAttributes.create()
       .topicDataType(dataType2)
       .topicName("Status")
       .reliabilityKind(ReliabilityQosKindType.RELIABLE)
       .partitions(Collections.singletonList("us/ihmc"))
       .durabilityKind(impl == PubSubImplementation.INTRAPROCESS ?
                             DurabilityQosKindType.VOLATILE
                             : DurabilityQosKindType.TRANSIENT_LOCAL)
       .historyQosPolicyKind(HistoryQosKindType.KEEP_ALL);

      return domain.createSubscriber(participant, subscriberAttributes, new SubscriberListenerImpl(messagesReceived));
   }

   private void publishABunch(Publisher publisher, Random random) throws IOException
   {
      for (int i = 0; i < NUMBER_OF_MESSAGES_TO_SEND; i++)
      {
         BigMessage bigMessage = new BigMessage();
         int randomSize = random.nextInt(100000); // randomly fill to the initial size declared in the .msg

         bigMessage.setId(i);
         for (int j = 0; j < randomSize; j++)
         {
            bigMessage.getLargeSequence().add().setHello(i + j);
         }
         
         publisher.write(bigMessage);
         System.out.println("write " + i);
         
         Thread.yield(); // does nothing?
      }
   }

   private class SubscriberListenerImpl implements SubscriberListener
   {
      private final BigMessage data = new BigMessage();
      private final SampleInfo info = new SampleInfo();
      private final MutableInt messagesReceived;
      int i = 0;

      public SubscriberListenerImpl(MutableInt messagesReceived)
      {
         this.messagesReceived = messagesReceived;
      }
      
      @Override
      public void onNewDataMessage(Subscriber subscriber)
      {
         if (subscriber.takeNextData(data, info))
         {
            try
            {
               Thread.sleep(100);
            }
            catch (InterruptedException e)
            {
               e.printStackTrace();
            }
            BigMessage copied = new BigMessage();
            copied.set(data);
            System.out.println("Received: " + i++ + " Copied id: " + copied.getId() + " size: " + copied.getLargeSequence().size());
            messagesReceived.add(1);
         }
      }

      @Override
      public void onSubscriptionMatched(Subscriber subscriber, MatchingInfo info)
      {
         System.out.println("New publisher matched");
         System.out.println("Status: " + info.getStatus());
         System.out.println("Guid: " + info.getGuid().toString());
      }
   }

   private class ParticipantListenerImpl implements ParticipantListener
   {
      @Override
      public void onParticipantDiscovery(Participant participant, ParticipantDiscoveryInfo info)
      {
         System.out.println("New participant discovered");
         System.out.println("Status: " + info.getStatus());
         System.out.println("Guid: " + info.getGuid().toString());
         System.out.println("Name: " + info.getName());
      }
   }

   private class PublisherListenerImpl implements PublisherListener
   {
      @Override
      public void onPublicationMatched(Publisher publisher, MatchingInfo info)
      {
         System.out.println("New subscriber matched");
         System.out.println("Status: " + info.getStatus());
         System.out.println("Guid: " + info.getGuid().toString());
      }
   }
}
