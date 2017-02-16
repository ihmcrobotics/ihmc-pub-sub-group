package us.ihmc.rtps.impl.fastRTPS;

import java.io.IOException;
import java.util.ArrayList;

import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.ParticipantAttributes;
import us.ihmc.pubsub.attributes.PublisherAttributes;
import us.ihmc.pubsub.attributes.SubscriberAttributes;
import us.ihmc.pubsub.attributes.TopicAttributes.TopicKind;
import us.ihmc.pubsub.common.Guid;
import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.participant.ParticipantListener;
import us.ihmc.pubsub.publisher.Publisher;
import us.ihmc.pubsub.publisher.PublisherListener;
import us.ihmc.pubsub.subscriber.Subscriber;
import us.ihmc.pubsub.subscriber.SubscriberListener;

class FastRTPSParticipant implements Participant
{
   private final NativeParticipantImpl impl;

   private final ArrayList<TopicDataType<?>> types = new ArrayList<>();
   private final ArrayList<FastRTPSPublisher> publishers = new ArrayList<>();
   private final ArrayList<FastRTPSSubscriber> subscribers = new ArrayList<>();

   private final FastRTPSParticipantAttributes attributes;
   private final ParticipantListener participantListener;

   private final Guid guid = new Guid();

   private class NativeParticipantListenerImpl extends NativeParticipantListener
   {
      private final FastRTPSParticipantDiscoveryInfo discoveryInfo = new FastRTPSParticipantDiscoveryInfo();

      @Override
      public void onParticipantDiscovery(long infoPtr, long guidHigh, long guidLow, DISCOVERY_STATUS status)
      {
         if (participantListener != null)
         {
            discoveryInfo.updateInfo(status, this, infoPtr, guidHigh, guidLow);
            participantListener.onParticipantDiscovery(FastRTPSParticipant.this, discoveryInfo);
         }
      }
   }

   FastRTPSParticipant(ParticipantAttributes<?> att, ParticipantListener participantListener) throws IOException, IllegalArgumentException
   {
      if (att instanceof FastRTPSParticipantAttributes)
      {
         this.attributes = (FastRTPSParticipantAttributes) att;
         impl = new NativeParticipantImpl(attributes.rtps(), new NativeParticipantListenerImpl());
      }
      else
      {
         throw new IllegalArgumentException("ParticipantAttributes<?> is not of base class FastRTPSParticipantAttributes");
      }

      this.participantListener = participantListener;
      getGuid(guid);

   }

   synchronized void delete()
   {
      for (int i = 0; i < publishers.size(); i++)
      {
         publishers.get(i).delete();
      }
      impl.delete();
   }

   private void getGuid(Guid guid)
   {
      guid.fromPrimitives(impl.getGuidHigh(), impl.getGuidLow());
   }

   @Override
   public Guid getGuid()
   {
      return guid;
   }

   @Override
   public FastRTPSParticipantAttributes getAttributes()
   {
      return attributes;
   }

   @Override
   public synchronized int get_no_publisher(String target_topic)
   {
      return publishers.size();
   }

   @Override
   public synchronized int get_no_subscribers(String target_topic)
   {
      return subscribers.size();
   }

   synchronized void registerType(TopicDataType<?> topicDataType) throws IllegalArgumentException
   {
      if (topicDataType.getTypeSize() <= 0)
      {
         throw new IllegalArgumentException("Registered type must have maximum byte size > 0");
      }

      if (topicDataType.getName().isEmpty())
      {
         throw new IllegalArgumentException("Registered type must have a name");
      }

      for (int i = 0; i < types.size(); i++)
      {
         if (types.get(i).getName().equals(topicDataType.getName()))
         {
            throw new IllegalArgumentException("Type with the same name already exists: " + topicDataType.getName());
         }
      }

      types.add(topicDataType);
   }

   synchronized TopicDataType<?> getRegisteredType(String name)
   {
      for (int i = 0; i < types.size(); i++)
      {
         if (types.get(i).getName().equals(name))
         {
            return types.get(i);
         }
      }
      return null;
   }

