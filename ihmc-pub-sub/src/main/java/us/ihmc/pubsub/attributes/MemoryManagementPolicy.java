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

public enum MemoryManagementPolicy
{
   PREALLOCATED_MEMORY_MODE,
   /** Preallocated memory. Size set to the data type maximum. Largest memory footprint but smalles allocation count. **/
   PREALLOCATED_WITH_REALLOC_MEMORY_MODE,
   /** Default size preallocated, requires reallocation when a bigger message arrives. Smaller memory footprint at the cost of an increased allocation count. **/
   DYNAMIC_RESERVE_MEMORY_MODE /** Dynamic allocation at the time of message arrival. Least memory footprint but highest allocation count. **/
}