package us.ihmc.rtps.impl.fastRTPS;

import us.ihmc.pubsub.attributes.DurabilityKind;
import us.ihmc.pubsub.attributes.OwnerShipPolicyKind;
import us.ihmc.pubsub.attributes.ReliabilityKind;
import us.ihmc.pubsub.attributes.WriterQosHolder;

public class FastRTPSWriterQosHolder implements WriterQosHolder<WriterQos>
{
   private final boolean ownMemory;
   private final WriterQos writerQos;

   public WriterQos getWriterQos()
   {
      return writerQos;
   }

   FastRTPSWriterQosHolder()
   {
      this.writerQos = new WriterQos();
      ownMemory = true;
   }

   FastRTPSWriterQosHolder(WriterQos writerQos)
   {
      this.writerQos = writerQos;
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
   
   @Override
   public DurabilityKind getDurabilityKind()
   {      
      return FastRTPSCommonFunctions.toJavaDurabilityKind(getWriterQos().getM_durability().getKind());
   }

   @Override
   public void setDurabilityKind(DurabilityKind durabilityKind)
   {
      getWriterQos().getM_durability().setKind(FastRTPSCommonFunctions.toCppDurabilityKind(durabilityKind));
   }

   @Override
   public OwnerShipPolicyKind getOwnershipPolicyKind()
   {
      return FastRTPSCommonFunctions.toJavaOwnershipQosPolicyKind(getWriterQos().getM_ownership().getKind());
   }

   @Override
   public void setOwnershipPolicyKind(OwnerShipPolicyKind ownerShipPolicyKind)
   {
      getWriterQos().getM_ownership().setKind(FastRTPSCommonFunctions.toCppOwnershipQosPolicyKind(ownerShipPolicyKind));
   }
}
