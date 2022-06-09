/**
 * Copyright 2017 Florida Institute for Human and Machine Cognition (IHMC)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package us.ihmc.pubsub.common;

import java.io.Serializable;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import com.eprosima.xmlschemas.fastrtps_profiles.DurationType;

import us.ihmc.pubsub.impl.fastRTPS.FastRTPSDomain;

/**
 * Time class.
 * 
 * @author Jesper Smith
 *
 */
public class Time
{
   public static final Time Infinite = new Time(0x7fffffff, 0xffffffff);
   public static final Time Zero = new Time(0, 0);
   public static final Time Invalid = new Time(-1, 0xffffffff);

   private int seconds;
   private long nsec;

   /**
    * 
    * Create new time object
    * 
    * @param seconds
    * @param fraction Fraction of second (1 fraction = 1/(2^32) seconds) 
    */
   public Time(int seconds, long nsec)
   {
      this.seconds = seconds;
      this.nsec = nsec;
   }

   public Time()
   {
      
   }
   
   public void set(long nanoseconds)
   {
      this.seconds = (int) (nanoseconds / 1000000000l);
      this.nsec = (nanoseconds % 1000000000l);
   }
   
   public int getSeconds()
   {
      return seconds;
   }

   public void setSeconds(int seconds)
   {
      this.seconds = seconds;
   }

   public void setNanoseconds(long nsec)
   {
      this.nsec = nsec;
   }
   
   public long getNanoseconds()
   {
      return nsec;
   }
   
   public String toString()
   {
      return String.format("%.2f", seconds + ((double) nsec / 1000000000l));
   }

   public void set(Time sourceTimestamp)
   {
      this.seconds = sourceTimestamp.seconds;
      this.nsec = sourceTimestamp.nsec;
   }
   
   
}
