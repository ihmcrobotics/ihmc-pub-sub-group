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
package us.ihmc.rtps.impl.fastRTPS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import us.ihmc.pubsub.attributes.DurabilityKind;
import us.ihmc.pubsub.attributes.OwnerShipPolicyKind;
import us.ihmc.pubsub.attributes.ReaderQosHolder;
import us.ihmc.pubsub.attributes.ReliabilityKind;

class FastRTPSReaderQosHolder implements ReaderQosHolder
{
   private final boolean ownMemory;

   private final ReaderQos readerQos;

   FastRTPSReaderQosHolder()
   {
      this.readerQos = new ReaderQos();
      ownMemory = true;
   }

   public FastRTPSReaderQosHolder(ReaderQos readerQos)
   {
      this();
      this.readerQos.setQos(readerQos, true);
   }

   public void delete()
   {
      if (ownMemory)
      {
         getReaderQos().delete();
      }
   }

   @Override
   public void finalize()
   {
      delete();
   }

   @Override
   public void setReliabilityKind(ReliabilityKind reliabilityKind)
   {
      getReaderQos().getM_reliability().setKind(FastRTPSCommonFunctions.toCppReliabilityQosPolicyKind(reliabilityKind));
   }

   @Override
   public ReliabilityKind getReliabilityKind()
   {
      return FastRTPSCommonFunctions.toJavaReliabilityKind(getReaderQos().getM_reliability().getKind());
   }

   @SuppressWarnings("unchecked")
   @Override
   public ReaderQos getReaderQos()
   {
      return readerQos;
   }

   @Override
   public DurabilityKind getDurabilityKind()
   {      
      return FastRTPSCommonFunctions.toJavaDurabilityKind(getReaderQos().getM_durability().getKind());
   }

   @Override
   public void setDurabilityKind(DurabilityKind durabilityKind)
   {
      getReaderQos().getM_durability().setKind(FastRTPSCommonFunctions.toCppDurabilityKind(durabilityKind));
   }

   @Override
   public OwnerShipPolicyKind getOwnershipPolicyKind()
   {
      return FastRTPSCommonFunctions.toJavaOwnershipQosPolicyKind(getReaderQos().getM_ownership().getKind());
   }

   @Override
   public void setOwnershipPolicyKind(OwnerShipPolicyKind ownerShipPolicyKind)
   {
      getReaderQos().getM_ownership().setKind(FastRTPSCommonFunctions.toCppOwnershipQosPolicyKind(ownerShipPolicyKind));
   }
   
   @Override
   public void addPartition(String name)
   {
      getReaderQos().getM_partition().push_back(name);
   }

   @Override
   public List<String> getPartitions()
   {
      ArrayList<String> partitions = new ArrayList<>();
      stringVector CppPartitions = getReaderQos().getM_partition().getNames();
      for(int i = 0; i < CppPartitions.size(); i++)
      {
         partitions.add(CppPartitions.get(i));
      }
      
      return Collections.unmodifiableList(partitions);
   }
}
