package us.ihmc.idl;

import org.apache.commons.lang3.NotImplementedException;

import gnu.trove.list.array.TByteArrayList;
import gnu.trove.list.array.TCharArrayList;
import gnu.trove.list.array.TDoubleArrayList;
import gnu.trove.list.array.TFloatArrayList;
import gnu.trove.list.array.TIntArrayList;
import gnu.trove.list.array.TLongArrayList;
import gnu.trove.list.array.TShortArrayList;
import us.ihmc.pubsub.TopicDataType;

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
public interface IDLSequence
{

   public static class Boolean extends TByteArrayList implements IDLSequence
   {
      public static final byte True = 1;
      public static final byte False = 0;
      private final int maxSize;
      
      public Boolean(int maxSize, String typeCode)
      {
         super(maxSize);
         if (!typeCode.equals("type_7"))
         {
            throw new NotImplementedException(typeCode + " is not implemented for Sequence");
         }
         this.maxSize = maxSize;
      }

      public void add(boolean value)
      {
         add(value ? True : False);
      }

      public boolean getBoolean(int offset)
      {
         return get(offset) == True;
      }
      
      public void set(int offset, boolean b)
      {
         set(offset, b?True : False);
      }

      @Override
      public void readElement(int i, CDR cdr)
      {
         add(cdr.read_type_7());
      }

      @Override
      public void writeElement(int i, CDR cdr)
      {
         cdr.write_type_7(getBoolean(i));
      }
      
      public void set(Boolean other)
      {
         resetQuick();
         for(int i = 0; i < other.size(); i++)
         {
            add(other.get(i));
         }
      }
      
      @Override
      public String toString()
      {
         StringBuilder builder = new StringBuilder();
         builder.append("[");
         for(int i = 0; i < size(); i++)
         {
            if(i > 0)
            {
               builder.append(", ");
            }
            builder.append(getBoolean(i));           
         }
         builder.append("]");
         return builder.toString();
      }

      @Override
      public int capacity()
      {
         return maxSize;
      }

   }

   public static class Byte extends TByteArrayList implements IDLSequence
   {
      private final int maxSize;
      public Byte(int maxSize, String typeCode)
      {
         super(maxSize);
         if (!typeCode.equals("type_9"))
         {
            throw new NotImplementedException(typeCode + " is not implemented for Sequence");
         }
         this.maxSize = maxSize;
      }

      @Override
      public void readElement(int i, CDR cdr)
      {
         add(cdr.read_type_9());
      }

      @Override
      public void writeElement(int i, CDR cdr)
      {
         cdr.write_type_9(get(i));
      }
      
      public void set(Byte other)
      {
         resetQuick();
         for(int i = 0; i < other.size(); i++)
         {
            add(other.get(i));
         }
      }
      
      @Override
      public String toString()
      {
         StringBuilder builder = new StringBuilder();
         builder.append("[");
         for(int i = 0; i < size(); i++)
         {
            if(i > 0)
            {
               builder.append(", ");
            }
            builder.append(get(i));           
         }
         builder.append("]");
         return builder.toString();
      }

      @Override
      public int capacity()
      {
         return maxSize;
      }
   }

   public static class Char extends TCharArrayList implements IDLSequence
   {
      private final int type;
      private final int maxSize;
      public Char(int maxSize, String typeCode)
      {
         super(maxSize);
         switch (typeCode)
         {
         case "type_8":
            type = 8;
            break;
         case "type_14":
            type = 14;
            break;
         default:
            throw new NotImplementedException(typeCode + " is not implemented for Sequence");
         }
         this.maxSize = maxSize;
      }

      @Override
      public void readElement(int i, CDR cdr)
      {
         switch (type)
         {
         case 8:
            add(cdr.read_type_8());
            break;
         case 14:
            add(cdr.read_type_14());
            break;
         }
      }

      @Override
      public void writeElement(int i, CDR cdr)
      {
         switch (type)
         {
         case 8:
            cdr.write_type_8(get(i));
            break;
         case 14:
            cdr.write_type_14(get(i));
            break;
         }
      }
      
