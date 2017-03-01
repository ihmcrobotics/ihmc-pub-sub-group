package us.ihmc.rtps.impl.fastRTPS;

import us.ihmc.pubsub.attributes.ReaderQosHolder;
import us.ihmc.pubsub.attributes.ReliabilityKind;

public class FastRTPSReaderQosHolder extends ReaderQosHolder<ReaderQos>
{
   private final boolean ownMemory;

   public FastRTPSReaderQosHolder()
   {
      super(new ReaderQos());
      ownMemory = true;

   }

   public FastRTPSReaderQosHolder(ReaderQos readerQos)
   {
      super(readerQos);
      ownMemory = false;
   }

   public void delete()
   {
      if (ownMemory)
      {
         getReaderQos().delete();
      }
   }

   @Override
   public void finalize()
   {
      delete();
   }

   @Override
   public void setReliabilityKind(ReliabilityKind reliabilityKind)
   {
      getReaderQos().getM_reliability().setKind(FastRTPSCommonFunctions.toCppReliabilityQosPolicyKind(reliabilityKind));
   }

   @Override
   public ReliabilityKind getReliabilityKind()
   {
      return FastRTPSCommonFunctions.toJavaReliabilityKind(getReaderQos().getM_reliability().getKind());
   }
}
