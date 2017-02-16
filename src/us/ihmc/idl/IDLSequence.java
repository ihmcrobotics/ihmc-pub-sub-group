package us.ihmc.idl;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.apache.commons.lang3.NotImplementedException;

import gnu.trove.list.array.TByteArrayList;
import gnu.trove.list.array.TCharArrayList;
import gnu.trove.list.array.TDoubleArrayList;
import gnu.trove.list.array.TFloatArrayList;
import gnu.trove.list.array.TIntArrayList;
import gnu.trove.list.array.TLongArrayList;
import gnu.trove.list.array.TShortArrayList;
import us.ihmc.idl.generated.IDLElement.Color;
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
public interface IDLSequence
{

   public static class Boolean extends TByteArrayList implements IDLSequence
   {
      public static final byte True = 1;
      public static final byte False = 1;

      public Boolean(int maxSize, String typeCode)
      {
         super(maxSize);
         if (!typeCode.equals("type_7"))
         {
            throw new NotImplementedException(typeCode + " is not implemented for Sequence");
         }
      }

      public void add(boolean value)
      {
         add(value ? True : False);
      }

      public boolean getBoolean(int offset)
      {
         return get(offset) == True;
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
         ;
      }
      
      public void set(Boolean other)
      {
         resetQuick();
         for(int i = 0; i < other.size(); i++)
         {
            add(other.get(i));
         }
      }

   }

   public static class Byte extends TByteArrayList implements IDLSequence
   {
      public Byte(int maxSize, String typeCode)
      {
         super(maxSize);
         if (!typeCode.equals("type_9"))
         {
            throw new NotImplementedException(typeCode + " is not implemented for Sequence");
         }
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
   }

   public static class Char extends TCharArrayList implements IDLSequence
   {
      private final int type;

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
      }

      @Override
      public void readElement(int i, CDR cdr)
      {
         switch (type)
         {
         case 1:
            add(cdr.read_type_8());
            break;
         case 2:
            add(cdr.read_type_14());
            break;
         }
      }

