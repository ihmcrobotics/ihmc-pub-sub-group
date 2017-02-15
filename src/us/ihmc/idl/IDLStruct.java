package us.ihmc.idl;

public interface IDLStruct
{
   void deserialize(CDR cdr);
   void serialize(CDR cdr);
}
