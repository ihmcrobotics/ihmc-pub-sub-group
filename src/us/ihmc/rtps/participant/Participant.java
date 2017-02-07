package us.ihmc.rtps.participant;

import us.ihmc.rtps.attributes.ParticipantAttributes;
import us.ihmc.rtps.common.Guid;

public interface Participant
{
   public Guid getGuid();
   public ParticipantAttributes<?> getAttributes();
   
   public int get_no_publisher(String target_topic);
   public int get_no_subscribers(String target_topic);
}
