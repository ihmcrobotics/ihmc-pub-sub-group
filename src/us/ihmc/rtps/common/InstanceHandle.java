package us.ihmc.rtps.common;

/**
 * Struct InstanceHandle_t, used to contain the key for WITH_KEY topics. 
 * 
 * @author Jesper Smith
 *
 */
public class InstanceHandle
{
   private boolean isDefined;
   private byte value[] = new byte[16];

   public boolean isDefined()
   {
      return isDefined;
   }

   public void setDefined(boolean isDefined)
   {
      this.isDefined = isDefined;
   }

   public byte[] getValue()
   {
      return value;
   }

   public void setValue(byte[] value)
   {
      this.value = value;
   }

}
