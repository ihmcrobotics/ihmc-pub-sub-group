package us.ihmc.rtps.attributes;

/**
 * Class ParticipantAttributes, used by the user to define the attributes of a Participant.
 * 
 * @param <T>
 * 
 * @author Jesper Smith
 */
public abstract class ParticipantAttributes <T>
{
   private final T rtps;
   
   /**
    * @param rtps Implementation specific representation of the underlying RTPS layer attributes. 
    */
   protected ParticipantAttributes(T rtps)
   {
      this.rtps = rtps;
   }
   
   /**
    * @return Implementation specific representation of the underlying RTPS layer attributes. 
    */
   public T rtps()
   {
      return rtps;
   }
   
}
