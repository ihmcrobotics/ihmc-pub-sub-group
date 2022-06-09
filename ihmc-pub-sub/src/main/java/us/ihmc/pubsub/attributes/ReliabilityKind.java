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
package us.ihmc.pubsub.attributes;

import com.eprosima.xmlschemas.fastrtps_profiles.ReliabilityQosKindType;

/**
 * Definition of the reliability QoS kind.
 * 
 * Note that subscribers and publishers needs to match reliability kind
 * 
 * Replaced by ReliabilityQosKindType
 * 
 * @author Jesper Smith
 *
 */
@Deprecated
public enum ReliabilityKind
{
   /**
    * Use reliable communication
    */
   RELIABLE,
   /**
    * Use best-effort communication 
    */
   BEST_EFFORT;
   
   public ReliabilityQosKindType toQosKind()
   {
      switch(this)
      {
         case RELIABLE:
            return ReliabilityQosKindType.RELIABLE;
         case BEST_EFFORT:
            return ReliabilityQosKindType.BEST_EFFORT;
      }
      
      throw new RuntimeException("Invalid kind");
   }
   
   
}
