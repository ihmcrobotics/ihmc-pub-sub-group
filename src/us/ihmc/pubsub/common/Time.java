package us.ihmc.pubsub.common;

/**
 * Time class.
 * 
 * @author Jesper Smith
 *
 */
public class Time
{

   public static final Time Infinite = new Time(0x7fffffff, 0xffffffff);
   public static final Time Zero = new Time(0, 0);
   public static final Time Invalid = new Time(-1, 0xffffffff);

   private int seconds;
   private long fraction;

   /**
    * 
    * Create new time object
    * 
    * @param seconds
    * @param fraction Fraction of second (1 fraction = 1/(2^32) seconds) 
    */
   public Time(int seconds, long fraction)
   {
      this.seconds = seconds;
      this.fraction = fraction;
   }

   public Time()
   {
      
   }
   
   public int getSeconds()
   {
      return seconds;
   }

   public void setSeconds(int seconds)
   {
      this.seconds = seconds;
   }

   public long getFraction()
   {
      return fraction;
   }

   public void setFraction(long fraction)
   {
      this.fraction = fraction;
   }

   
   public String toString()
   {
      return String.format("%.2f", seconds + (fraction / Math.pow(2, 32)));
   }
}
