package us.ihmc.pubsub.test;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.Future;

import org.junit.jupiter.api.Test;

import com.eprosima.xmlschemas.fastrtps_profiles.DurabilityQosKindType;
import com.eprosima.xmlschemas.fastrtps_profiles.HistoryQosKindType;
import com.eprosima.xmlschemas.fastrtps_profiles.PublishModeQosKindType;
import com.eprosima.xmlschemas.fastrtps_profiles.ReliabilityQosKindType;

import us.ihmc.commons.thread.ThreadTools;
import us.ihmc.idl.generated.test.BigMessage;
import us.ihmc.idl.generated.test.BigMessagePubSubType;
import us.ihmc.idl.generated.test.IDLSubmessage;
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
 *  Start a subscriber and 5 publisher threads, each sending 20 messages with up to 100,000 longs.
 *
 *  Assert that IndexOutOfBoundsException exceptions do not occur in any threads.
 */
public class IntraprocessLargeCopyTest
{
   //   @Disabled // not working, no output, not sure why
   @Test // timeout = 300000
   public void testRepeatedLargeCopiesInFastRTPSCallbacks() throws IOException, InterruptedException
   {
      Random random = new Random(981239012380L);

      PubSubImplementation impl = PubSubImplementation.FAST_RTPS;

      performCopyTest(random, impl);
   }

   @Test // timeout = 300000
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
      Domain domain = DomainFactory.getDomain(impl);
      try
      {

         System.setErr(new PrintStream(byteArrayOutputStream));

         // start subscriber in separate thread
         createSubscriber(domain);

         // start 5 publisher threads
         ArrayList<Thread> threads = new ArrayList<>();
         for (int i = 0; i < 5; i++)
         {
            Thread publisherThread = new Thread(() ->
            {
               try
               {
                  Publisher publisher = createPublisher(domain);
                  publishABunch(publisher, random);
               }
               catch (IOException e)
               {
                  e.printStackTrace();
               }
            }, "PublisherThread");
            publisherThread.start();
            threads.add(publisherThread);
         }

         // join with all of the publisher threads
         threads.stream().forEach(thread ->
         {
            try
            {
               thread.join();
            }
            catch (InterruptedException e)
            {
               e.printStackTrace();
            }
         });

         // join with the subscriber thread

         // wait for things to happen
         ThreadTools.sleep(5000);

         System.err.flush();

         System.setErr(systemErr);

         System.err.println(byteArrayOutputStream.toString());

         // this captures the output of the program to make sure bad threading exceptions didn't happen
         assertFalse(byteArrayOutputStream.toString().contains("IndexOutOfBoundsException"), "Standard error contains java.lang.IndexOutOfBoundsException");

      }
      finally
      {
         // Tear down everything
         domain.stopAll();
      }

   }

   private ParticipantAttributes createParticipantAttributes(String name) throws UnknownHostException
   {
      return ParticipantAttributes.create().domainId(215).discoveryLeaseDuration(Time.Infinite).name(name)
                                  .useOnlySharedMemoryTransport();
   }

   /**
    * Do everything in the thread in a single function so we can shutdown the domain afterwards
    * 
    * @param impl
    * @param random
    * @throws IOException
    */
   private Publisher createPublisher(Domain domain) throws IOException
   {

      domain.setLogLevel(LogLevel.ERROR);

      ParticipantAttributes attributes = createParticipantAttributes("StatusTest");

      Participant participant = domain.createParticipant(attributes, new ParticipantListenerImpl());

      BigMessagePubSubType dataType = new BigMessagePubSubType();
      domain.registerType(participant, dataType);

      PublisherAttributes genericPublisherAttributes = PublisherAttributes.create().topicDataType(dataType).topicName("Status")
                                                                          .reliabilityKind(ReliabilityQosKindType.RELIABLE)
                                                                          .partitions(Collections.singletonList("us/ihmc"))
                                                                          .durabilityKind(DurabilityQosKindType.VOLATILE)
                                                                          .historyQosPolicyKind(HistoryQosKindType.KEEP_LAST).historyDepth(10);

      return domain.createPublisher(participant, genericPublisherAttributes, new PublisherListenerImpl());

   }

   private void createSubscriber(Domain domain) throws IOException
   {

      domain.setLogLevel(LogLevel.ERROR);

      ParticipantAttributes attributes = createParticipantAttributes("StatusTest");
      Participant participant = domain.createParticipant(attributes, new ParticipantListenerImpl());

      BigMessagePubSubType dataType = new BigMessagePubSubType();
      domain.registerType(participant, dataType);

      BigMessagePubSubType dataType2 = new BigMessagePubSubType();

      SubscriberAttributes subscriberAttributes = SubscriberAttributes.create().topicDataType(dataType2).topicName("Status")
                                                                      .reliabilityKind(ReliabilityQosKindType.RELIABLE)
                                                                      .partitions(Collections.singletonList("us/ihmc"))
                                                                      .durabilityKind(DurabilityQosKindType.VOLATILE)
                                                                      .historyQosPolicyKind(HistoryQosKindType.KEEP_ALL);

      domain.createSubscriber(participant, subscriberAttributes, new SubscriberListenerImpl());

   }

   private void publishABunch(Publisher publisher, Random random) throws IOException
   {
      int i = 0;
      // send 20 messages
      for (; i < 20; i++)
      {
         BigMessage msg = new BigMessage();
         IDLSubmessage idlSubmessage = new IDLSubmessage();

         // pack each message to a random size up to 100000
         int randomSize = random.nextInt(100000);
         //         System.out.println("Random: " + randomSize);
         for (int j = 0; j < randomSize; j++)
         {
            idlSubmessage.setHello(i + j); // set the values to all be different
            msg.getLargeSequence().add().set(idlSubmessage);
         }
         //         try
         {
            publisher.write(msg);

            //            System.out.println("Publishing: " + i);
            //            Thread.sleep(1000);
         }
         //         catch (InterruptedException e)
         {
         }
      }
   }

   private class SubscriberListenerImpl implements SubscriberListener
   {
      private final BigMessage data = new BigMessage();
      private final SampleInfo info = new SampleInfo();
      int i = 0;

      @Override
      public void onNewDataMessage(Subscriber subscriber)
      {
         if (subscriber.takeNextData(data, info))
         {
            // wait 100 ms
            try
            {
               Thread.sleep(100);
            }
            catch (InterruptedException e)
            {
               e.printStackTrace();
            }

            // try copying the message to break threading
            BigMessage copied = new BigMessage();
            copied.set(data);
            System.out.println("Received: " + i++ + " Copied size: " + copied.getLargeSequence().size());
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
