package us.ihmc.idl.generated.sensor_msgs;
import java.util.ArrayList;
import us.ihmc.idl.IDLSequence;
import us.ihmc.idl.CDR;
import us.ihmc.idl.IDLStruct;

public class LaserScan implements IDLStruct
{
    public LaserScan()
    {
                header_ = new us.ihmc.idl.generated.sensor_msgs.Header();        
                
                
                
                
                
                
                
                
                ranges_ = new IDLSequence.Float (65535, "type_e");


                
                intensities_ = new IDLSequence.Float (65535, "type_e");


                
                headers_ = new IDLSequence.Object<us.ihmc.idl.generated.sensor_msgs.Header> (10, us.ihmc.idl.generated.sensor_msgs.Header.class, new us.ihmc.idl.generated.sensor_msgs.HeaderPubSubType());

                
                strings_ = new IDLSequence.StringBuilderHolder (20, "type_e");        
                stringArray_ = new StringBuilder[5][2];
                
                floatArray_ = new float[3];
                
                timeArray_ = new us.ihmc.idl.generated.sensor_msgs.Time[9];
                
        
        
    }

        public void setHeader(us.ihmc.idl.generated.sensor_msgs.Header header)
        {
            header_ = header;
        }

        public us.ihmc.idl.generated.sensor_msgs.Header getHeader()
        {
            return header_;
        }

        
        public void setAngle_min(float angle_min)
        {
            angle_min_ = angle_min;
        }

        public float getAngle_min()
        {
            return angle_min_;
        }

        
        public void setAngle_max(float angle_max)
        {
            angle_max_ = angle_max;
        }

        public float getAngle_max()
        {
            return angle_max_;
        }

        
        public void setAngle_increment(float angle_increment)
        {
            angle_increment_ = angle_increment;
        }

        public float getAngle_increment()
        {
            return angle_increment_;
        }

        
        public void setTime_increment(float time_increment)
        {
            time_increment_ = time_increment;
        }

        public float getTime_increment()
        {
            return time_increment_;
        }

        
        public void setScan_time(float scan_time)
        {
            scan_time_ = scan_time;
        }

        public float getScan_time()
        {
            return scan_time_;
        }

        
        public void setRange_min(float range_min)
        {
            range_min_ = range_min;
        }

        public float getRange_min()
        {
            return range_min_;
        }

        
        public void setRange_max(float range_max)
        {
            range_max_ = range_max;
        }

        public float getRange_max()
        {
            return range_max_;
        }

        
        public void setCur(us.ihmc.idl.generated.sensor_msgs.Currency cur)
        {
            cur_ = cur;
        }

        public us.ihmc.idl.generated.sensor_msgs.Currency getCur()
        {
            return cur_;
        }

        

        public IDLSequence.Float  getRanges()
        {
            return ranges_;
        }

        

        public IDLSequence.Float  getIntensities()
        {
            return intensities_;
        }

        

        public IDLSequence.Object<us.ihmc.idl.generated.sensor_msgs.Header>  getHeaders()
        {
            return headers_;
        }

        

        public IDLSequence.StringBuilderHolder  getStrings()
        {
            return strings_;
        }

        
        public void setStringArray(StringBuilder[][] stringArray)
        {
            stringArray_ = stringArray;
        }

        public StringBuilder[][] getStringArray()
        {
            return stringArray_;
        }

        
        public void setFloatArray(float[] floatArray)
        {
            floatArray_ = floatArray;
        }

        public float[] getFloatArray()
        {
            return floatArray_;
        }

        
        public void setTimeArray(us.ihmc.idl.generated.sensor_msgs.Time[] timeArray)
        {
            timeArray_ = timeArray;
        }

        public us.ihmc.idl.generated.sensor_msgs.Time[] getTimeArray()
        {
            return timeArray_;
        }

        


	static int getMaxCdrSerializedSize()
	{
		return getMaxCdrSerializedSize(0);
	}

