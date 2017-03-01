package us.ihmc.rtps.impl.fastRTPS;

import us.ihmc.pubsub.attributes.ReliabilityKind;
import us.ihmc.pubsub.attributes.WriterQosHolder;

public class FastRTPSWriterQosHolder extends WriterQosHolder<WriterQos>
{
   private final boolean ownMemory;

   FastRTPSWriterQosHolder()
   {
      super(new WriterQos());
      ownMemory = true;
   }

   FastRTPSWriterQosHolder(WriterQos writerQos)
   {
      super(writerQos);
      ownMemory = false;

   }

   public void delete()
   {
      if (ownMemory)
      {
         getWriterQos().delete();

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
      getWriterQos().getM_reliability().setKind(FastRTPSCommonFunctions.toCppReliabilityQosPolicyKind(reliabilityKind));
   }

   @Override
   public ReliabilityKind getReliabilityKind()
   {
      return FastRTPSCommonFunctions.toJavaReliabilityKind(getWriterQos().getM_reliability().getKind());
   }
}
