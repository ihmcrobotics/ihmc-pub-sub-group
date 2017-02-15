package us.ihmc.idl;

import java.io.IOException;

import us.ihmc.rtps.TopicDataType;
import us.ihmc.rtps.common.SerializedPayload;

public class StringPubSubType implements TopicDataType<String>
{

   @Override
   public void serialize(String data, SerializedPayload serializedPayload) throws IOException
   {
      
   }

   @Override
   public void deserialize(SerializedPayload serializedPayload, String data) throws IOException
   {
      
   }

   @Override
   public int getTypeSize()
   {
      return 255;
   }

   @Override
   public String getName()
   {
      return "String";
   }

   @Override
   public String createData()
   {
      return new String();
   }

}
