package us.ihmc.idl.generated.sensor_msgs;
import java.util.ArrayList;
import us.ihmc.idl.IDLSequence;
import us.ihmc.idl.CDR;
import us.ihmc.idl.IDLStruct;

public class Time implements IDLStruct
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

        
        public void setNanosec(long nanosec)
        {
            nanosec_ = nanosec;
        }

        public long getNanosec()
        {
            return nanosec_;
        }

        


	static int getMaxCdrSerializedSize()
	{
		return getMaxCdrSerializedSize(0);
	}

	static int getMaxCdrSerializedSize(int current_alignment)
	{
	    int initial_alignment = current_alignment;
	            
	    current_alignment += 4 + CDR.alignment(current_alignment, 4);

	    current_alignment += 4 + CDR.alignment(current_alignment, 4);

	
	    return current_alignment - initial_alignment;
	}


	static int getCdrSerializedSize(Time data)
	{
		return getCdrSerializedSize(data, 0);
	}

	static int getCdrSerializedSize(Time data, int current_alignment)
	{
	    int initial_alignment = current_alignment;
	            
	    current_alignment += 4 + CDR.alignment(current_alignment, 4);

	    current_alignment += 4 + CDR.alignment(current_alignment, 4);

	
	    return current_alignment - initial_alignment;
	}
	
	public void serialize(CDR cdr)
	{


	    cdr.write_type_2(sec_);

	    cdr.write_type_4(nanosec_);
	}
	
	public void deserialize(CDR cdr)
	{

	    	sec_ = cdr.read_type_2();	

	    	nanosec_ = cdr.read_type_4();	
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
    private long nanosec_; 

}