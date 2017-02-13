package us.ihmc.rtps.impl.fastRTPS;

import us.ihmc.rtps.attributes.SubscriberAttributes;

public class FastRTPSSubscriberAttributes extends SubscriberAttributes<ReaderQos, ReaderTimes, LocatorList_t>
{
   public FastRTPSSubscriberAttributes()
   {
      super(new ReaderQos(), new ReaderTimes(), new LocatorList_t(), new LocatorList_t(), new LocatorList_t());
   }

   TopicAttributes createFastRTPSTopicAttributes()
   {
      return FastRTPSAttributes.createAttributes(topic);
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