      public void set(Char other)
      {
         resetQuick();
         for(int i = 0; i < other.size(); i++)
         {
            add(other.get(i));
         }
      }
      
      @Override
      public String toString()
      {
         StringBuilder builder = new StringBuilder();
         builder.append("[");
         for(int i = 0; i < size(); i++)
         {
            if(i > 0)
            {
               builder.append(", ");
            }
            builder.append(get(i));           
         }
         builder.append("]");
         return builder.toString();
      }

      @Override
      public int capacity()
      {
         return maxSize;
      }
   }

   public static class Short extends TShortArrayList implements IDLSequence
   {
      private final int maxSize;
      public Short(int maxSize, String typeCode)
      {
         super(maxSize);
         if (!typeCode.equals("type_1"))
         {
            throw new NotImplementedException(typeCode + " is not implemented for Sequence");
         }
         this.maxSize = maxSize;
      }

      @Override
      public void readElement(int i, CDR cdr)
      {
         add(cdr.read_type_1());
      }

      @Override
      public void writeElement(int i, CDR cdr)
      {
         cdr.write_type_1(get(i));
      }
      
      public void set(Short other)
      {
         resetQuick();
         for(int i = 0; i < other.size(); i++)
         {
            add(other.get(i));
         }
      }
      
      @Override
      public String toString()
      {
         StringBuilder builder = new StringBuilder();
         builder.append("[");
         for(int i = 0; i < size(); i++)
         {
            if(i > 0)
            {
               builder.append(", ");
            }
            builder.append(get(i));           
         }
         builder.append("]");
         return builder.toString();
      }

      @Override
      public int capacity()
      {
         return maxSize;
      }
   }

   public static class Integer extends TIntArrayList implements IDLSequence
   {
      private final int type;
      private final int maxSize;

      public Integer(int maxSize, String typeCode)
      {
         super(maxSize);
         switch (typeCode)
         {
         case "type_2":
            type = 2;
            break;
         case "type_3":
            type = 3;
            break;
         default:
            throw new NotImplementedException(typeCode + " is not implemented for Sequence");
         }
         this.maxSize = maxSize;
      }

      @Override
      public void readElement(int i, CDR cdr)
      {
         switch (type)
         {
         case 2:
            add(cdr.read_type_2());
            break;
         case 3:
            add(cdr.read_type_3());
            break;
         }
      }

      @Override
      public void writeElement(int i, CDR cdr)
      {
         switch (type)
         {
         case 2:
            cdr.write_type_2(get(i));
            break;
         case 3:
            cdr.write_type_3(get(i));
            break;
         }
      }
      
      public void set(Integer other)
      {
         resetQuick();
         for(int i = 0; i < other.size(); i++)
         {
            add(other.get(i));
         }
      }
      
      @Override
      public String toString()
      {
         StringBuilder builder = new StringBuilder();
         builder.append("[");
         for(int i = 0; i < size(); i++)
         {
            if(i > 0)
            {
               builder.append(", ");
            }
            builder.append(get(i));           
         }
         builder.append("]");
         return builder.toString();
      }

      @Override
      public int capacity()
      {
         return maxSize;
      }
   }

   public static class Long extends TLongArrayList implements IDLSequence
   {
      private final int type;
      private final int maxSize;
      public Long(int maxSize, String typeCode)
      {
         super(maxSize);
         switch (typeCode)
         {
         case "type_11":
            type = 11;
            break;
         case "type_12":
            type = 12;
            break;
         case "type_4":
            type = 4;
            break;
         default:
            throw new NotImplementedException(typeCode + " is not implemented for Sequence");
         }
         this.maxSize = maxSize;
      }

      @Override
      public void readElement(int i, CDR cdr)
      {
         switch (type)
         {
         case 11:
            add(cdr.read_type_11());
            break;
         case 12:
            add(cdr.read_type_12());
            break;
         case 4:
            add(cdr.read_type_4());
            break;
         }
      }

