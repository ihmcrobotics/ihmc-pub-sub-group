package us.ihmc.pubsub;

import us.ihmc.rtps.impl.fastRTPS.FastRTPSDomain;

public class DomainFactory
{
   public enum PubSubImplementation
   {
      FAST_RTPS;
   }
   
   private static Domain domain = null;
   public static synchronized Domain getDomain(PubSubImplementation impl)
   {
      if(domain == null)
      {
         domain = new FastRTPSDomain();
      }
      
      return domain;
   }
}
