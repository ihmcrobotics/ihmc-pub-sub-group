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
package us.ihmc.pubsub.examples;

import us.ihmc.idl.generated.chat.ChatMessage;
import us.ihmc.idl.generated.chat.ChatMessagePubSubType;
import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.DomainFactory;
import us.ihmc.pubsub.DomainFactory.PubSubImplementation;
import us.ihmc.pubsub.common.LogLevel;
import us.ihmc.pubsub.common.MatchingInfo;
import us.ihmc.pubsub.common.SampleInfo;
import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.participant.ParticipantDiscoveryInfo;
import us.ihmc.pubsub.participant.ParticipantListener;
import us.ihmc.pubsub.subscriber.Subscriber;
import us.ihmc.pubsub.subscriber.SubscriberListener;

import java.io.IOException;

public class XMLSubscriberExample
{

   private class ParticipantListenerImpl implements ParticipantListener
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

   private class SubscriberListenerImpl implements SubscriberListener
   {
      private final ChatMessage data = new ChatMessage();
      private final SampleInfo info = new SampleInfo();

      @Override
      public void onNewDataMessage(Subscriber subscriber)
      {
         if (subscriber.takeNextData(data, info))
         {
            System.out.println(data.getSender().toString() + ": " + data.getMsg().toString());
         }
      }

      @Override
      public void onSubscriptionMatched(Subscriber subscriber, MatchingInfo info)
      {
         System.out.println("New publisher matched");
         System.out.println("Status: " + info.getStatus());
         System.out.println("Guid: " + info.getGuid().toString());
      }
   }

   public XMLSubscriberExample() throws IOException
   {
      Domain domain = DomainFactory.getDomain(PubSubImplementation.FAST_RTPS);

      domain.setLogLevel(LogLevel.INFO);

      String participantXml = "<profiles>\n" + "    <participant profile_name=\"INMEM_PARTICIPANT\">\n" + "        <domainId>1</domainId>\n" + "        <rtps>\n" + "            <name>Participant Name</name>\n" + "            <builtin>\n" + "                <discovery_config>\n" + "                    <discoveryProtocol>CLIENT</discoveryProtocol>\n" + "                    <discoveryServersList>\n" + "                        <RemoteServer prefix=\"44.53.00.5f.45.50.52.4f.53.49.4d.41\">\n" + "                            <metatrafficUnicastLocatorList>\n" + "                            <locator>\n" + "                                <udpv4>\n" + "                                    <address>127.0.0.1</address>\n" + "                                    <port>11811</port>\n" + "                                </udpv4>\n" + "                            </locator>\n" + "                            </metatrafficUnicastLocatorList>\n" + "                        </RemoteServer>\n" + "                    </discoveryServersList>\n" + "                    <clientAnnouncementPeriod>\n" + "                    <!-- change default to 250 ms -->\n" + "                        <nanosec>250000000</nanosec>\n" + "                    </clientAnnouncementPeriod>\n" + "                </discovery_config>\n" + "            </builtin>\n" + "        </rtps>\n" + "    </participant>\n" + "</profiles>";
      Participant participant = domain.createParticipant(participantXml, new ParticipantListenerImpl());

      ChatMessagePubSubType dataType = new ChatMessagePubSubType();
      domain.registerType(participant, dataType);

      String subscriberXml = "<profiles>\n" + "    <subscriber profile_name=\"INMEM_SUBSCRIBER\">\n" + "        <topic>\n" + "            <name>chatter</name>\n" + "            <dataType>chat::ChatMessage</dataType>\n" + "            <historyQos>\n" + "                <kind>KEEP_ALL</kind>\n" + "            </historyQos>\n" + "        </topic>\n" + "\n" + "        <qos> <!-- dataWriterQosPoliciesType -->\n" + "            <durability>\n" + "                <kind>TRANSIENT_LOCAL</kind>\n" + "            </durability>\n" + "            <reliability>\n" + "                <kind>BEST_EFFORT</kind>\n" + "            </reliability>\n" + "            <partition>\n" + "                <names>\n" + "                    <name>us/ihmc</name>\n" + "                </names>\n" + "            </partition>\n" + "        </qos>\n" + "    </subscriber>\n" + "</profiles>\n";
      Subscriber subscriber = domain.createSubscriber(participant, "INMEM_SUBSCRIBER", subscriberXml, dataType, new SubscriberListenerImpl());
   }

   public static void main(String[] args) throws IOException, InterruptedException
   {
      new XMLSubscriberExample();
      Thread.currentThread().join();
   }
}
