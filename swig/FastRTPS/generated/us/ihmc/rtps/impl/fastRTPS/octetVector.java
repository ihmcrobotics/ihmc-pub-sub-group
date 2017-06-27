/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.rtps.impl.fastRTPS;

public class octetVector {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected octetVector(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(octetVector obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        FastRTPSJNI.delete_octetVector(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public octetVector() {
    this(FastRTPSJNI.new_octetVector__SWIG_0(), true);
  }

  public octetVector(long n) {
    this(FastRTPSJNI.new_octetVector__SWIG_1(n), true);
  }

  public long size() {
    return FastRTPSJNI.octetVector_size(swigCPtr, this);
  }

  public long capacity() {
    return FastRTPSJNI.octetVector_capacity(swigCPtr, this);
  }

  public void reserve(long n) {
    FastRTPSJNI.octetVector_reserve(swigCPtr, this, n);
  }

  public boolean isEmpty() {
    return FastRTPSJNI.octetVector_isEmpty(swigCPtr, this);
  }

  public void clear() {
    FastRTPSJNI.octetVector_clear(swigCPtr, this);
  }

  public void add(short x) {
    FastRTPSJNI.octetVector_add(swigCPtr, this, x);
  }

  public short get(int i) {
    return FastRTPSJNI.octetVector_get(swigCPtr, this, i);
  }

  public void set(int i, short val) {
    FastRTPSJNI.octetVector_set(swigCPtr, this, i, val);
  }

}
