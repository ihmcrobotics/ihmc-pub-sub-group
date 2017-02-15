package us.ihmc.idl;

/**
 * Represents and IDL struct.  
 * 
 * 
 * @author Jesper Smith
 *
 */
public interface IDLStruct
{
   /**
    * Serialization method used internally to serialize nested structs
    * 
    * @param cdr
    */
   void deserialize(CDR cdr);
   
   /**
    * Deserialization method used internally to deserialize nested structs
    * 
    * @param cdr
    */
   void serialize(CDR cdr);
}
