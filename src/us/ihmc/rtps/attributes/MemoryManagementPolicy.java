package us.ihmc.rtps.attributes;

public enum MemoryManagementPolicy
{
   PREALLOCATED_MEMORY_MODE,
   /** Preallocated memory. Size set to the data type maximum. Largest memory footprint but smalles allocation count. **/
   PREALLOCATED_WITH_REALLOC_MEMORY_MODE,
   /** Default size preallocated, requires reallocation when a bigger message arrives. Smaller memory footprint at the cost of an increased allocation count. **/
   DYNAMIC_RESERVE_MEMORY_MODE /** Dynamic allocation at the time of message arrival. Least memory footprint but highest allocation count. **/
}