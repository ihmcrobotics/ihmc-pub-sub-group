package us.ihmc.pubsub.common;

/**
 * Class SampleInfo with information that is provided along a sample when reading data from a Subscriber. 
 * 
 * @author Jesper Smith
 *
 */
public class SampleInfo
{
   private int dataLength;
   private ChangeKind sampleKind;
   private int ownershipStrength;
   private final Time sourceTimestamp = new Time();
   private final InstanceHandle instanceHandle = new InstanceHandle();
   private final SampleIdentity sampleIdentity = new SampleIdentity();
   private final SampleIdentity relatedSampleIdentity = new SampleIdentity();

   public ChangeKind getSampleKind()
   {
      return sampleKind;
   }

   public void setSampleKind(ChangeKind sampleKind)
   {
      this.sampleKind = sampleKind;
   }

   /**
    * 
    * @return Ownership Strength of the writer of the sample (0 if the ownership kind is set to SHARED_OWNERSHIP_QOS)
    */
   public int getOwnershipStrength()
   {
      return ownershipStrength;
   }

   public void setOwnershipStrength(int ownershipStrength)
   {
      this.ownershipStrength = ownershipStrength;
   }

   /**
    * 
    * @return Source timestamp of the sample
    */
   public Time getSourceTimestamp()
   {
      return sourceTimestamp;
   }

   public InstanceHandle getInstanceHandle()
   {
      return instanceHandle;
   }

   public SampleIdentity getSampleIdentity()
   {
      return sampleIdentity;
   }

   public SampleIdentity getRelatedSampleIdentity()
   {
      return relatedSampleIdentity;
   }

   /**
    * @return the size of this sample in bytes
    */
   public int getDataLength()
   {
      return dataLength;
   }

   /**
    * Set the size of this sample in bytes
    * @param dataLength
    */
   public void setDataLength(int dataLength)
   {
      this.dataLength = dataLength;
   }

}
