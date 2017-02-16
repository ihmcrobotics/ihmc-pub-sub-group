package us.ihmc.idl;

import java.util.ArrayList;

import org.apache.commons.lang3.NotImplementedException;

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

   }

   public static class EnumType<T extends Enum<T>> extends ArrayList<T> implements IDLSequence
   {
      private final Enum<T>[] enumConstants;

      public EnumType(int maxSize, Class<T> clazz)
      {
         super(maxSize);
         this.enumConstants = clazz.getEnumConstants();
      }

      @Override
      public void resetQuick()
      {
         clear();
      }

      @SuppressWarnings("unchecked")
      @Override
      public void readElement(int i, CDR cdr)
      {
         add((T) enumConstants[cdr.read_type_c()]);
      }

      @Override
      public void writeElement(int i, CDR cdr)
      {
         cdr.write_type_c(get(i).ordinal());
      }

   }

   public static class Object<T extends IDLStruct> extends ArrayList<T> implements IDLSequence
   {
      private static final long serialVersionUID = -5474351057888727678L;
      private final TopicDataType<T> topicDataType;
      private final Enum[] constants;
      private final boolean isEnum;

      /**
       * 
       * @param maxSize Maximum size of this sequence
       * @param clazz Class to store
       * @param topicDataType TopicDataType to preallocate data if desired
       */
      public Object(int maxSize, Class<T> clazz, TopicDataType<T> topicDataType)
      {
         super(maxSize);
         this.topicDataType = topicDataType;
         this.isEnum = false;
         this.constants = null;
      }

      public Object(int maxSize, Enum[] constants)
      {
         super(maxSize);
         this.topicDataType = null;
         this.isEnum = true;
         this.constants = constants;
      }

      @Override
      public void resetQuick()
      {
         clear();
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
            T val = topicDataType.createData();
            cdr.read_type_a(val);
            add(val);
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
   }

   public void resetQuick();

   public void readElement(int i, CDR cdr);

   public void writeElement(int i, CDR cdr);

   public int size();

}
