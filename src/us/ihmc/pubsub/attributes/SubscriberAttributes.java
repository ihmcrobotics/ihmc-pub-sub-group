package us.ihmc.pubsub.attributes;

/**
 * Class SubscriberAttributes, used by the user to define the attributes of a Subscriber.
 * 
 * @author Jesper Smith
 *
 * @param <ReaderQos_t>
 * @param <ReaderTimes_t>
 * @param <LocatorList_t>
 */
public abstract class SubscriberAttributes<ReaderQos_t, ReaderTimes_t, LocatorList_t>
{
   protected final TopicAttributes topic = new TopicAttributes();
   protected final ReaderQos_t qos;
   protected final ReaderTimes_t times;
   protected final LocatorList_t unicastLocatorList;
   protected final LocatorList_t multicastLocatorList;
   protected final LocatorList_t outLocatorList;

   private int userDefinedID = -1;
   private int entityID = -1;
   private boolean expectsInlineQos;
   private MemoryManagementPolicy historyMemoryPolicy = MemoryManagementPolicy.PREALLOCATED_MEMORY_MODE;

   public SubscriberAttributes(ReaderQos_t qos, ReaderTimes_t times, LocatorList_t unicastLocatorList, LocatorList_t multicastLocatorList,
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

   public boolean isExpectsInlineQos()
   {
      return expectsInlineQos;
   }

   public void setExpectsInlineQos(boolean expectsInlineQos)
   {
      this.expectsInlineQos = expectsInlineQos;
   }

   public MemoryManagementPolicy getHistoryMemoryPolicy()
   {
      return historyMemoryPolicy;
   }

   public void setHistoryMemoryPolicy(MemoryManagementPolicy historyMemoryPolicy)
   {
      this.historyMemoryPolicy = historyMemoryPolicy;
   }

   public TopicAttributes getTopic()
   {
      return topic;
   }

   public ReaderQos_t getQos()
   {
      return qos;
   }

   public ReaderTimes_t getTimes()
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

}
