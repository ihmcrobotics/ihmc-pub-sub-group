package us.ihmc.rtps.participant;

import us.ihmc.rtps.common.DiscoveryStatus;
import us.ihmc.rtps.common.Guid;

public abstract class ParticipantDiscoveryInfo
{
   protected final Guid guid = new Guid();
   protected DiscoveryStatus status;
   
   
   public Guid getGuid()
   {
      return guid;
   }
   
   public DiscoveryStatus getStatus()
   {
      return status;
   }
   
   public abstract String getName();
   
}
