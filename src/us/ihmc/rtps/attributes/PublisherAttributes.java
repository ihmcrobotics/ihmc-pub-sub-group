package us.ihmc.rtps.attributes;

/**
 * Class PublisherAttributes, used by the user to define the attributes of a Publisher.
 * 
 * @author Jesper Smith
 *
 * @param <T>
 */
public class PublisherAttributes<WriterQos_t, WriterTimes_t, LocatorList_t>
{

   public enum MemoryManagementPolicy
   {
      PREALLOCATED_MEMORY_MODE,
      /** Preallocated memory. Size set to the data type maximum. Largest memory footprint but smalles allocation count. **/
      PREALLOCATED_WITH_REALLOC_MEMORY_MODE,
      /** Default size preallocated, requires reallocation when a bigger message arrives. Smaller memory footprint at the cost of an increased allocation count. **/
      DYNAMIC_RESERVE_MEMORY_MODE /** Dynamic allocation at the time of message arrival. Least memory footprint but highest allocation count. **/
   }

   private int userDefinedID = -1;
   private int entityID = -1;
   protected final MemoryManagementPolicy historyMemoryPolicy = MemoryManagementPolicy.PREALLOCATED_MEMORY_MODE;

   protected final TopicAttributes topic = new TopicAttributes();
   protected final WriterQos_t qos;
   protected final WriterTimes_t times;
   protected final LocatorList_t unicastLocatorList;
   protected final LocatorList_t multicastLocatorList;
   protected final LocatorList_t outLocatorList;
   protected final TroughputControllerDescriptor throughputController = new TroughputControllerDescriptor();

   protected PublisherAttributes(WriterQos_t qos, WriterTimes_t times, LocatorList_t unicastLocatorList, LocatorList_t multicastLocatorList,
                              LocatorList_t outLocatorList)
   {
      this.qos = qos;
      this.times = times;
      this.unicastLocatorList = unicastLocatorList;
      this.multicastLocatorList = multicastLocatorList;
      this.outLocatorList = outLocatorList;
   }

   public int getUserDefinedID()
   {
      return userDefinedID;
   }

   public void setUserDefinedID(int userDefinedID)
   {
      this.userDefinedID = userDefinedID;
   }

   public int getEntityID()
   {
      return entityID;
   }

   public void setEntityID(int entityID)
   {
      this.entityID = entityID;
   }

   public MemoryManagementPolicy getHistoryMemoryPolicy()
   {
      return historyMemoryPolicy;
   }

   public TopicAttributes getTopic()
   {
      return topic;
   }

   public WriterQos_t getQos()
   {
      return qos;
   }

   public WriterTimes_t getTimes()
   {
      return times;
   }

   public LocatorList_t getUnicastLocatorList()
   {
      return unicastLocatorList;
   }

   public LocatorList_t getMulticastLocatorList()
   {
      return multicastLocatorList;
   }

   public LocatorList_t getOutLocatorList()
   {
      return outLocatorList;
   }

   public TroughputControllerDescriptor getThroughputController()
   {
      return throughputController;
   }
   
   

}
