package us.ihmc.pubsub.attributes;

import java.util.ArrayList;
import java.util.List;

/**
 * Class SubscriberAttributes, used by the user to define the attributes of a Subscriber.
 * 
 * @author Jesper Smith
 *
 * @param <ReaderQos_t>
 * @param <ReaderTimes_t>
 * @param <LocatorList_t>
 */
public abstract class SubscriberAttributes<ReaderQoS_t, ReaderTimes_t>
{
   protected final TopicAttributes topic = new TopicAttributes();
   protected final ReaderQosHolder<ReaderQoS_t> qos;
   protected final ReaderTimes_t times;
   protected final ArrayList<Locator> unicastLocatorList = new ArrayList<>();
   protected final ArrayList<Locator> multicastLocatorList = new ArrayList<>();
   protected final ArrayList<Locator> outLocatorList = new ArrayList<>();

   private int userDefinedID = -1;
   private int entityID = -1;
   private boolean expectsInlineQos;
   private MemoryManagementPolicy historyMemoryPolicy = MemoryManagementPolicy.PREALLOCATED_MEMORY_MODE;

   public SubscriberAttributes(ReaderQosHolder<ReaderQoS_t> qos, ReaderTimes_t times)
   {
      this.qos = qos;
      this.times = times;
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

   public ReaderQosHolder<ReaderQoS_t> getQos()
   {
      return qos;
   }

   public ReaderTimes_t getTimes()
   {
      return times;
   }

   public List<Locator> getUnicastLocatorList()
   {
      return unicastLocatorList;
   }

   public List<Locator> getMulticastLocatorList()
   {
      return multicastLocatorList;
   }

   public List<Locator> getOutLocatorList()
   {
      return outLocatorList;
   }

}
