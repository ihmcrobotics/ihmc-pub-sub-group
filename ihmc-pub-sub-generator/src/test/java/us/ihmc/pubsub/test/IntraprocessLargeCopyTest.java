package us.ihmc.pubsub.test;

import org.junit.Test;
import us.ihmc.idl.generated.test.BigMessage;
import us.ihmc.idl.generated.test.BigMessagePubSubType;
import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.DomainFactory;
import us.ihmc.pubsub.DomainFactory.PubSubImplementation;
import us.ihmc.pubsub.attributes.*;
import us.ihmc.pubsub.attributes.HistoryQosPolicy.HistoryQosPolicyKind;
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

import java.io.IOException;
import java.util.Random;

public class IntraprocessLargeCopyTest
{

   public static final PubSubImplementation IMPL = PubSubImplementation.INTRAPROCESS;

   @Test(timeout = 300000)
   public void testRepeatedLargeCopiesInIntraprocessCallbacks() throws IOException, InterruptedException
   {
      Random random = new Random(981239012380L);


//      createSubscriber();

      Thread subscriberThread = new Thread(() -> {
         try
         {
            createSubscriber();
         }
         catch (IOException e)
         {
            e.printStackTrace();
         }
      }, "SubscriberThread");
      subscriberThread.start();


      Publisher publisher = createPublisher();
      publishABunch(publisher, random);

      subscriberThread.join();
//
//      ArrayList<Thread> threads = new ArrayList<>();
//      for (int i = 0; i < 5; i++)
//      {
//         Thread publisherThread = new Thread(() -> {
//            try
//            {
//               Publisher publisher = createPublisher();
//               publishABunch(publisher, random);
//            }
//            catch (IOException e)
//            {
//               e.printStackTrace();
//            }
//         }, "PublisherThread");
//         publisherThread.start();
//         threads.add(publisherThread);
//      }
//      threads.stream().forEach(thread -> {
//         try
//         {
//            thread.join();
//         }
//         catch (InterruptedException e)
//         {
//            e.printStackTrace();
//         }
//      });
//
//      subscriberThread.join();
   }

   private Publisher createPublisher() throws IOException
   {
      Domain domain = DomainFactory.getDomain(IMPL);

      domain.setLogLevel(LogLevel.ERROR);

      ParticipantAttributes attributes = domain.createParticipantAttributes();
      attributes.setDomainId(1);
      attributes.setLeaseDuration(Time.Infinite);
      attributes.setName("StatusTest");

      Participant participant = domain.createParticipant(attributes, new ParticipantListenerImpl());

      BigMessagePubSubType dataType = new BigMessagePubSubType();
      domain.registerType(participant, dataType);

      PublisherAttributes publisherAttributes = domain.createPublisherAttributes(participant, dataType, "Status", ReliabilityKind.RELIABLE, "us/ihmc");
      if (IMPL == PubSubImplementation.INTRAPROCESS)
      publisherAttributes.getQos().setDurabilityKind(DurabilityKind.VOLATILE_DURABILITY_QOS);
      else
      publisherAttributes.getQos().setDurabilityKind(DurabilityKind.TRANSIENT_LOCAL_DURABILITY_QOS);
      publisherAttributes.getTopic().getHistoryQos().setKind(HistoryQosPolicyKind.KEEP_LAST_HISTORY_QOS);
      publisherAttributes.getTopic().getHistoryQos().setDepth(10);
      publisherAttributes.getQos().setPublishMode(PublishModeKind.ASYNCHRONOUS_PUBLISH_MODE);

      return domain.createPublisher(participant, publisherAttributes, new PublisherListenerImpl());
   }

   private Subscriber createSubscriber() throws IOException
   {
      Domain domain = DomainFactory.getDomain(IMPL);

      domain.setLogLevel(LogLevel.ERROR);

      ParticipantAttributes attributes = domain.createParticipantAttributes();
      attributes.setDomainId(1);
      attributes.setLeaseDuration(Time.Infinite);
      attributes.setName("StatusTest");

      Participant participant = domain.createParticipant(attributes, new ParticipantListenerImpl());

      BigMessagePubSubType dataType = new BigMessagePubSubType();
      domain.registerType(participant, dataType);

      BigMessagePubSubType dataType2 = new BigMessagePubSubType();

      SubscriberAttributes subscriberAttributes = domain.createSubscriberAttributes(participant, dataType2, "Status", ReliabilityKind.RELIABLE, "us/ihmc");
      subscriberAttributes.getQos().setDurabilityKind(DurabilityKind.TRANSIENT_LOCAL_DURABILITY_QOS);
      subscriberAttributes.getTopic().getHistoryQos().setKind(HistoryQosPolicyKind.KEEP_ALL_HISTORY_QOS);

      return domain.createSubscriber(participant, subscriberAttributes, new SubscriberListenerImpl());
   }

   private void publishABunch(Publisher publisher, Random random) throws IOException
   {
      int i = 0;
<<<<<<< Updated upstream
      for (; i < 100; i++)
=======
      for (; i < 1000; i++)
>>>>>>> Stashed changes
      {
         BigMessage msg = new BigMessage();
         int i1 = random.nextInt(msg.getLargeSequence().capacity());
//         System.out.println("Random: " + i1);
         for (int j = 0; j < i1; j++)
         {
            msg.getLargeSequence().add(j);
         }
         publisher.write(msg);

         System.out.println("Publishing: " + i);
         try
         {
            Thread.sleep(10);
         }
         catch (InterruptedException e)
         {
            e.printStackTrace();
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
