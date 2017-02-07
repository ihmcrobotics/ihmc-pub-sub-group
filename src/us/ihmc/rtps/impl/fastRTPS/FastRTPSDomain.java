package us.ihmc.rtps.impl.fastRTPS;

import java.io.IOException;
import java.util.ArrayList;

import us.ihmc.rtps.Domain;
import us.ihmc.rtps.TopicDataType;
import us.ihmc.rtps.attributes.ParticipantAttributes;
import us.ihmc.rtps.impl.fastRTPS.participant.FastRTPSParticipant;
import us.ihmc.rtps.participant.Participant;
import us.ihmc.rtps.participant.ParticipantListener;
import us.ihmc.rtps.publisher.Publisher;
import us.ihmc.rtps.subscriber.Subscriber;
import us.ihmc.tools.nativelibraries.NativeLibraryLoader;

public class FastRTPSDomain implements Domain
{
   private final ArrayList<FastRTPSParticipant> participants = new ArrayList<>();
   
   public FastRTPSDomain()
   {
      NativeLibraryLoader.loadLibrary("us.ihmc.rtps.impl.fastRTPS", "FastRTPSWrapper");
   }
   

   @Override
   public synchronized Participant createParticipant(ParticipantAttributes<?> att, ParticipantListener participantListener) throws IOException
   {
      FastRTPSParticipant participant =  new FastRTPSParticipant(att, participantListener);
      participants.add(participant);
      return participant;
   }

   @Override
   public synchronized Publisher createPublisher(Participant participant)
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public synchronized Subscriber createSubscriber(Participant participant)
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public synchronized boolean removeParticipant(Participant participant)
   {
      for(int i = 0; i < participants.size(); i++)
      {
         if(participants.get(i) == participant)
         {
            participants.get(i).delete();
            participants.remove(i);
            return true;
         }
      }
      
      return false;
   }

   @Override
   public synchronized boolean removePublisher(Publisher publisher)
   {
      // TODO Auto-generated method stub
      return false;
   }

   @Override
   public synchronized boolean removeSubscriber(Subscriber subscriber)
   {
      // TODO Auto-generated method stub
      return false;
   }

   @Override
   public synchronized TopicDataType getRegisteredType(Participant participant, String typeName)
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public synchronized boolean registerType(Participant participant, TopicDataType topicDataType)
   {
      // TODO Auto-generated method stub
      return false;
   }

   @Override
   public synchronized boolean unregisterType(Participant participant, String typeName)
   {
      // TODO Auto-generated method stub
      return false;
   }

   @Override
   public synchronized void stopAll()
   {
      // TODO Auto-generated method stub
      
   }

}
