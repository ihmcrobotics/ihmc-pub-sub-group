package us.ihmc.rtps.example;

import java.io.IOException;

import us.ihmc.rtps.Domain;
import us.ihmc.rtps.attributes.PublisherAttributes;
import us.ihmc.rtps.attributes.TopicAttributes.TopicKind;
import us.ihmc.rtps.impl.fastRTPS.FastRTPSDomain;
import us.ihmc.rtps.impl.fastRTPS.FastRTPSParticipantAttributes;
import us.ihmc.rtps.impl.fastRTPS.FastRTPSTime;
import us.ihmc.rtps.participant.Participant;
import us.ihmc.rtps.participant.ParticipantDiscoveryInfo;
import us.ihmc.rtps.participant.ParticipantListener;

public class PublisherExample
{
   private class ParticipantListenerImpl implements ParticipantListener
   {

      @Override
      public void onParticipantDiscovery(Participant participant, ParticipantDiscoveryInfo info)
      {
         System.out.println("New participant discovered");
         System.out.println(info.getStatus());
         System.out.println(info.getGuid().toString());
         System.out.println(info.getName());
      }

   }

   public PublisherExample() throws IOException
   {
      Domain domain = new FastRTPSDomain();

      FastRTPSParticipantAttributes attributes = new FastRTPSParticipantAttributes();
      attributes.rtps().getBuiltin().setDomainId(1);
      attributes.rtps().getBuiltin().setLeaseDuration(FastRTPSTime.c_TimeInfinite);
      attributes.rtps().setName("ChatBox");

      Participant participant = domain.createParticipant(attributes, new ParticipantListenerImpl());
      
      
      PublisherAttributes<?,?,?> publisherAttributes = domain.createPublisherAttributes();
      publisherAttributes.getTopic().setTopicKind(TopicKind.NO_KEY);
      publisherAttributes.getTopic().setTopicDataType("");
      publisherAttributes.getTopic().setTopicName("ChatBox");
      
      domain.createPublisher(participant, publisherAttributes, null);
      
      while(true)
      {
         try
         {
            Thread.sleep(1000);
         }
         catch (InterruptedException e)
         {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
   }
   
   public static void main(String[] args) throws IOException
   {
      new PublisherExample();
   }
}
