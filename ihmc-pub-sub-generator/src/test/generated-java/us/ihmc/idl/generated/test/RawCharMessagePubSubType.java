package us.ihmc.idl.generated.test;

/**
* 
* Topic data type of the struct "RawCharMessage" defined in "RawCharMessage.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from RawCharMessage.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit RawCharMessage.idl instead.
*
*/
public class RawCharMessagePubSubType implements us.ihmc.pubsub.TopicDataType<RawCharMessage>
{
   public static final java.lang.String name = "test::RawCharMessage";

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(RawCharMessage data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, RawCharMessage data) throws java.io.IOException
   {
      deserializeCDR.deserialize(serializedPayload);
      read(data, deserializeCDR);
      deserializeCDR.finishDeserialize();
   }

   public static int getMaxCdrSerializedSize()
   {
      return getMaxCdrSerializedSize(0);
   }

   public static int getMaxCdrSerializedSize(int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);current_alignment += (10000000 * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(RawCharMessage data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(RawCharMessage data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getData().size() * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      return current_alignment - initial_alignment;
   }

   public static void write(RawCharMessage data, us.ihmc.idl.CDR cdr)
   {
      if(data.getData().size() <= 10000000)
      cdr.write_type_e(data.getData());else
          throw new RuntimeException("data field exceeds the maximum length");

   }

   public static void read(RawCharMessage data, us.ihmc.idl.CDR cdr)
   {
      cdr.read_type_e(data.getData());	

   }

   @Override
   public final void serialize(RawCharMessage data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_e("data", data.getData());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, RawCharMessage data)
   {
      ser.read_type_e("data", data.getData());
   }

   public static void staticCopy(RawCharMessage src, RawCharMessage dest)
   {
      dest.set(src);
   }

   @Override
   public RawCharMessage createData()
   {
      return new RawCharMessage();
   }
   @Override
   public int getTypeSize()
   {
      return us.ihmc.idl.CDR.getTypeSize(getMaxCdrSerializedSize());
   }

   @Override
   public java.lang.String getName()
   {
      return name;
   }
   
   public void serialize(RawCharMessage data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(RawCharMessage data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(RawCharMessage src, RawCharMessage dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public RawCharMessagePubSubType newInstance()
   {
      return new RawCharMessagePubSubType();
   }
}
