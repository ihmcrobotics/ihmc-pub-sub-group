package us.ihmc.idl.Chat;
import java.util.ArrayList;
import us.ihmc.idl.StringBufferPubSubType;
import us.ihmc.idl.IDLSequence;
import us.ihmc.idl.CDR;
import us.ihmc.idl.IDLStruct;

public class ChatMessage implements IDLStruct
{
    public ChatMessage()
    {
                sender_ = new StringBuffer(255);
                
                msg_ = new StringBuffer(255);
                
        
        
    }

        public void setSender(StringBuffer sender)
        {
            sender_ = sender;
        }

        public StringBuffer getSender()
        {
            return sender_;
        }

        
        public void setMsg(StringBuffer msg)
        {
            msg_ = msg;
        }

        public StringBuffer getMsg()
        {
            return msg_;
        }

        


	static int getMaxCdrSerializedSize()
	{
		return getMaxCdrSerializedSize(0);
	}

	static int getMaxCdrSerializedSize(int current_alignment)
	{
	    int initial_alignment = current_alignment;
	            
	    current_alignment += 4 + CDR.alignment(current_alignment, 4) + 255 + 1;

	    current_alignment += 4 + CDR.alignment(current_alignment, 4) + 255 + 1;

	
	    return current_alignment - initial_alignment;
	}


	static int getCdrSerializedSize(ChatMessage data)
	{
		return getCdrSerializedSize(data, 0);
	}

	static int getCdrSerializedSize(ChatMessage data, int current_alignment)
	{
	    int initial_alignment = current_alignment;
	            
	    current_alignment += 4 + CDR.alignment(current_alignment, 4) + data.getSender().length() + 1;

	    current_alignment += 4 + CDR.alignment(current_alignment, 4) + data.getMsg().length() + 1;

	
	    return current_alignment - initial_alignment;
	}
	
	public void serialize(CDR cdr)
	{


	    if(sender_.length() <= 255)
	    cdr.write_type_d(sender_);
	    else
	        throw new RuntimeException("sender field exceeds the maximum length");

	    if(msg_.length() <= 255)
	    cdr.write_type_d(msg_);
	    else
	        throw new RuntimeException("msg field exceeds the maximum length");
	}
	
	public void deserialize(CDR cdr)
	{

	    	cdr.read_type_d(sender_);	

	    	cdr.read_type_d(msg_);	
	}

    @Override
    public boolean equals(Object other)
    {
        if(other == null) return false;
        if(other == this) return true;
        if(!(other instanceof ChatMessage)) return false;
        ChatMessage otherMyClass = (ChatMessage)other;
        boolean returnedValue = true;

        returnedValue &= this.sender_.equals(otherMyClass.sender_);
                
        returnedValue &= this.msg_.equals(otherMyClass.msg_);
                

        return returnedValue;
    }

    private StringBuffer sender_; 
    private StringBuffer msg_; 

}