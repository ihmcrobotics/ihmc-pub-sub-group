package us.ihmc.pubsub.common;

/**
 * Structure SequenceNumber, different for each change in the same writer
 * 
 * @author Jesper Smith
 *
 */
public class SequenceNumber
{
   private int high;
   private long low;

   /**
    * @return High 32 bits for sequence number
    */
   public int getHigh()
   {
      return high;
   }

   public void setHigh(int high)
   {
      this.high = high;
   }

   /**
    * 
    * @return Low 32bits for sequence number
    */
   public long getLow()
   {
      return low;
   }

   public void setLow(long low)
   {
      this.low = low;
   }
   
   public void set(int high, long low)
   {
      this.high = high;
      this.low = low;
   }
   
   /**
    * Check if this < other
    * 
    * @param other 
    * @return true if this < other
    */
   public boolean lessThan(SequenceNumber other)
   {
      if(high > other.high)
      {
         return false;
      }
      else if (high < other.high)
      {
         return true;
      }
      else
      {
         if(low < other.low)
         {
            return true;
         }
      }
      return false;
   }

   /**
    * Get this sequence number as 64 bit long
    * 
    * @return sequence number as long, -1 if not defined
    */
   public long get()
   {
      return getAsLong();
   }
   
   /**
    * Get this sequence number as 64 bit long
    * 
    * @return sequence number as long, -1 if not defined
    */
   private long getAsLong()
   {
      if(high == -1)
      {
         return -1;
      }
      return (((long) high) << 32) + low;
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + high;
      result = prime * result + (int) (low ^ (low >>> 32));
      return result;
   }

   @Override
   public boolean equals(Object obj)
   {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      SequenceNumber other = (SequenceNumber) obj;
      if (high != other.high)
         return false;
      if (low != other.low)
         return false;
      return true;
   }

   
}
