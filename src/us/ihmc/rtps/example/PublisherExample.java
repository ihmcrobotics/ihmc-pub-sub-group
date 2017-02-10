package us.ihmc.rtps.example;

import java.io.IOException;
import java.nio.ByteOrder;

import us.ihmc.rtps.Domain;
import us.ihmc.rtps.DomainFactory;
import us.ihmc.rtps.DomainFactory.PubSubImplementation;
import us.ihmc.rtps.attributes.ParticipantAttributes;
import us.ihmc.rtps.attributes.PublisherAttributes;
import us.ihmc.rtps.attributes.TopicAttributes.TopicKind;
import us.ihmc.rtps.common.LogLevel;
import us.ihmc.rtps.common.MatchingInfo;
import us.ihmc.rtps.common.Time;
import us.ihmc.rtps.participant.Participant;
import us.ihmc.rtps.participant.ParticipantDiscoveryInfo;
import us.ihmc.rtps.participant.ParticipantListener;
import us.ihmc.rtps.publisher.Publisher;
import us.ihmc.rtps.publisher.PublisherListener;

public class PublisherExample
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
   
   private class PublisherListenerImpl implements PublisherListener
   {

      @Override
      public void onPublicationMatched(Publisher publisher, MatchingInfo info)
      {
         System.out.println("New publication matched");
         System.out.println("Status: " + info.getStatus());
         System.out.println("Guid: " + info.getGuid().toString());
      }
      
   }

   public PublisherExample() throws IOException
   {
      Domain domain = DomainFactory.getDomain(PubSubImplementation.FAST_RTPS);
      
      domain.setLogLevel(LogLevel.WARNING);

      ParticipantAttributes<?> attributes = domain.createParticipantAttributes();
      attributes.setDomainId(1);
      attributes.setLeaseDuration(Time.Infinite);
      attributes.setName("PublisherExample");

      
      
      Participant participant = domain.createParticipant(attributes, new ParticipantListenerImpl());
      
      ByteArrayTopicDataType dataType = new ByteArrayTopicDataType(500, "Chat::ChatMessage", ByteOrder.nativeOrder());
      domain.registerType(participant, dataType);
      
      PublisherAttributes<?,?,?> publisherAttributes = domain.createPublisherAttributes();
      publisherAttributes.getTopic().setTopicKind(TopicKind.NO_KEY);
      publisherAttributes.getTopic().setTopicDataType(dataType.getName());
      publisherAttributes.getTopic().setTopicName("ChatBox");
      
      Publisher publisher = domain.createPublisher(participant, publisherAttributes, new PublisherListenerImpl());
      
      
      byte[] javaHelloWorld = { 0x05, 0x00, 0x00, 0x00, 0x4a, 0x61, 0x76, 0x61, 0x00, 0x00, 0x00, 0x00, 0x0c, 0x00, 0x00, 0x00, 0x48, 0x65, 0x6c, 0x6c, 0x6f, 0x20, 0x57, 0x6f, 0x72, 0x6c, 0x64, 0x00 };
      

      while(true)
      {
         try
         {
            publisher.write(javaHelloWorld);
            Thread.sleep(1000);
         }
         catch (InterruptedException e)
         {
         }
      }
   }
   
   public static void main(String[] args) throws IOException
   {
      new PublisherExample();
   }
}
