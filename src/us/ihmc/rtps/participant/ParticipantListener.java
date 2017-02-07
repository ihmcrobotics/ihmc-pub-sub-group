package us.ihmc.rtps.participant;

/**
 * Class ParticipantListener, overrides behaviour towards certain events
 * 
 * @author Jesper Smith
 *
 */
public interface ParticipantListener
{
   /**
    * This method is called when a new Participant is discovered, or a previously discovered participant changes its QOS or is removed.
    * 
    * @param participant
    * @param info
    */
   public void onParticipantDiscovery(Participant participant, ParticipantDiscoveryInfo info);
}
