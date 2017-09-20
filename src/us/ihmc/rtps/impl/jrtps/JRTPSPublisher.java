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

import net.sf.jrtps.QualityOfService;
import net.sf.jrtps.udds.DataWriter;
import net.sf.jrtps.udds.Participant;
import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.PublisherAttributes;
import us.ihmc.pubsub.common.Guid;
import us.ihmc.pubsub.publisher.Publisher;
import us.ihmc.pubsub.publisher.PublisherListener;

public class JRTPSPublisher implements Publisher
{
   
   private final TopicDataType<?> topicDataType;
   private final DataWriter dataWriter;
   
   JRTPSPublisher(TopicDataType<?> topicDataTypeIn, PublisherAttributes publisherAttributes, PublisherListener listener,
                   Participant participantImpl)
   {
      this.topicDataType = topicDataTypeIn.newInstance();
      
      
      QualityOfService qos = new QualityOfService();
      Class<? extends Object> topicClass = topicDataType.createData().getClass();
      dataWriter = participantImpl.createDataWriter(publisherAttributes.getTopic().getTopicName(), topicClass, publisherAttributes.getTopic().getTopicDataType(), qos);
      

   }

   @Override
   public Guid getGuid()
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public boolean isAvailable()
   {
      // TODO Auto-generated method stub
      return true;
   }

   @Override
   public void write(Object data) throws IOException
   {
      dataWriter.write(data);
   }

   @Override
   public void dispose(Object data) throws IOException
   {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void unregister(Object data) throws IOException
   {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void dispose_and_unregister(Object data) throws IOException
   {
      // TODO Auto-generated method stub
      
   }

   @Override
   public int removeAllChange() throws IOException
   {
      // TODO Auto-generated method stub
      return 0;
   }

   @Override
   public PublisherAttributes getAttributes()
   {
      // TODO Auto-generated method stub
      return null;
   }

}
