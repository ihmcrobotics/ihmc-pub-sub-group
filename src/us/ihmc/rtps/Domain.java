package us.ihmc.rtps;

import java.io.IOException;

import us.ihmc.rtps.attributes.ParticipantAttributes;
import us.ihmc.rtps.participant.Participant;
import us.ihmc.rtps.participant.ParticipantListener;
import us.ihmc.rtps.publisher.Publisher;
import us.ihmc.rtps.subscriber.Subscriber;

/**
 * Class Domain, use to interact with the Publisher Subscriber API of the IHMC Java RTPS API.
 * 
 * 
 * @author Jesper Smith
 *
 */
public interface Domain
{
   /**
    * Create a Participant.
    * 
    * This method may allocate memory
    * 
    * @param att Participant Attributes. Implementation specific. Not null.
    * @param participantListener. Listener for newly discovered participants. Can be null
    * 
    * @return Participant handle
    * 
    * @throws IOException If no participant can be made
    * 
    */
   public Participant createParticipant(ParticipantAttributes<?> att, ParticipantListener participantListener) throws IOException;

   public Publisher createPublisher(Participant participant) throws IOException;
   
   public Subscriber createSubscriber(Participant participant) throws IOException;

   /**
    * Remove a Participant and all associated publishers and subscribers.
    * 
    * This method may allocate memory
    * 
    * @param participant to remove
    * 
    * @return true if participant is found and removed
    */
   public boolean removeParticipant(Participant participant);

   public boolean removePublisher(Publisher publisher);
   
   public boolean removeSubscriber(Subscriber subscriber);
   
   public TopicDataType<?> getRegisteredType(Participant participant, String typeName);
   
   public boolean registerType(Participant participant, TopicDataType<?> topicDataType);
   
   public boolean unregisterType(Participant participant, String typeName);
   
   public void stopAll();
}
