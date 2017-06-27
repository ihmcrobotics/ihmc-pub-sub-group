/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.rtps.impl.fastRTPS;

public class FastRTPS implements FastRTPSConstants {
  public static SWIGTYPE_p_unsigned_char new_charArray(int nelements) {
    long cPtr = FastRTPSJNI.new_charArray(nelements);
    return (cPtr == 0) ? null : new SWIGTYPE_p_unsigned_char(cPtr, false);
  }

  public static void delete_charArray(SWIGTYPE_p_unsigned_char ary) {
    FastRTPSJNI.delete_charArray(SWIGTYPE_p_unsigned_char.getCPtr(ary));
  }

  public static short charArray_getitem(SWIGTYPE_p_unsigned_char ary, int index) {
    return FastRTPSJNI.charArray_getitem(SWIGTYPE_p_unsigned_char.getCPtr(ary), index);
  }

  public static void charArray_setitem(SWIGTYPE_p_unsigned_char ary, int index, short value) {
    FastRTPSJNI.charArray_setitem(SWIGTYPE_p_unsigned_char.getCPtr(ary), index, value);
  }

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

  public static short getLocatorOctet(int octet, Locator_t locator) {
    return FastRTPSJNI.getLocatorOctet(octet, Locator_t.getCPtr(locator), locator);
  }

  public static void setLocatorOctet(Locator_t locator, int oct, short value) {
    FastRTPSJNI.setLocatorOctet(Locator_t.getCPtr(locator), locator, oct, value);
  }

  public static Locator_t getLocator(LocatorList_t list, int index) {
    long cPtr = FastRTPSJNI.getLocator(LocatorList_t.getCPtr(list), list, index);
    return (cPtr == 0) ? null : new Locator_t(cPtr, false);
  }

}
