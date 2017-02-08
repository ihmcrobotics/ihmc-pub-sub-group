package us.ihmc.rtps.common;

import java.nio.ByteBuffer;

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

   private short encapsulation = CDR_BE;
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
   }

   /**
    * 
    * @return Encapsulation of the data as suggested in the RTPS 2.1 specification chapter 10.
    */
   public short getEncapsulation()
   {
      return encapsulation;
   }

   public void setEncapsulation(short encapsulation)
   {
      this.encapsulation = encapsulation;
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
