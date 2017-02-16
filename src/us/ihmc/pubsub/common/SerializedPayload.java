package us.ihmc.pubsub.common;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Structure to hold serialized data
 * 
 * @author Jesper Smith
 *
 */
public class SerializedPayload
{
   public static final short CDR_BE = 0x0000;
   public static final short CDR_LE = 0x0001;
   public static final short PL_CDR_BE = 0x0002;
   public static final short PL_CDR_LE = 0x0003;

   private short encapsulation;
   private int length;
   private final ByteBuffer data;
   private int max_size;
   private int pos;

   /**
    * Constructor 
    * 
    * @param maxSize maximum size of the serialized data
    */
   public SerializedPayload(int maxSize)
   {
      this.data = ByteBuffer.allocateDirect(maxSize);
      setEncapsulation(CDR_LE);
   }

   /**
    * 
    * @return Encapsulation of the data as suggested in the RTPS 2.1 specification chapter 10.
    */
   public short getEncapsulation()
   {
      return encapsulation;
   }

   /**
    * Set encapsulation of the data as suggested in the RTPS 2.1 specification chapter 10. The byte order of the underlying buffer is adjusted accordingly.
    * @param encapsulation
    */
   public void setEncapsulation(short encapsulation)
   {
      this.encapsulation = encapsulation;
      if(encapsulation == CDR_BE || encapsulation == PL_CDR_BE)
      {
         data.order(ByteOrder.BIG_ENDIAN);
      }
      else
      {
         data.order(ByteOrder.LITTLE_ENDIAN);
      }
   }

   /**
    * 
    * @return Actual length of the data.
    */
   public int getLength()
   {
      return length;
   }

   public void setLength(int length)
   {
      this.length = length;
   }

   /**
    * @return Maximum size of the payload
    */
   public int getMax_size()
   {
      return max_size;
   }

   public void setMax_size(int max_size)
   {
      this.max_size = max_size;
   }

   /**
    * 
    * @return Position when reading.
    */
   public int getPos()
   {
      return pos;
   }

   public void setPos(int pos)
   {
      this.pos = pos;
   }

   public ByteBuffer getData()
   {
      return data;
   }

}
