package us.ihmc.idl.generated.IDLElement;
import us.ihmc.idl.IDLSequence;
import us.ihmc.idl.CDR;
import us.ihmc.idl.IDLStruct;

public class IDLElementTest implements IDLStruct
{
    public IDLElementTest()
    {
                
                
                
                
                
                
                
                
                
                
                
                
                
                nestedElementTest_ = new us.ihmc.idl.generated.IDLElement.NestedElement();        
                stringTest_ = new StringBuilder(255); 
                
                wstringTest_ = new StringBuilder(255); 
                
                longArray_ = new int[10];
                
                nestedArray_ = new us.ihmc.idl.generated.IDLElement.NestedElement[5][3];
                
                stringArray_ = new StringBuilder[4];
                
                charSeqTest_ = new IDLSequence.Char (25, "type_8");
                
                wcharSeqTest_ = new IDLSequence.Char (25, "type_14");
                
                octetSeqTest_ = new IDLSequence.Byte (25, "type_9");
                
                shortSeqTest_ = new IDLSequence.Short (25, "type_1");
                
                ushortSeqTest_ = new IDLSequence.Integer (25, "type_3");
                
                longSeqTest_ = new IDLSequence.Integer (25, "type_2");
                
                longlongSeqtest_ = new IDLSequence.Long (25, "type_11");
                
                ulonglongSeqTest_ = new IDLSequence.Long (25, "type_12");
                
                floatSeqTest_ = new IDLSequence.Float (25, "type_5");
                
                doubleSeqTest_ = new IDLSequence.Double (25, "type_6");
                
                booleanSeqTest_ = new IDLSequence.Boolean (25, "type_7");
                
                colorSeqTest_ = new IDLSequence.Object<us.ihmc.idl.generated.IDLElement.Color> (25, us.ihmc.idl.generated.IDLElement.Color.values);


                
                nestedSeqTest_ = new IDLSequence.Object<us.ihmc.idl.generated.IDLElement.NestedElement> (25, us.ihmc.idl.generated.IDLElement.NestedElement.class, new us.ihmc.idl.generated.IDLElement.NestedElementPubSubType());

                
                stringSeqTest_ = new IDLSequence.StringBuilderHolder (25, "type_d");           
                wstringSeqTest_ = new IDLSequence.StringBuilderHolder (25, "type_15");           
        
        
    }

        public void setCharTest(char charTest)
        {
            charTest_ = charTest;
        }

        public char getCharTest()
        {
            return charTest_;
        }

        
        public void setWcharTest(char wcharTest)
        {
            wcharTest_ = wcharTest;
        }

        public char getWcharTest()
        {
            return wcharTest_;
        }

        
        public void setOctetTest(byte octetTest)
        {
            octetTest_ = octetTest;
        }

        public byte getOctetTest()
        {
            return octetTest_;
        }

        
        public void setShortTest(short shortTest)
        {
            shortTest_ = shortTest;
        }

        public short getShortTest()
        {
            return shortTest_;
        }

        
        public void setUshortTest(int ushortTest)
        {
            ushortTest_ = ushortTest;
        }

        public int getUshortTest()
        {
            return ushortTest_;
        }

        
        public void setLongTest(int longTest)
        {
            longTest_ = longTest;
        }

        public int getLongTest()
        {
            return longTest_;
        }

        
        public void setUlongTest(long ulongTest)
        {
            ulongTest_ = ulongTest;
        }

        public long getUlongTest()
        {
            return ulongTest_;
        }

        
        public void setLonglongTest(long longlongTest)
        {
            longlongTest_ = longlongTest;
        }

        public long getLonglongTest()
        {
            return longlongTest_;
        }

        
        public void setUlonglongTest(long ulonglongTest)
        {
            ulonglongTest_ = ulonglongTest;
        }

        public long getUlonglongTest()
        {
            return ulonglongTest_;
        }

        
        public void setFloatTest(float floatTest)
        {
            floatTest_ = floatTest;
        }

        public float getFloatTest()
        {
            return floatTest_;
        }

        
        public void setDoubleTest(double doubleTest)
        {
            doubleTest_ = doubleTest;
        }

        public double getDoubleTest()
        {
            return doubleTest_;
        }

        
        public void setBooleanTest(boolean booleanTest)
        {
            booleanTest_ = booleanTest;
        }

