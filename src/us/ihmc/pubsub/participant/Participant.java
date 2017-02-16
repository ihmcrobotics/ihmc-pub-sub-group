package us.ihmc.pubsub.participant;

import us.ihmc.pubsub.attributes.ParticipantAttributes;
import us.ihmc.pubsub.common.Guid;

/**
 * Class Participant used to group Publishers and Subscribers into a single working unit
 * 
 * @author Jesper Smith
 *
 */
public interface Participant
{
   /**
    * Get the GUID_t of the associated RTPSParticipant.
    *
    * This method does not allocate memory. 
    *
    * @return Guid
    */
   public Guid getGuid();
   
   /**
    * Get the ParticipantAttributes.
    * 
    * This method does not allocate memory
    * 
    * @return ParticipantAttributes.
    */
   public ParticipantAttributes<?> getAttributes();
   
   public int get_no_publisher(String target_topic);
   public int get_no_subscribers(String target_topic);
}
