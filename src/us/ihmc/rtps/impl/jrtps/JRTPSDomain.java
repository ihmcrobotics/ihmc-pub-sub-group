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

import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.ParticipantAttributes;
import us.ihmc.pubsub.attributes.PublisherAttributes;
import us.ihmc.pubsub.attributes.SubscriberAttributes;
import us.ihmc.pubsub.common.LogLevel;
import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.participant.ParticipantListener;
import us.ihmc.pubsub.publisher.Publisher;
import us.ihmc.pubsub.publisher.PublisherListener;
import us.ihmc.pubsub.subscriber.Subscriber;
import us.ihmc.pubsub.subscriber.SubscriberListener;

public class JRTPSDomain implements Domain
{
   private final HashMap<Participant, JRTPSParticipant> participants = new HashMap<>();
   
   @Override
   public void setLogLevel(LogLevel level)
   {
      // TODO Auto-generated method stub

   }

   @Override
   public synchronized Participant createParticipant(ParticipantAttributes att, ParticipantListener participantListener) throws IOException
   {
      if(att instanceof JRTPSParticipantAttributes)
      {
         JRTPSParticipant jrtpsParticipant = new JRTPSParticipant((JRTPSParticipantAttributes) att);
         participants.put(jrtpsParticipant, jrtpsParticipant);
         return jrtpsParticipant;
      }
      else
      {
         throw new IllegalArgumentException("ParticipantAttributes<?> is not of base class JRTPSParticipantAttributes");
      }
   }

   @Override
   public Publisher createPublisher(Participant participant, PublisherAttributes publisherAttributes, PublisherListener listener)
         throws IOException, IllegalArgumentException
   {
      // TODO Auto-generated method stub
      return participants.get(participant).createPublisher(publisherAttributes, listener);
   }

   @Override
   public Subscriber createSubscriber(Participant participant, SubscriberAttributes subscriberAttributes, SubscriberListener listener)
         throws IOException, IllegalArgumentException
   {
      return participants.get(participant).createSubscriber(subscriberAttributes, listener);
   }

   @Override
   public boolean removeParticipant(Participant participant)
   {
      // TODO Auto-generated method stub
      return false;
   }

   @Override
   public boolean removePublisher(Publisher publisher)
   {
      // TODO Auto-generated method stub
      return false;
   }

   @Override
   public boolean removeSubscriber(Subscriber subscriber)
   {
      // TODO Auto-generated method stub
      return false;
   }

   @Override
   public TopicDataType<?> getRegisteredType(Participant participant, String typeName)
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public void registerType(Participant participant, TopicDataType<?> topicDataType) throws IllegalArgumentException
   {
      participants.get(participant).registryType(topicDataType);
   }

   @Override
   public void unregisterType(Participant participant, String typeName) throws IOException
   {
      // TODO Auto-generated method stub

   }

   @Override
   public void stopAll()
   {
      // TODO Auto-generated method stub

   }

   @Override
   public SubscriberAttributes createSubscriberAttributes()
   {
      return new JRTPSSubscriberAttributes();
   }

   @Override
   public PublisherAttributes createPublisherAttributes()
   {
      return new JRTPSPublisherAttributes();
   }

   @Override
   public ParticipantAttributes createParticipantAttributes()
   {
      return new JRTPSParticipantAttributes();
   }

}
