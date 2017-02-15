package us.ihmc.idl.generated.sensor_msgs;

import java.io.IOException;

import us.ihmc.rtps.common.SerializedPayload;
import us.ihmc.rtps.TopicDataType;
import us.ihmc.idl.CDR;

public class TimePubSubType implements TopicDataType<Time>
{
	public static final String name = "sensor_msgs::Time";
	private final CDR serializeCDR = new CDR();
	private final CDR deserializeCDR = new CDR();
	
	
	
    public TimePubSubType()
    {
        
    }
    
       @Override
   public void serialize(Time data, SerializedPayload serializedPayload) throws IOException
   {
      serializeCDR.serialize(serializedPayload);
      data.serialize(serializeCDR);
   }

   @Override
   public void deserialize(SerializedPayload serializedPayload, Time data) throws IOException
   {
      deserializeCDR.deserialize(serializedPayload);
      data.deserialize(deserializeCDR);
   }

   @Override
   public int getTypeSize()
   {
      return Time.getMaxCdrSerializedSize();
   }

   @Override
   public String getName()
   {
      return name;
   }

   @Override
   public Time createData()
   {
      return new Time();
   }
}