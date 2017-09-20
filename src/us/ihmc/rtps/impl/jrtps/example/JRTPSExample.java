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
package us.ihmc.rtps.impl.jrtps.example;

import java.io.IOException;

import us.ihmc.idl.generated.Chat.ChatMessage;
import us.ihmc.idl.generated.Chat.ChatMessagePubSubType;
import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.DomainFactory;
import us.ihmc.pubsub.DomainFactory.PubSubImplementation;
import us.ihmc.pubsub.attributes.ParticipantAttributes;
import us.ihmc.pubsub.attributes.PublisherAttributes;
import us.ihmc.pubsub.attributes.ReliabilityKind;
import us.ihmc.pubsub.attributes.SubscriberAttributes;
import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.publisher.Publisher;
import us.ihmc.pubsub.subscriber.Subscriber;

public class JRTPSExample
{
   public static void main(String[] args) throws IOException, InterruptedException
   {
      Domain domain = DomainFactory.getDomain(PubSubImplementation.JRTPS);
      
      ParticipantAttributes attr = domain.createParticipantAttributes(1, "JRTPS");
      Participant participant = domain.createParticipant(attr);
      
      ChatMessagePubSubType type = new ChatMessagePubSubType();
      domain.registerType(participant, type);
      SubscriberAttributes subscriberAttributes = domain.createSubscriberAttributes(participant, type, "ChatBox", ReliabilityKind.BEST_EFFORT, "us/ihmc");
      Subscriber subscriber = domain.createSubscriber(participant, subscriberAttributes);
      
      PublisherAttributes publisherAttributes = domain.createPublisherAttributes(participant, type, "ChatBox", ReliabilityKind.RELIABLE, "us/ihmc");
      Publisher publisher = domain.createPublisher(participant, publisherAttributes);
      while(true)
      {
         Thread.sleep(1000);
         ChatMessage data = new ChatMessage();
         data.setMsg("BLAbLABLA");
         publisher.write(data);
      }
   }
}
