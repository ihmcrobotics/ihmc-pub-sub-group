package us.ihmc.pubsub.attributes;

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
    * 
    * @return true if the endpoint is a writer (publisher), false otherwise 
    */
   boolean isWriter();

}