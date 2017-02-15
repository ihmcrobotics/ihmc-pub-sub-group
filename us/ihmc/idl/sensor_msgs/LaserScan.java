package us.ihmc.idl..sensor_msgs;
import java.util.ArrayList;

public class LaserScan
{
    public LaserScan()
    {
                header_ = new sensor_msgs.Header();        
                
                
                
                
                
                
                
                ranges_ = new IDLSequence<float> (new float[65535]);

                
                intensities_ = new IDLSequence<float> (new float[65535]);

                
                headers_ = new IDLSequence<sensor_msgs.Header> (new sensor_msgs.Header[10]);

                
                strings_ = new IDLSequence<String> (new String[20]);

                
                stringArray_ = new String[(5 * 2)];
                
                floatArray_ = new float[(3)];
                
                timeArray_ = new sensor_msgs.Time[(9)];
                
        
        
    }

        public void setHeader(sensor_msgs.Header header)
        {
            header_ = header;
        }

        public sensor_msgs.Header getHeader()
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

        

        public IDLSequence<float>  getRanges()
        {
            return ranges_;
        }

        

        public IDLSequence<float>  getIntensities()
        {
            return intensities_;
        }

        

        public IDLSequence<sensor_msgs.Header>  getHeaders()
        {
            return headers_;
        }

        

        public IDLSequence<String>  getStrings()
        {
            return strings_;
        }

        
        public void setStringArray(String[][] stringArray)
        {
            stringArray_ = stringArray;
        }

        public String[][] getStringArray()
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

        
        public void setTimeArray(sensor_msgs.Time[] timeArray)
        {
            timeArray_ = timeArray;
        }

        public sensor_msgs.Time[] getTimeArray()
        {
            return timeArray_;
        }

        

	public static int getMaxCdrSerializedSize(int current_alignment)
	{
	    int initial_alignment = current_alignment;
	            
	    current_alignment += sensor_msgs.Header.getMaxCdrSerializedSize(current_alignment);
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
	    for(size_t a = 0; a < 10; ++a)
	    {
	        current_alignment += sensor_msgs.Header.getMaxCdrSerializedSize(current_alignment);}

	    current_alignment += 4 + CDR.alignment(current_alignment, 4);
	    for(size_t a = 0; a < 20; ++a)
	    {
	        current_alignment += 4 + CDR.alignment(current_alignment, 4) + 255 + 1;
	    }
	    for(size_t a = 0; a < (5 * 2); ++a)
	    {
	        current_alignment += 4 + CDR.alignment(current_alignment, 4) + 255 + 1;
	    }
	    current_alignment += ((3) * 4) + CDR.alignment(current_alignment, 4);

	    for(size_t a = 0; a < (9); ++a)
	    {
	        current_alignment += sensor_msgs.Time.getMaxCdrSerializedSize(current_alignment);}
	
	    return current_alignment - initial_alignment;
	}

	public static int getCdrSerializedSize(LaserScan data, int current_alignment)
	{
	    size_t initial_alignment = current_alignment;
	            
	    current_alignment += sensor_msgs.Header.getCdrSerializedSize(data.getHeader(), current_alignment);
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
	    for(size_t a = 0; a < data.getHeaders().size(); ++a)
	    {
	        current_alignment += sensor_msgs.Header.getCdrSerializedSize(data.getHeaders().get(a), current_alignment);}

	    current_alignment += 4 + CDR.alignment(current_alignment, 4);
	    for(size_t a = 0; a < data.getStrings().size(); ++a)
	    {
	        current_alignment += 4 + CDR.alignment(current_alignment, 4) + data.getStrings().get(a).length() + 1;
	    }
	    for(size_t a = 0; a < data.getStringArray().size(); ++a)
	    {
	        for(size_t b = 0; b < data.getStringArray().at(a).size(); ++b)
	        {
	                current_alignment += 4 + CDR.alignment(current_alignment, 4) + data.getStringArray().at(a).at(b).size() + 1;

	        }
	    }
	    current_alignment += ((3) * 4) + CDR.alignment(current_alignment, 4);
	    for(size_t a = 0; a < data.getTimeArray().size(); ++a)
	    {
	            current_alignment += sensor_msgs.Time.getCdrSerializedSize(data.getTimeArray().at(a), current_alignment);
	    }
	
	    return current_alignment - initial_alignment;
	}
	
	public static void serialize(CDR cdr)
	{


	    cdr.serializetype_a(header_);


	    cdr.serializetype_5(angle_min_);


	    cdr.serializetype_5(angle_max_);


	    cdr.serializetype_5(angle_increment_);


	    cdr.serializetype_5(time_increment_);


	    cdr.serializetype_5(scan_time_);


	    cdr.serializetype_5(range_min_);


	    cdr.serializetype_5(range_max_);


	    if(ranges_.size() <= 65535)
	    cdr.serializetype_e(ranges_);
	    else
	        throw new RuntimeException("ranges field exceeds the maximum length");

	    if(intensities_.size() <= 65535)
	    cdr.serializetype_e(intensities_);
	    else
	        throw new RuntimeException("intensities field exceeds the maximum length");

	    if(headers_.size() <= 10)
	    cdr.serializetype_e(headers_);
	    else
	        throw new RuntimeException("headers field exceeds the maximum length");

	    if(strings_.size() <= 20)
	    cdr.serializetype_e(strings_);
	    else
	        throw new RuntimeException("strings field exceeds the maximum length");

	    cdr.serializetype_f(stringArray_);


	    cdr.serializetype_f(floatArray_);


	    cdr.serializetype_f(timeArray_);

	}
	
	public static void deserialize(CDR cdr)
	{
	    	cdr.deserializetype_a(header_);	
	    	angle_min_ = cdr.deserializetype_5();	
	    	angle_max_ = cdr.deserializetype_5();	
	    	angle_increment_ = cdr.deserializetype_5();	
	    	time_increment_ = cdr.deserializetype_5();	
	    	scan_time_ = cdr.deserializetype_5();	
	    	range_min_ = cdr.deserializetype_5();	
	    	range_max_ = cdr.deserializetype_5();	
	    	cdr.deserializetype_e(ranges_);	
	    	cdr.deserializetype_e(intensities_);	
	    	cdr.deserializetype_e(headers_);	
	    	cdr.deserializetype_e(strings_);	
	    	cdr.deserializetype_f(stringArray_);	
	    	cdr.deserializetype_f(floatArray_);	
	    	cdr.deserializetype_f(timeArray_);	
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
                
        returnedValue &= this.ranges_.equals(otherMyClass.ranges_);
                
        returnedValue &= this.intensities_.equals(otherMyClass.intensities_);
                
        returnedValue &= this.headers_.equals(otherMyClass.headers_);
                
        returnedValue &= this.strings_.equals(otherMyClass.strings_);
                
        returnedValue &= this.stringArray_.equals(otherMyClass.stringArray_);
                
        returnedValue &= this.floatArray_.equals(otherMyClass.floatArray_);
                
        returnedValue &= this.timeArray_.equals(otherMyClass.timeArray_);
                

        return returnedValue;
    }

    private sensor_msgs.Header header_; 
    private float angle_min_; 
    private float angle_max_; 
    private float angle_increment_; 
    private float time_increment_; 
    private float scan_time_; 
    private float range_min_; 
    private float range_max_; 
    private IDLSequence<float>  ranges_; 
    private IDLSequence<float>  intensities_; 
    private IDLSequence<sensor_msgs.Header>  headers_; 
    private IDLSequence<String>  strings_; 
    private String[][] stringArray_; 
    private float[] floatArray_; 
    private sensor_msgs.Time[] timeArray_; 

}