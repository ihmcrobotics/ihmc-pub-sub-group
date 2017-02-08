package us.ihmc.rtps.attributes;

/**
 * Class HistoryQosPolicy, defines the HistoryQos of the topic in the Writer or Reader side.
 * 
 */
public class HistoryQosPolicy extends QosPolicy
{
   /**
    * 
    * Enum HistoryQosPolicyKind, different kinds of History Qos for HistoryQosPolicy.
    *
    */
   public enum HistoryQosPolicyKind
   {
      KEEP_LAST_HISTORY_QOS, /** Keep only a number of samples, default value. **/
      KEEP_ALL_HISTORY_QOS /** Keep all samples until the ResourceLimitsQosPolicy are exhausted. **/

   }
   
   private HistoryQosPolicyKind kind = HistoryQosPolicyKind.KEEP_LAST_HISTORY_QOS;
   private int depth = 1;
   
   public HistoryQosPolicy()
   {
      super(true);
   }

   public HistoryQosPolicyKind getKind()
   {
      return kind;
   }

   public void setKind(HistoryQosPolicyKind kind)
   {
      this.kind = kind;
   }

   public int getDepth()
   {
      return depth;
   }

   public void setDepth(int depth)
   {
      this.depth = depth;
   }
   
}
