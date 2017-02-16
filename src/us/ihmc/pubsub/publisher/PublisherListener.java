package us.ihmc.pubsub.publisher;

import us.ihmc.pubsub.common.MatchingInfo;

/**
 * Class PublisherListener, allows the end user to implement callbacks triggered by certain events.
 * 
 * @author Jesper Smith
 *
 */
public interface PublisherListener
{
   /**
    * This method is called when the Publisher is matched (or unmatched) against an endpoint. 
    * 
    * @param publisher
    * @param info Information regarding the matched subscriber
    */
   public void onPublicationMatched (Publisher publisher, MatchingInfo info);
}
