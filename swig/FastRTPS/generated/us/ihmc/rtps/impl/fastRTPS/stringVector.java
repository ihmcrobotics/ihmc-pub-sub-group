/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.8
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.rtps.impl.fastRTPS;

public class stringVector {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected stringVector(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(stringVector obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        FastRTPSJNI.delete_stringVector(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public stringVector() {
    this(FastRTPSJNI.new_stringVector__SWIG_0(), true);
  }

  public stringVector(long n) {
    this(FastRTPSJNI.new_stringVector__SWIG_1(n), true);
  }

  public long size() {
    return FastRTPSJNI.stringVector_size(swigCPtr, this);
  }

  public long capacity() {
    return FastRTPSJNI.stringVector_capacity(swigCPtr, this);
  }

  public void reserve(long n) {
    FastRTPSJNI.stringVector_reserve(swigCPtr, this, n);
  }

  public boolean isEmpty() {
    return FastRTPSJNI.stringVector_isEmpty(swigCPtr, this);
  }

  public void clear() {
    FastRTPSJNI.stringVector_clear(swigCPtr, this);
  }

  public void add(String x) {
    FastRTPSJNI.stringVector_add(swigCPtr, this, x);
  }

  public String get(int i) {
    return FastRTPSJNI.stringVector_get(swigCPtr, this, i);
  }

  public void set(int i, String val) {
    FastRTPSJNI.stringVector_set(swigCPtr, this, i, val);
  }

}
