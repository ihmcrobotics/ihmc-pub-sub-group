package us.ihmc.idl.IDLElement;

import java.io.IOException;

import org.junit.Test;

import us.ihmc.idl.generated.IDLElement.Color;
import us.ihmc.idl.generated.IDLElement.IDLElementTest;
import us.ihmc.idl.generated.IDLElement.IDLElementTestPubSubType;
import us.ihmc.idl.generated.IDLElement.NestedElement;
import us.ihmc.rtps.common.SerializedPayload;

public class IDLElementTestTest
{
   @Test
   public void testIDLElementTest() throws IOException
   {
      IDLElementTest test = new IDLElementTest();
      test.setColorTest(Color.blue);
      for(int i = 0; i < test.getStringArray().length; i++)
      {
         test.getStringArray()[i] = new StringBuilder("Bla");
      }
      
      
      
      for(int a = 0; a < test.getNestedArray().length; ++a)
      {
          for(int b = 0; b < test.getNestedArray()[a].length; ++b)
          {
             test.getNestedArray()[a][b] = new NestedElement();
          }
      }

      
      IDLElementTestPubSubType type = new IDLElementTestPubSubType();
      SerializedPayload payload = new SerializedPayload(type.getTypeSize());
      type.serialize(test, payload);

   }
}