	static int getMaxCdrSerializedSize(int current_alignment)
	{
	    int initial_alignment = current_alignment;
	            
	    current_alignment += us.ihmc.idl.generated.sensor_msgs.Header.getMaxCdrSerializedSize(current_alignment);
	    current_alignment += 4 + CDR.alignment(current_alignment, 4);

	    current_alignment += 4 + CDR.alignment(current_alignment, 4);

	    current_alignment += 4 + CDR.alignment(current_alignment, 4);

	    current_alignment += 4 + CDR.alignment(current_alignment, 4);

	    current_alignment += 4 + CDR.alignment(current_alignment, 4);

	    current_alignment += 4 + CDR.alignment(current_alignment, 4);

	    current_alignment += 4 + CDR.alignment(current_alignment, 4);

	    current_alignment += 4 + CDR.alignment(current_alignment, 4);

	    current_alignment += 4 + CDR.alignment(current_alignment, 4);
	    current_alignment += (65535 * 4) + CDR.alignment(current_alignment, 4);


	    current_alignment += 4 + CDR.alignment(current_alignment, 4);
	    current_alignment += (65535 * 4) + CDR.alignment(current_alignment, 4);


	    current_alignment += 4 + CDR.alignment(current_alignment, 4);
	    for(int a = 0; a < 10; ++a)
	    {
	        current_alignment += us.ihmc.idl.generated.sensor_msgs.Header.getMaxCdrSerializedSize(current_alignment);}

	    current_alignment += 4 + CDR.alignment(current_alignment, 4);
	    for(int a = 0; a < 20; ++a)
	    {
	        current_alignment += 4 + CDR.alignment(current_alignment, 4) + 255 + 1;
	    }
	    for(int a = 0; a < (5 * 2); ++a)
	    {
	        current_alignment += 4 + CDR.alignment(current_alignment, 4) + 255 + 1;
	    }
	    current_alignment += ((3) * 4) + CDR.alignment(current_alignment, 4);

	    for(int a = 0; a < (9); ++a)
	    {
	        current_alignment += us.ihmc.idl.generated.sensor_msgs.Time.getMaxCdrSerializedSize(current_alignment);}
	
	    return current_alignment - initial_alignment;
	}


	static int getCdrSerializedSize(LaserScan data)
	{
		return getCdrSerializedSize(data, 0);
	}

	static int getCdrSerializedSize(LaserScan data, int current_alignment)
	{
	    int initial_alignment = current_alignment;
	            
	    current_alignment += us.ihmc.idl.generated.sensor_msgs.Header.getCdrSerializedSize(data.getHeader(), current_alignment);
	    current_alignment += 4 + CDR.alignment(current_alignment, 4);

	    current_alignment += 4 + CDR.alignment(current_alignment, 4);

	    current_alignment += 4 + CDR.alignment(current_alignment, 4);

	    current_alignment += 4 + CDR.alignment(current_alignment, 4);

	    current_alignment += 4 + CDR.alignment(current_alignment, 4);

	    current_alignment += 4 + CDR.alignment(current_alignment, 4);

	    current_alignment += 4 + CDR.alignment(current_alignment, 4);

	    current_alignment += 4 + CDR.alignment(current_alignment, 4);

	    current_alignment += 4 + CDR.alignment(current_alignment, 4);
	    current_alignment += (data.getRanges().size() * 4) + CDR.alignment(current_alignment, 4);


	    current_alignment += 4 + CDR.alignment(current_alignment, 4);
	    current_alignment += (data.getIntensities().size() * 4) + CDR.alignment(current_alignment, 4);


	    current_alignment += 4 + CDR.alignment(current_alignment, 4);
	    for(int a = 0; a < data.getHeaders().size(); ++a)
	    {
	        current_alignment += us.ihmc.idl.generated.sensor_msgs.Header.getCdrSerializedSize(data.getHeaders().get(a), current_alignment);}

	    current_alignment += 4 + CDR.alignment(current_alignment, 4);
	    for(int a = 0; a < data.getStrings().size(); ++a)
	    {
	        current_alignment += 4 + CDR.alignment(current_alignment, 4) + data.getStrings().get(a).length() + 1;
	    }
	    for(int a = 0; a < data.getStringArray().length; ++a)
	    {
	        for(int b = 0; b < data.getStringArray()[a].length; ++b)
	        {
	                current_alignment += 4 + CDR.alignment(current_alignment, 4) + data.getStringArray()[a][b].length() + 1;

	        }
	    }
	    current_alignment += ((3) * 4) + CDR.alignment(current_alignment, 4);
	    for(int a = 0; a < data.getTimeArray().length; ++a)
	    {
	            current_alignment += us.ihmc.idl.generated.sensor_msgs.Time.getCdrSerializedSize(data.getTimeArray()[a], current_alignment);
	    }
	
	    return current_alignment - initial_alignment;
	}
	
