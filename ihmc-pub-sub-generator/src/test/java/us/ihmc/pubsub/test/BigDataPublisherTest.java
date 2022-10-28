/**
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
package us.ihmc.pubsub.test;

import us.ihmc.idl.IDLSequence;
import us.ihmc.idl.generated.test.RawCharMessage;
import us.ihmc.idl.generated.test.RawCharMessagePubSubType;
import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.DomainFactory;
import us.ihmc.pubsub.DomainFactory.PubSubImplementation;
import us.ihmc.pubsub.attributes.ParticipantAttributes;
import us.ihmc.pubsub.attributes.PublisherAttributes;
import us.ihmc.pubsub.common.LogLevel;
import us.ihmc.pubsub.common.MatchingInfo;
import us.ihmc.pubsub.common.Time;
import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.participant.ParticipantDiscoveryInfo;
import us.ihmc.pubsub.participant.ParticipantListener;
import us.ihmc.pubsub.publisher.Publisher;
import us.ihmc.pubsub.publisher.PublisherListener;

import java.io.IOException;
import java.util.Collections;
import java.util.Random;

public class BigDataPublisherTest
{
   private static int totalMessagesPublished;

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

   private static class PublisherListenerImpl implements PublisherListener
   {
      @Override
      public void onPublicationMatched(Publisher publisher, MatchingInfo info)
      {
         System.out.println("New subscriber matched");
         System.out.println("Status: " + info.getStatus());
         System.out.println("Guid: " + info.getGuid().toString());
      }
   }

   public BigDataPublisherTest() throws IOException, InterruptedException
   {
      Domain domain = DomainFactory.getDomain(PubSubImplementation.FAST_RTPS);

      domain.setLogLevel(LogLevel.INFO);

      ParticipantAttributes attributes2 = ParticipantAttributes.create()
                                                               .domainId(112)
                                                               .name("BigDataPublisher")
                                                               .discoveryLeaseDuration(Time.Infinite);

      System.out.println(attributes2.marshall("test"));

      Participant participant = domain.createParticipant(attributes2, new ParticipantListenerImpl());

      RawCharMessagePubSubType dataType = new RawCharMessagePubSubType();
      domain.registerType(participant, dataType);

      PublisherAttributes attrs = PublisherAttributes.create()
                                                     .topicName("bigData")
                                                     .topicDataType(dataType)
                                                     .partitions(Collections.singletonList("us/ihmc"));

      Publisher publisher = domain.createPublisher(participant, attrs, new PublisherListenerImpl());

      Random random = new Random();

      long lastTestDataSizeIncrease = System.currentTimeMillis();
      int bigTestDataSize = 1;

      while (true)
      {
         char[] bigTestData = new char[bigTestDataSize];
         for (int i = 0; i < bigTestData.length; i++) {
            bigTestData[i] = (char)(random.nextInt(26) + 'a');
         }

         IDLSequence.Char charSeq = new IDLSequence.Char(1000000, "type_8");
         charSeq.add(bigTestData);

         RawCharMessage rawCharMessage = new RawCharMessage();
         rawCharMessage.data_ = charSeq;

         publisher.write(rawCharMessage);
         System.out.println("Data size:  " + bigTestDataSize + " Message no.:" + (totalMessagesPublished++));

         if (System.currentTimeMillis() - lastTestDataSizeIncrease >= 1000) {
            bigTestDataSize = bigTestDataSize * 2;
            lastTestDataSizeIncrease = System.currentTimeMillis();
         }

         Thread.sleep(10);
      }
   }

   public static void main(String[] args) throws IOException, InterruptedException
   {
      new BigDataPublisherTest();
   }
}
