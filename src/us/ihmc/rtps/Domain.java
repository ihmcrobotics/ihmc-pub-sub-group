package us.ihmc.rtps;

import java.io.IOException;

import us.ihmc.rtps.attributes.ParticipantAttributes;
import us.ihmc.rtps.attributes.PublisherAttributes;
import us.ihmc.rtps.participant.Participant;
import us.ihmc.rtps.participant.ParticipantListener;
import us.ihmc.rtps.publisher.Publisher;
import us.ihmc.rtps.publisher.PublisherListener;
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
    * This method may allocate memory and is thread-safe
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

   public Publisher createPublisher(Participant participant, PublisherAttributes<?,?,?> publisherAttributes, PublisherListener listener) throws IOException, IllegalArgumentException;
   
   public Subscriber createSubscriber(Participant participant) throws IOException;

   /**
    * Remove a Participant and all associated publishers and subscribers.
    * 
    * This method may allocate memory and is thread-safe
    * 
    * @param participant to remove
    * 
    * @return true if participant is found and removed
    */
   public boolean removeParticipant(Participant participant);

   public boolean removePublisher(Publisher publisher);
   
   public boolean removeSubscriber(Subscriber subscriber);
   
   /**
    * Return a registered type.
    * 
    * This method does not allocate memory and is thread-safe
    * 
    * @param participant
    * @param typeName
    * 
    * @return Registered type or null if not found
    */
   public TopicDataType<?> getRegisteredType(Participant participant, String typeName);
   
   /**
    * Register a type in a participant.
    * 
    * This method may allocate memory and is thread-safe
    * 
    * @param participant
    * @param topicDataType
    * 
    * @throws IllegalArgumentException 
    */
   public void registerType(Participant participant, TopicDataType<?> topicDataType) throws IllegalArgumentException;
   
   public boolean unregisterType(Participant participant, String typeName);
   
   public void stopAll();
   
   /**
    * Generate an implementation specific version of PublisherAttributes
    * 
    * This method allocates memory
    * 
    * @return Implementation specific version of PublisherAttributes
    */
   public PublisherAttributes<?, ?, ?> createPublisherAttributes();
}
