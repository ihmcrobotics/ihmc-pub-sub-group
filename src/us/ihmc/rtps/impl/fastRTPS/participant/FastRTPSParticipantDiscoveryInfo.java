package us.ihmc.rtps.impl.fastRTPS.participant;

import java.nio.ByteBuffer;

import us.ihmc.rtps.common.DiscoveryStatus;
import us.ihmc.rtps.common.Guid;
import us.ihmc.rtps.impl.fastRTPS.DISCOVERY_STATUS;
import us.ihmc.rtps.impl.fastRTPS.NativeParticipantListener;
import us.ihmc.rtps.participant.ParticipantDiscoveryInfo;

public class FastRTPSParticipantDiscoveryInfo extends ParticipantDiscoveryInfo
{
   private final ByteBuffer guidBuffer = ByteBuffer.allocateDirect(Guid.GuidPrefix.size + Guid.Entity.size);

   private NativeParticipantListener participant;
   private long infoPtr;

   public void updateInfo(DISCOVERY_STATUS status, NativeParticipantListener nativeParticipantListener, long infoPtr)
   {
      nativeParticipantListener.getGuid(infoPtr, guidBuffer);
      guidBuffer.clear();
      guid.fromByteBuffer(guidBuffer);
      
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
