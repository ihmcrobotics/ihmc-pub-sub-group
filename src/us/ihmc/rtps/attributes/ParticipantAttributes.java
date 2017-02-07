package us.ihmc.rtps.attributes;

public class ParticipantAttributes <T>
{
   private final T rtps;
   
   public ParticipantAttributes(T rtps)
   {
      this.rtps = rtps;
   }
   
   public T rtps()
   {
      return rtps;
   }
   
}
