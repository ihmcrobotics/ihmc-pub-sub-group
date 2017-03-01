package us.ihmc.rtps.impl.fastRTPS;

import us.ihmc.pubsub.attributes.SubscriberAttributes;

public class FastRTPSSubscriberAttributes extends SubscriberAttributes<ReaderQos, ReaderTimes>
{
   public FastRTPSSubscriberAttributes()
   {
      super(new FastRTPSReaderQosHolder(), new ReaderTimes());
   }

   TopicAttributes createFastRTPSTopicAttributes()
   {
      return FastRTPSAttributes.createAttributes(topic);
   }

   public void delete()
   {
      ((FastRTPSReaderQosHolder)this.qos).delete();
      this.times.delete();
   }

   @Override
   public void finalize()
   {
      delete();
   }
}
