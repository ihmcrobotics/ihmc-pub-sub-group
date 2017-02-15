package us.ihmc.idl.generated.sensor_msgs;

import java.io.IOException;

import us.ihmc.rtps.common.SerializedPayload;
import us.ihmc.rtps.TopicDataType;
import us.ihmc.idl.CDR;

public class HeaderPubSubType implements TopicDataType<Header>
{
	public static final String name = "sensor_msgs::Header";
	private final CDR serializeCDR = new CDR();
	private final CDR deserializeCDR = new CDR();
	
	
	
    public HeaderPubSubType()
    {
        
    }
    
       @Override
   public void serialize(Header data, SerializedPayload serializedPayload) throws IOException
   {
      serializeCDR.serialize(serializedPayload);
      data.serialize(serializeCDR);
   }

   @Override
   public void deserialize(SerializedPayload serializedPayload, Header data) throws IOException
   {
      deserializeCDR.deserialize(serializedPayload);
      data.deserialize(deserializeCDR);
   }

   @Override
   public int getTypeSize()
   {
      return Header.getMaxCdrSerializedSize();
   }

   @Override
   public String getName()
   {
      return name;
   }

   @Override
   public Header createData()
   {
      return new Header();
   }
}