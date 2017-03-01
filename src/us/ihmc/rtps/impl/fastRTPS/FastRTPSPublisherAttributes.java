package us.ihmc.rtps.impl.fastRTPS;

import us.ihmc.pubsub.attributes.PublisherAttributes;

public class FastRTPSPublisherAttributes extends PublisherAttributes<WriterQos, WriterTimes>
{

   FastRTPSPublisherAttributes()
   {
      super(new FastRTPSWriterQosHolder(), new WriterTimes());
   }
   
   TopicAttributes createFastRTPSTopicAttributes()
   {
      return FastRTPSAttributes.createAttributes(topic);
   }
   
   ThroughputControllerDescriptor createTroughputControllerDescriptor()
   {
      return FastRTPSAttributes.createTroughputControllerDescriptor(throughputController);
   }
   
   public void delete()
   {
      ((FastRTPSWriterQosHolder)this.qos).delete();
      this.times.delete();
   }
   
   @Override
   public void finalize()
   {
      delete();
   }
   
}
