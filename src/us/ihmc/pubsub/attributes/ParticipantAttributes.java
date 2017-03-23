package us.ihmc.pubsub.attributes;

import us.ihmc.pubsub.common.Time;

/**
 * Class ParticipantAttributes, used by the user to define the attributes of a Participant.
 * 
 * @param <T>
 * 
 * @author Jesper Smith
 */
public abstract class ParticipantAttributes
{
   
   
   protected ParticipantAttributes()
   {
   }
   
   
   /**
    * Get implementation specific representation of the underlying RTPS layer attributes.
    * 
    * Implementations:
    *    FastRTPS: us.ihmc.rtps.impl.fastRTPS.RTPSParticipantAttributes
    * 
    * @return Implementation specific representation of the underlying RTPS layer attributes. 
    */
   public abstract <T> T rtps();
   
   /**
    * Convenience function to set the participant name in an implementation agnostic manner
    * 
    * @param name
    */
   public abstract void setName(String name);
   
   /**
    * Convenience function to set the participant domain id in an implementation agnostic manner
    * 
    * @param domain
    */
   public abstract void setDomainId(long domain);
   
   /**
    * Convenience function to set the participant lease duration an implementation agnostic manner
    * 
    * @param time
    */
   public abstract void setLeaseDuration(Time time);
}