        public boolean getBooleanTest()
        {
            return booleanTest_;
        }

        
        public void setColorTest(us.ihmc.idl.generated.IDLElement.Color colorTest)
        {
            colorTest_ = colorTest;
        }

        public us.ihmc.idl.generated.IDLElement.Color getColorTest()
        {
            return colorTest_;
        }

        
        public void setNestedElementTest(us.ihmc.idl.generated.IDLElement.NestedElement nestedElementTest)
        {
            nestedElementTest_ = nestedElementTest;
        }

        public us.ihmc.idl.generated.IDLElement.NestedElement getNestedElementTest()
        {
            return nestedElementTest_;
        }

        
        public void setStringTest(StringBuilder stringTest)
        {
            stringTest_ = stringTest;
        }

        public StringBuilder getStringTest()
        {
            return stringTest_;
        }

        
        public void setWstringTest(StringBuilder wstringTest)
        {
            wstringTest_ = wstringTest;
        }

        public StringBuilder getWstringTest()
        {
            return wstringTest_;
        }

        
        public void setLongArray(int[] longArray)
        {
            longArray_ = longArray;
        }

        public int[] getLongArray()
        {
            return longArray_;
        }

        
        public void setNestedArray(us.ihmc.idl.generated.IDLElement.NestedElement[][] nestedArray)
        {
            nestedArray_ = nestedArray;
        }

        public us.ihmc.idl.generated.IDLElement.NestedElement[][] getNestedArray()
        {
            return nestedArray_;
        }

        
        public void setStringArray(StringBuilder[] stringArray)
        {
            stringArray_ = stringArray;
        }

        public StringBuilder[] getStringArray()
        {
            return stringArray_;
        }

        

        public IDLSequence.Char  getCharSeqTest()
        {
            return charSeqTest_;
        }

        

        public IDLSequence.Char  getWcharSeqTest()
        {
            return wcharSeqTest_;
        }

        

        public IDLSequence.Byte  getOctetSeqTest()
        {
            return octetSeqTest_;
        }

        

        public IDLSequence.Short  getShortSeqTest()
        {
            return shortSeqTest_;
        }

        

        public IDLSequence.Integer  getUshortSeqTest()
        {
            return ushortSeqTest_;
        }

        

        public IDLSequence.Integer  getLongSeqTest()
        {
            return longSeqTest_;
        }

        

        public IDLSequence.Long  getLonglongSeqtest()
        {
            return longlongSeqtest_;
        }

        

        public IDLSequence.Long  getUlonglongSeqTest()
        {
            return ulonglongSeqTest_;
        }

        

        public IDLSequence.Float  getFloatSeqTest()
        {
            return floatSeqTest_;
        }

        

        public IDLSequence.Double  getDoubleSeqTest()
        {
            return doubleSeqTest_;
        }

        

        public IDLSequence.Boolean  getBooleanSeqTest()
        {
            return booleanSeqTest_;
        }

        

        public IDLSequence.Object<us.ihmc.idl.generated.IDLElement.Color>  getColorSeqTest()
        {
            return colorSeqTest_;
        }

        

        public IDLSequence.Object<us.ihmc.idl.generated.IDLElement.NestedElement>  getNestedSeqTest()
        {
            return nestedSeqTest_;
        }

        

        public IDLSequence.StringBuilderHolder  getStringSeqTest()
        {
            return stringSeqTest_;
        }

        

        public IDLSequence.StringBuilderHolder  getWstringSeqTest()
        {
            return wstringSeqTest_;
        }

        


	static int getMaxCdrSerializedSize()
	{
		return getMaxCdrSerializedSize(0);
	}

