package us.ihmc.rtps;

import java.io.IOException;

import us.ihmc.rtps.attributes.ParticipantAttributes;
import us.ihmc.rtps.participant.Participant;
import us.ihmc.rtps.participant.ParticipantListener;
import us.ihmc.rtps.publisher.Publisher;
import us.ihmc.rtps.subscriber.Subscriber;

public interface Domain
{
   public Participant createParticipant(ParticipantAttributes<?> att, ParticipantListener participantListener) throws IOException;

   public Publisher createPublisher(Participant participant) throws IOException;
   
   public Subscriber createSubscriber(Participant participant) throws IOException;

   public boolean removeParticipant(Participant participant);

   public boolean removePublisher(Publisher publisher);
   
   public boolean removeSubscriber(Subscriber subscriber);
   
   public TopicDataType getRegisteredType(Participant participant, String typeName);
   
   public boolean registerType(Participant participant, TopicDataType topicDataType);
   
   public boolean unregisterType(Participant participant, String typeName);
   
   public void stopAll();
}
