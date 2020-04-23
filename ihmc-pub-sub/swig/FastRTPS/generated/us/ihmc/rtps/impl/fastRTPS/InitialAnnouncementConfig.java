/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.rtps.impl.fastRTPS;

public class InitialAnnouncementConfig {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected InitialAnnouncementConfig(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(InitialAnnouncementConfig obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        FastRTPSJNI.delete_InitialAnnouncementConfig(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setCount(long value) {
    FastRTPSJNI.InitialAnnouncementConfig_count_set(swigCPtr, this, value);
  }

  public long getCount() {
    return FastRTPSJNI.InitialAnnouncementConfig_count_get(swigCPtr, this);
  }

  public void setPeriod(Time_t value) {
    FastRTPSJNI.InitialAnnouncementConfig_period_set(swigCPtr, this, Time_t.getCPtr(value), value);
  }

  public Time_t getPeriod() {
    long cPtr = FastRTPSJNI.InitialAnnouncementConfig_period_get(swigCPtr, this);
    return (cPtr == 0) ? null : new Time_t(cPtr, false);
  }

  public InitialAnnouncementConfig() {
    this(FastRTPSJNI.new_InitialAnnouncementConfig(), true);
  }

}