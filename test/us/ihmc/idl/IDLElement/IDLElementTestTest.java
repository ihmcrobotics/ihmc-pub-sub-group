package us.ihmc.idl.IDLElement;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import us.ihmc.idl.generated.IDLElement.Color;
import us.ihmc.idl.generated.IDLElement.IDLElementTest;
import us.ihmc.idl.generated.IDLElement.IDLElementTestPubSubType;
import us.ihmc.rtps.common.SerializedPayload;

public class IDLElementTestTest
{
   @Test
   public void testIDLElementTest() throws IOException
   {
      IDLElementTest test = new IDLElementTest();
      
      test.setCharTest('3');
      test.setWcharTest('Ω');
      test.setOctetTest((byte) 0xa);
      test.setShortTest((short)-16);
      test.setUshortTest(15);
      test.setLongTest(-58102);
      test.setUlongTest(914);
      test.setLonglongTest(-90224141);
      test.setUlonglongTest(582142);
      test.setFloatTest(0258145.2143f);
      test.setDoubleTest(9184289051.1241);
      test.setBooleanTest(true);
      test.setColorTest(Color.green);
      test.getStringTest().append("Wolololo");
      test.getWstringTest().append("ΑΩ");
      
      
      
      IDLElementTestPubSubType type = new IDLElementTestPubSubType();
      SerializedPayload payload = new SerializedPayload(type.getTypeSize());
      type.serialize(test, payload);

      
      
      IDLElementTest other = new IDLElementTest();
      type.deserialize(payload, other);
      System.out.println(other.toString());
      assertTrue(test.equals(other));
   }
}
