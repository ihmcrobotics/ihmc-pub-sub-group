package us.ihmc.pubsub.attributes;

/**
 * Holder for the QoS Parameters. 
 *  
 * @author Jesper Smith
 *
 * @param <T>
 */
public interface ReaderQosHolder extends QosInterface
{

   /**
    * Function to get an implementation specific version of the reader QoS parameters.
    * 
    * Versions:
    *    FastRTPS: us.ihmc.rtps.impl.fastRTPS.ReaderQos
    * 
    * @return Reader QoS parameters
    */
   public <T> T getReaderQos();
   
   @Override
   default boolean isWriter()
   {
      return false;
   }
}
