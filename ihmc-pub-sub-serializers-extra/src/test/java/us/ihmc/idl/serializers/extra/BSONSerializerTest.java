/**
 * Copyright 2018 Florida Institute for Human and Machine Cognition (IHMC)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package us.ihmc.idl.serializers.extra;

import static us.ihmc.robotics.Assert.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import us.ihmc.idl.generated.test.IDLElementTest;
import us.ihmc.idl.generated.test.IDLElementTestPubSubType;

public class BSONSerializerTest
{

   @Test// timeout = 30000
   public void test() throws IOException
   {
      IDLElementTestPubSubType dataType = new IDLElementTestPubSubType();
      BSONSerializer<IDLElementTest> serializer = new BSONSerializer<>(dataType);
      
      IDLElementTest testElement = JSONSerializerTest.createPopulatedIDLElementTest();
      
      byte[] data = serializer.serializeToBytes(testElement);
      
      
      IDLElementTest result = serializer.deserialize(data);
      
      assertEquals(testElement, result);
      
   }

}
