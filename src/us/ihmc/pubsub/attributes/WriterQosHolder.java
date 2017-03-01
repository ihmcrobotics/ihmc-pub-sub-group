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
public abstract class WriterQosHolder <T> implements QosInterface
{
   private final T writerQos;
   
   public WriterQosHolder(T writerQos)
   {
      this.writerQos = writerQos;
      setReliabilityKind(ReliabilityKind.BEST_EFFORT);
   }
   
   public T getWriterQos()
   {
      return writerQos;
   }
}
