package us.ihmc.rtps.example;

import java.io.IOException;

import us.ihmc.idl.generated.Chat.ChatMessage;
import us.ihmc.idl.generated.Chat.ChatMessagePubSubType;
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
         System.out.println("New subscriber matched");
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
      
      ChatMessagePubSubType dataType = new ChatMessagePubSubType();
      domain.registerType(participant, dataType);
      
      PublisherAttributes<?,?,?> publisherAttributes = domain.createPublisherAttributes();
      publisherAttributes.getTopic().setTopicKind(TopicKind.NO_KEY);
      publisherAttributes.getTopic().setTopicDataType(dataType.getName());
      publisherAttributes.getTopic().setTopicName("ChatBox");
      
      Publisher publisher = domain.createPublisher(participant, publisherAttributes, new PublisherListenerImpl());
      
      
      ChatMessage msg = new ChatMessage();
      msg.getSender().append("Java");
      msg.getMsg().append("Hello World");
      

      while(true)
      {
         try
         {
            publisher.write(msg);
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
