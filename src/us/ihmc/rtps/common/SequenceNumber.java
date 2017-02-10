package us.ihmc.rtps.common;

/**
 * Structure SequenceNumber_t, different for each change in the same writer
 * 
 * @author Jesper Smith
 *
 */
public class SequenceNumber
{
   private int high;
   private long low;

   public int getHigh()
   {
      return high;
   }

   public void setHigh(int high)
   {
      this.high = high;
   }

   public long getLow()
   {
      return low;
   }

   public void setLow(long low)
   {
      this.low = low;
   }

}
