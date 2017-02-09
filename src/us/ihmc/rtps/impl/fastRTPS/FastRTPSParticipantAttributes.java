package us.ihmc.rtps.impl.fastRTPS;

import us.ihmc.rtps.attributes.ParticipantAttributes;
import us.ihmc.rtps.common.Time;

public class FastRTPSParticipantAttributes extends ParticipantAttributes<RTPSParticipantAttributes>
{
   private final BuiltinAttributes builtin;
   private final Time_t time = new Time_t();
   public FastRTPSParticipantAttributes()
   {
      super(new RTPSParticipantAttributes());
      this.builtin = rtps().getBuiltin();
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
