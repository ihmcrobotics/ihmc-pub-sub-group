package us.ihmc.rtps.common;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/**
 * Structure GUID_t, entity identifier, unique in DDS-RTPS Domain.
 * 
 * @author Jesper Smith
 *
 */
public class Guid
{
   public class GuidPrefix
   {
      public static final int size = 12;
      
      private byte[] value = new byte[size];
      
      public byte[] getValue()
      {
         return value;
      }

      public void setValue(byte[] value)
      {
         this.value = value;
      }

      private GuidPrefix() {}
      
      @Override
      public String toString()
      {
         StringBuilder sb = new StringBuilder(size * 2);
         for(byte b: value)
            sb.append(String.format("%02x", b));
         return sb.toString();
      }

      @Override
      public int hashCode()
      {
         final int prime = 31;
         int result = 1;
         result = prime * result + getOuterType().hashCode();
         result = prime * result + Arrays.hashCode(value);
         return result;
      }

      @Override
      public boolean equals(Object obj)
      {
         if (this == obj)
            return true;
         if (obj == null)
            return false;
         if (getClass() != obj.getClass())
            return false;
         GuidPrefix other = (GuidPrefix) obj;
         if (!getOuterType().equals(other.getOuterType()))
            return false;
         if (!Arrays.equals(value, other.value))
            return false;
         return true;
      }

      private Guid getOuterType()
      {
         return Guid.this;
      }
      
      
   }
   
   public class Entity
   {
      public static final int size = 4;
      
      private byte[] value = new byte[size];
      
      public byte[] getValue()
      {
         return value;
      }

      public void setValue(byte[] value)
      {
         this.value = value;
      }

      private Entity() {};
      
      @Override
      public String toString()
      {
         StringBuilder sb = new StringBuilder(size * 2);
         for(byte b: value)
            sb.append(String.format("%02x", b));
         return sb.toString();
      }
   }
   
   private final GuidPrefix guidPrefix = new GuidPrefix();
   private final Entity entity = new Entity();
   
   private final ByteBuffer conversionBuffer = ByteBuffer.allocate(16);
   
   public Guid()
   {
      conversionBuffer.order(ByteOrder.nativeOrder());
   }
   
   public GuidPrefix getGuidPrefix()
   {
      return guidPrefix;
   }


   public Entity getEntity()
   {
      return entity;
   }

   public void fromPrimitives(long high, long low)
   {
      conversionBuffer.clear();
      conversionBuffer.putLong(high);
      conversionBuffer.putLong(low);
      conversionBuffer.flip();
      conversionBuffer.get(guidPrefix.value, 0, Guid.GuidPrefix.size);
      conversionBuffer.get(entity.value, 0, Guid.Entity.size);
   }
   
   @Override
   public String toString()
   {
      StringBuilder sb = new StringBuilder();
      sb.append("GUID Prefix: ");
      sb.append(guidPrefix.toString());
      sb.append(" Entity ID: ");
      sb.append(entity.toString());
      return sb.toString();
   }
}
