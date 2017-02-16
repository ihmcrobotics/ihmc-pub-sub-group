package us.ihmc.pubsub.attributes;

/**
 * Descriptor for a Throughput Controller, containing all constructor information
 * for it. 
 */
public class ThroughputControllerDescriptor
{
   /**
    * Packet size in bytes that this controller will allow in a given period.
    * 
    * Default: Unsigned 32 bit integer max
    */
   private long bytesPerPeriod = 4294967295l;

   /**
    *  Window of time in which no more than 'bytesPerPeriod' bytes are allowed.
    */
   private long periodMillisecs = 0;

   public long getBytesPerPeriod()
   {
      return bytesPerPeriod;
   }

   public void setBytesPerPeriod(long bytesPerPeriod)
   {
      this.bytesPerPeriod = bytesPerPeriod;
   }

   public long getPeriodMillisecs()
   {
      return periodMillisecs;
   }

   public void setPeriodMillisecs(long periodMillisecs)
   {
      this.periodMillisecs = periodMillisecs;
   }

}
