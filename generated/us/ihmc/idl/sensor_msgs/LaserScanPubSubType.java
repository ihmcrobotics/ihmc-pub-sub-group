package us.ihmc.idl.sensor_msgs;

import java.io.IOException;

import us.ihmc.rtps.common.SerializedPayload;
import us.ihmc.rtps.TopicDataType;
import us.ihmc.idl.CDR;

public class LaserScanPubSubType implements TopicDataType<LaserScan>
{
	public static final String name = "sensor_msgs::LaserScan";
	private final CDR serializeCDR = new CDR();
	private final CDR deserializeCDR = new CDR();
	
	
	
    public LaserScanPubSubType()
    {
        
    }
    
       @Override
   public void serialize(LaserScan data, SerializedPayload serializedPayload) throws IOException
   {
      serializeCDR.init(serializedPayload);
      data.serialize(serializeCDR);
   }

   @Override
   public void deserialize(SerializedPayload serializedPayload, LaserScan data) throws IOException
   {
      deserializeCDR.init(serializedPayload);
      data.deserialize(deserializeCDR);
   }

   @Override
   public int getTypeSize()
   {
      return LaserScan.getMaxCdrSerializedSize();
   }

   @Override
   public String getName()
   {
      return name;
   }

   @Override
   public LaserScan createData()
   {
      return new LaserScan();
   }
}