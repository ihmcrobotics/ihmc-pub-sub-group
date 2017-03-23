package us.ihmc.pubsub.example;

import java.io.IOException;

import us.ihmc.idl.generated.Chat.ChatMessage;
import us.ihmc.idl.generated.Chat.ChatMessagePubSubType;
import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.DomainFactory;
import us.ihmc.pubsub.DomainFactory.PubSubImplementation;
import us.ihmc.pubsub.attributes.DurabilityKind;
import us.ihmc.pubsub.attributes.HistoryQosPolicy.HistoryQosPolicyKind;
import us.ihmc.pubsub.attributes.ParticipantAttributes;
import us.ihmc.pubsub.attributes.PublisherAttributes;
import us.ihmc.pubsub.attributes.ReliabilityKind;
import us.ihmc.pubsub.attributes.TopicAttributes.TopicKind;
import us.ihmc.pubsub.common.LogLevel;
import us.ihmc.pubsub.common.MatchingInfo;
import us.ihmc.pubsub.common.Time;
import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.participant.ParticipantDiscoveryInfo;
import us.ihmc.pubsub.participant.ParticipantListener;
import us.ihmc.pubsub.publisher.Publisher;
import us.ihmc.pubsub.publisher.PublisherListener;

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

      ParticipantAttributes attributes = domain.createParticipantAttributes();
      attributes.setDomainId(1);
      attributes.setLeaseDuration(Time.Infinite);
      attributes.setName("PublisherExample");

      
      
      Participant participant = domain.createParticipant(attributes, new ParticipantListenerImpl());
      
      ChatMessagePubSubType dataType = new ChatMessagePubSubType();
      domain.registerType(participant, dataType);
      
      PublisherAttributes publisherAttributes = domain.createPublisherAttributes();
      publisherAttributes.getTopic().setTopicKind(TopicKind.NO_KEY);
      publisherAttributes.getTopic().setTopicDataType(dataType.getName());
      publisherAttributes.getTopic().setTopicName("ChatBox");
      publisherAttributes.getQos().setReliabilityKind(ReliabilityKind.RELIABLE);
      publisherAttributes.getQos().addPartition("us/ihmc");
            
      publisherAttributes.getQos().setDurabilityKind(DurabilityKind.TRANSIENT_LOCAL_DURABILITY_QOS);
      publisherAttributes.getTopic().getHistoryQos().setKind(HistoryQosPolicyKind.KEEP_LAST_HISTORY_QOS);
      publisherAttributes.getTopic().getHistoryQos().setDepth(50);
      
      
      Publisher publisher = domain.createPublisher(participant, publisherAttributes, new PublisherListenerImpl());
      
      
      ChatMessage msg = new ChatMessage();
      msg.getSender().append("Java");
      
      int i = 0;
      while(true)
      {
         try
         {
            msg.getMsg().setLength(0);
            msg.getMsg().append("Hello World ");
            msg.getMsg().append(i++);
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
