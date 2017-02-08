package us.ihmc.rtps.impl.fastRTPS;

import java.io.IOException;
import java.util.ArrayList;

import us.ihmc.rtps.Domain;
import us.ihmc.rtps.TopicDataType;
import us.ihmc.rtps.attributes.ParticipantAttributes;
import us.ihmc.rtps.attributes.PublisherAttributes;
import us.ihmc.rtps.participant.Participant;
import us.ihmc.rtps.participant.ParticipantListener;
import us.ihmc.rtps.publisher.Publisher;
import us.ihmc.rtps.publisher.PublisherListener;
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
   public synchronized Participant createParticipant(ParticipantAttributes<?> participantAttributes, ParticipantListener participantListener) throws IOException
   {
      FastRTPSParticipant participant =  new FastRTPSParticipant(participantAttributes, participantListener);
      participants.add(participant);
      return participant;
   }

   @Override
   public synchronized Publisher createPublisher(Participant participant, PublisherAttributes<?,?,?> publisherAttributes, PublisherListener listener) throws IOException, IllegalArgumentException
   {
      for(int i = 0; i < participants.size(); i++)
      {
         if(participants.get(i) == participant)
         {
            participants.get(i).createPublisher(publisherAttributes, listener);
         }
      }
      throw new IllegalArgumentException("Participant is not part of this domain.");
      
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
   public synchronized TopicDataType<?> getRegisteredType(Participant participant, String typeName)
   {
      for(int i = 0; i < participants.size(); i++)
      {
         if(participants.get(i) == participant)
         {
            return participants.get(i).getRegisteredType(typeName);
         }
      }
      return null;
   }

   @Override
   public synchronized void registerType(Participant participant, TopicDataType<?> topicDataType) throws IllegalArgumentException
   {
      for(int i = 0; i < participants.size(); i++)
      {
         if(participants.get(i) == participant)
         {
            participants.get(i).registerType(topicDataType);
         }
      }
      throw new IllegalArgumentException("Participant is not part of this domain.");
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


   @Override
   public FastRTPSPublisherAttributes createPublisherAttributes()
   {
      return new FastRTPSPublisherAttributes();
   }

}