      @Override
      public void writeElement(int i, CDR cdr)
      {
         switch (type)
         {
         case 1:
            cdr.write_type_8(get(i));
            break;
         case 2:
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
   }

   public static class Short extends TShortArrayList implements IDLSequence
   {
      public Short(int maxSize, String typeCode)
      {
         super(maxSize);
         if (!typeCode.equals("type_1"))
         {
            throw new NotImplementedException(typeCode + " is not implemented for Sequence");
         }
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
   }

   public static class Integer extends TIntArrayList implements IDLSequence
   {
      private final int type;

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
   }

   public static class Long extends TLongArrayList implements IDLSequence
   {
      private final int type;

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
   }

   public static class Float extends TFloatArrayList implements IDLSequence
   {
      public Float(int maxSize, String typeCode)
      {
         super(maxSize);
         if (!typeCode.equals("type_5"))
         {
            throw new NotImplementedException(typeCode + " is not implemented for Sequence");
         }
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
   }

   public static class Double extends TDoubleArrayList implements IDLSequence
   {
      public Double(int maxSize, String typeCode)
      {
         super(maxSize);
         if (!typeCode.equals("type_6"))
         {
            throw new NotImplementedException(typeCode + " is not implemented for Sequence");
         }
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
   }

   public static class StringBuilderHolder extends ArrayList<StringBuilder> implements IDLSequence
   {
      private static final long serialVersionUID = -8682247533370869042L;
      private final int type;

      public StringBuilderHolder(int maxSize, String typeCode)
      {
         super(maxSize);
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
      public void resetQuick()
      {
         clear();
      }

      @Override
      public void readElement(int i, CDR cdr)
      {
         StringBuilder res = new StringBuilder();
         switch (type)
         {
         case 0xd:
            cdr.read_type_d(res);
            break;
         case 0x15:
            cdr.read_type_15(res);
            break;
         }
         add(res);
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
      
      public void set(StringBuilderHolder other)
      {
         resetQuick();
         for(int i = 0; i < other.size(); i++)
         {
            add(other.get(i));
         }
      }

   }


   /**
    * Generic object and enum type for IDL sequences. 
    * 
    * This object preallocates the maximum number of instances. 
    * No setter is provided, use add(), remove() and get(i) to add, remove or get elements and change them in place. 
    * 
    * @author Jesper Smith
    *
    * @param <T> Element type
    */
   public static class Object<T extends IDLStruct> implements IDLSequence
   {
      private final TopicDataType<T> topicDataType;
      private final Enum[] constants;
      private final boolean isEnum;
      
      private final T[] values;
      private int pos = -1;

      /**
       * 
       * @param maxSize Maximum size of this sequence
       * @param clazz Class to store
       * @param topicDataType TopicDataType to preallocate data if desired
       */
      public Object(int maxSize, Class<T> clazz, TopicDataType<T> topicDataType)
      {
         this.values = (T[]) Array.newInstance(clazz, maxSize);
         for(int i = 0; i < maxSize; i++)
         {
            values[i] = topicDataType.createData();
         }
         this.topicDataType = topicDataType;
         this.isEnum = false;
         this.constants = null;
      }

      public Object(int maxSize, Enum[] constants)
      {
         if(maxSize > 0)
         {
            this.values = (T[]) Array.newInstance(constants[0].getClass(), maxSize);
         }
         else
         {
            this.values = (T[]) new Object[0];
         }
         this.topicDataType = null;
         this.isEnum = true;
         this.constants = constants;
      }

      /**
       * Clears the list. 
       * 
       * This function just resets the size to 0. The underlying data objects are not emptied or removed.
       */
      @Override
      public void resetQuick()
      {
         pos = -1;
      }

      /**
       * Add a value and return a handle to the object.
       * 
       * Do not use for Enum sequences.
       * 
       * @return value at the last position. This object can still hold data.
       */
      public T add()
      {
         if(isEnum)
         {
            throw new RuntimeException("Cannot add() enum to enum sequences. Use add(T) instead.");
         }
         if(pos + 1 >= this.values.length)
         {
            throw new ArrayIndexOutOfBoundsException("Cannot add element to sequence, max size is violated");
         }
         return values[++pos];  
      }
      
      /**
       * Add an enum value.
       * 
       * Use for enum sequences 
       * 
       * @param Enum value
       */
      public void add(T value)
      {
         if(!isEnum)
         {
            throw new RuntimeException("Cannot add(Enum) to object sequences. Use T add() instead");
         }
         if(pos + 1 >= this.values.length)
         {
            throw new ArrayIndexOutOfBoundsException("Cannot add element to sequence, max size is violated");
         }
         values[++pos] = value; 
      }
      
      /**
       * Removes the last element in the list. The underlying data object is not emptied or removed
       */
      public void remove()
      {
         if(pos < 0)
         {
            throw new ArrayIndexOutOfBoundsException("List is empty");
         }
         --pos;
      }
      
      /**
       * Get the element at position i. To change the element, use get() and 
       * 
       * @param i Position to get element at
       * @return Element at position i.
       */
      public T get(int i)
      {
         if(i < 0 || i > pos)
         {
            throw new ArrayIndexOutOfBoundsException("Position is not valid in the list, size is " + size() + ", requested element is " + i);
         }
         return values[i];
      }
      
      /**
       * Clears the list
       */
      public void clear()
      {
         resetQuick();
      }
      
      @Override
      public void readElement(int i, CDR cdr)
      {
         if (isEnum)
         {
            add((T) constants[cdr.read_type_c()]);
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
         if (isEnum)
         {
            cdr.write_type_c(((Enum) get(i)).ordinal());
         }
         else
         {
            cdr.write_type_a(get(i));
         }
      }

      /**
       * Returns the number of active elements in this list
       */
      @Override
      public int size()
      {
         return pos + 1;
      }

      public void set(Object<T> other)
      {
         if(isEnum)
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
   }

   public void resetQuick();

   public void readElement(int i, CDR cdr);

   public void writeElement(int i, CDR cdr);

   public int size();

}
