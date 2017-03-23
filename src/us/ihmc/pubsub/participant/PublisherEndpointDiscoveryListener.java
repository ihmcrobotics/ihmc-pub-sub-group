package us.ihmc.pubsub.participant;

import java.util.ArrayList;

import us.ihmc.pubsub.attributes.Locator;
import us.ihmc.pubsub.attributes.TopicAttributes.TopicKind;
import us.ihmc.pubsub.attributes.WriterQosHolder;
import us.ihmc.pubsub.common.Guid;

/**
 * Listener for the publisher endpoint discovery protocol
 * 
 * @author Jesper Smith
 *
 */
public interface PublisherEndpointDiscoveryListener
{

   /**
    * Callback for a new topic change event.
    *
    * 
    * @param isAlive
    * @param guid
    * @param unicastLocatorList
    * @param multicastLocatorList
    * @param participantGuid
    * @param typeName
    * @param topicName
    * @param userDefinedId
    * @param typeMaxSerialized
    * @param topicKind
    * @param writerQosHolder holds implementation specific version of the WriterQos attributes. Cast to the implementation specific datatype. Only valid till this method returns.
    */
   void publisherTopicChange(boolean isAlive, Guid guid, ArrayList<Locator> unicastLocatorList, ArrayList<Locator> multicastLocatorList,
                             Guid participantGuid, String typeName, String topicName, int userDefinedId, long typeMaxSerialized, TopicKind topicKind,
                             WriterQosHolder writerQosHolder);

}
