package us.ihmc.rtps.impl.fastRTPS;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;

import us.ihmc.rtps.TopicDataType;
import us.ihmc.rtps.attributes.ParticipantAttributes;
import us.ihmc.rtps.attributes.PublisherAttributes;
import us.ihmc.rtps.attributes.TopicAttributes.TopicKind;
import us.ihmc.rtps.common.Guid;
import us.ihmc.rtps.participant.Participant;
import us.ihmc.rtps.participant.ParticipantListener;
import us.ihmc.rtps.publisher.PublisherListener;

class FastRTPSParticipant implements Participant
{
   private final NativeParticipantImpl impl;

   private final ArrayList<TopicDataType<?>> types = new ArrayList<>();
   private final ArrayList<FastRTPSPublisher> publishers = new ArrayList<>();
   
   private final FastRTPSParticipantAttributes attributes;
   private final ParticipantListener participantListener;

   private final Guid guid = new Guid();
   private final FastRTPSParticipantDiscoveryInfo discoveryInfo = new FastRTPSParticipantDiscoveryInfo();

   private class NativeParticipantListenerImpl extends NativeParticipantListener
   {

      @Override
      public void onParticipantDiscovery(long infoPtr, DISCOVERY_STATUS status)
      {
         if (participantListener != null)
         {
            discoveryInfo.updateInfo(status, this, infoPtr);
            participantListener.onParticipantDiscovery(FastRTPSParticipant.this, discoveryInfo);
         }
      }
   }

   public FastRTPSParticipant(ParticipantAttributes<?> att, ParticipantListener participantListener) throws IOException, IllegalArgumentException
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

   void delete()
   {
      impl.delete();
   }

   private void getGuid(Guid guid)
   {
      ByteBuffer guidBuffer = ByteBuffer.allocateDirect(Guid.GuidPrefix.size + Guid.Entity.size);
      impl.getGuid(guidBuffer);
      guidBuffer.clear();
      guid.fromByteBuffer(guidBuffer);
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
   public int get_no_publisher(String target_topic)
   {
      // TODO Auto-generated method stub
      return 0;
   }

   @Override
   public int get_no_subscribers(String target_topic)
   {
      // TODO Auto-generated method stub
      return 0;
   }

   void registerType(TopicDataType<?> topicDataType) throws IllegalArgumentException
   {
      if(topicDataType.getTypeSize() <= 0)
      {
         throw new IllegalArgumentException("Registered type must have maximum byte size > 0");
      }
      
      if(topicDataType.getName().isEmpty())
      {
         throw new IllegalArgumentException("Registered type must have a name");
      }
      
      for(int i = 0; i < types.size(); i++)
      {
         if(types.get(i).getName().equals(topicDataType.getName()))
         {
            throw new IllegalArgumentException("Type with the same name already exists: " + topicDataType.getName());
         }
      }
      
      types.add(topicDataType);
   }
   
   TopicDataType<?> getRegisteredType(String name)
   {
      for(int i = 0; i < types.size(); i++)
      {
         if(types.get(i).getName().equals(name))
         {
            return types.get(i);
         }
      }
      return null;
   }

   FastRTPSPublisher createPublisher(PublisherAttributes<?, ?, ?> publisherAttributes, PublisherListener listener) throws IOException, IllegalArgumentException
   {
      TopicDataType<?> topicDataType = getRegisteredType(publisherAttributes.getTopic().getTopicDataType());
      if(topicDataType == null)
      {
         throw new IllegalArgumentException("Type: " + publisherAttributes.getTopic().getTopicDataType() + " is not registered");
      }
      
      if(publisherAttributes.getTopic().getTopicKind() == TopicKind.WITH_KEY && !topicDataType.isGetKeyDefined())
      {
         throw new IllegalArgumentException("Keyed topic needs getKey function");
      }
      
      if(attributes.rtps().getBuiltin().getUse_STATIC_EndpointDiscoveryProtocol())
      {
         if(publisherAttributes.getUserDefinedID() <= 0)
         {
            throw new IllegalArgumentException("Static EDP requires user defined EDP");
         }
      }
      
      if(publisherAttributes instanceof FastRTPSPublisherAttributes)
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
   
}
