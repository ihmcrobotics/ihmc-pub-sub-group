package us.ihmc.idl.generated.IDLElement;
import us.ihmc.idl.IDLSequence;
import us.ihmc.idl.CDR;
import us.ihmc.idl.IDLStruct;
import java.util.Arrays;

public class IDLElementTest implements IDLStruct<IDLElementTest>
{
    public IDLElementTest()
    {
        	nestedElementTest_ = new us.ihmc.idl.generated.IDLElement.NestedElement();stringTest_ = new StringBuilder(255); 
        	wstringTest_ = new StringBuilder(255); 
        	longArray_ = new int[10];
        	nestedArray_ = new us.ihmc.idl.generated.IDLElement.NestedElement[5][3];
        	for(int b = 0; b < nestedArray_.length; ++b)
        	{
        	    for(int c = 0; c < nestedArray_[b].length; ++c)
        	    {
        	        	nestedArray_[b][c] = new us.ihmc.idl.generated.IDLElement.NestedElement();	
        	    }
        	}
        	stringArray_ = new StringBuilder[4];
        	for(int e = 0; e < stringArray_.length; ++e)
        	{
        	    	stringArray_[e] = new StringBuilder();	
        	}
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
        	colorSeqTest_ = new IDLSequence.Object<us.ihmc.idl.generated.IDLElement.Color> (25, us.ihmc.idl.generated.IDLElement.Color.class, us.ihmc.idl.generated.IDLElement.Color.values);


        	nestedSeqTest_ = new IDLSequence.Object<us.ihmc.idl.generated.IDLElement.NestedElement> (25, us.ihmc.idl.generated.IDLElement.NestedElement.class, new us.ihmc.idl.generated.IDLElement.NestedElementPubSubType());

        	stringSeqTest_ = new IDLSequence.StringBuilderHolder (25, "type_d");   wstringSeqTest_ = new IDLSequence.StringBuilderHolder (25, "type_15");   
        
        
    }
    @Override
    public void set(IDLElementTest other)
    {
        	charTest_ = other.charTest_;
        	wcharTest_ = other.wcharTest_;
        	octetTest_ = other.octetTest_;
        	shortTest_ = other.shortTest_;
        	ushortTest_ = other.ushortTest_;
        	longTest_ = other.longTest_;
        	ulongTest_ = other.ulongTest_;
        	longlongTest_ = other.longlongTest_;
        	ulonglongTest_ = other.ulonglongTest_;
        	floatTest_ = other.floatTest_;
        	doubleTest_ = other.doubleTest_;
        	booleanTest_ = other.booleanTest_;
        	colorTest_ = other.colorTest_;
        	nestedElementTest_.set(other.nestedElementTest_);stringTest_.setLength(0);
        	stringTest_.append(other.stringTest_);
        	wstringTest_.setLength(0);
        	wstringTest_.append(other.wstringTest_);
        	for(int g = 0; g < longArray_.length; ++g)
        	{
        	    	longArray_[g] = other.longArray_[g];	

        	}
        	for(int i = 0; i < nestedArray_.length; ++i)
        	{
        	    for(int j = 0; j < nestedArray_[i].length; ++j)
        	    {
        	        	other.nestedArray_[i][j].set(nestedArray_[i][j]);
        	    }
        	}
        	for(int l = 0; l < stringArray_.length; ++l)
        	{
        	    	stringArray_[l].setLength(0);
        	    	stringArray_[l].append(other.stringArray_[l]);
        	            	}
        	charSeqTest_.set(other.charSeqTest_);wcharSeqTest_.set(other.wcharSeqTest_);octetSeqTest_.set(other.octetSeqTest_);shortSeqTest_.set(other.shortSeqTest_);ushortSeqTest_.set(other.ushortSeqTest_);longSeqTest_.set(other.longSeqTest_);longlongSeqtest_.set(other.longlongSeqtest_);ulonglongSeqTest_.set(other.ulonglongSeqTest_);floatSeqTest_.set(other.floatSeqTest_);doubleSeqTest_.set(other.doubleSeqTest_);booleanSeqTest_.set(other.booleanSeqTest_);colorSeqTest_.set(other.colorSeqTest_);nestedSeqTest_.set(other.nestedSeqTest_);stringSeqTest_.set(other.stringSeqTest_);wstringSeqTest_.set(other.wstringSeqTest_);
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

        

    public us.ihmc.idl.generated.IDLElement.NestedElement getNestedElementTest()
    {
        return nestedElementTest_;
    }

        

    public StringBuilder getStringTest()
    {
        return stringTest_;
    }

        

    public StringBuilder getWstringTest()
    {
        return wstringTest_;
    }

        

    public int[] getLongArray()
    {
        return longArray_;
    }

        

    public us.ihmc.idl.generated.IDLElement.NestedElement[][] getNestedArray()
    {
        return nestedArray_;
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
	
	@Override
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
	
	@Override
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
                
        returnedValue &= us.ihmc.idl.IDLTools.equals(this.stringTest_, otherMyClass.stringTest_);
                
        returnedValue &= us.ihmc.idl.IDLTools.equals(this.wstringTest_, otherMyClass.wstringTest_);
                
                	for(int c = 0; c < longArray_.length; ++c)
                	{
                	    returnedValue &= this.longArray_[c] == otherMyClass.longArray_[c];

                	}        
                	for(int e = 0; e < nestedArray_.length; ++e)
                	{
                	    for(int f = 0; f < nestedArray_[e].length; ++f)
                	    {
                	        returnedValue &= nestedArray_[e][f].equals(otherMyClass.nestedArray_[e][f]);
                	    }
                	}        
                	for(int h = 0; h < stringArray_.length; ++h)
                	{
                	    returnedValue &= this.stringArray_[h].equals(otherMyClass.stringArray_[h]);}        
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
    
     @Override
    public String toString()
    {
		StringBuilder builder = new StringBuilder();
		
      	builder.append("IDLElementTest {");
        builder.append("charTest=");
        builder.append(this.charTest_);

                builder.append(", ");
        builder.append("wcharTest=");
        builder.append(this.wcharTest_);

                builder.append(", ");
        builder.append("octetTest=");
        builder.append(this.octetTest_);

                builder.append(", ");
        builder.append("shortTest=");
        builder.append(this.shortTest_);

                builder.append(", ");
        builder.append("ushortTest=");
        builder.append(this.ushortTest_);

                builder.append(", ");
        builder.append("longTest=");
        builder.append(this.longTest_);

                builder.append(", ");
        builder.append("ulongTest=");
        builder.append(this.ulongTest_);

                builder.append(", ");
        builder.append("longlongTest=");
        builder.append(this.longlongTest_);

                builder.append(", ");
        builder.append("ulonglongTest=");
        builder.append(this.ulonglongTest_);

                builder.append(", ");
        builder.append("floatTest=");
        builder.append(this.floatTest_);

                builder.append(", ");
        builder.append("doubleTest=");
        builder.append(this.doubleTest_);

                builder.append(", ");
        builder.append("booleanTest=");
        builder.append(this.booleanTest_);

                builder.append(", ");
        builder.append("colorTest=");
        builder.append(this.colorTest_);

                builder.append(", ");
        builder.append("nestedElementTest=");
        builder.append(this.nestedElementTest_);

                builder.append(", ");
        builder.append("stringTest=");
        builder.append(this.stringTest_);

                builder.append(", ");
        builder.append("wstringTest=");
        builder.append(this.wstringTest_);

                builder.append(", ");
        builder.append("longArray=");
        builder.append(Arrays.toString(this.longArray_));

                builder.append(", ");
        builder.append("nestedArray=");
        builder.append(Arrays.deepToString(this.nestedArray_));

                builder.append(", ");
        builder.append("stringArray=");
        builder.append(Arrays.toString(this.stringArray_));

                builder.append(", ");
        builder.append("charSeqTest=");
        builder.append(this.charSeqTest_);

                builder.append(", ");
        builder.append("wcharSeqTest=");
        builder.append(this.wcharSeqTest_);

                builder.append(", ");
        builder.append("octetSeqTest=");
        builder.append(this.octetSeqTest_);

                builder.append(", ");
        builder.append("shortSeqTest=");
        builder.append(this.shortSeqTest_);

                builder.append(", ");
        builder.append("ushortSeqTest=");
        builder.append(this.ushortSeqTest_);

                builder.append(", ");
        builder.append("longSeqTest=");
        builder.append(this.longSeqTest_);

                builder.append(", ");
        builder.append("longlongSeqtest=");
        builder.append(this.longlongSeqtest_);

                builder.append(", ");
        builder.append("ulonglongSeqTest=");
        builder.append(this.ulonglongSeqTest_);

                builder.append(", ");
        builder.append("floatSeqTest=");
        builder.append(this.floatSeqTest_);

                builder.append(", ");
        builder.append("doubleSeqTest=");
        builder.append(this.doubleSeqTest_);

                builder.append(", ");
        builder.append("booleanSeqTest=");
        builder.append(this.booleanSeqTest_);

                builder.append(", ");
        builder.append("colorSeqTest=");
        builder.append(this.colorSeqTest_);

                builder.append(", ");
        builder.append("nestedSeqTest=");
        builder.append(this.nestedSeqTest_);

                builder.append(", ");
        builder.append("stringSeqTest=");
        builder.append(this.stringSeqTest_);

                builder.append(", ");
        builder.append("wstringSeqTest=");
        builder.append(this.wstringSeqTest_);

                
        builder.append("}");
		return builder.toString();
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