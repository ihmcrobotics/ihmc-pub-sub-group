/**
 * Copyright 2017 Florida Institute for Human and Machine Cognition (IHMC)
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
package us.ihmc.idl;

import org.apache.commons.lang3.NotImplementedException;

/**
 * Represents and IDL struct.  
 * 
 * 
 * @author Jesper Smith
 *
 */
public interface IDLStruct <T extends IDLStruct<?>>
{
   /**
    * Serialization method used internally to serialize nested structs
    * 
    * @param cdr
    */
   default void deserialize(CDR cdr) { throw new NotImplementedException("Not implemented"); };
   
   /**
    * Deserialization method used internally to deserialize nested structs
    * 
    * @param cdr
    */
   default void serialize(CDR cdr) { throw new NotImplementedException("Not implemented"); };
   
   
   /**
    * Serialization method used internally to serialize nested structs
    * 
    * @param ser
    */
   default void deserialize(InterchangeSerializer ser) { throw new NotImplementedException("Not implemented"); };
   
   /**
    * Deserialization method used internally to deserialize nested structs
    * 
    * @param ser
    */
   default void serialize(InterchangeSerializer ser) { throw new NotImplementedException("Not implemented"); };
   
   
   /**
    * Setter method used internally to set nested struct sequences.
    * 
    * @param other
    */
   default void set(T other) { throw new NotImplementedException("Not implemented"); };
}
