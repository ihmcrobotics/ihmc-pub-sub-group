package us.ihmc.pubsub.participant;

import us.ihmc.pubsub.common.DiscoveryStatus;
import us.ihmc.pubsub.common.Guid;

/**
 * Class ParticipantDiscoveryInfo, provided to the user with information regarding a Discovered Participant.
 * 
 * @author Jesper Smith
 *
 */
public abstract class ParticipantDiscoveryInfo
{
   protected final Guid guid = new Guid();
   protected DiscoveryStatus status;
   
   /**
    * Associated GUID.
    * 
    * This method does not allocate memory
    * 
    * @return Guid
    */
   public Guid getGuid()
   {
      return guid;
   }
   
   /**
    * Status
    * 
    * This method does not allocate memory
    * 
    * @return status
    */
   public DiscoveryStatus getStatus()
   {
      return status;
   }
   
   /**
    * Associated participant name
    * 
    * This method allocates a new java.util.String.
    * 
    * @return participant name
    */
   public abstract String getName();
   
}
