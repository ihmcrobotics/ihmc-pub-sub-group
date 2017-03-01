package us.ihmc.rtps.impl.fastRTPS;

import us.ihmc.pubsub.attributes.DurabilityKind;
import us.ihmc.pubsub.attributes.OwnerShipPolicyKind;
import us.ihmc.pubsub.attributes.ReaderQosHolder;
import us.ihmc.pubsub.attributes.ReliabilityKind;

public class FastRTPSReaderQosHolder implements ReaderQosHolder<ReaderQos>
{
   private final boolean ownMemory;

   private final ReaderQos readerQos;

   public FastRTPSReaderQosHolder()
   {
      this.readerQos = new ReaderQos();
      ownMemory = true;

   }

   public FastRTPSReaderQosHolder(ReaderQos readerQos)
   {
      this.readerQos = readerQos;
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

   @Override
   public ReaderQos getReaderQos()
   {
      return readerQos;
   }

   @Override
   public DurabilityKind getDurabilityKind()
   {      
      return FastRTPSCommonFunctions.toJavaDurabilityKind(getReaderQos().getM_durability().getKind());
   }

   @Override
   public void setDurabilityKind(DurabilityKind durabilityKind)
   {
      getReaderQos().getM_durability().setKind(FastRTPSCommonFunctions.toCppDurabilityKind(durabilityKind));
   }

   @Override
   public OwnerShipPolicyKind getOwnershipPolicyKind()
   {
      return FastRTPSCommonFunctions.toJavaOwnershipQosPolicyKind(getReaderQos().getM_ownership().getKind());
   }

   @Override
   public void setOwnershipPolicyKind(OwnerShipPolicyKind ownerShipPolicyKind)
   {
      getReaderQos().getM_ownership().setKind(FastRTPSCommonFunctions.toCppOwnershipQosPolicyKind(ownerShipPolicyKind));
   }
   
   
}