      @Override
      public void writeElement(int i, CDR cdr)
      {
         switch (type)
         {
         case 11:
            cdr.write_type_11(get(i));
            break;
         case 12:
            cdr.write_type_12(get(i));
            break;
         case 4:
            cdr.write_type_4(get(i));
            break;
         }
      }
      
      public void set(Long other)
      {
         resetQuick();
         for(int i = 0; i < other.size(); i++)
         {
            add(other.get(i));
         }
      }
      
      @Override
      public String toString()
      {
         StringBuilder builder = new StringBuilder();
         builder.append("[");
         for(int i = 0; i < size(); i++)
         {
            if(i > 0)
            {
               builder.append(", ");
            }
            builder.append(get(i));           
         }
         builder.append("]");
         return builder.toString();
      }

      @Override
      public int capacity()
      {
         return maxSize;
      }
   }

   public static class Float extends TFloatArrayList implements IDLSequence
   {
      private final int maxSize;
      public Float(int maxSize, String typeCode)
      {
         super(maxSize);
         if (!typeCode.equals("type_5"))
         {
            throw new NotImplementedException(typeCode + " is not implemented for Sequence");
         }
         this.maxSize = maxSize;
      }

      @Override
      public void readElement(int i, CDR cdr)
      {
         add(cdr.read_type_5());
      }

      @Override
      public void writeElement(int i, CDR cdr)
      {
         cdr.write_type_5(get(i));
      }
      
      public void set(Float other)
      {
         resetQuick();
         for(int i = 0; i < other.size(); i++)
         {
            add(other.get(i));
         }
      }
      
      @Override
      public String toString()
      {
         StringBuilder builder = new StringBuilder();
         builder.append("[");
         for(int i = 0; i < size(); i++)
         {
            if(i > 0)
            {
               builder.append(", ");
            }
            builder.append(get(i));           
         }
         builder.append("]");
         return builder.toString();
      }

      @Override
      public int capacity()
      {
         return maxSize;
      }
   }

   public static class Double extends TDoubleArrayList implements IDLSequence
   {
      private final int maxSize;
      public Double(int maxSize, String typeCode)
      {
         super(maxSize);
         if (!typeCode.equals("type_6"))
         {
            throw new NotImplementedException(typeCode + " is not implemented for Sequence");
         }
         this.maxSize = maxSize;
      }

      @Override
      public void readElement(int i, CDR cdr)
      {
         add(cdr.read_type_6());
      }

      @Override
      public void writeElement(int i, CDR cdr)
      {
         cdr.write_type_6(get(i));
      }
      
      public void set(Double other)
      {
         resetQuick();
         for(int i = 0; i < other.size(); i++)
         {
            add(other.get(i));
         }
      }
      
      @Override
      public String toString()
      {
         StringBuilder builder = new StringBuilder();
         builder.append("[");
         for(int i = 0; i < size(); i++)
         {
            if(i > 0)
            {
               builder.append(", ");
            }
            builder.append(get(i));           
         }
         builder.append("]");
         return builder.toString();
      }

      @Override
      public int capacity()
      {
         return maxSize;
      }
   }

   public static class StringBuilderHolder extends PreallocatedList<StringBuilder> implements IDLSequence
   {
      private final int type;

      public StringBuilderHolder(int maxSize, String typeCode)
      {
         super(StringBuilder.class, () -> new StringBuilder(), maxSize);
         switch (typeCode)
         {
         case "type_d":
            type = 0xd;
            break;
         case "type_15":
            type = 0x15;
            break;
         default:
            throw new NotImplementedException(typeCode + " is not implemented for Sequence");
         }
      }

      @Override
      public void readElement(int i, CDR cdr)
      {
         StringBuilder res = add();
         switch (type)
         {
         case 0xd:
            cdr.read_type_d(res);
            break;
         case 0x15:
            cdr.read_type_15(res);
            break;
         }
      }

      @Override
      public void writeElement(int i, CDR cdr)
      {
         switch (type)
         {
         case 0xd:
            cdr.write_type_d(get(i));
            break;
         case 0x15:
            cdr.write_type_15(get(i));
            break;
         }
      }
      
