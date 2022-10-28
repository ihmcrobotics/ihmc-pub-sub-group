/**
 * Copyright 2017 Florida Institute for Human and Machine Cognition (IHMC)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package us.ihmc.pubsub.test;

import us.ihmc.idl.generated.test.RawCharMessage;
import us.ihmc.idl.generated.test.RawCharMessagePubSubType;
import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.DomainFactory;
import us.ihmc.pubsub.DomainFactory.PubSubImplementation;
import us.ihmc.pubsub.attributes.ParticipantAttributes;
import us.ihmc.pubsub.attributes.SubscriberAttributes;
import us.ihmc.pubsub.common.LogLevel;
import us.ihmc.pubsub.common.MatchingInfo;
import us.ihmc.pubsub.common.SampleInfo;
import us.ihmc.pubsub.common.Time;
import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.participant.ParticipantDiscoveryInfo;
import us.ihmc.pubsub.participant.ParticipantListener;
import us.ihmc.pubsub.subscriber.Subscriber;
import us.ihmc.pubsub.subscriber.SubscriberListener;

import java.io.IOException;
import java.util.Collections;

public class BigDataSubscriberTest
{
   private static int totalMessagesReceived;

   private static class ParticipantListenerImpl implements ParticipantListener
   {
      @Override
      public void onParticipantDiscovery(Participant participant, ParticipantDiscoveryInfo info)
      {
         System.out.println("New participant discovered");
         System.out.println("Status: " + info.getStatus());
         System.out.println("Guid: " + info.getGuid().toString());
         System.out.println("Name: " + info.getName());
      }
   }

   private static class SubscriberListenerImpl implements SubscriberListener<RawCharMessage>
   {
      private final RawCharMessage data = new RawCharMessage();
      private final SampleInfo info = new SampleInfo();

      @Override
      public void onNewDataMessage(Subscriber<RawCharMessage> subscriber)
      {
         if (subscriber.takeNextData(data, info))
         {
            System.out.println("Message " + (totalMessagesReceived++) + " Recv size: " + info.getDataLength());
         }
      }

      @Override
      public void onSubscriptionMatched(Subscriber<RawCharMessage> subscriber, MatchingInfo info)
      {
         System.out.println("New publisher matched");
         System.out.println("Status: " + info.getStatus());
         System.out.println("Guid: " + info.getGuid().toString());
      }
   }

   public BigDataSubscriberTest() throws IOException
   {
      Domain domain = DomainFactory.getDomain(PubSubImplementation.FAST_RTPS);

      domain.setLogLevel(LogLevel.INFO);

      ParticipantAttributes attributes2 = ParticipantAttributes.create()
                                                               .domainId(1)
                                                               .name("BigDataSubscriber")
                                                               .discoveryLeaseDuration(Time.Infinite);

      Participant participant = domain.createParticipant(attributes2, new ParticipantListenerImpl());

      RawCharMessagePubSubType dataType = new RawCharMessagePubSubType();
      domain.registerType(participant, dataType);

      SubscriberAttributes subscriberAttributes = SubscriberAttributes.create()
                                                                      .topicName("bigData")
                                                                      .topicDataType(dataType)
                                                                      .partitions(Collections.singletonList("us/ihmc"));

      domain.createSubscriber(participant, subscriberAttributes, new SubscriberListenerImpl());
   }

   public static void main(String[] args) throws IOException, InterruptedException
   {
      new BigDataSubscriberTest();
      Thread.currentThread().join();
   }
}
