package us.ihmc.rtps.impl.fastRTPS;

import java.io.IOException;
import java.nio.ByteBuffer;

import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.SubscriberAttributes;
import us.ihmc.pubsub.common.ChangeKind;
import us.ihmc.pubsub.common.Guid;
import us.ihmc.pubsub.common.MatchingInfo;
import us.ihmc.pubsub.common.SampleIdentity;
import us.ihmc.pubsub.common.SampleInfo;
import us.ihmc.pubsub.common.SerializedPayload;
import us.ihmc.pubsub.common.Time;
import us.ihmc.pubsub.subscriber.Subscriber;
import us.ihmc.pubsub.subscriber.SubscriberListener;

public class FastRTPSSubscriber implements Subscriber
{

   private final NativeSubscriberImpl impl;

   private final FastRTPSSubscriberAttributes attributes;
   private final TopicDataType<Object> topicDataType;
   private final Object topicData;
   private final SubscriberListener listener;
   private final SerializedPayload payload;
   private TopicAttributes fastRTPSAttributes;
   private final Guid guid = new Guid();
   private final MatchingInfo matchingInfo = new MatchingInfo();

   private final ByteBuffer keyBuffer = ByteBuffer.allocateDirect(16);

   private final SampleInfoMarshaller sampleInfoMarshaller = new SampleInfoMarshaller();

   private final TopicKind_t topicKind;
   private final OwnershipQosPolicyKind ownershipQosPolicyKind;

   private class NativeSubscriberListenerImpl extends NativeSubscriberListener
   {
      @Override
      public void onReaderMatched(MatchingStatus status, long guidHigh, long guidLow)
      {
         try
         {
            if (listener != null)
            {
               matchingInfo.getGuid().fromPrimitives(guidHigh, guidLow);
               matchingInfo.setStatus(MatchingInfo.MatchingStatus.values[status.swigValue()]);
               listener.onSubscriptionMatched(FastRTPSSubscriber.this, matchingInfo);
            }
         }
         catch (Throwable e)
         {
            e.printStackTrace();
         }
      }

      @Override
      public void onNewCacheChangeAdded()
      {
         try
         {
            if (listener != null)
            {
               listener.onNewDataMessage(FastRTPSSubscriber.this);
            }
         }
         catch (Throwable e)
         {
            e.printStackTrace();
         }
      }

      @Override
      public boolean getKey(long cacheChangePtr, short encoding, int dataLength)
      {
         impl.getData(cacheChangePtr, payload.getData().capacity(), payload.getData());
         preparePayload(encoding, dataLength);
         if (!topicDataType.isGetKeyDefined())
         {
            return false;
         }
         try
         {
            topicDataType.deserialize(payload, topicData);
         }
         catch (IOException e)
         {
            return false;
         }
         keyBuffer.clear();
         topicDataType.getKey(topicData, keyBuffer);
         keyBuffer.flip();
         impl.updateKey(cacheChangePtr, keyBuffer);

         return true;
      }

   }

   private void preparePayload(short encapsulation, int dataLength)
   {
      payload.getData().clear();
      payload.setEncapsulation(encapsulation);
      payload.setLength(dataLength);
      payload.getData().limit(dataLength);

   }

   @SuppressWarnings("unchecked")
   FastRTPSSubscriber(TopicDataType<?> topicDataType, FastRTPSSubscriberAttributes attributes, SubscriberListener listener,
                      NativeParticipantImpl participantImpl)
         throws IOException
   {

      LocatorList_t unicastLocatorList = new LocatorList_t();
      FastRTPSCommonFunctions.convertToCPPLocatorList(attributes.getUnicastLocatorList(), unicastLocatorList);
      LocatorList_t multicastLocatorList = new LocatorList_t();
      FastRTPSCommonFunctions.convertToCPPLocatorList(attributes.getMulticastLocatorList(), multicastLocatorList);
      LocatorList_t outLocatorList = new LocatorList_t();
      FastRTPSCommonFunctions.convertToCPPLocatorList(attributes.getOutLocatorList(), outLocatorList);
      
      
      
      
      if (!unicastLocatorList.isValid())
      {
         throw new IllegalArgumentException("Unicast Locator List for Subscriber contains invalid Locator");
      }
      if (!multicastLocatorList.isValid())
      {
         throw new IllegalArgumentException(" Multicast Locator List for Subscriber contains invalid Locator");
      }
      if (!outLocatorList.isValid())
      {
         throw new IllegalArgumentException("Output Locator List for Subscriber contains invalid Locator");
      }

      ReaderQos qos = attributes.getQos().getReaderQos();
      this.attributes = attributes;
      this.topicDataType = (TopicDataType<Object>) topicDataType;
      this.topicData = topicDataType.createData();
      this.listener = listener;
      this.payload = new SerializedPayload(topicDataType.getTypeSize());
      this.topicKind = TopicKind_t.swigToEnum(attributes.getTopic().getTopicKind().ordinal());
      this.ownershipQosPolicyKind = qos.getM_ownership().getKind();

      fastRTPSAttributes = attributes.createFastRTPSTopicAttributes();

      if (!qos.checkQos() || !fastRTPSAttributes.checkQos())
      {
         throw new IllegalArgumentException("Invalid QoS settings");
      }

      impl = new NativeSubscriberImpl(attributes.getEntityID(), attributes.getUserDefinedID(), topicDataType.getTypeSize(),
                                      MemoryManagementPolicy_t.swigToEnum(attributes.getHistoryMemoryPolicy().ordinal()), fastRTPSAttributes, qos,
                                      attributes.getTimes(), unicastLocatorList, multicastLocatorList, outLocatorList, attributes.isExpectsInlineQos(), participantImpl,
                                      new NativeSubscriberListenerImpl());

      guid.fromPrimitives(impl.getGuidHigh(), impl.getGuidLow());
      
      
      unicastLocatorList.delete();
      multicastLocatorList.delete();
      outLocatorList.delete();
   }

