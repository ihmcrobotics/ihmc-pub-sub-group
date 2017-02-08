package us.ihmc.rtps.publisher;

import us.ihmc.rtps.attributes.PublisherAttributes;
import us.ihmc.rtps.common.Guid;

/**
 * Class Publisher, used to send data to associated subscribers.
 *
 * @author Jesper Smith
 *
 */
public interface Publisher
{
   /**
    * Write data to the topic
    * 
    * This method does not allocate memory
    * 
    * @param data
    */
   public void write(Object data);
   
   /**
    * This method does not allocate memory
    * 
    * @return the GUID_t of the associated RTPSWriter.
    */
   public Guid getGuid();
   
   /**
    * This method does not allocate memory
    * 
    * @return the Attributes of the Publisher
    */
   public PublisherAttributes<?, ?, ?> getAttributes();
}
