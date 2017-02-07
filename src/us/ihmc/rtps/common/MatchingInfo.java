package us.ihmc.rtps.common;

/**
 * Class MatchingInfo contains information about the matching between two endpoints
 * 
 * @author Jesper Smith
 *
 */
public class MatchingInfo
{
   /**
    * Indicates whether the matched publication/subscription method of the PublisherListener or SubscriberListener has been called for a matching or a removal of a remote endpoint
    *
    */
   public enum MatchingStatus
   {
      /**
       * MATCHED_MATCHING, new publisher/subscriber found.
       */
      MATCHED_MATCHING,
      /**
       * REMOVED_MATCHING, publisher/subscriber removed.
       */
      REMOVED_MATCHING
   }
   
   private MatchingStatus status;
   private final Guid guid = new Guid();
   
   
   /**
    * 
    * This method does not allocate memory
    *  
    * @return status
    */
   public MatchingStatus getStatus()
   {
      return status;
   }
   public void setStatus(MatchingStatus status)
   {
      this.status = status;
   }
   
   /**
    * 
    * This method does not allocate memory
    * 
    * @return Remote endpoint GUID
    */
   public Guid getGuid()
   {
      return guid;
   }
   
   
}
