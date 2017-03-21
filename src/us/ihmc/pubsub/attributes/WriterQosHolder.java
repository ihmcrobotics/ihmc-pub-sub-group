package us.ihmc.pubsub.attributes;

/**
 * Holder for the QoS Parameters. 
 *  
 * @author Jesper Smith
 *
 * @param <T>
 */
public interface WriterQosHolder <T> extends QosInterface
{
   
   public T getWriterQos();
   
   @Override
   default boolean isWriter()
   {
      return true;
   }
   
   /**
    * Set the publish mode QoS policy
    * 
    * Set to to ASYNCHRONOUS_PUBLISH_MODE if the data is expected to be over 65kB
    * 
    * @param publishMode
    */
   public void setPublishMode(PublishModeKind publishMode);
   
   /**
    * Get the publish mode QoS policy
    * @return
    */
   public PublishModeKind getPublishMode();
}
