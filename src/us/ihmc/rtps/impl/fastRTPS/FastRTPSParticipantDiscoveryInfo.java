package us.ihmc.rtps.impl.fastRTPS;

import us.ihmc.rtps.common.DiscoveryStatus;
import us.ihmc.rtps.participant.ParticipantDiscoveryInfo;

public class FastRTPSParticipantDiscoveryInfo extends ParticipantDiscoveryInfo
{
   private NativeParticipantListener participant;
   private long infoPtr;

   public void updateInfo(DISCOVERY_STATUS status, NativeParticipantListener nativeParticipantListener, long infoPtr, long guidHigh, long guidLow)
   {
      guid.fromPrimitives(guidHigh, guidLow);

      this.status = DiscoveryStatus.values[status.swigValue()];

      this.participant = nativeParticipantListener;
      this.infoPtr = infoPtr;
   }

   @Override
   public String getName()
   {
      return participant.getName(infoPtr);
   }

}
