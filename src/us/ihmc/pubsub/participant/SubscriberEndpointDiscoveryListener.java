package us.ihmc.pubsub.participant;

import java.util.ArrayList;

import us.ihmc.pubsub.attributes.Locator;
import us.ihmc.pubsub.attributes.ReaderQosHolder;
import us.ihmc.pubsub.attributes.TopicAttributes.TopicKind;
import us.ihmc.pubsub.common.Guid;
import us.ihmc.rtps.impl.fastRTPS.ReaderQos;

/**
 * Listener for the subscriber endpoint discovery protocol
 * 
 * @author Jesper Smith
 *
 */
public interface SubscriberEndpointDiscoveryListener
{

   /**
    * Callback for a new topic change event.
    * 
    * @param isAlive
    * @param guid
    * @param expectsInlineQos
    * @param unicastLocatorList
    * @param multicastLocatorList
    * @param participantGuid
    * @param typeName
    * @param topicName
    * @param userDefinedId
    * @param javaTopicKind
    * @param readerQosHolder holds implementation specific version of the ReaderQos attributes. Cast to the implementation specific datatype. Only valid till this method returns.
    */
   void subscriberTopicChange(boolean isAlive, Guid guid, boolean expectsInlineQos, ArrayList<Locator> unicastLocatorList,
                              ArrayList<Locator> multicastLocatorList, Guid participantGuid, String typeName, String topicName, int userDefinedId,
                              TopicKind javaTopicKind, ReaderQosHolder<?> readerQosHolder);

}
