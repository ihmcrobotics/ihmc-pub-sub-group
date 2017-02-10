package us.ihmc.rtps.common;

/** 
 * 
 * This class is used to specify a sample.
 * 
 * @author Jesper Smith
 *
 */
public class SampleIdentity
{
   private final Guid guid = new Guid();
   private final SequenceNumber sequenceNumber = new SequenceNumber();

   public Guid getGuid()
   {
      return guid;
   }

   public SequenceNumber getSequenceNumber()
   {
      return sequenceNumber;
   }

}
