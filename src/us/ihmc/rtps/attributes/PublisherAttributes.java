package us.ihmc.rtps.attributes;

/**
 * Class PublisherAttributes, used by the user to define the attributes of a Publisher.
 * 
 * @todo Make this a implementation-agnostic version
 * 
 * @author Jesper Smith
 *
 * @param <T>
 */
public class PublisherAttributes<T>
{
   /**
    * 
    * @param attributes Implementation specific representation of the underlying RTPS layer attributes
    */
   protected PublisherAttributes(T attributes)
   {
      this.attributes = attributes;
   }

   private final T attributes;

   /**
    * @return Implementation specific representation of the underlying RTPS layer attributes. 
    */
   public T getAttributes()
   {
      return attributes;
   }

   
}