	static int getMaxCdrSerializedSize(int current_alignment)
	{
	    int initial_alignment = current_alignment;
	            
	    current_alignment += 1 + CDR.alignment(current_alignment, 1);

	    current_alignment += 4 + CDR.alignment(current_alignment, 4);

	    current_alignment += 1 + CDR.alignment(current_alignment, 1);

	    current_alignment += 2 + CDR.alignment(current_alignment, 2);

	    current_alignment += 2 + CDR.alignment(current_alignment, 2);

	    current_alignment += 4 + CDR.alignment(current_alignment, 4);

	    current_alignment += 4 + CDR.alignment(current_alignment, 4);

	    current_alignment += 8 + CDR.alignment(current_alignment, 8);

	    current_alignment += 8 + CDR.alignment(current_alignment, 8);

	    current_alignment += 4 + CDR.alignment(current_alignment, 4);

	    current_alignment += 8 + CDR.alignment(current_alignment, 8);

	    current_alignment += 1 + CDR.alignment(current_alignment, 1);

	    current_alignment += 4 + CDR.alignment(current_alignment, 4);

	    current_alignment += us.ihmc.idl.generated.IDLElement.NestedElement.getMaxCdrSerializedSize(current_alignment);
	    current_alignment += 4 + CDR.alignment(current_alignment, 4) + 255 + 1;

	    current_alignment += 4 + CDR.alignment(current_alignment, 4) + 255 + 1;

	    current_alignment += ((10) * 4) + CDR.alignment(current_alignment, 4);

	    for(int a = 0; a < (5 * 3); ++a)
	    {
	        current_alignment += us.ihmc.idl.generated.IDLElement.NestedElement.getMaxCdrSerializedSize(current_alignment);}
	    for(int a = 0; a < (4); ++a)
	    {
	        current_alignment += 4 + CDR.alignment(current_alignment, 4) + 255 + 1;
	    }
	    current_alignment += 4 + CDR.alignment(current_alignment, 4);
	    current_alignment += (25 * 1) + CDR.alignment(current_alignment, 1);


	    current_alignment += 4 + CDR.alignment(current_alignment, 4);
	    current_alignment += (25 * 4) + CDR.alignment(current_alignment, 4);


	    current_alignment += 4 + CDR.alignment(current_alignment, 4);
	    current_alignment += (25 * 1) + CDR.alignment(current_alignment, 1);


	    current_alignment += 4 + CDR.alignment(current_alignment, 4);
	    current_alignment += (25 * 2) + CDR.alignment(current_alignment, 2);


	    current_alignment += 4 + CDR.alignment(current_alignment, 4);
	    current_alignment += (25 * 2) + CDR.alignment(current_alignment, 2);


	    current_alignment += 4 + CDR.alignment(current_alignment, 4);
	    current_alignment += (25 * 4) + CDR.alignment(current_alignment, 4);


	    current_alignment += 4 + CDR.alignment(current_alignment, 4);
	    current_alignment += (25 * 8) + CDR.alignment(current_alignment, 8);


	    current_alignment += 4 + CDR.alignment(current_alignment, 4);
	    current_alignment += (25 * 8) + CDR.alignment(current_alignment, 8);


	    current_alignment += 4 + CDR.alignment(current_alignment, 4);
	    current_alignment += (25 * 4) + CDR.alignment(current_alignment, 4);


	    current_alignment += 4 + CDR.alignment(current_alignment, 4);
	    current_alignment += (25 * 8) + CDR.alignment(current_alignment, 8);


	    current_alignment += 4 + CDR.alignment(current_alignment, 4);
	    current_alignment += (25 * 1) + CDR.alignment(current_alignment, 1);


	    current_alignment += 4 + CDR.alignment(current_alignment, 4);
	    current_alignment += (25 * 4) + CDR.alignment(current_alignment, 4);


	    current_alignment += 4 + CDR.alignment(current_alignment, 4);
	    for(int a = 0; a < 25; ++a)
	    {
	        current_alignment += us.ihmc.idl.generated.IDLElement.NestedElement.getMaxCdrSerializedSize(current_alignment);}

	    current_alignment += 4 + CDR.alignment(current_alignment, 4);
	    for(int a = 0; a < 25; ++a)
	    {
	        current_alignment += 4 + CDR.alignment(current_alignment, 4) + 255 + 1;
	    }
	    current_alignment += 4 + CDR.alignment(current_alignment, 4);
	    for(int a = 0; a < 25; ++a)
	    {
	        current_alignment += 4 + CDR.alignment(current_alignment, 4) + 255 + 1;
	    }
	
	    return current_alignment - initial_alignment;
	}


	static int getCdrSerializedSize(IDLElementTest data)
	{
		return getCdrSerializedSize(data, 0);
	}

