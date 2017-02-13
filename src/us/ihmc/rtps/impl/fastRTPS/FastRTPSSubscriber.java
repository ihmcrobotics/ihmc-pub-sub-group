package us.ihmc.rtps.impl.fastRTPS;

import java.io.IOException;
import java.nio.ByteBuffer;

import us.ihmc.rtps.TopicDataType;
import us.ihmc.rtps.attributes.SubscriberAttributes;
import us.ihmc.rtps.common.ChangeKind;
import us.ihmc.rtps.common.Guid;
import us.ihmc.rtps.common.MatchingInfo;
import us.ihmc.rtps.common.SampleIdentity;
import us.ihmc.rtps.common.SampleInfo;
import us.ihmc.rtps.common.SerializedPayload;
import us.ihmc.rtps.common.Time;
import us.ihmc.rtps.subscriber.Subscriber;
import us.ihmc.rtps.subscriber.SubscriberListener;

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
         if(listener != null)
         {
            matchingInfo.getGuid().fromPrimitives(guidHigh, guidLow);
            matchingInfo.setStatus(MatchingInfo.MatchingStatus.values[status.swigValue()]);
            listener.onSubscriptionMatched(FastRTPSSubscriber.this, matchingInfo);
         }
      }

      @Override
      public void onNewCacheChangeAdded()
      {
         if(listener != null)
         {
            listener.onNewDataMessage(FastRTPSSubscriber.this);
         }
      }

      @Override
      public boolean getKey(long cacheChangePtr, short encoding, int dataLength)
      {
         payload.setEncapsulation(encoding);
         payload.setLength(dataLength);
         impl.getData(cacheChangePtr, payload.getData());
         if(!topicDataType.isGetKeyDefined())
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

   public FastRTPSSubscriber(TopicDataType<?> topicDataType, FastRTPSSubscriberAttributes attributes, SubscriberListener listener,
                             NativeParticipantImpl participantImpl)
         throws IOException
   {

      if (!attributes.getUnicastLocatorList().isValid())
      {
         throw new IllegalArgumentException("Unicast Locator List for Publisher contains invalid Locator");
      }
      if (!attributes.getMulticastLocatorList().isValid())
      {
         throw new IllegalArgumentException(" Multicast Locator List for Publisher contains invalid Locator");
      }
      if (!attributes.getOutLocatorList().isValid())
      {
         throw new IllegalArgumentException("Output Locator List for Publisher contains invalid Locator");
      }

      this.attributes = attributes;
      this.topicDataType = (TopicDataType<Object>) topicDataType;
      this.topicData = topicDataType.createData();
      this.listener = listener;
      this.payload = new SerializedPayload(topicDataType.getTypeSize());
      this.topicKind = TopicKind_t.swigToEnum(attributes.getTopic().getTopicKind().ordinal());
      this.ownershipQosPolicyKind = attributes.getQos().getM_ownership().getKind();

      fastRTPSAttributes = attributes.createFastRTPSTopicAttributes();

      ReaderQos qos = attributes.getQos();
      if (!qos.checkQos() || !fastRTPSAttributes.checkQos())
      {
         throw new IllegalArgumentException("Invalid QoS settings");
      }

      impl = new NativeSubscriberImpl(attributes.getEntityID(), attributes.getUserDefinedID(), topicDataType.getTypeSize(),
                                      MemoryManagementPolicy_t.swigToEnum(attributes.getHistoryMemoryPolicy().ordinal()), fastRTPSAttributes, qos,
                                      attributes.getTimes(), attributes.getUnicastLocatorList(), attributes.getMulticastLocatorList(),
                                      attributes.getMulticastLocatorList(), attributes.isExpectsInlineQos(), participantImpl, new NativeSubscriberListenerImpl());
   }

   @Override
   public Guid getGuid()
   {
      return guid;
   }

   @Override
   public void waitForUnreadMessage()
   {
      // TODO Auto-generated method stub

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
         long cacheChange = impl.readnextData(payload.getData(), sampleInfoMarshaller, topicKind, ownershipQosPolicyKind);
         if (cacheChange != 0)
         {
            impl.decreaseUnreadCount();
            if (sampleInfoMarshaller.getChangeKind() == ChangeKind_t.ALIVE.swigValue())
            {
               payload.setEncapsulation(sampleInfoMarshaller.getEncapsulation());
               payload.setLength(sampleInfoMarshaller.getDataLength());
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
   public boolean takeNextData(Object data, SampleInfo info)
   {
      boolean ret = false;
      impl.lock();
      {

      }
      impl.unlock();
      return ret;
   }

   @Override
   public SubscriberAttributes<?, ?, ?> getAttributes()
   {
      return attributes;
   }

   @Override
   public boolean isInCleanState()
   {
      // TODO Auto-generated method stub
      return false;
   }

   public void delete()
   {
      impl.delete();
   }

}
