package us.ihmc.rtps.impl.fastRTPS;

import java.io.IOException;
import java.nio.ByteBuffer;

import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.PublisherAttributes;
import us.ihmc.pubsub.attributes.TopicAttributes.TopicKind;
import us.ihmc.pubsub.common.Guid;
import us.ihmc.pubsub.common.MatchingInfo;
import us.ihmc.pubsub.common.SerializedPayload;
import us.ihmc.pubsub.publisher.Publisher;
import us.ihmc.pubsub.publisher.PublisherListener;

public class FastRTPSPublisher implements Publisher
{

   private final NativePublisherImpl impl;
   private final FastRTPSPublisherAttributes attributes;
   private final TopicDataType<Object> topicDataType;
   private final PublisherListener listener;
   private final SerializedPayload payload;
   private TopicAttributes fastRTPSAttributes;
   private ThroughputControllerDescriptor throughputController;
   private final Guid guid = new Guid();

   private final ByteBuffer keyBuffer = ByteBuffer.allocateDirect(16);

   private class NativePublisherListenerImpl extends NativePublisherListener
   {
      private final MatchingInfo matchingInfo = new MatchingInfo();

      @Override
      public void onWriterMatched(MatchingStatus status, long guidHigh, long guidLow)
      {
         try
         {
            if (listener != null)
            {
               matchingInfo.getGuid().fromPrimitives(guidHigh, guidLow);
               matchingInfo.setStatus(MatchingInfo.MatchingStatus.values[status.swigValue()]);
               listener.onPublicationMatched(FastRTPSPublisher.this, matchingInfo);
            }
         }
         catch (Throwable e)
         {
            e.printStackTrace();
         }
      }

   }

   @SuppressWarnings("unchecked")
   public FastRTPSPublisher(TopicDataType<?> topicDataType, FastRTPSPublisherAttributes attributes, PublisherListener listener,
                            NativeParticipantImpl participant)
         throws IOException, IllegalArgumentException
   {
      LocatorList_t unicastLocatorList = new LocatorList_t();
      FastRTPSCommonFunctions.convertToCPPLocatorList(attributes.getUnicastLocatorList(), unicastLocatorList);
      LocatorList_t multicastLocatorList = new LocatorList_t();
      FastRTPSCommonFunctions.convertToCPPLocatorList(attributes.getMulticastLocatorList(), multicastLocatorList);
      LocatorList_t outLocatorList = new LocatorList_t();
      FastRTPSCommonFunctions.convertToCPPLocatorList(attributes.getOutLocatorList(), outLocatorList);
      
      
      
      
      if (!unicastLocatorList.isValid())
      {
         throw new IllegalArgumentException("Unicast Locator List for Publisher contains invalid Locator");
      }
      if (!multicastLocatorList.isValid())
      {
         throw new IllegalArgumentException(" Multicast Locator List for Publisher contains invalid Locator");
      }
      if (!outLocatorList.isValid())
      {
         throw new IllegalArgumentException("Output Locator List for Publisher contains invalid Locator");
      }

      this.attributes = attributes;
      this.topicDataType = (TopicDataType<Object>) topicDataType;
      this.listener = listener;
      this.payload = new SerializedPayload(topicDataType.getTypeSize());

      fastRTPSAttributes = attributes.createFastRTPSTopicAttributes();
      throughputController = attributes.createTroughputControllerDescriptor();

      WriterQos qos = attributes.getQos().getWriterQos();
      if (!qos.checkQos() || !fastRTPSAttributes.checkQos())
      {
         throw new IllegalArgumentException("Invalid QoS settings");
      }

      impl = new NativePublisherImpl(attributes.getEntityID(), attributes.getUserDefinedID(), topicDataType.getTypeSize(),
                                     MemoryManagementPolicy_t.swigToEnum(attributes.getHistoryMemoryPolicy().ordinal()), fastRTPSAttributes, qos,
                                     attributes.getTimes(), unicastLocatorList, multicastLocatorList,
                                     outLocatorList, throughputController, participant, new NativePublisherListenerImpl());

      guid.fromPrimitives(impl.getGuidHigh(), impl.getGuidLow());
      
      unicastLocatorList.delete();
      multicastLocatorList.delete();
      outLocatorList.delete();

   }

   @Override
   public void write(Object data) throws IOException
   {
      ChangeKind_t change = ChangeKind_t.ALIVE;
      createNewChange(data, change);
   }

   private void createNewChange(Object data, ChangeKind_t change) throws IOException
   {
      if (attributes.getTopic().getTopicKind() == TopicKind.WITH_KEY)
      {
         keyBuffer.clear();
         topicDataType.getKey(data, keyBuffer);
      }

      payload.getData().clear();
      topicDataType.serialize(data, payload);
      impl.create_new_change(change, payload.getData(), payload.getLength(), payload.getEncapsulation(), keyBuffer);
   }

   @Override
   public Guid getGuid()
   {
      return guid;
   }

   @Override
   public PublisherAttributes<?, ?> getAttributes()
   {
      return attributes;
   }

   void delete()
   {
      fastRTPSAttributes.delete();
      throughputController.delete();
      impl.delete();
   }

   @Override
   public void finalize()
   {
      delete();
   }

   @Override
   public void dispose(Object data) throws IOException
   {
      createNewChange(data, ChangeKind_t.NOT_ALIVE_DISPOSED);
   }

   @Override
   public void unregister(Object data) throws IOException
   {
      createNewChange(data, ChangeKind_t.NOT_ALIVE_UNREGISTERED);
   }

   @Override
   public void dispose_and_unregister(Object data) throws IOException
   {
      createNewChange(data, ChangeKind_t.NOT_ALIVE_DISPOSED_UNREGISTERED);
   }

   @Override
   public int removeAllChange() throws IOException
   {
      int removed = impl.removeAllChange();
      if (removed >= 0)
      {
         return removed;
      }
      else
      {
         throw new IOException("Cannot remove all changes");
      }
   }

   public TopicDataType<?> getTopicDataType()
   {
      return topicDataType;
   }
}
