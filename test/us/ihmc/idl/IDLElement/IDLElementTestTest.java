package us.ihmc.idl.IDLElement;

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
      test.setColorTest(Color.blue);
      
      
      IDLElementTestPubSubType type = new IDLElementTestPubSubType();
      SerializedPayload payload = new SerializedPayload(type.getTypeSize());
      type.serialize(test, payload);

   }
}
