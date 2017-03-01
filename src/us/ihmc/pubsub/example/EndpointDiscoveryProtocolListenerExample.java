package us.ihmc.pubsub.example;

import java.io.IOException;
import java.util.ArrayList;

import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.DomainFactory;
import us.ihmc.pubsub.DomainFactory.PubSubImplementation;
import us.ihmc.pubsub.attributes.Locator;
import us.ihmc.pubsub.attributes.ParticipantAttributes;
import us.ihmc.pubsub.attributes.ReaderQosHolder;
import us.ihmc.pubsub.attributes.TopicAttributes.TopicKind;
import us.ihmc.pubsub.attributes.WriterQosHolder;
import us.ihmc.pubsub.common.Guid;
import us.ihmc.pubsub.common.Time;
import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.participant.ParticipantDiscoveryInfo;
import us.ihmc.pubsub.participant.ParticipantListener;
import us.ihmc.pubsub.participant.PublisherEndpointDiscoveryListener;
import us.ihmc.pubsub.participant.SubscriberEndpointDiscoveryListener;
import us.ihmc.rtps.impl.fastRTPS.ReaderQos;

public class EndpointDiscoveryProtocolListenerExample
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
   
   private class PublisherEndpointDiscoveryListenerImpl implements PublisherEndpointDiscoveryListener
   {

      @Override
      public void publisherTopicChange(boolean isAlive, Guid guid, ArrayList<Locator> unicastLocatorList, ArrayList<Locator> multicastLocatorList,
                                       Guid participantGuid, String typeName, String topicName, int userDefinedId, long typeMaxSerialized, TopicKind topicKind,
                                       WriterQosHolder<?> writerQosHolder)
      {
         System.out.println("New publisher topic change");
         System.out.println("Is alive: " + isAlive);
         System.out.println("GUID: " + guid);
         System.out.println("ParticipantGUID: " + participantGuid);
         System.out.println("TypeName: " + typeName);
         System.out.println("TopicName: " + topicName);
      }
      
   }
   
   private class SubscriberEndpointDiscoveryListenerImpl implements SubscriberEndpointDiscoveryListener
   {

      @Override
      public void subscriberTopicChange(boolean isAlive, Guid guid, boolean expectsInlineQos, ArrayList<Locator> unicastLocatorList,
                                        ArrayList<Locator> multicastLocatorList, Guid participantGuid, String typeName, String topicName, int userDefinedId,
                                        TopicKind javaTopicKind, ReaderQosHolder<ReaderQos> readerQosHolder)
      {
         System.out.println("New subscriber topic change");
         System.out.println("Is alive: " + isAlive);
         System.out.println("GUID: " + guid);
         System.out.println("ParticipantGUID: " + participantGuid);
         System.out.println("TypeName: " + typeName);
         System.out.println("TopicName: " + topicName);
      }
      
   }
   
   
   public EndpointDiscoveryProtocolListenerExample() throws IOException
   {
      Domain domain = DomainFactory.getDomain(PubSubImplementation.FAST_RTPS);
      
      ParticipantAttributes<?> attributes = domain.createParticipantAttributes();
      attributes.setDomainId(1);
      attributes.setLeaseDuration(Time.Infinite);
      attributes.setName("EndpointDiscoveryProtocolListenerExample");
      Participant participant = domain.createParticipant(attributes, new ParticipantListenerImpl());
      
      
      participant.registerEndpointDiscoveryListeners(new PublisherEndpointDiscoveryListenerImpl(), new SubscriberEndpointDiscoveryListenerImpl());
      
   }
   
   public static void main(String[] args) throws IOException
   {
      new EndpointDiscoveryProtocolListenerExample();
      
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
}
