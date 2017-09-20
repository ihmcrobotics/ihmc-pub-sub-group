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

import java.util.List;

import us.ihmc.pubsub.attributes.DurabilityKind;
import us.ihmc.pubsub.attributes.OwnerShipPolicyKind;
import us.ihmc.pubsub.attributes.PublishModeKind;
import us.ihmc.pubsub.attributes.PublisherAttributes;
import us.ihmc.pubsub.attributes.ReliabilityKind;
import us.ihmc.pubsub.attributes.WriterQosHolder;

public class JRTPSPublisherAttributes extends PublisherAttributes
{
   private final WriterQosHolder writerQos = new WriterQosHolder()
   {
      
      @Override
      public void setReliabilityKind(ReliabilityKind reliabilityKind)
      {
         // TODO Auto-generated method stub
         
      }
      
      @Override
      public void setOwnershipPolicyKind(OwnerShipPolicyKind ownerShipPolicyKind)
      {
         // TODO Auto-generated method stub
         
      }
      
      @Override
      public void setDurabilityKind(DurabilityKind durabilityKind)
      {
         // TODO Auto-generated method stub
         
      }
      
      @Override
      public ReliabilityKind getReliabilityKind()
      {
         // TODO Auto-generated method stub
         return null;
      }
      
      @Override
      public List<String> getPartitions()
      {
         // TODO Auto-generated method stub
         return null;
      }
      
      @Override
      public OwnerShipPolicyKind getOwnershipPolicyKind()
      {
         // TODO Auto-generated method stub
         return null;
      }
      
      @Override
      public DurabilityKind getDurabilityKind()
      {
         // TODO Auto-generated method stub
         return null;
      }
      
      @Override
      public void addPartition(String name)
      {
         // TODO Auto-generated method stub
         
      }
      
      @Override
      public void setPublishMode(PublishModeKind publishMode)
      {
         // TODO Auto-generated method stub
         
      }
      
      @Override
      public <T> T getWriterQos()
      {
         // TODO Auto-generated method stub
         return null;
      }
      
      @Override
      public PublishModeKind getPublishMode()
      {
         // TODO Auto-generated method stub
         return null;
      }
   };
   
   @Override
   public WriterQosHolder getQos()
   {
      return writerQos;
   }

   @Override
   public <T> T getTimes()
   {
      // TODO Auto-generated method stub
      return null;
   }

}
