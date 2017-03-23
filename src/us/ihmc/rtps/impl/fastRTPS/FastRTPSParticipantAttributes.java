package us.ihmc.rtps.impl.fastRTPS;

import us.ihmc.pubsub.attributes.ParticipantAttributes;
import us.ihmc.pubsub.common.Time;

public class FastRTPSParticipantAttributes extends ParticipantAttributes
{
   private final RTPSParticipantAttributes rtps = new RTPSParticipantAttributes();
   private final BuiltinAttributes builtin = rtps.getBuiltin();
   private final Time_t time = new Time_t();
   
   public FastRTPSParticipantAttributes()
   {
      super();
   }
   

   /**
    * @return Implementation specific representation of the underlying RTPS layer attributes. 
    */
   @SuppressWarnings("unchecked")
   public RTPSParticipantAttributes rtps()
   {
      return rtps;
   }

   @Override
   public void setName(String name)
   {
      rtps().setName(name);
   }

   @Override
   public void setDomainId(long domain)
   {
      builtin.setDomainId(domain);
   }

   @Override
   public void setLeaseDuration(Time time)
   {
      this.time.setSeconds(time.getSeconds());
      this.time.setFraction(time.getFraction());
      builtin.setLeaseDuration(this.time);
   }
   
   
   public void delete()
   {
      rtps().delete();
      time.delete();
   }
   
   public void finalize()
   {
      delete();
   }
}
