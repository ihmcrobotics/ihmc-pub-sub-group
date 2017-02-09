package us.ihmc.rtps.example;

import java.io.IOException;
import java.nio.ByteOrder;

import us.ihmc.rtps.TopicDataType;
import us.ihmc.rtps.common.SerializedPayload;

public class ByteArrayTopicDataType implements TopicDataType<byte[]>
{
   
   private final int maxSize;
   private final String name;
   private final ByteOrder order;
   
   public ByteArrayTopicDataType(int maxSize, String name, ByteOrder order)
   {
      this.name = name;
      this.maxSize = maxSize;
      this.order = order;
   }

   @Override
   public void serialize(byte[] data, SerializedPayload serializedPayload) throws IOException
   {
      if(data.length > maxSize)
      {
         throw new IOException("Data size is more than the maximum length");
      }
      
      serializedPayload.setEncapsulation(order == ByteOrder.BIG_ENDIAN ? SerializedPayload.CDR_BE : SerializedPayload.CDR_LE);
      serializedPayload.getData().clear();
      serializedPayload.getData().put(data);
      serializedPayload.getData().flip();
      
      serializedPayload.setLength(data.length);
      serializedPayload.setMax_size(maxSize);
   }

   @Override
   public void deserialize(SerializedPayload serializedPayload, byte[] data) throws IOException
   {
      serializedPayload.getData().get(data, 0, serializedPayload.getLength());
   }

   @Override
   public int getTypeSize()
   {
      return maxSize;
   }

   @Override
   public String getName()
   {
      return name;
   }

}