	static int getCdrSerializedSize(IDLElementTest data, int current_alignment)
	{
	    int initial_alignment = current_alignment;
	            
	    current_alignment += 1 + CDR.alignment(current_alignment, 1);

	    current_alignment += 4 + CDR.alignment(current_alignment, 4);

	    current_alignment += 1 + CDR.alignment(current_alignment, 1);

	    current_alignment += 2 + CDR.alignment(current_alignment, 2);

	    current_alignment += 2 + CDR.alignment(current_alignment, 2);

	    current_alignment += 4 + CDR.alignment(current_alignment, 4);

	    current_alignment += 4 + CDR.alignment(current_alignment, 4);

	    current_alignment += 8 + CDR.alignment(current_alignment, 8);

	    current_alignment += 8 + CDR.alignment(current_alignment, 8);

	    current_alignment += 4 + CDR.alignment(current_alignment, 4);

	    current_alignment += 8 + CDR.alignment(current_alignment, 8);

	    current_alignment += 1 + CDR.alignment(current_alignment, 1);

	    current_alignment += 4 + CDR.alignment(current_alignment, 4);

	    current_alignment += us.ihmc.idl.generated.IDLElement.NestedElement.getCdrSerializedSize(data.getNestedElementTest(), current_alignment);
	    current_alignment += 4 + CDR.alignment(current_alignment, 4) + data.getStringTest().length() + 1;

	    current_alignment += 4 + CDR.alignment(current_alignment, 4) + data.getWstringTest().length() + 1;

	    current_alignment += ((10) * 4) + CDR.alignment(current_alignment, 4);
	    for(int a = 0; a < data.getNestedArray().length; ++a)
	    {
	        for(int b = 0; b < data.getNestedArray()[a].length; ++b)
	        {
	                current_alignment += us.ihmc.idl.generated.IDLElement.NestedElement.getCdrSerializedSize(data.getNestedArray()[a][b], current_alignment);
	        }
	    }
	    for(int a = 0; a < data.getStringArray().length; ++a)
	    {
	            current_alignment += 4 + CDR.alignment(current_alignment, 4) + data.getStringArray()[a].length() + 1;

	    }
	    current_alignment += 4 + CDR.alignment(current_alignment, 4);
	    current_alignment += (data.getCharSeqTest().size() * 1) + CDR.alignment(current_alignment, 1);


	    current_alignment += 4 + CDR.alignment(current_alignment, 4);
	    current_alignment += (data.getWcharSeqTest().size() * 4) + CDR.alignment(current_alignment, 4);


	    current_alignment += 4 + CDR.alignment(current_alignment, 4);
	    current_alignment += (data.getOctetSeqTest().size() * 1) + CDR.alignment(current_alignment, 1);


	    current_alignment += 4 + CDR.alignment(current_alignment, 4);
	    current_alignment += (data.getShortSeqTest().size() * 2) + CDR.alignment(current_alignment, 2);


	    current_alignment += 4 + CDR.alignment(current_alignment, 4);
	    current_alignment += (data.getUshortSeqTest().size() * 2) + CDR.alignment(current_alignment, 2);


	    current_alignment += 4 + CDR.alignment(current_alignment, 4);
	    current_alignment += (data.getLongSeqTest().size() * 4) + CDR.alignment(current_alignment, 4);


	    current_alignment += 4 + CDR.alignment(current_alignment, 4);
	    current_alignment += (data.getLonglongSeqtest().size() * 8) + CDR.alignment(current_alignment, 8);


	    current_alignment += 4 + CDR.alignment(current_alignment, 4);
	    current_alignment += (data.getUlonglongSeqTest().size() * 8) + CDR.alignment(current_alignment, 8);


	    current_alignment += 4 + CDR.alignment(current_alignment, 4);
	    current_alignment += (data.getFloatSeqTest().size() * 4) + CDR.alignment(current_alignment, 4);


	    current_alignment += 4 + CDR.alignment(current_alignment, 4);
	    current_alignment += (data.getDoubleSeqTest().size() * 8) + CDR.alignment(current_alignment, 8);


	    current_alignment += 4 + CDR.alignment(current_alignment, 4);
	    current_alignment += (data.getBooleanSeqTest().size() * 1) + CDR.alignment(current_alignment, 1);


	    current_alignment += 4 + CDR.alignment(current_alignment, 4);
	    current_alignment += (data.getColorSeqTest().size() * 4) + CDR.alignment(current_alignment, 4);


	    current_alignment += 4 + CDR.alignment(current_alignment, 4);
	    for(int a = 0; a < data.getNestedSeqTest().size(); ++a)
	    {
	        current_alignment += us.ihmc.idl.generated.IDLElement.NestedElement.getCdrSerializedSize(data.getNestedSeqTest().get(a), current_alignment);}

	    current_alignment += 4 + CDR.alignment(current_alignment, 4);
	    for(int a = 0; a < data.getStringSeqTest().size(); ++a)
	    {
	        current_alignment += 4 + CDR.alignment(current_alignment, 4) + data.getStringSeqTest().get(a).length() + 1;
	    }
	    current_alignment += 4 + CDR.alignment(current_alignment, 4);
	    for(int a = 0; a < data.getWstringSeqTest().size(); ++a)
	    {
	        current_alignment += 4 + CDR.alignment(current_alignment, 4) + data.getWstringSeqTest().get(a).length() + 1;
	    }
	
	    return current_alignment - initial_alignment;
	}
	
