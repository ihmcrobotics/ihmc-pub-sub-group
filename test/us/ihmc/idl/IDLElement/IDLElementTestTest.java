package us.ihmc.idl.IDLElement;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import us.ihmc.idl.generated.IDLElement.Color;
import us.ihmc.idl.generated.IDLElement.IDLElementTest;
import us.ihmc.idl.generated.IDLElement.IDLElementTestPubSubType;
import us.ihmc.idl.generated.IDLElement.NestedElement;
import us.ihmc.rtps.common.SerializedPayload;

public class IDLElementTestTest
{
   //Output of the C++ program SerializationTest, found in cppsrc/test

   private void populateIDLElementTest(IDLElementTest test)
   {

      test.setCharTest('3');
      test.setWcharTest('Ω');
      test.setOctetTest((byte) 0xa);
      test.setShortTest((short) -16);
      test.setUshortTest(15);
      test.setLongTest(-58102);
      test.setUlongTest(914);
      test.setLonglongTest(-90224141);
      test.setUlonglongTest(582142);
      test.setFloatTest(258145.2143f);
      test.setDoubleTest(9184289051.1241);
      test.setBooleanTest(true);
      test.setColorTest(Color.blue);
      test.getNestedElementTest().setLongTest(518);
      test.getNestedElementTest().getStringTest().append("Nested");
      test.getStringTest().append("Wolololo");

      for (int i = 0; i < 10; i++)
      {
         test.getLongArray()[i] = i * 124;
      }

      for (int a = 0; a < 5; a++)
      {
         for (int b = 0; b < 3; b++)
         {
            test.getNestedArray()[a][b].setLongTest(a + a * b * 3 + b + 24);
            test.getNestedArray()[a][b].getStringTest().append("arrayDim:" + a + b);
         }
      }

      for (int i = 0; i < 4; i++)
      {
         test.getStringArray()[i].append("arrayDim:" + i);
      }

      for (int s = 1; s < 4; s++)
      {
         for (int w = 0; w < 5; w++)
         {
            int i = s + s * w;

            switch (s)
            {
            case 1:
               test.getCharSeqTest().add(String.valueOf(i).charAt(0));
               test.getWcharSeqTest().add('Ω');
               test.getOctetSeqTest().add((byte) (i * 2));
               test.getShortSeqTest().add((short) (-2 * i + 1));
               test.getBooleanSeqTest().add(i % 2 == 0);
            case 2:
               test.getUshortSeqTest().add(i + 4);
               test.getLongSeqTest().add(i * 124 - 98);
               test.getUlongSeqTest().add(i * 11561);
               test.getLonglongSeqtest().add(-2143125l + i * 1251);
            case 3:
               test.getUlonglongSeqTest().add(241l + i * 100421410l);
               test.getFloatSeqTest().add(325.25f * i);
               test.getDoubleSeqTest().add(15095.921 * i);
               NestedElement elem = test.getNestedSeqTest().add();
               elem.setLongTest(i * 541);
               elem.getStringTest().append("dim:" + s + w);
               StringBuilder builder = test.getStringSeqTest().add();
               builder.append("sdim:" + s + w);

            }
         }
      }
   }

   @Test
   public void testIDLElementSerializeDeserialize() throws IOException
   {
      IDLElementTest test = new IDLElementTest();
      populateIDLElementTest(test);

      IDLElementTestPubSubType type = new IDLElementTestPubSubType();
      SerializedPayload payload = new SerializedPayload(type.getTypeSize());
      type.serialize(test, payload);

      IDLElementTest other = new IDLElementTest();
      type.deserialize(payload, other);
      assertTrue(test.equals(other));

   }

   @Test
   public void testIDLElementWithFastRTPSGenCPPCode() throws IOException
   {
      IDLElementTest test = new IDLElementTest();
      populateIDLElementTest(test);

      IDLElementTestPubSubType type = new IDLElementTestPubSubType();
      SerializedPayload payload = new SerializedPayload(type.getTypeSize());
      type.serialize(test, payload);

      IDLElementTest cppElement = new IDLElementTest();

      SerializedPayload cppPayload = new SerializedPayload(type.getTypeSize());
      cppPayload.getData().put(IDLElementTestCPPData.cppData);
      cppPayload.getData().flip();
      cppPayload.setLength(IDLElementTestCPPData.cppData.length);
      System.out.println();
      type.deserialize(cppPayload, cppElement);
      System.out.println(cppElement);

      assertTrue(test.equals(cppElement));
   }
}
