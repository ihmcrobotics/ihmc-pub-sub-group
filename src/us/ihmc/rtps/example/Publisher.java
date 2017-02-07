package us.ihmc.rtps.example;

import java.io.IOException;

import us.ihmc.rtps.Domain;
import us.ihmc.rtps.impl.fastRTPS.FastRTPSDomain;
import us.ihmc.rtps.impl.fastRTPS.FastRTPSTime;
import us.ihmc.rtps.impl.fastRTPS.attributes.FastRTPSParticipantAttributes;
import us.ihmc.rtps.participant.Participant;
import us.ihmc.rtps.participant.ParticipantListener;
import us.ihmc.rtps.participant.ParticipantDiscoveryInfo;

public class Publisher
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

   public Publisher() throws IOException
   {
      Domain domain = new FastRTPSDomain();

      FastRTPSParticipantAttributes attributes = new FastRTPSParticipantAttributes();
      attributes.rtps().getBuiltin().setDomainId(1);
      attributes.rtps().getBuiltin().setLeaseDuration(FastRTPSTime.c_TimeInfinite);
      attributes.rtps().setName("ChatBox");

      Participant participant = domain.createParticipant(attributes, new ParticipantListenerImpl());
      
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
      new Publisher();
   }
}
