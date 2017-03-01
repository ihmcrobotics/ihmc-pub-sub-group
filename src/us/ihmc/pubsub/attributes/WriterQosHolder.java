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
}
