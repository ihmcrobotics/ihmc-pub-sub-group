package us.ihmc.rtps.impl.fastRTPS;

import java.io.IOException;

import us.ihmc.rtps.TopicDataType;
import us.ihmc.rtps.attributes.PublisherAttributes;
import us.ihmc.rtps.common.Guid;
import us.ihmc.rtps.publisher.Publisher;
import us.ihmc.rtps.publisher.PublisherListener;

public class FastRTPSPublisher implements Publisher
{

   private final NativePublisherImpl impl;
   private TopicAttributes fastRTPSAttributes;
   private ThroughputControllerDescriptor throughputController;

   public FastRTPSPublisher(TopicDataType<?> topicDataType, FastRTPSPublisherAttributes attributes, PublisherListener listener, NativeParticipantImpl participant)
         throws IOException, IllegalArgumentException
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

      fastRTPSAttributes = attributes.createFastRTPSTopicAttributes();
      throughputController = attributes.createTroughputControllerDescriptor();

      WriterQos qos = attributes.getQos();
      if (!qos.checkQos() || !fastRTPSAttributes.checkQos())
      {
         throw new IllegalArgumentException("Invalid QoS settings");
      }

      impl = new NativePublisherImpl(attributes.getEntityID(), attributes.getUserDefinedID(), topicDataType.getTypeSize(),
                                     MemoryManagementPolicy_t.swigToEnum(attributes.getHistoryMemoryPolicy().ordinal()), fastRTPSAttributes, qos,
                                     attributes.getTimes(), attributes.getUnicastLocatorList(), attributes.getMulticastLocatorList(),
                                     attributes.getOutLocatorList(), throughputController, participant);

   }

   @Override
   public void write(Object data)
   {
      // TODO Auto-generated method stub

   }

   @Override
   public Guid getGuid()
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public PublisherAttributes<?, ?, ?> getAttributes()
   {
      // TODO Auto-generated method stub
      return null;
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
}
