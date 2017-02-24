package us.ihmc.pubsub.participant;

import java.io.IOException;

import us.ihmc.pubsub.attributes.ParticipantAttributes;
import us.ihmc.pubsub.common.Guid;

/**
 * Class Participant used to group Publishers and Subscribers into a single working unit
 * 
 * @author Jesper Smith
 *
 */
public interface Participant
{
   /**
    * Get the GUID_t of the associated RTPSParticipant.
    *
    * This method does not allocate memory. 
    *
    * @return Guid
    */
   public Guid getGuid();
   
   /**
    * Get the ParticipantAttributes.
    * 
    * This method does not allocate memory
    * 
    * @return ParticipantAttributes.
    */
   public ParticipantAttributes<?> getAttributes();
   
   
   /**
    * Register a publisher and a subscriber endpoint discovery listener to this participant.
    * 
    *  This functionality is exposed to create debugging and visualization tools for an RTPS network. It is not guaranteed that all implementations support this method.
    *  
    *  This method can result in memory being allocated in the endpoint discovery listener calls.
    *  
    * @param publisherEndpointDiscoveryListener Listener for the publisher endpoint discovery protocol
    * @param subscriberEndpointDiscoveryListener Listener for the subscriber endpoint discovery protocol
    * 
    * @throws IOException when the Endpoint Discovery protocol is not used.
    */
   public void registerEndpointDiscoveryListeners(PublisherEndpointDiscoveryListener publisherEndpointDiscoveryListener, SubscriberEndpointDiscoveryListener subscriberEndpointDiscoveryListener) throws IOException;
   
   /**
    * 
    * @param target_topic Topic name to query
    * @return the number of local publishers registered to target_topic
    */
   public int get_no_publisher(String target_topic);
   
   /**
    * 
    * @param target_topic Topic name to query
    * @return the number of local subscribers registered to the target_topic
    */
   public int get_no_subscribers(String target_topic);
}
