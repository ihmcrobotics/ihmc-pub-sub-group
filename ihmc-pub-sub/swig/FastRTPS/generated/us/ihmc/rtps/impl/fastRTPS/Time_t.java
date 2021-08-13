/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.rtps.impl.fastRTPS;

public class Time_t {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected Time_t(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Time_t obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  @SuppressWarnings("deprecation")
  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        FastRTPSJNI.delete_Time_t(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setSeconds(int value) {
    FastRTPSJNI.Time_t_seconds_set(swigCPtr, this, value);
  }

  public int getSeconds() {
    return FastRTPSJNI.Time_t_seconds_get(swigCPtr, this);
  }

  public void setNanosec(long value) {
    FastRTPSJNI.Time_t_nanosec_set(swigCPtr, this, value);
  }

  public long getNanosec() {
    return FastRTPSJNI.Time_t_nanosec_get(swigCPtr, this);
  }

  public Time_t() {
    this(FastRTPSJNI.new_Time_t__SWIG_0(), true);
  }

  public Time_t(int sec, long nsec) {
    this(FastRTPSJNI.new_Time_t__SWIG_1(sec, nsec), true);
  }

  public void fraction(long frac) {
    FastRTPSJNI.Time_t_fraction(swigCPtr, this, frac);
  }

  public void setFraction(long value) {
    FastRTPSJNI.Time_t_setFraction(swigCPtr, this, value);
  }

}
