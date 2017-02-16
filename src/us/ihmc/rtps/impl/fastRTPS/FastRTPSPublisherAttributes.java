package us.ihmc.rtps.impl.fastRTPS;

import us.ihmc.pubsub.attributes.PublisherAttributes;

public class FastRTPSPublisherAttributes extends PublisherAttributes<WriterQos, WriterTimes, LocatorList_t>
{

   FastRTPSPublisherAttributes()
   {
      super(new WriterQos(), new WriterTimes(), new LocatorList_t(), new LocatorList_t(), new LocatorList_t());
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
