package us.ihmc.rtps.example;

import java.io.IOException;
import java.nio.ByteOrder;
import java.util.Arrays;

import us.ihmc.rtps.Domain;
import us.ihmc.rtps.DomainFactory;
import us.ihmc.rtps.DomainFactory.PubSubImplementation;
import us.ihmc.rtps.attributes.ParticipantAttributes;
import us.ihmc.rtps.attributes.SubscriberAttributes;
import us.ihmc.rtps.attributes.TopicAttributes.TopicKind;
import us.ihmc.rtps.common.LogLevel;
import us.ihmc.rtps.common.MatchingInfo;
import us.ihmc.rtps.common.SampleInfo;
import us.ihmc.rtps.common.Time;
import us.ihmc.rtps.participant.Participant;
import us.ihmc.rtps.participant.ParticipantDiscoveryInfo;
import us.ihmc.rtps.participant.ParticipantListener;
import us.ihmc.rtps.subscriber.Subscriber;
import us.ihmc.rtps.subscriber.SubscriberListener;

public class SubscriberExample
{
   
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
   
   private class SubscriberListenerImpl implements SubscriberListener
   {
      private final byte[] data = new byte[500];
      private final SampleInfo info = new SampleInfo();
      
      @Override
      public void onNewDataMessage(Subscriber subscriber)
      {
         try
         {
            if(subscriber.takeNextData(data, info))
            {
//               System.out.println(Arrays.toString(data));
            }
         }
         catch (IOException e)
         {
            e.printStackTrace();
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
   
   public SubscriberExample() throws IOException
   {
      Domain domain = DomainFactory.getDomain(PubSubImplementation.FAST_RTPS);
      
      domain.setLogLevel(LogLevel.WARNING);

      ParticipantAttributes<?> attributes = domain.createParticipantAttributes();
      attributes.setDomainId(1);
      attributes.setLeaseDuration(Time.Infinite);
      attributes.setName("SubscriberExample");

      
      
      Participant participant = domain.createParticipant(attributes, new ParticipantListenerImpl());
      
      ByteArrayTopicDataType dataType = new ByteArrayTopicDataType(500, "Chat::ChatMessage", ByteOrder.nativeOrder());
      domain.registerType(participant, dataType);
      
      
      SubscriberAttributes<?, ?, ?> subscriberAttributes = domain.createSubscriberAttributes();
      subscriberAttributes.getTopic().setTopicKind(TopicKind.NO_KEY);
      subscriberAttributes.getTopic().setTopicDataType(dataType.getName());
      subscriberAttributes.getTopic().setTopicName("ChatBox");
      
      domain.createSubscriber(participant, subscriberAttributes, new SubscriberListenerImpl());
      

      while(true)
      {
         try
         {
            Thread.sleep(1000);
         }
         catch (InterruptedException e)
         {
         }
      }

   }
   
   public static void main(String[] args) throws IOException
   {
      new SubscriberExample();
   }
}
