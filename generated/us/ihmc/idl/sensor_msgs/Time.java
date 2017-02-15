package us.ihmc.idl.sensor_msgs;
import java.util.ArrayList;
import us.ihmc.idl.StringPubSubType;
import us.ihmc.idl.IDLSequence;
import us.ihmc.idl.CDR;
import us.ihmc.idl.IDLType;

public class Time implements IDLType
{
    public Time()
    {
                
                
        
        
    }

        public void setSec(int sec)
        {
            sec_ = sec;
        }

        public int getSec()
        {
            return sec_;
        }

        
        public void setNanosec(int nanosec)
        {
            nanosec_ = nanosec;
        }

        public int getNanosec()
        {
            return nanosec_;
        }

        


	public static int getMaxCdrSerializedSize()
	{
		return getMaxCdrSerializedSize(0);
	}

	public static int getMaxCdrSerializedSize(int current_alignment)
	{
	    int initial_alignment = current_alignment;
	            
	    current_alignment += 4 + CDR.alignment(current_alignment, 4);

	    current_alignment += 4 + CDR.alignment(current_alignment, 4);

	
	    return current_alignment - initial_alignment;
	}


	public static int getCdrSerializedSize(Time data)
	{
		return getCdrSerializedSize(data, 0);
	}

	public static int getCdrSerializedSize(Time data, int current_alignment)
	{
	    int initial_alignment = current_alignment;
	            
	    current_alignment += 4 + CDR.alignment(current_alignment, 4);

	    current_alignment += 4 + CDR.alignment(current_alignment, 4);

	
	    return current_alignment - initial_alignment;
	}
	
	public void serialize(CDR cdr)
	{


	    cdr.serializetype_2(sec_);


	    cdr.serializetype_4(nanosec_);

	}
	
	public void deserialize(CDR cdr)
	{
	    	sec_ = cdr.deserializetype_2();	
	    	nanosec_ = cdr.deserializetype_4();	
	}

    @Override
    public boolean equals(Object other)
    {
        if(other == null) return false;
        if(other == this) return true;
        if(!(other instanceof Time)) return false;
        Time otherMyClass = (Time)other;
        boolean returnedValue = true;

        returnedValue &= this.sec_ == otherMyClass.sec_;
                
        returnedValue &= this.nanosec_ == otherMyClass.nanosec_;
                

        return returnedValue;
    }

    private int sec_; 
    private int nanosec_; 

}