	public void serialize(CDR cdr)
	{


	    cdr.write_type_8(charTest_);

	    cdr.write_type_14(wcharTest_);

	    cdr.write_type_9(octetTest_);

	    cdr.write_type_1(shortTest_);

	    cdr.write_type_3(ushortTest_);

	    cdr.write_type_2(longTest_);

	    cdr.write_type_4(ulongTest_);

	    cdr.write_type_11(longlongTest_);

	    cdr.write_type_12(ulonglongTest_);

	    cdr.write_type_5(floatTest_);

	    cdr.write_type_6(doubleTest_);

	    cdr.write_type_7(booleanTest_);

	    cdr.write_type_c(colorTest_.ordinal());


	    cdr.write_type_a(nestedElementTest_);

	    if(stringTest_.length() <= 255)
	    cdr.write_type_d(stringTest_);else
	        throw new RuntimeException("stringTest field exceeds the maximum length");

	    if(wstringTest_.length() <= 255)
	    cdr.write_type_15(wstringTest_);else
	        throw new RuntimeException("wstringTest field exceeds the maximum length");

	    for(int a = 0; a < longArray_.length; ++a)
	    {
	        	cdr.write_type_2(longArray_[a]);	
	    }

	    for(int a = 0; a < nestedArray_.length; ++a)
	    {
	        for(int b = 0; b < nestedArray_[a].length; ++b)
	        {
	            	cdr.write_type_a(nestedArray_[a][b]);	
	        }
	    }

	    for(int a = 0; a < stringArray_.length; ++a)
	    {
	        	cdr.write_type_d(stringArray_[a]);	
	    }

	    if(charSeqTest_.size() <= 25)
	    cdr.write_type_e(charSeqTest_);else
	        throw new RuntimeException("charSeqTest field exceeds the maximum length");

	    if(wcharSeqTest_.size() <= 25)
	    cdr.write_type_e(wcharSeqTest_);else
	        throw new RuntimeException("wcharSeqTest field exceeds the maximum length");

	    if(octetSeqTest_.size() <= 25)
	    cdr.write_type_e(octetSeqTest_);else
	        throw new RuntimeException("octetSeqTest field exceeds the maximum length");

	    if(shortSeqTest_.size() <= 25)
	    cdr.write_type_e(shortSeqTest_);else
	        throw new RuntimeException("shortSeqTest field exceeds the maximum length");

	    if(ushortSeqTest_.size() <= 25)
	    cdr.write_type_e(ushortSeqTest_);else
	        throw new RuntimeException("ushortSeqTest field exceeds the maximum length");

	    if(longSeqTest_.size() <= 25)
	    cdr.write_type_e(longSeqTest_);else
	        throw new RuntimeException("longSeqTest field exceeds the maximum length");

	    if(longlongSeqtest_.size() <= 25)
	    cdr.write_type_e(longlongSeqtest_);else
	        throw new RuntimeException("longlongSeqtest field exceeds the maximum length");

	    if(ulonglongSeqTest_.size() <= 25)
	    cdr.write_type_e(ulonglongSeqTest_);else
	        throw new RuntimeException("ulonglongSeqTest field exceeds the maximum length");

	    if(floatSeqTest_.size() <= 25)
	    cdr.write_type_e(floatSeqTest_);else
	        throw new RuntimeException("floatSeqTest field exceeds the maximum length");

	    if(doubleSeqTest_.size() <= 25)
	    cdr.write_type_e(doubleSeqTest_);else
	        throw new RuntimeException("doubleSeqTest field exceeds the maximum length");

	    if(booleanSeqTest_.size() <= 25)
	    cdr.write_type_e(booleanSeqTest_);else
	        throw new RuntimeException("booleanSeqTest field exceeds the maximum length");

	    if(colorSeqTest_.size() <= 25)
	    cdr.write_type_e(colorSeqTest_);else
	        throw new RuntimeException("colorSeqTest field exceeds the maximum length");

	    if(nestedSeqTest_.size() <= 25)
	    cdr.write_type_e(nestedSeqTest_);else
	        throw new RuntimeException("nestedSeqTest field exceeds the maximum length");

	    if(stringSeqTest_.size() <= 25)
	    cdr.write_type_e(stringSeqTest_);else
	        throw new RuntimeException("stringSeqTest field exceeds the maximum length");

	    if(wstringSeqTest_.size() <= 25)
	    cdr.write_type_e(wstringSeqTest_);else
	        throw new RuntimeException("wstringSeqTest field exceeds the maximum length");
	}
	
