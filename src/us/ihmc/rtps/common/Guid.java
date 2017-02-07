package us.ihmc.rtps.common;

public class Guid
{
   public class GuidPrefix
   {
      public static final int size = 12;
      
      public byte[] value = new byte[size];
      
      private GuidPrefix() {}
   }
   
   public class Entity
   {
      public static final int size = 4;
      
      public byte[] value = new byte[size];
      
      private Entity() {};
   }
   
   public final GuidPrefix guidPrefix = new GuidPrefix();
   public final Entity entity = new Entity();
}
