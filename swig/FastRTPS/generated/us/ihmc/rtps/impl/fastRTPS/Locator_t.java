/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.8
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.rtps.impl.fastRTPS;

public class Locator_t {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected Locator_t(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Locator_t obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        FastRTPSJNI.delete_Locator_t(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setKind(int value) {
    FastRTPSJNI.Locator_t_kind_set(swigCPtr, this, value);
  }

  public int getKind() {
    return FastRTPSJNI.Locator_t_kind_get(swigCPtr, this);
  }

  public void setPort(long value) {
    FastRTPSJNI.Locator_t_port_set(swigCPtr, this, value);
  }

  public long getPort() {
    return FastRTPSJNI.Locator_t_port_get(swigCPtr, this);
  }

  public void setAddress(SWIGTYPE_p_unsigned_char value) {
    FastRTPSJNI.Locator_t_address_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value));
  }

  public SWIGTYPE_p_unsigned_char getAddress() {
    long cPtr = FastRTPSJNI.Locator_t_address_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_unsigned_char(cPtr, false);
  }

  public Locator_t() {
    this(FastRTPSJNI.new_Locator_t__SWIG_0(), true);
  }

  public Locator_t(Locator_t loc) {
    this(FastRTPSJNI.new_Locator_t__SWIG_1(Locator_t.getCPtr(loc), loc), true);
  }

  public Locator_t(long portin) {
    this(FastRTPSJNI.new_Locator_t__SWIG_2(portin), true);
  }

  public boolean set_IP4_address(short o1, short o2, short o3, short o4) {
    return FastRTPSJNI.Locator_t_set_IP4_address__SWIG_0(swigCPtr, this, o1, o2, o3, o4);
  }

  public boolean set_IP4_address(String in_address) {
    return FastRTPSJNI.Locator_t_set_IP4_address__SWIG_1(swigCPtr, this, in_address);
  }

  public String to_IP4_string() {
    return FastRTPSJNI.Locator_t_to_IP4_string(swigCPtr, this);
  }

  public long to_IP4_long() {
    return FastRTPSJNI.Locator_t_to_IP4_long(swigCPtr, this);
  }

  public boolean set_IP6_address(int group0, int group1, int group2, int group3, int group4, int group5, int group6, int group7) {
    return FastRTPSJNI.Locator_t_set_IP6_address(swigCPtr, this, group0, group1, group2, group3, group4, group5, group6, group7);
  }

  public String to_IP6_string() {
    return FastRTPSJNI.Locator_t_to_IP6_string(swigCPtr, this);
  }

}
