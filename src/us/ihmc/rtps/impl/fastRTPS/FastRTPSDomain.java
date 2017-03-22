package us.ihmc.rtps.impl.fastRTPS;

import java.io.IOException;
import java.util.ArrayList;

import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.ParticipantAttributes;
import us.ihmc.pubsub.attributes.PublisherAttributes;
import us.ihmc.pubsub.attributes.SubscriberAttributes;
import us.ihmc.pubsub.common.LogLevel;
import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.participant.ParticipantListener;
import us.ihmc.pubsub.publisher.Publisher;
import us.ihmc.pubsub.publisher.PublisherListener;
import us.ihmc.pubsub.subscriber.Subscriber;
import us.ihmc.pubsub.subscriber.SubscriberListener;
import us.ihmc.tools.nativelibraries.NativeLibraryLoader;

public class FastRTPSDomain implements Domain
{
   private final ArrayList<FastRTPSParticipant> participants = new ArrayList<>();

   public FastRTPSDomain()
   {
      NativeLibraryLoader.loadLibrary("us.ihmc.rtps.impl.fastRTPS", "FastRTPSWrapper");
      Runtime.getRuntime().addShutdownHook(new Thread((Runnable) () -> {
         stopAll();
      })); 
   }

   @Override
   public synchronized Participant createParticipant(ParticipantAttributes<?> participantAttributes, ParticipantListener participantListener) throws IOException
   {
      FastRTPSParticipant participant = new FastRTPSParticipant(participantAttributes, participantListener);
      participants.add(participant);
      return participant;
   }

   @Override
   public synchronized Publisher createPublisher(Participant participant, PublisherAttributes<?, ?> publisherAttributes, PublisherListener listener)
         throws IOException, IllegalArgumentException
   {
      for (int i = 0; i < participants.size(); i++)
      {
         if (participants.get(i) == participant)
         {
            return participants.get(i).createPublisher(publisherAttributes, listener);
         }
      }
      throw new IllegalArgumentException("Participant is not part of this domain.");

   }

   @Override
   public Subscriber createSubscriber(Participant participant, SubscriberAttributes<?, ?> subscriberAttributes, SubscriberListener listener)
         throws IOException, IllegalArgumentException
   {
      for (int i = 0; i < participants.size(); i++)
      {
         if (participants.get(i) == participant)
         {
            return participants.get(i).createSubscriber(subscriberAttributes, listener);
         }
      }
      throw new IllegalArgumentException("Participant is not part of this domain.");

   }

   @Override
   public synchronized boolean removeParticipant(Participant participant)
   {
      for (int i = 0; i < participants.size(); i++)
      {
         if (participants.get(i) == participant)
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
      for (int i = 0; i < participants.size(); i++)
      {
         if (participants.get(i).getGuid().getGuidPrefix().equals(publisher.getGuid().getGuidPrefix()))
         {
            return participants.get(i).removePublisher(publisher);
         }
      }
      return false;
   }

   @Override
   public synchronized boolean removeSubscriber(Subscriber subscriber)
   {
      for (int i = 0; i < participants.size(); i++)
      {
         if (participants.get(i).getGuid().getGuidPrefix().equals(subscriber.getGuid().getGuidPrefix()))
         {
            return participants.get(i).removeSubscriber(subscriber);
         }
      }
      return false;
   }

   @Override
   public synchronized TopicDataType<?> getRegisteredType(Participant participant, String typeName)
   {
      for (int i = 0; i < participants.size(); i++)
      {
         if (participants.get(i) == participant)
         {
            return participants.get(i).getRegisteredType(typeName);
         }
      }
      return null;
   }

   @Override
   public synchronized void registerType(Participant participant, TopicDataType<?> topicDataType) throws IllegalArgumentException
   {
      for (int i = 0; i < participants.size(); i++)
      {
         if (participants.get(i) == participant)
         {
            participants.get(i).registerType(topicDataType);
            return;
         }
      }
      throw new IllegalArgumentException("Participant is not part of this domain.");
   }

   @Override
   public synchronized void unregisterType(Participant participant, String typeName) throws IOException
   {
      for (int i = 0; i < participants.size(); i++)
      {
         if (participants.get(i) == participant)
         {
            participants.get(i).unregisterType(typeName);
            return;
         }
      }
      throw new IllegalArgumentException("Participant is not part of this domain.");
   }

   @Override
   public synchronized void stopAll()
   {
      for(int i = 0; i < participants.size(); i++)
      {
         removeParticipant(participants.get(i));
      }
   }

   @Override
   public FastRTPSSubscriberAttributes createSubscriberAttributes()
   {
      return new FastRTPSSubscriberAttributes();
   }
   
   @Override
   public FastRTPSPublisherAttributes createPublisherAttributes()
   {
      return new FastRTPSPublisherAttributes();
   }

   @Override
   public ParticipantAttributes<?> createParticipantAttributes()
   {
      return new FastRTPSParticipantAttributes();
   }

   @Override
   public void setLogLevel(LogLevel level)
   {
      us.ihmc.rtps.impl.fastRTPS.LogLevel.setLogLevel(level.getLevel());
   }


}
