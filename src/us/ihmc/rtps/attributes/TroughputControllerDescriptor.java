package us.ihmc.rtps.attributes;

/**
 * Descriptor for a Throughput Controller, containing all constructor information
 * for it. 
 */
public class TroughputControllerDescriptor
{
   /**
    * Packet size in bytes that this controller will allow in a given period.
    */
   private int bytesPerPeriod;

   /**
    *  Window of time in which no more than 'bytesPerPeriod' bytes are allowed.
    */
   private int periodMillisecs;

   public int getBytesPerPeriod()
   {
      return bytesPerPeriod;
   }

   public void setBytesPerPeriod(int bytesPerPeriod)
   {
      this.bytesPerPeriod = bytesPerPeriod;
   }

   public int getPeriodMillisecs()
   {
      return periodMillisecs;
   }

   public void setPeriodMillisecs(int periodMillisecs)
   {
      this.periodMillisecs = periodMillisecs;
   }

}
