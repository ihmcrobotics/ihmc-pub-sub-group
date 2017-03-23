package us.ihmc.rtps.impl.fastRTPS;

import us.ihmc.pubsub.attributes.SubscriberAttributes;

public class FastRTPSSubscriberAttributes extends SubscriberAttributes
{
   private final FastRTPSReaderQosHolder qos = new FastRTPSReaderQosHolder();
   private final ReaderTimes times = new ReaderTimes();
   
   public FastRTPSSubscriberAttributes()
   {
      super();
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

   @Override
   public FastRTPSReaderQosHolder getQos()
   {
      return qos;
   }

   @SuppressWarnings("unchecked")
   @Override
   public ReaderTimes getTimes()
   {
      return times;
   }
}
