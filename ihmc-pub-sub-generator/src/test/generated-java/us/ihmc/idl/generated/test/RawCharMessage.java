package us.ihmc.idl.generated.test;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

public class RawCharMessage extends Packet<RawCharMessage> implements Settable<RawCharMessage>, EpsilonComparable<RawCharMessage>
{
   public us.ihmc.idl.IDLSequence.Char  data_;

   public RawCharMessage()
   {
      data_ = new us.ihmc.idl.IDLSequence.Char (10000000, "type_8");

   }

   public RawCharMessage(RawCharMessage other)
   {
      this();
      set(other);
   }

   public void set(RawCharMessage other)
   {
      data_.set(other.data_);
   }


   public us.ihmc.idl.IDLSequence.Char  getData()
   {
      return data_;
   }


   public static Supplier<RawCharMessagePubSubType> getPubSubType()
   {
      return RawCharMessagePubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return RawCharMessagePubSubType::new;
   }

   @Override
   public boolean epsilonEquals(RawCharMessage other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsCharSequence(this.data_, other.data_, epsilon)) return false;

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof RawCharMessage)) return false;

      RawCharMessage otherMyClass = (RawCharMessage) other;

      if (!this.data_.equals(otherMyClass.data_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("RawCharMessage {");
      builder.append("data=");
      builder.append(this.data_);
      builder.append("}");
      return builder.toString();
   }
}
