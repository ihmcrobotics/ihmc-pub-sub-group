package us.ihmc.pubsub.publisher;

import java.io.IOException;

import us.ihmc.pubsub.attributes.PublisherAttributes;
import us.ihmc.pubsub.common.Guid;

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
    * This method does not allocate memory except when an exception is thrown
    * 
    * @param data
    * @throws IOException 
    */
   public void write(Object data) throws IOException;
   
   
   /**
    * Dispose of a previously written data
    * 
    * This method does not allocate memory except when an exception is thrown
    * 
    * @param data
    * @throws IOException
    */
   public void dispose(Object data) throws IOException;
   
   /**
    * Dispose of a previously written data
    * 
    * This method does not allocate memory except when an exception is thrown
    * 
    * @param data
    * @throws IOException
    */
   public void unregister(Object data) throws IOException;
   
   /**
    * Dispose and unregister a previously written data
    * 
    * This method does not allocate memory except when an exception is thrown
    * 
    * @param data
    * @throws IOException
    */
   public void dispose_and_unregister(Object data) throws IOException;
   
   /**
    * Remove all the Changes in the associated RTPSWriter.
    * 
    * @return number of elements removed
    * @throws IOException if not all elements were removed
    */
   public int removeAllChange() throws IOException;
   
   
   /**
    * This method does not allocate memory
    * 
    * @return the GUID_t of the associated RTPSWriter.
    */
   public Guid getGuid();
   
   /**
    * This method does not allocate memory
    * 
    * 
    * 
    * @return the Attributes of the Publisher
    */
   public PublisherAttributes getAttributes();
}
