package us.ihmc.pubsub.attributes;

/**
 * Holder for the QoS Parameters. 
 * 
 * Defaults to BEST_EFFORT relability
 * 
 * @author Jesper Smith
 *
 * @param <T>
 */
public abstract class ReaderQosHolder <T> implements QosInterface
{
   private final T readerQos;
   
   public ReaderQosHolder(T readerQos)
   {
      this.readerQos = readerQos;
   }
   
   public T getReaderQos()
   {
      return readerQos;
   }
}
