package us.ihmc.pubsub.subscriber;

import us.ihmc.pubsub.common.MatchingInfo;

/**
 * Class SubscriberListener, it should be used by the end user to implement specific callbacks to certain actions.
 * 
 * @author Jesper Smith
 *
 */
public interface SubscriberListener
{
   /**
    * Virtual function to be implemented by the user containing the actions to be performed when a new Data Message is received
    * 
    * @param subscriber 
    */
   public void onNewDataMessage(Subscriber subscriber);

   /**
    * Virtual method to be called when the subscriber is matched with a new Writer (or unmatched); i.e., when a writer publishing in the same topic is discovered
    * 
    * @param subscriber
    * @param info
    */
   public void onSubscriptionMatched(Subscriber subscriber, MatchingInfo info);
}
