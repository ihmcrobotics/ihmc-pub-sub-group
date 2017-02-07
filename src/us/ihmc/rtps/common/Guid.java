package us.ihmc.rtps.common;

import java.nio.ByteBuffer;

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
   
   
   public GuidPrefix getGuidPrefix()
   {
      return guidPrefix;
   }


   public Entity getEntity()
   {
      return entity;
   }


   public void fromByteBuffer(ByteBuffer buffer)
   {
      buffer.get(guidPrefix.value, 0, Guid.GuidPrefix.size);
      buffer.get(entity.value, 0, Guid.Entity.size);
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
