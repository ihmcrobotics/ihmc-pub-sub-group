package us.ihmc.pubsub.attributes;

/**
 * Holder for the QoS Parameters. 
 *  
 * @author Jesper Smith
 *
 * @param <T>
 */
public interface ReaderQosHolder <T> extends QosInterface
{

   public T getReaderQos();
   
   @Override
   default boolean isWriter()
   {
      return false;
   }
}
