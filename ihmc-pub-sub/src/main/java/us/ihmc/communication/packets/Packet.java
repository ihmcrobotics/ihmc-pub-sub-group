package us.ihmc.communication.packets;

import us.ihmc.communication.ros.generators.RosExportedField;
import us.ihmc.communication.ros.generators.RosIgnoredField;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

public abstract class Packet<T extends Packet<T>> implements EpsilonComparable<T>, Settable<T>
{
   @RosExportedField(documentation = "A unique id for the current message. This can be a timestamp or sequence number.\n"
         + "Only the unique id in the top level message is used, the unique id in nested messages is ignored.\n"
         + "Use /output/last_received_message for feedback about when the last message was received.\n"
         + "A message with a unique id equals to 0 will be interpreted as invalid and will not be processed by the controller.")
   public long uniqueId = 0;

   @RosIgnoredField
   public static final long INVALID_MESSAGE_ID = 0L;

   @RosIgnoredField
   public static final long VALID_MESSAGE_DEFAULT_ID = -1L;

   @RosIgnoredField
   public byte destination = (byte) PacketDestination.BROADCAST.ordinal();

   @RosIgnoredField
   public byte source = (byte) PacketDestination.BROADCAST.ordinal();

   public void setPacketInformation(Packet<?> other)
   {
      uniqueId = other.uniqueId;
      destination = other.destination;
      source = other.source;
   }

   public void setDestination(PacketDestination destination)
   {
      setDestination(destination.ordinal());
   }

   public void setDestination(int destination)
   {
      this.destination = (byte) destination;
   }

   public int getDestination()
   {
      return destination;
   }

   public void setSource(int source)
   {
      this.source = (byte) source;
   }

   public int getSource()
   {
      return source;
   }

   public long getUniqueId()
   {
      return uniqueId;
   }

   public void setUniqueId(long uniqueId)
   {
      this.uniqueId = uniqueId;
   }

   public boolean isClonable()
   {
      return true;
   }

   /**
    * Check the data held in that message.
    * It returns "null" if no error detected, otherwise it returns the error message.
    * The controller uses this validation to detect bad messages to throw away and report the error to the user.
    */
   public String validateMessage()
   {
      return null;
   }
}
