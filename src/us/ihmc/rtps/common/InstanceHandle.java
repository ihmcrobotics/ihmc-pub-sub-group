package us.ihmc.rtps.common;

/**
 * Struct InstanceHandle_t, used to contain the key for WITH_KEY topics. 
 * 
 * @author Jesper Smith
 *
 */
public class InstanceHandle
{
   private byte value[] = new byte[16];

   public boolean isDefined()
   {
      for(int i = 0; i < 16; i++)
      {
            if(value[i] != 0)
            {
               return true;
            }
      }
      return false;
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
