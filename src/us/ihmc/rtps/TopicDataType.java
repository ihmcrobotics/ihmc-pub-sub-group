package us.ihmc.rtps;

import us.ihmc.rtps.common.SerializedPayload;

/**
 * Class TopicDataType used to provide the Participant with the methods to serialize, deserialize and get the key of a specific data type
 * 
 * @author Jesper Smith
 *
 * @param <T>
 */
public interface TopicDataType<T>
{
   /**
    * Serialize method, it should be implemented by the user.
    *
    * 
    * @param data
    * @param serializedPayload
    * 
    * @return true if serialized correctly
    */
   public boolean serialize(T data, SerializedPayload serializedPayload);

   /**
    * Deserialize method, it should be implemented by the user
    * 
    * @param serializedPayload
    * @param data
    * 
    * @return true if deserialized correctly
    */
   public boolean deserialize(SerializedPayload serializedPayload, T data);

   /**
    * Maximum serialized size of the type in bytes.
    * 
    * If the type has unbounded fields, and therefore cannot have a maximum size, use 0.
    *
    * @return maximum size in bytes
    */
   public int getTypeSize();

   /**
    * 
    * @return Topic data type name
    */
   public String getName();

   /**
    * Get the key associated with the data. 
    */
   default byte[] getKey(T data)
   {
      return null;
   }

   /**
    * Indicates whether the method to obtain the key has been implemented
    * @return true when implemented
    */
   default boolean isGetKeyDefined()
   {
      return false;
   }
}