      /**
       * Directly add a string value.
       * 
       * @param string
       */
      public void add(String string)
      {
         StringBuilder elem = add();
         elem.setLength(0);
         elem.append(string);
      }
      
      /**
       * Get value at index i as string
       * 
       * @param i index
       * @return string value corresponding to index i
       */
      public String getString(int i)
      {
         return get(i).toString();
      }
      
      public void set(StringBuilderHolder other)
      {
         resetQuick();
         for(int i = 0; i < other.size(); i++)
         {
            add().append(other.get(i));
         }
      }
      
      /**
       * Create a new string array with all elements in this sequence.
       * 
       * @return string array
       */
      public String[] toStringArray()
      {
         String[] dest = new String[size()];
         toArray(dest);
         return dest;
      }
      
      /**
       * Copy the data into a string array
       * 
       * @param dest string array of length > size()
       */
      public void toArray(String[] dest)
      {
         if(dest.length < size())
         {
            throw new IndexOutOfBoundsException("Cannot copy data in destination array, insufficient space.");
         }
         for(int i = 0; i < size(); i++)
         {
            dest[i] = getString(i);
         }
      }
      
      @Override
      public String toString()
      {
         StringBuilder builder = new StringBuilder();
         builder.append("[");
         for(int i = 0; i < size(); i++)
         {
            if(i > 0)
            {
               builder.append(", ");
            }
            builder.append(get(i));           
         }
         builder.append("]");
         return builder.toString();
      }

      @Override
      public boolean equals(java.lang.Object obj)
      {
         if (this == obj)
            return true;
         if (obj == null)
            return false;
         if (getClass() != obj.getClass())
            return false;
         StringBuilderHolder other = (StringBuilderHolder) obj;
         if(size() != other.size())
            return false;
         for(int i = 0; i < size(); i++)
         {
            if(!IDLTools.equals(get(i), other.get(i)))
               return false;
         }
         
         return true;
      }

   }


   /**
    * Generic object and enum type for IDL sequences. 
    * 
    * @author Jesper Smith
    *
    * @param <T> Element type
    */
   @SuppressWarnings("rawtypes")
   public static class Object<T extends IDLStruct> extends PreallocatedList<T> implements IDLSequence
   {
     
      /**
       * 
       * @param maxSize Maximum size of this sequence
       * @param clazz Class to store
       * @param topicDataType TopicDataType to preallocate data if desired
       */
      public Object(int maxSize, Class<T> clazz, TopicDataType<T> topicDataType)
      {
         super(clazz, () -> topicDataType.createData() , maxSize);
         
      }

      public Object(int maxSize, Class<T> clazz, Enum[] constants)
      {
         super(clazz, constants, maxSize);
      }

      
      
      @SuppressWarnings("unchecked")
      @Override
      public void readElement(int i, CDR cdr)
      {
         if (isEnum())
         {
            add((T) getEnumConstants()[cdr.read_type_c()]);
         }
         else
         {
            T val = add();
            cdr.read_type_a(val);            
         }
      }

      @Override
      public void writeElement(int i, CDR cdr)
      {
         if (isEnum())
         {
            cdr.write_type_c(((Enum) get(i)).ordinal());
         }
         else
         {
            cdr.write_type_a(get(i));
         }
      }



      @SuppressWarnings("unchecked")
      public void set(Object<T> other)
      {
         if(isEnum())
         {
            clear();
            for(int i = 0; i < other.size(); i++)
            {
               add(other.get(i));
            }
         }
         else
         {
            clear();
            for(int i = 0; i < other.size(); i++)
            {
               T val = add();
               val.set(other.get(i));
            }
         }
      }
      
      @Override
      public String toString()
      {
         StringBuilder builder = new StringBuilder();
         builder.append("[");
         for(int i = 0; i < size(); i++)
         {
            if(i > 0)
            {
               builder.append(", ");
            }
            builder.append(get(i));           
         }
         builder.append("]");
         return builder.toString();
      }

   }

   public void resetQuick();

   public void readElement(int i, CDR cdr);

   public void writeElement(int i, CDR cdr);

   public int size();
   
   public int capacity();

}