   @Override
   public Guid getGuid()
   {
      return guid;
   }

   @Override
   public void waitForUnreadMessage()
   {
      impl.waitForUnreadMessage();
   }

   private void updateSampleInfo(SampleInfoMarshaller marshaller, SampleInfo info, ByteBuffer keyBuffer)
   {
      info.setOwnershipStrength(marshaller.getOwnershipStrength());
      info.setSampleKind(ChangeKind.values[marshaller.getChangeKind()]);

      Time time = info.getSourceTimestamp();
      time.setSeconds(marshaller.getTime_seconds());
      time.setFraction(marshaller.getTime_fraction());

      SampleIdentity id = info.getSampleIdentity();
      id.getGuid().fromPrimitives(marshaller.getSampleIdentity_GuidHigh(), marshaller.getSampleIdentity_GuidLow());
      id.getSequenceNumber().set(marshaller.getSampleIdentity_sequenceNumberHigh(), marshaller.getSampleIdentity_sequenceNumberLow());

      SampleIdentity relatedId = info.getRelatedSampleIdentity();
      relatedId.getGuid().fromPrimitives(marshaller.getRelatedSampleIdentity_GuidHigh(), marshaller.getRelatedSampleIdentity_GuidLow());
      relatedId.getSequenceNumber().set(marshaller.getRelatedSampleIdentity_sequenceNumberHigh(), marshaller.getRelatedSampleIdentity_sequenceNumberLow());

   }

   @Override
   public boolean readNextData(Object data, SampleInfo info) throws IOException
   {
      boolean ret = false;
      impl.lock();
      {
         long cacheChange = impl.readnextData(payload.getData().capacity(), payload.getData(), sampleInfoMarshaller, topicKind, ownershipQosPolicyKind);
         if (cacheChange != 0)
         {
            if (sampleInfoMarshaller.getChangeKind() == ChangeKind_t.ALIVE.swigValue())
            {
               preparePayload(sampleInfoMarshaller.getEncapsulation(), sampleInfoMarshaller.getDataLength());
               topicDataType.deserialize(payload, data);
            }

            if (sampleInfoMarshaller.getUpdateKey())
            {
               keyBuffer.clear();
               topicDataType.getKey(data, keyBuffer);
               keyBuffer.flip();
               impl.updateKey(cacheChange, keyBuffer);
            }
            else
            {
               sampleInfoMarshaller.getInstanceHandleValue(keyBuffer);
               keyBuffer.clear();
            }
            if (info != null)
            {
               updateSampleInfo(sampleInfoMarshaller, info, keyBuffer);
            }
            ret = true;
         }
         else
         {
            ret = false;
         }
      }
      impl.unlock();
      return ret;
   }

   @Override
   public boolean takeNextData(Object data, SampleInfo info) throws IOException
   {
      boolean ret = false;
      impl.lock();
      {
         long cacheChange = impl.takeNextData(payload.getData().capacity(), payload.getData(), sampleInfoMarshaller, topicKind, ownershipQosPolicyKind);
         if (cacheChange != 0)
         {

            if (sampleInfoMarshaller.getChangeKind() == ChangeKind_t.ALIVE.swigValue())
            {
               preparePayload(sampleInfoMarshaller.getEncapsulation(), sampleInfoMarshaller.getDataLength());
               topicDataType.deserialize(payload, data);
            }

            if (sampleInfoMarshaller.getUpdateKey())
            {
               keyBuffer.clear();
               topicDataType.getKey(data, keyBuffer);
               keyBuffer.flip();
               impl.updateKey(cacheChange, keyBuffer);
            }
            else
            {
               sampleInfoMarshaller.getInstanceHandleValue(keyBuffer);
               keyBuffer.clear();
            }
            if (info != null)
            {
               updateSampleInfo(sampleInfoMarshaller, info, keyBuffer);
            }

            impl.remove_change_sub_swig(cacheChange);
            return true;
         }
      }
      impl.unlock();
      return ret;
   }

   @Override
   public SubscriberAttributes<?, ?> getAttributes()
   {
      return attributes;
   }

   @Override
   public boolean isInCleanState()
   {
      return impl.isInCleanState();
   }

   void delete()
   {
      fastRTPSAttributes.delete();
      impl.delete();
   }

   TopicDataType<Object> getTopicDataType()
   {
      return topicDataType;
   }

}