	public void deserialize(CDR cdr)
	{

	    	charTest_ = cdr.read_type_8();	

	    	wcharTest_ = cdr.read_type_14();	

	    	octetTest_ = cdr.read_type_9();	

	    	shortTest_ = cdr.read_type_1();	

	    	ushortTest_ = cdr.read_type_3();	

	    	longTest_ = cdr.read_type_2();	

	    	ulongTest_ = cdr.read_type_4();	

	    	longlongTest_ = cdr.read_type_11();	

	    	ulonglongTest_ = cdr.read_type_12();	

	    	floatTest_ = cdr.read_type_5();	

	    	doubleTest_ = cdr.read_type_6();	

	    	booleanTest_ = cdr.read_type_7();	

	    	colorTest_ = us.ihmc.idl.generated.IDLElement.Color.values[cdr.read_type_c()];
	    	

	    	cdr.read_type_a(nestedElementTest_);	

	    	cdr.read_type_d(stringTest_);	

	    	cdr.read_type_15(wstringTest_);	

	    	for(int a = 0; a < longArray_.length; ++a)
	    	{
	    	    	longArray_[a] = cdr.read_type_2();	
	    	}
	    	

	    	for(int a = 0; a < nestedArray_.length; ++a)
	    	{
	    	    for(int b = 0; b < nestedArray_[a].length; ++b)
	    	    {
	    	        	cdr.read_type_a(nestedArray_[a][b]);	
	    	    }
	    	}
	    	

	    	for(int a = 0; a < stringArray_.length; ++a)
	    	{
	    	    	cdr.read_type_d(stringArray_[a]);	
	    	}
	    	

	    	cdr.read_type_e(charSeqTest_);	

	    	cdr.read_type_e(wcharSeqTest_);	

	    	cdr.read_type_e(octetSeqTest_);	

	    	cdr.read_type_e(shortSeqTest_);	

	    	cdr.read_type_e(ushortSeqTest_);	

	    	cdr.read_type_e(longSeqTest_);	

	    	cdr.read_type_e(longlongSeqtest_);	

	    	cdr.read_type_e(ulonglongSeqTest_);	

	    	cdr.read_type_e(floatSeqTest_);	

	    	cdr.read_type_e(doubleSeqTest_);	

	    	cdr.read_type_e(booleanSeqTest_);	

	    	cdr.read_type_e(colorSeqTest_);	

	    	cdr.read_type_e(nestedSeqTest_);	

	    	cdr.read_type_e(stringSeqTest_);	

	    	cdr.read_type_e(wstringSeqTest_);	
	}

