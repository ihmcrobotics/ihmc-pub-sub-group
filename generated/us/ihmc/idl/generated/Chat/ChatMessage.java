package us.ihmc.idl.generated.Chat;
import us.ihmc.idl.IDLSequence;
import us.ihmc.idl.CDR;
import us.ihmc.idl.InterchangeSerializer;
import us.ihmc.idl.IDLStruct;
import java.util.Arrays;

/**
* 
* Definition of the class "ChatMessage" defined in ChatMessage.idl. 
*
* This file was automatically generated from ChatMessage.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit ChatMessage.idl instead.
*
*/
public class ChatMessage implements IDLStruct<ChatMessage>
{
    public ChatMessage()
    {
        	sender_ = new StringBuilder(255); 
        	msg_ = new StringBuilder(255); 
        
        
    }
    @Override
    public void set(ChatMessage other)
    {
        	sender_.setLength(0);
        	sender_.append(other.sender_);
        	msg_.setLength(0);
        	msg_.append(other.msg_);
    }

        public void setSender(String sender)
        {
        	sender_.setLength(0);
        	sender_.append(sender);
        }
        
        public String getSenderAsString()
        {
        	return getSender().toString();
        }

    public StringBuilder getSender()
    {
        return sender_;
    }

        
        public void setMsg(String msg)
        {
        	msg_.setLength(0);
        	msg_.append(msg);
        }
        
        public String getMsgAsString()
        {
        	return getMsg().toString();
        }

    public StringBuilder getMsg()
    {
        return msg_;
    }

        


	public static int getMaxCdrSerializedSize()
	{
		return getMaxCdrSerializedSize(0);
	}

	public static int getMaxCdrSerializedSize(int current_alignment)
	{
	    int initial_alignment = current_alignment;
	            
	    current_alignment += 4 + CDR.alignment(current_alignment, 4) + 255 + 1;

	    current_alignment += 4 + CDR.alignment(current_alignment, 4) + 255 + 1;

	
	    return current_alignment - initial_alignment;
	}


	public final static int getCdrSerializedSize(ChatMessage data)
	{
		return getCdrSerializedSize(data, 0);
	}

	public final static int getCdrSerializedSize(ChatMessage data, int current_alignment)
	{
	    int initial_alignment = current_alignment;
	            
	    current_alignment += 4 + CDR.alignment(current_alignment, 4) + data.getSender().length() + 1;

	    current_alignment += 4 + CDR.alignment(current_alignment, 4) + data.getMsg().length() + 1;

	
	    return current_alignment - initial_alignment;
	}
	
	@Override
	public final void serialize(CDR cdr)
	{


	    if(sender_.length() <= 255)
	    cdr.write_type_d(sender_);else
	        throw new RuntimeException("sender field exceeds the maximum length");

	    if(msg_.length() <= 255)
	    cdr.write_type_d(msg_);else
	        throw new RuntimeException("msg field exceeds the maximum length");
	}
	
	@Override
	public final void deserialize(CDR cdr)
	{

	    	cdr.read_type_d(sender_);	

	    	cdr.read_type_d(msg_);	
	}
	
	@Override
	public final void serialize(InterchangeSerializer ser)
	{
			    ser.write_type_d("sender", sender_);
			    
			    ser.write_type_d("msg", msg_);
			    
	}
	
	@Override
	public final void deserialize(InterchangeSerializer ser)
	{
	    			ser.read_type_d("sender", sender_);	
	    	    
	    			ser.read_type_d("msg", msg_);	
	    	    
	}

    @Override
    public boolean equals(Object other)
    {
        if(other == null) return false;
        if(other == this) return true;
        if(!(other instanceof ChatMessage)) return false;
        ChatMessage otherMyClass = (ChatMessage)other;
        boolean returnedValue = true;

        returnedValue &= us.ihmc.idl.IDLTools.equals(this.sender_, otherMyClass.sender_);
                
        returnedValue &= us.ihmc.idl.IDLTools.equals(this.msg_, otherMyClass.msg_);
                

        return returnedValue;
    }
    
     @Override
    public String toString()
    {
		StringBuilder builder = new StringBuilder();
		
      	builder.append("ChatMessage {");
        builder.append("sender=");
        builder.append(this.sender_);

                builder.append(", ");
        builder.append("msg=");
        builder.append(this.msg_);

                
        builder.append("}");
		return builder.toString();
    }

    private StringBuilder sender_; 
    private StringBuilder msg_; 

}