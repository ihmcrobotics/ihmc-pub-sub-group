package us.ihmc.idl;

import java.nio.ByteBuffer;

import us.ihmc.rtps.common.SerializedPayload;

public class CDR
{
   private ByteBuffer payloadBuffer;
   private int alignment = 0;
   
   public static int alignment(int current_alignment, int size)
   {
      return size;
   }
   
   
   public void init(SerializedPayload payload)
   {
      payloadBuffer = payload.getData();
      alignment = 0;
   }
}
