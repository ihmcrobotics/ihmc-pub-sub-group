package us.ihmc.pubsub.types;

import java.io.IOException;
import java.nio.ByteBuffer;

import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.common.SerializedPayload;

/**
 * A generic data type to send over raw byte buffers.
 * 
 * As the IHMC pub sub library assumes a predefined maximum data size, the max size has to be specified and will be allocated as buffer. 
 * Buffers will be pre-allocated and incur a double copy (native layer -> internal library layer -> user buffer). 
 * 
 * The topic name will include the maximum topic size in the following format:
 *    [name]::[maxSize]
 *    
 * On serialization, the data will be read from the source ByteBuffer from its current position to the limit.
 * On deserialization, the data will be put in the target ByteBuffer at its current position. Make sure there is enough space remaining for the incoming message.
 *    
 * @author Jesper Smith
 *
 */
public class ByteBufferPubSubType implements TopicDataType<ByteBuffer>
{
   private final String name;
   private final int maxSize;
   
   /**
    * Constructor for the ByteBuffer pub/sub type.
    * 
    * @param name desired topic name
    * @param maxSize maximum size of the buffer
    */
   public ByteBufferPubSubType(String name, int maxSize)
   {
      this.name = name + "::" + maxSize;
      this.maxSize = maxSize;
   }
   
   @Override
   public void serialize(ByteBuffer data, SerializedPayload serializedPayload) throws IOException
   {
      if(data.remaining() > maxSize)
      {
         throw new IOException("Data size is larger than the maximum size");
      }
      
      ByteBuffer target = serializedPayload.getData();
      target.clear();
      target.put(data);
      target.flip();
      serializedPayload.setLength(target.limit());
   }

   @Override
   public void deserialize(SerializedPayload serializedPayload, ByteBuffer data) throws IOException
   {
      if(serializedPayload.getLength() > data.remaining())
      {
         throw new IOException("ByteBuffer data does not have enough space remaining to accept the incoming message.");
      }
      
      ByteBuffer src = serializedPayload.getData();
      data.put(src);
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

   @Override
   public ByteBuffer createData()
   {
      return ByteBuffer.allocateDirect(maxSize);
   }

}
