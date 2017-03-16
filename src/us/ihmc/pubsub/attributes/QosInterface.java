package us.ihmc.pubsub.attributes;

import java.util.List;

public interface QosInterface
{

   /**
    * Sets the reliability kind of the Qos Parameters 
    * 
    * @param reliabilityKind
    */
   void setReliabilityKind(ReliabilityKind reliabilityKind);

   /**
    * 
    * @return the reliability setting for Qos
    */
   ReliabilityKind getReliabilityKind();
   
   
   /**
    * 
    * @return the durability settings of the Qos parameters
    */
   DurabilityKind getDurabilityKind();
   
   /**
    * 
    * @param durabilityKind the desired durability kind
    */
   void setDurabilityKind(DurabilityKind durabilityKind);
   
   
   /**
    * 
    * @return ownership policy of the QoS parameters
    */
   OwnerShipPolicyKind getOwnershipPolicyKind();
   
   /**
    * 
    * @param ownerShipPolicyKind the desired ownership policy
    */
   void setOwnershipPolicyKind(OwnerShipPolicyKind ownerShipPolicyKind);
   
   
   /**
    * Add partition to the list of partitions this endpoint is connected to
    * @param name
    */
   public abstract void addPartition(String name);
   
   /**
    * 
    * @return list of partitions this endpoint is connected to
    */
   public abstract List<String> getPartitions();
   
   /**
    * 
    * @return true if the endpoint is a writer (publisher), false otherwise 
    */
   boolean isWriter();

}