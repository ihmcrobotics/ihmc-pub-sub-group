package us.ihmc.pubsub.attributes;

public class WriterQosHolder <T>
{
   private final T writerQos;
   
   public WriterQosHolder(T writerQos)
   {
      this.writerQos = writerQos;
   }
   
   T getWriterQos()
   {
      return writerQos;
   }
}
