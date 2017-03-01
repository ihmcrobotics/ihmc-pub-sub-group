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

}