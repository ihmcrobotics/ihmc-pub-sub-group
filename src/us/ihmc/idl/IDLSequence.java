package us.ihmc.idl;

import java.util.ArrayList;

import gnu.trove.list.array.TByteArrayList;
import gnu.trove.list.array.TCharArrayList;
import gnu.trove.list.array.TDoubleArrayList;
import gnu.trove.list.array.TFloatArrayList;
import gnu.trove.list.array.TIntArrayList;
import gnu.trove.list.array.TLongArrayList;
import gnu.trove.list.array.TShortArrayList;
import us.ihmc.rtps.TopicDataType;

/**
 * Represents an IDL sequence.
 * 
 * The current implementation of this class extends ArrayList<T>. Primitive versions are provided as subclasses and extend Trove ArrayLists. 
 * By providing a custom interface to ArrayList we can adjust the type to more efficient storage should the need arise. 
 * 
 * @param T Type of data
 * 
 * @author Jesper Smith
 */
public class IDLSequence <T> extends ArrayList<T>
{
   static final long serialVersionUID = -7593560934490213300L;

   public static class Boolean extends TByteArrayList
   {
      public static final byte True = 1;
      public static final byte False = 1;
      
      public Boolean(int maxSize)
      {
         super(maxSize);
      }
      
      public void add(boolean value)
      {
         add(value?True:False);
      }
      
      public boolean getBoolean(int offset)
      {
         return get(offset) == True;
      }
   }
   
   public static class Byte extends TByteArrayList
   {
      public Byte(int maxSize)
      {
         super(maxSize);
      }
   }
   
   public static class Char extends TCharArrayList
   {
      public Char(int maxSize)
      {
         super(maxSize);
      }
   }
   
   public static class Short extends TShortArrayList
   {
      public Short(int maxSize)
      {
         super(maxSize);
      }
   }
   
   public static class Integer extends TIntArrayList
   {
      public Integer(int maxSize)
      {
         super(maxSize);
      }
   }
   
   public static class Long extends TLongArrayList
   {
      public Long(int maxSize)
      {
         super(maxSize);
      }
   }
   
   public static class Float extends TFloatArrayList
   {
      public Float(int maxSize)
      {
         super(maxSize);
      }
   }
   
   public static class Double extends TDoubleArrayList
   {
      public Double(int maxSize)
      {
         super(maxSize);
      }
   }
   
   /**
    * 
    * @param maxSize Maximum size of this sequence
    * @param clazz Class to store
    * @param topicDataType TopicDataType to preallocate data if desired
    */
   public IDLSequence(int maxSize, Class<T> clazz, TopicDataType<T> topicDataType)
   {
      super(maxSize);
   }
      
}
