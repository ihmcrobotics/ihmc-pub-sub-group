/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.8
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.rtps.impl.fastRTPS;

public class FastRTPS implements FastRTPSConstants {
  public static java.nio.ByteBuffer new_octetArray(int nelements) {  
  return FastRTPSJNI.new_octetArray(nelements);  
}

  public static void delete_octetArray(java.nio.ByteBuffer ary) {
  assert ary.isDirect() : "Buffer must be allocated direct.";
    {
      FastRTPSJNI.delete_octetArray(ary);
    }
  }

  public static short octetArray_getitem(java.nio.ByteBuffer ary, int index) {
  assert ary.isDirect() : "Buffer must be allocated direct.";
    {
      return FastRTPSJNI.octetArray_getitem(ary, index);
    }
  }

  public static void octetArray_setitem(java.nio.ByteBuffer ary, int index, short value) {
  assert ary.isDirect() : "Buffer must be allocated direct.";
    {
      FastRTPSJNI.octetArray_setitem(ary, index, value);
    }
  }

  public static boolean IsAddressDefined(Locator_t loc) {
    return FastRTPSJNI.IsAddressDefined(Locator_t.getCPtr(loc), loc);
  }

  public static boolean IsLocatorValid(Locator_t loc) {
    return FastRTPSJNI.IsLocatorValid(Locator_t.getCPtr(loc), loc);
  }

}