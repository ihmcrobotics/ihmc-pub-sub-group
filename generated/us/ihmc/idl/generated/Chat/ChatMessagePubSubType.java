package us.ihmc.idl.generated.Chat;

import java.io.IOException;

import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.common.SerializedPayload;
import us.ihmc.idl.CDR;

/**
* 
* Topic data type of the struct "ChatMessage" defined in "ChatMessage.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from ChatMessage.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit ChatMessage.idl instead.
*
*/
public class ChatMessagePubSubType implements TopicDataType<ChatMessage>
{
	public static final String name = "Chat::ChatMessage";
	private final CDR serializeCDR = new CDR();
	private final CDR deserializeCDR = new CDR();
	
	
	
    public ChatMessagePubSubType()
    {
        
    }
    
       @Override
   public void serialize(ChatMessage data, SerializedPayload serializedPayload) throws IOException
   {
      serializeCDR.serialize(serializedPayload);
      data.serialize(serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(SerializedPayload serializedPayload, ChatMessage data) throws IOException
   {
      deserializeCDR.deserialize(serializedPayload);
      data.deserialize(deserializeCDR);
      deserializeCDR.finishDeserialize();
   }

   @Override
   public int getTypeSize()
   {
      return ChatMessage.getMaxCdrSerializedSize() + 4;
   }

   @Override
   public String getName()
   {
      return name;
   }

   @Override
   public ChatMessage createData()
   {
      return new ChatMessage();
   }
   
   @Override
   public ChatMessagePubSubType newInstance()
   {
   	  return new ChatMessagePubSubType();
   }
}