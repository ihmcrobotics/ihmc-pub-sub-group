package us.ihmc.idl..Chat;
import java.util.ArrayList;

public class ChatMessage
{
    public ChatMessage()
    {
                sender_ = new String();
                
                msg_ = new String();
                
    }

        public void setSender(String sender)
        {
            sender_ = sender;
        }

        public String getSender()
        {
            return sender_;
        }

        
        public void setMsg(String msg)
        {
            msg_ = msg;
        }

        public String getMsg()
        {
            return msg_;
        }

        

	public static int getMaxCdrSerializedSize(int current_alignment)
	{
	    int initial_alignment = current_alignment;
	            
	    current_alignment += 4 + CDR.alignment(current_alignment, 4) + 255 + 1;

	    current_alignment += 4 + CDR.alignment(current_alignment, 4) + 255 + 1;

	
	    return current_alignment - initial_alignment;
	}

	public static int getCdrSerializedSize(ChatMessage data, int current_alignment)
	{
	    size_t initial_alignment = current_alignment;
	            
	    current_alignment += 4 + CDR.alignment(current_alignment, 4) + data.getSender().length() + 1;

	    current_alignment += 4 + CDR.alignment(current_alignment, 4) + data.getMsg().length() + 1;

	
	    return current_alignment - initial_alignment;
	}
	
	public static void serialize(CDR cdr)
	{


	    if(sender_.length() <= 255)
	    cdr.serializetype_d(sender_);
	    else
	        throw new RuntimeException("sender field exceeds the maximum length");

	    if(msg_.length() <= 255)
	    cdr.serializetype_d(msg_);
	    else
	        throw new RuntimeException("msg field exceeds the maximum length");
	}
	
	public static void deserialize(CDR cdr)
	{
	    	cdr.deserializetype_d(sender_);	
	    	cdr.deserializetype_d(msg_);	
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

    private String sender_; 
    private String msg_; 

}