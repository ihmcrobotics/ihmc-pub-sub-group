package us.ihmc.rtps.impl.fastRTPS;

public class FastRTPSTime
{
   public static final Time_t c_TimeInfinite = new Time_t(0x7fffffff,0xffffffff);
   public static final Time_t c_TimeZero = new Time_t(0,0);
   public static final Time_t c_TimeInvalid = new Time_t(-1,0xffffffff);

}