	public void serialize(CDR cdr)
	{


	    cdr.write_type_a(header_);

	    cdr.write_type_5(angle_min_);

	    cdr.write_type_5(angle_max_);

	    cdr.write_type_5(angle_increment_);

	    cdr.write_type_5(time_increment_);

	    cdr.write_type_5(scan_time_);

	    cdr.write_type_5(range_min_);

	    cdr.write_type_5(range_max_);

	    cdr.write_type_c(cur_.ordinal());


	    if(ranges_.size() <= 65535)
	    cdr.write_type_e(ranges_);else
	        throw new RuntimeException("ranges field exceeds the maximum length");

	    if(intensities_.size() <= 65535)
	    cdr.write_type_e(intensities_);else
	        throw new RuntimeException("intensities field exceeds the maximum length");

	    if(headers_.size() <= 10)
	    cdr.write_type_e(headers_);else
	        throw new RuntimeException("headers field exceeds the maximum length");

	    if(strings_.size() <= 20)
	    cdr.write_type_e(strings_);else
	        throw new RuntimeException("strings field exceeds the maximum length");

	    for(int a = 0; a < stringArray_.length; ++a)
	    {
	        for(int b = 0; b < stringArray_[a].length; ++b)
	        {
	            	cdr.read_type_d(stringArray_[a][b]);	
	        }
	    }

	    for(int a = 0; a < floatArray_.length; ++a)
	    {
	        	floatArray_[a] = cdr.read_type_5();	
	    }

	    for(int a = 0; a < timeArray_.length; ++a)
	    {
	        	cdr.read_type_a(timeArray_[a]);	
	    }
	}
	
	public void deserialize(CDR cdr)
	{

	    	cdr.read_type_a(header_);	

	    	angle_min_ = cdr.read_type_5();	

	    	angle_max_ = cdr.read_type_5();	

	    	angle_increment_ = cdr.read_type_5();	

	    	time_increment_ = cdr.read_type_5();	

	    	scan_time_ = cdr.read_type_5();	

	    	range_min_ = cdr.read_type_5();	

	    	range_max_ = cdr.read_type_5();	

	    	cur_ = us.ihmc.idl.generated.sensor_msgs.Currency.values[cdr.read_type_c()];
	    	

	    	cdr.read_type_e(ranges_);	

	    	cdr.read_type_e(intensities_);	

	    	cdr.read_type_e(headers_);	

	    	cdr.read_type_e(strings_);	

	    	for(int a = 0; a < stringArray_.length; ++a)
	    	{
	    	    for(int b = 0; b < stringArray_[a].length; ++b)
	    	    {
	    	        	cdr.read_type_d(stringArray_[a][b]);	
	    	    }
	    	}
	    	

	    	for(int a = 0; a < floatArray_.length; ++a)
	    	{
	    	    	floatArray_[a] = cdr.read_type_5();	
	    	}
	    	

	    	for(int a = 0; a < timeArray_.length; ++a)
	    	{
	    	    	cdr.read_type_a(timeArray_[a]);	
	    	}
	    	
	}

    @Override
    public boolean equals(Object other)
    {
        if(other == null) return false;
        if(other == this) return true;
        if(!(other instanceof LaserScan)) return false;
        LaserScan otherMyClass = (LaserScan)other;
        boolean returnedValue = true;

        returnedValue &= this.header_.equals(otherMyClass.header_);
                
        returnedValue &= this.angle_min_ == otherMyClass.angle_min_;
                
        returnedValue &= this.angle_max_ == otherMyClass.angle_max_;
                
        returnedValue &= this.angle_increment_ == otherMyClass.angle_increment_;
                
        returnedValue &= this.time_increment_ == otherMyClass.time_increment_;
                
        returnedValue &= this.scan_time_ == otherMyClass.scan_time_;
                
        returnedValue &= this.range_min_ == otherMyClass.range_min_;
                
        returnedValue &= this.range_max_ == otherMyClass.range_max_;
                
        returnedValue &= this.cur_ == otherMyClass.cur_;
                
        returnedValue &= this.ranges_.equals(otherMyClass.ranges_);
                
        returnedValue &= this.intensities_.equals(otherMyClass.intensities_);
                
        returnedValue &= this.headers_.equals(otherMyClass.headers_);
                
        returnedValue &= this.strings_.equals(otherMyClass.strings_);
                
        returnedValue &= this.stringArray_.equals(otherMyClass.stringArray_);
                
        returnedValue &= this.floatArray_.equals(otherMyClass.floatArray_);
                
        returnedValue &= this.timeArray_.equals(otherMyClass.timeArray_);
                

        return returnedValue;
    }

    private us.ihmc.idl.generated.sensor_msgs.Header header_; 
    private float angle_min_; 
    private float angle_max_; 
    private float angle_increment_; 
    private float time_increment_; 
    private float scan_time_; 
    private float range_min_; 
    private float range_max_; 
    private us.ihmc.idl.generated.sensor_msgs.Currency cur_; 
    private IDLSequence.Float  ranges_; 
    private IDLSequence.Float  intensities_; 
    private IDLSequence.Object<us.ihmc.idl.generated.sensor_msgs.Header>  headers_; 
    private IDLSequence.StringBuilderHolder  strings_; 
    private StringBuilder[][] stringArray_; 
    private float[] floatArray_; 
    private us.ihmc.idl.generated.sensor_msgs.Time[] timeArray_; 

}