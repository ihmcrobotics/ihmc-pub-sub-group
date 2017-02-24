package us.ihmc.pubsub.attributes;

public class ReaderQosHolder <T>
{
   private final T readerQos;
   
   public ReaderQosHolder(T readerQos)
   {
      this.readerQos = readerQos;
   }
   
   T getWriterQos()
   {
      return readerQos;
   }
}
