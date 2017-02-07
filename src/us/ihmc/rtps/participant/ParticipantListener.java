package us.ihmc.rtps.participant;

public interface ParticipantListener
{
   public void onParticipantDiscovery(Participant participant, ParticpantDiscorveryInfo info);
}
