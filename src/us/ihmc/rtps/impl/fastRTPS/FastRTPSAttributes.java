package us.ihmc.rtps.impl.fastRTPS;


public class FastRTPSAttributes
{
   static TopicAttributes createAttributes(us.ihmc.rtps.attributes.TopicAttributes topic)
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
   
   static ThroughputControllerDescriptor createTroughputControllerDescriptor(us.ihmc.rtps.attributes.ThroughputControllerDescriptor throughputController)
   {
      ThroughputControllerDescriptor descriptor = new ThroughputControllerDescriptor(throughputController.getBytesPerPeriod(), throughputController.getPeriodMillisecs());
      return descriptor;
   }
}
