package us.ihmc.idl.generated.IDLElement;
import us.ihmc.idl.IDLSequence;
import us.ihmc.idl.CDR;
import us.ihmc.idl.IDLStruct;

public class NestedElement implements IDLStruct
{
    public NestedElement()
    {
                stringTest_ = new StringBuilder(255); 
                
                
        
        
    }


        public StringBuilder getStringTest()
        {
            return stringTest_;
        }

        
        public void setLongTest(int longTest)
        {
            longTest_ = longTest;
        }

        public int getLongTest()
        {
            return longTest_;
        }

        


	static int getMaxCdrSerializedSize()
	{
		return getMaxCdrSerializedSize(0);
	}

	static int getMaxCdrSerializedSize(int current_alignment)
	{
	    int initial_alignment = current_alignment;
	            
	    current_alignment += 4 + CDR.alignment(current_alignment, 4) + 255 + 1;

	    current_alignment += 4 + CDR.alignment(current_alignment, 4);

	
	    return current_alignment - initial_alignment;
	}


	static int getCdrSerializedSize(NestedElement data)
	{
		return getCdrSerializedSize(data, 0);
	}

	static int getCdrSerializedSize(NestedElement data, int current_alignment)
	{
	    int initial_alignment = current_alignment;
	            
	    current_alignment += 4 + CDR.alignment(current_alignment, 4) + data.getStringTest().length() + 1;

	    current_alignment += 4 + CDR.alignment(current_alignment, 4);

	
	    return current_alignment - initial_alignment;
	}
	
	public void serialize(CDR cdr)
	{


	    if(stringTest_.length() <= 255)
	    cdr.write_type_d(stringTest_);else
	        throw new RuntimeException("stringTest field exceeds the maximum length");

	    cdr.write_type_2(longTest_);
	}
	
	public void deserialize(CDR cdr)
	{

	    	cdr.read_type_d(stringTest_);	

	    	longTest_ = cdr.read_type_2();	
	}

    @Override
    public boolean equals(Object other)
    {
        if(other == null) return false;
        if(other == this) return true;
        if(!(other instanceof NestedElement)) return false;
        NestedElement otherMyClass = (NestedElement)other;
        boolean returnedValue = true;

        returnedValue &= this.stringTest_.equals(otherMyClass.stringTest_);
                
        returnedValue &= this.longTest_ == otherMyClass.longTest_;
                

        return returnedValue;
    }

    private StringBuilder stringTest_; 
    private int longTest_; 

}