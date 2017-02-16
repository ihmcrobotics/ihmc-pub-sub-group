package us.ihmc.idl.generated.IDLElement;

import java.io.IOException;

import us.ihmc.rtps.common.SerializedPayload;
import us.ihmc.rtps.TopicDataType;
import us.ihmc.idl.CDR;

public class NestedElementPubSubType implements TopicDataType<NestedElement>
{
	public static final String name = "IDLElement::NestedElement";
	private final CDR serializeCDR = new CDR();
	private final CDR deserializeCDR = new CDR();
	
	
	
    public NestedElementPubSubType()
    {
        
    }
    
       @Override
   public void serialize(NestedElement data, SerializedPayload serializedPayload) throws IOException
   {
      serializeCDR.serialize(serializedPayload);
      data.serialize(serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(SerializedPayload serializedPayload, NestedElement data) throws IOException
   {
      deserializeCDR.deserialize(serializedPayload);
      data.deserialize(deserializeCDR);
      deserializeCDR.finishDeserialize();
   }

   @Override
   public int getTypeSize()
   {
      return NestedElement.getMaxCdrSerializedSize();
   }

   @Override
   public String getName()
   {
      return name;
   }

   @Override
   public NestedElement createData()
   {
      return new NestedElement();
   }
}