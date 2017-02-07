package us.ihmc.rtps.impl.fastRTPS.attributes;

import us.ihmc.rtps.attributes.ParticipantAttributes;
import us.ihmc.rtps.impl.fastRTPS.RTPSParticipantAttributes;

public class FastRTPSParticipantAttributes extends ParticipantAttributes<RTPSParticipantAttributes>
{

   public FastRTPSParticipantAttributes()
   {
      super(new RTPSParticipantAttributes());
   }
   
}
