package us.ihmc.rtps.impl.fastRTPS;

import us.ihmc.rtps.attributes.PublisherAttributes;

public class FastRTPSPublisherAttributes extends PublisherAttributes<WriterQos, WriterTimes, LocatorList_t>
{

   FastRTPSPublisherAttributes()
   {
      super(new WriterQos(), new WriterTimes(), new LocatorList_t(), new LocatorList_t(), new LocatorList_t());
   }
   
   TopicAttributes createFastRTPSTopicAttributes()
   {
      TopicAttributes attributes = new TopicAttributes(topic.getTopicName(), topic.getTopicDataType(),TopicKind_t.swigToEnum(topic.getTopicKind().ordinal()));
      
      HistoryQosPolicy historyQos = attributes.getHistoryQos();
      historyQos.setDepth(topic.getHistoryQos().getDepth());
      historyQos.setKind(HistoryQosPolicyKind.swigToEnum(topic.getHistoryQos().getKind().ordinal()));
      historyQos.setHasChanged(topic.getHistoryQos().isHasChanged());
      
      
      ResourceLimitsQosPolicy resourceLimitsQosPolicy = attributes.getResourceLimitsQos();
      resourceLimitsQosPolicy.setAllocated_samples(topic.getResourceLimitsQosPolicy().getAllocated_samples());
      resourceLimitsQosPolicy.setHasChanged(topic.getResourceLimitsQosPolicy().isHasChanged());
      resourceLimitsQosPolicy.setMax_instances(topic.getResourceLimitsQosPolicy().getMax_instances());
      resourceLimitsQosPolicy.setMax_samples(topic.getResourceLimitsQosPolicy().getMaxSamples());
      resourceLimitsQosPolicy.setMax_samples_per_instance(topic.getResourceLimitsQosPolicy().getMax_samples_per_instance());
      
      return attributes;
      
   }
   
   ThroughputControllerDescriptor createTroughputControllerDescriptor()
   {
      ThroughputControllerDescriptor descriptor = new ThroughputControllerDescriptor(throughputController.getBytesPerPeriod(), throughputController.getPeriodMillisecs());
      return descriptor;
   }
   
   public void delete()
   {
      this.qos.delete();
      this.times.delete();
      this.unicastLocatorList.delete();
      this.multicastLocatorList.delete();
      this.outLocatorList.delete();
   }
   
   @Override
   public void finalize()
   {
      delete();
   }
   
}
