package us.ihmc.rtps.subscriber;

import java.io.IOException;

import us.ihmc.rtps.attributes.SubscriberAttributes;
import us.ihmc.rtps.common.Guid;
import us.ihmc.rtps.common.SampleInfo;

public interface Subscriber
{
   /**
    * Get the associated GUID.
    * 
    * This method does not allocate memory.
    * 
    * @return the associated GUID
    */
   public Guid getGuid();
   
   /**
    * Method to block the current thread until an unread message is available.
    * 
    * This method does not allocate memory
    * 
    */
   public void waitForUnreadMessage();
   
   /**
    * Read next unread Data from the Subscriber.
    * 
    * This method does not allocate memory.
    * 
    * @param data the object where you want the data stored.
    * @param info a SampleInfo structure that informs you about your sample.
    * 
    * @return True if a sample was read.
    */
   public boolean readNextData(Object data, SampleInfo info) throws IOException;
   
   /**
    * Take next Data from the Subscriber.
    * 
    * The data is removed from the subscriber.
    * 
    * This method does not allocate memory.
    * 
    * @param data the object where you want the data stored.
    * @param info a SampleInfo_t structure that informs you about your sample.
    * 
    * @return True if a sample was taken.
    */
   public boolean takeNextData(Object data, SampleInfo info) throws IOException;
   
   /**
    * Get the Attributes of the Subscriber.
    * 
    * This method does not allocate memory
    * 
    * @return Attributes of the subscriber
    */
   public SubscriberAttributes<?, ?, ?> getAttributes();
   
   /**
    * Returns there is a clean state with all Publishers. It occurs when the Subscriber received all samples sent by Publishers. In other words, its WriterProxies are up to date.
    * 
    * This method does not allocate memory
    * 
    * @return There is a clean state with all Publishers.
    */
   public boolean isInCleanState();
}
