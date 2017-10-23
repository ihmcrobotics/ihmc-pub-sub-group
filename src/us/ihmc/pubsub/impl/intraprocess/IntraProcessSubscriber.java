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
package us.ihmc.pubsub.impl.intraprocess;

import java.io.IOException;

import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.common.Guid;
import us.ihmc.pubsub.common.MatchingInfo;
import us.ihmc.pubsub.common.MatchingInfo.MatchingStatus;
import us.ihmc.pubsub.common.SampleInfo;
import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.subscriber.Subscriber;
import us.ihmc.pubsub.subscriber.SubscriberListener;

class IntraProcessSubscriber implements Subscriber
{

   private final TopicDataType<?> topicDataType;
   private final Guid guid;
   private final IntraProcessDomainImpl domain;
   private final IntraProcessParticipant participant;
   private final IntraProcessSubscriberAttributes attr;
   private final SubscriberListener listener;

   IntraProcessSubscriber(Guid guid, IntraProcessDomainImpl domain, IntraProcessParticipant intraProcessParticipant, IntraProcessSubscriberAttributes attr,
                          SubscriberListener listener)
         throws IOException
   {
      TopicDataType<?> topicDataType = intraProcessParticipant.getTopicDataType(attr.getTopic().getTopicDataType());
      if (topicDataType == null)
      {
         throw new IOException("Cannot registered publisher with topic " + attr.getTopic().getTopicDataType() + ". Topic data type is not registered.");
      }
      this.topicDataType = topicDataType.newInstance();
      this.guid = guid;
      this.domain = domain;
      this.participant = intraProcessParticipant;
      this.attr = attr;
      this.listener = listener;

   }

   @Override
   public Guid getGuid()
   {
      return guid;
   }

   @Override
   public void waitForUnreadMessage(int timeoutInMilliseconds) throws InterruptedException
   {
      // TODO Auto-generated method stub

   }

   @Override
   public boolean readNextData(Object data, SampleInfo info) throws IOException
   {
      // TODO Auto-generated method stub
      return false;
   }

   @Override
   public boolean takeNextData(Object data, SampleInfo info) throws IOException
   {
      // TODO Auto-generated method stub
      return false;
   }

   @Override
   public IntraProcessSubscriberAttributes getAttributes()
   {
      return attr;
   }

   @Override
   public boolean isInCleanState()
   {
      return true;
   }

   @Override
   public boolean isAvailable()
   {
      return true;
   }

   public void notifySubscriberListener(IntraProcessPublisher publisher, MatchingStatus matchedMatching)
   {
      if (listener != null)
      {
         MatchingInfo info = new MatchingInfo();
         info.setStatus(matchedMatching);
         info.getGuid().set(publisher.getGuid());
         listener.onSubscriptionMatched(this, info);
      }
   }

   public Participant getParticipant()
   {
      return participant;
   }

}
