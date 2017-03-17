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
