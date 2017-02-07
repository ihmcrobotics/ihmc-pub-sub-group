package us.ihmc.rtps;

import us.ihmc.rtps.impl.fastRTPS.FastRTPSDomain;

public class DomainFactory
{
   private static Domain domain = null;
   public static synchronized Domain getDomain()
   {
      if(domain == null)
      {
         domain = new FastRTPSDomain();
      }
      
      return domain;
   }
}
