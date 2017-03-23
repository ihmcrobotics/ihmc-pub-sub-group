package us.ihmc.rtps.impl.fastRTPS;

import us.ihmc.pubsub.attributes.PublisherAttributes;

public class FastRTPSPublisherAttributes extends PublisherAttributes
{
   private final WriterTimes times = new WriterTimes();
   private final FastRTPSWriterQosHolder qos = new FastRTPSWriterQosHolder();


   FastRTPSPublisherAttributes()
   {
      super();
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

   @Override
   public FastRTPSWriterQosHolder getQos()
   {
      return qos;
   }

   @SuppressWarnings("unchecked")
   @Override
   public WriterTimes getTimes()
   {
      return times;
   }
   
}
