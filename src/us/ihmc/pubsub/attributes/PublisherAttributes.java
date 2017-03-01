package us.ihmc.pubsub.attributes;

import java.util.ArrayList;
import java.util.List;

/**
 * Class PublisherAttributes, used by the user to define the attributes of a Publisher.
 * 
 * @author Jesper Smith
 *
 * @param <T>
 */
public class PublisherAttributes<WriterQos_t, WriterTimes_t>
{

   private int userDefinedID = -1;
   private int entityID = -1;
   protected final MemoryManagementPolicy historyMemoryPolicy = MemoryManagementPolicy.PREALLOCATED_MEMORY_MODE;

   protected final TopicAttributes topic = new TopicAttributes();
   protected final WriterQosHolder<WriterQos_t> qos;
   protected final WriterTimes_t times;
   protected final ArrayList<Locator> unicastLocatorList = new ArrayList<>();
   protected final ArrayList<Locator> multicastLocatorList = new ArrayList<>();
   protected final ArrayList<Locator> outLocatorList = new ArrayList<>();
   protected final ThroughputControllerDescriptor throughputController = new ThroughputControllerDescriptor();

   protected PublisherAttributes(WriterQosHolder<WriterQos_t> qos, WriterTimes_t times)
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

   public MemoryManagementPolicy getHistoryMemoryPolicy()
   {
      return historyMemoryPolicy;
   }

   public TopicAttributes getTopic()
   {
      return topic;
   }

   public WriterQosHolder<WriterQos_t> getQos()
   {
      return qos;
   }

   public WriterTimes_t getTimes()
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

   public ThroughputControllerDescriptor getThroughputController()
   {
      return throughputController;
   }

}