   synchronized FastRTPSPublisher createPublisher(PublisherAttributes<?, ?, ?> publisherAttributes, PublisherListener listener)
         throws IOException, IllegalArgumentException
   {
      TopicDataType<?> topicDataType = getRegisteredType(publisherAttributes.getTopic().getTopicDataType());
      if (topicDataType == null)
      {
         throw new IllegalArgumentException("Type: " + publisherAttributes.getTopic().getTopicDataType() + " is not registered");
      }

      if (publisherAttributes.getTopic().getTopicKind() == TopicKind.WITH_KEY && !topicDataType.isGetKeyDefined())
      {
         throw new IllegalArgumentException("Keyed topic needs getKey function");
      }

      if (attributes.rtps().getBuiltin().getUse_STATIC_EndpointDiscoveryProtocol())
      {
         if (publisherAttributes.getUserDefinedID() <= 0)
         {
            throw new IllegalArgumentException("Static EDP requires user defined EDP");
         }
      }

      if (publisherAttributes instanceof FastRTPSPublisherAttributes)
      {
         FastRTPSPublisher publisher = new FastRTPSPublisher(topicDataType, (FastRTPSPublisherAttributes) publisherAttributes, listener, impl);
         publishers.add(publisher);
         return publisher;
      }
      else
      {
         throw new IllegalArgumentException("publisherAttributes are not an instance of FastRTPSPublisherAttributes");
      }
   }

   synchronized Subscriber createSubscriber(SubscriberAttributes<?, ?, ?> subscriberAttributes, SubscriberListener listener) throws IOException
   {
      TopicDataType<?> topicDataType = getRegisteredType(subscriberAttributes.getTopic().getTopicDataType());
      if (topicDataType == null)
      {
         throw new IllegalArgumentException("Type: " + subscriberAttributes.getTopic().getTopicDataType() + " is not registered");
      }

      if (subscriberAttributes.getTopic().getTopicKind() == TopicKind.WITH_KEY && !topicDataType.isGetKeyDefined())
      {
         throw new IllegalArgumentException("Keyed topic needs getKey function");
      }

      if (attributes.rtps().getBuiltin().getUse_STATIC_EndpointDiscoveryProtocol())
      {
         if (subscriberAttributes.getUserDefinedID() <= 0)
         {
            throw new IllegalArgumentException("Static EDP requires user defined EDP");
         }
      }

      if (subscriberAttributes instanceof FastRTPSSubscriberAttributes)
      {
         FastRTPSSubscriber subscriber = new FastRTPSSubscriber(topicDataType, (FastRTPSSubscriberAttributes) subscriberAttributes, listener, impl);
         subscribers.add(subscriber);
         return subscriber;
      }
      else
      {
         throw new IllegalArgumentException("subscriberAttributes are not an instance of FastRTPSSubscriberAttributes");
      }
   }

   synchronized boolean removePublisher(Publisher publisher)
   {
      for (int i = 0; i < publishers.size(); i++)
      {
         if (publishers.get(i) == publisher)
         {
            publishers.get(i).delete();
            publishers.remove(i);
            return true;
         }
      }
      return false;
   }

   synchronized boolean removeSubscriber(Subscriber subscriber)
   {
      for (int i = 0; i < subscribers.size(); i++)
      {
         if (subscribers.get(i) == subscriber)
         {
            subscribers.get(i).delete();
            subscribers.remove(i);
            return true;
         }
      }
      return false;
   }

   synchronized void unregisterType(String typeName) throws IOException
   {
      TopicDataType<?> type = null;
      for (int i = 0; i < types.size(); i++)
      {
         if (types.get(i).getName().equals(typeName))
         {
            type = types.get(i);
            continue;
         }
      }
      if (type == null)
      {
         throw new IllegalArgumentException(typeName + " is not registered with participant");
      }

      for (int i = 0; i < publishers.size(); i++)
      {
         if (publishers.get(i).getTopicDataType().equals(type))
         {
            throw new IOException("TopicDataType in use by publisher " + publishers.get(i).getAttributes().getTopic().getTopicName());
         }
      }
      
      for(int i  = 0; i < subscribers.size(); i++)
      {
         if(subscribers.get(i).getTopicDataType().equals(type))
         {
            throw new IOException("TopicDataType in use by subscriber " + subscribers.get(i).getAttributes().getTopic().getTopicName());

         }
      }

      publishers.remove(type);
   }

}
