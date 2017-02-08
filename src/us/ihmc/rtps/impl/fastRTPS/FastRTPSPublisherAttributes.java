package us.ihmc.rtps.impl.fastRTPS;

import us.ihmc.rtps.attributes.PublisherAttributes;
import us.ihmc.rtps.impl.fastRTPS.LocatorList_t;
import us.ihmc.rtps.impl.fastRTPS.WriterQos;
import us.ihmc.rtps.impl.fastRTPS.WriterTimes;

public class FastRTPSPublisherAttributes extends PublisherAttributes<WriterQos, WriterTimes, LocatorList_t>
{

   FastRTPSPublisherAttributes()
   {
      super(new WriterQos(), new WriterTimes(), new LocatorList_t(), new LocatorList_t(), new LocatorList_t());
   }
   
}