    @Override
    public boolean equals(Object other)
    {
        if(other == null) return false;
        if(other == this) return true;
        if(!(other instanceof IDLElementTest)) return false;
        IDLElementTest otherMyClass = (IDLElementTest)other;
        boolean returnedValue = true;

        returnedValue &= this.charTest_ == otherMyClass.charTest_;
                
        returnedValue &= this.wcharTest_ == otherMyClass.wcharTest_;
                
        returnedValue &= this.octetTest_ == otherMyClass.octetTest_;
                
        returnedValue &= this.shortTest_ == otherMyClass.shortTest_;
                
        returnedValue &= this.ushortTest_ == otherMyClass.ushortTest_;
                
        returnedValue &= this.longTest_ == otherMyClass.longTest_;
                
        returnedValue &= this.ulongTest_ == otherMyClass.ulongTest_;
                
        returnedValue &= this.longlongTest_ == otherMyClass.longlongTest_;
                
        returnedValue &= this.ulonglongTest_ == otherMyClass.ulonglongTest_;
                
        returnedValue &= this.floatTest_ == otherMyClass.floatTest_;
                
        returnedValue &= this.doubleTest_ == otherMyClass.doubleTest_;
                
        returnedValue &= this.booleanTest_ == otherMyClass.booleanTest_;
                
        returnedValue &= this.colorTest_ == otherMyClass.colorTest_;
                
        returnedValue &= this.nestedElementTest_.equals(otherMyClass.nestedElementTest_);
                
        returnedValue &= this.stringTest_.equals(otherMyClass.stringTest_);
                
        returnedValue &= this.wstringTest_.equals(otherMyClass.wstringTest_);
                
        returnedValue &= this.longArray_.equals(otherMyClass.longArray_);
                
        returnedValue &= this.nestedArray_.equals(otherMyClass.nestedArray_);
                
        returnedValue &= this.stringArray_.equals(otherMyClass.stringArray_);
                
        returnedValue &= this.charSeqTest_.equals(otherMyClass.charSeqTest_);
                
        returnedValue &= this.wcharSeqTest_.equals(otherMyClass.wcharSeqTest_);
                
        returnedValue &= this.octetSeqTest_.equals(otherMyClass.octetSeqTest_);
                
        returnedValue &= this.shortSeqTest_.equals(otherMyClass.shortSeqTest_);
                
        returnedValue &= this.ushortSeqTest_.equals(otherMyClass.ushortSeqTest_);
                
        returnedValue &= this.longSeqTest_.equals(otherMyClass.longSeqTest_);
                
        returnedValue &= this.longlongSeqtest_.equals(otherMyClass.longlongSeqtest_);
                
        returnedValue &= this.ulonglongSeqTest_.equals(otherMyClass.ulonglongSeqTest_);
                
        returnedValue &= this.floatSeqTest_.equals(otherMyClass.floatSeqTest_);
                
        returnedValue &= this.doubleSeqTest_.equals(otherMyClass.doubleSeqTest_);
                
        returnedValue &= this.booleanSeqTest_.equals(otherMyClass.booleanSeqTest_);
                
        returnedValue &= this.colorSeqTest_.equals(otherMyClass.colorSeqTest_);
                
        returnedValue &= this.nestedSeqTest_.equals(otherMyClass.nestedSeqTest_);
                
        returnedValue &= this.stringSeqTest_.equals(otherMyClass.stringSeqTest_);
                
        returnedValue &= this.wstringSeqTest_.equals(otherMyClass.wstringSeqTest_);
                

        return returnedValue;
    }

    private char charTest_; 
    private char wcharTest_; 
    private byte octetTest_; 
    private short shortTest_; 
    private int ushortTest_; 
    private int longTest_; 
    private long ulongTest_; 
    private long longlongTest_; 
    private long ulonglongTest_; 
    private float floatTest_; 
    private double doubleTest_; 
    private boolean booleanTest_; 
    private us.ihmc.idl.generated.IDLElement.Color colorTest_; 
    private us.ihmc.idl.generated.IDLElement.NestedElement nestedElementTest_; 
    private StringBuilder stringTest_; 
    private StringBuilder wstringTest_; 
    private int[] longArray_; 
    private us.ihmc.idl.generated.IDLElement.NestedElement[][] nestedArray_; 
    private StringBuilder[] stringArray_; 
    private IDLSequence.Char  charSeqTest_; 
    private IDLSequence.Char  wcharSeqTest_; 
    private IDLSequence.Byte  octetSeqTest_; 
    private IDLSequence.Short  shortSeqTest_; 
    private IDLSequence.Integer  ushortSeqTest_; 
    private IDLSequence.Integer  longSeqTest_; 
    private IDLSequence.Long  longlongSeqtest_; 
    private IDLSequence.Long  ulonglongSeqTest_; 
    private IDLSequence.Float  floatSeqTest_; 
    private IDLSequence.Double  doubleSeqTest_; 
    private IDLSequence.Boolean  booleanSeqTest_; 
    private IDLSequence.Object<us.ihmc.idl.generated.IDLElement.Color>  colorSeqTest_; 
    private IDLSequence.Object<us.ihmc.idl.generated.IDLElement.NestedElement>  nestedSeqTest_; 
    private IDLSequence.StringBuilderHolder  stringSeqTest_; 
    private IDLSequence.StringBuilderHolder  wstringSeqTest_; 

}