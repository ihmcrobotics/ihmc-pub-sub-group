package us.ihmc.pubsub.attributes;

/**
 * Class QosPolicy, base for all QoS policies defined for Writers and Readers.
 */
public class QosPolicy
{
   private boolean sendAlways = false;
   private boolean hasChanged = false;
   
   public QosPolicy(boolean sendAlways)
   {
      this.sendAlways = sendAlways;
   }

   public boolean isSendAlways()
   {
      return sendAlways;
   }

   public void setSendAlways(boolean sendAlways)
   {
      this.sendAlways = sendAlways;
   }

   public boolean isHasChanged()
   {
      return hasChanged;
   }

   public void setHasChanged(boolean hasChanged)
   {
      this.hasChanged = hasChanged;
   }

}
