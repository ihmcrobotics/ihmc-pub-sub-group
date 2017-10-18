/*
 * Copyright 2017 Florida Institute for Human and Machine Cognition (IHMC)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
package us.ihmc.rtps.impl.jrtps;

import java.io.IOException;
import java.util.HashMap;

import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.ParticipantAttributes;
import us.ihmc.pubsub.attributes.PublisherAttributes;
import us.ihmc.pubsub.attributes.SubscriberAttributes;
import us.ihmc.pubsub.attributes.TopicAttributes.TopicKind;
import us.ihmc.pubsub.common.Guid;
import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.participant.PublisherEndpointDiscoveryListener;
import us.ihmc.pubsub.participant.SubscriberEndpointDiscoveryListener;
import us.ihmc.pubsub.publisher.Publisher;
import us.ihmc.pubsub.publisher.PublisherListener;
import us.ihmc.pubsub.subscriber.Subscriber;
import us.ihmc.pubsub.subscriber.SubscriberListener;

public class JRTPSParticipant implements Participant
{
   private final HashMap<String, TopicDataType<?>> types = new HashMap<>();

   private final JRTPSParticipantAttributes attr;

   private final net.sf.jrtps.udds.Participant participantImpl;
   private final Guid guid;

   public JRTPSParticipant(JRTPSParticipantAttributes attr)
   {
      this.attr = attr;

      participantImpl = new net.sf.jrtps.udds.Participant((int) attr.getDomain(), 1);

      guid = new Guid();
      guid.fromBytes(participantImpl.getGuid().getBytes());

   }

   @SuppressWarnings({"unchecked", "rawtypes"})
   void registryType(TopicDataType<?> type)
   {
      types.put(type.getName(), type);
      participantImpl.setMarshaller(type.createData().getClass(), new JRTPSTopicDataMarshaller(type));
   }

   @Override
   public Guid getGuid()
   {
      return guid;
   }

   @Override
   public ParticipantAttributes getAttributes()
   {
      return attr;
   }

   @Override
   public void registerEndpointDiscoveryListeners(PublisherEndpointDiscoveryListener publisherEndpointDiscoveryListener,
                                                  SubscriberEndpointDiscoveryListener subscriberEndpointDiscoveryListener)
         throws IOException
   {
      System.err.println("TODO: Implement JRTPSParticipant.registerEndpointDiscoveryListeners");
   }

   @Override
   public int get_no_publisher(String target_topic)
   {
      return 0;
   }

   @Override
   public int get_no_subscribers(String target_topic)
   {
      return 0;
   }

   @Override
   public boolean isAvailable()
   {
      return true;
   }

   Subscriber createSubscriber(SubscriberAttributes subscriberAttributes, SubscriberListener listener)
   {
      // TODO Auto-generated method stub
      TopicDataType<?> topicDataType = types.get(subscriberAttributes.getTopic().getTopicDataType());

      if (topicDataType == null)
      {
         throw new IllegalArgumentException("Type: " + subscriberAttributes.getTopic().getTopicDataType() + " is not registered");
      }
      if (subscriberAttributes.getTopic().getTopicKind() == TopicKind.WITH_KEY && !topicDataType.isGetKeyDefined())
      {
         throw new IllegalArgumentException("Keyed topic needs getKey function");
      }

      return new JRTPSSubscriber(topicDataType, subscriberAttributes, listener, participantImpl);
   }

   Publisher createPublisher(PublisherAttributes publisherAttributes, PublisherListener listener)
   {
      TopicDataType<?> topicDataType = types.get(publisherAttributes.getTopic().getTopicDataType());

      if (topicDataType == null)
      {
         throw new IllegalArgumentException("Type: " + publisherAttributes.getTopic().getTopicDataType() + " is not registered");
      }
      if (publisherAttributes.getTopic().getTopicKind() == TopicKind.WITH_KEY && !topicDataType.isGetKeyDefined())
      {
         throw new IllegalArgumentException("Keyed topic needs getKey function");
      }

      
      
      return new JRTPSPublisher(topicDataType, publisherAttributes, listener, participantImpl);
   }

}
