package us.ihmc.idl.generated.IDLElement;

import java.io.IOException;

import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.common.SerializedPayload;
import us.ihmc.idl.CDR;

/**
* 
* Topic data type of the struct "IDLElementTest" defined in "IDLElementTest.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from IDLElementTest.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit IDLElementTest.idl instead.
*
*/
public class IDLElementTestPubSubType implements TopicDataType<IDLElementTest>
{
	public static final String name = "IDLElement::IDLElementTest";
	private final CDR serializeCDR = new CDR();
	private final CDR deserializeCDR = new CDR();
	
	
	
    public IDLElementTestPubSubType()
    {
        
    }
    
       @Override
   public void serialize(IDLElementTest data, SerializedPayload serializedPayload) throws IOException
   {
      serializeCDR.serialize(serializedPayload);
      data.serialize(serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(SerializedPayload serializedPayload, IDLElementTest data) throws IOException
   {
      deserializeCDR.deserialize(serializedPayload);
      data.deserialize(deserializeCDR);
      deserializeCDR.finishDeserialize();
   }

   @Override
   public int getTypeSize()
   {
      return IDLElementTest.getMaxCdrSerializedSize();
   }

   @Override
   public String getName()
   {
      return name;
   }

   @Override
   public IDLElementTest createData()
   {
      return new IDLElementTest();
   }
}