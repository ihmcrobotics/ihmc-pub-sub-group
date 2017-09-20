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
import java.util.List;

import net.sf.jrtps.QualityOfService;
import net.sf.jrtps.udds.DataReader;
import net.sf.jrtps.udds.Participant;
import net.sf.jrtps.udds.SampleListener;
import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.SubscriberAttributes;
import us.ihmc.pubsub.common.Guid;
import us.ihmc.pubsub.common.SampleInfo;
import us.ihmc.pubsub.subscriber.Subscriber;
import us.ihmc.pubsub.subscriber.SubscriberListener;

public class JRTPSSubscriber implements Subscriber
{
   
   private final TopicDataType<?> topicDataType;
   private final DataReader<?> dataReader;
   
   JRTPSSubscriber(TopicDataType<?> topicDataTypeIn, SubscriberAttributes attributes, SubscriberListener listener,
                   Participant participantImpl)
   {
      this.topicDataType = topicDataTypeIn.newInstance();
      
      
      QualityOfService qos = new QualityOfService();
      Class<? extends Object> topicClass = topicDataType.createData().getClass();
      dataReader = participantImpl.createDataReader(attributes.getTopic().getTopicName(), topicClass, attributes.getTopic().getTopicDataType(), qos);
      
      dataReader.addSampleListener(new SampleListener()
      {

         @Override
         public void onSamples(List samples)
         {
            System.out.println("GOT SAMPLES" + samples.size());
         }

      });
   }

   @Override
   public Guid getGuid()
   {
      // TODO Auto-generated method stub
      return null;
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
   public SubscriberAttributes getAttributes()
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public boolean isInCleanState()
   {
      // TODO Auto-generated method stub
      return false;
   }

   @Override
   public boolean isAvailable()
   {
      // TODO Auto-generated method stub
      return false;
   }

}
