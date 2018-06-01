/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.8
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.rtps.impl.fastRTPS;

public class WriterTimes {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected WriterTimes(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(WriterTimes obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        FastRTPSJNI.delete_WriterTimes(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public WriterTimes() {
    this(FastRTPSJNI.new_WriterTimes(), true);
  }

  public void setInitialHeartbeatDelay(Time_t value) {
    FastRTPSJNI.WriterTimes_initialHeartbeatDelay_set(swigCPtr, this, Time_t.getCPtr(value), value);
  }

  public Time_t getInitialHeartbeatDelay() {
    long cPtr = FastRTPSJNI.WriterTimes_initialHeartbeatDelay_get(swigCPtr, this);
    return (cPtr == 0) ? null : new Time_t(cPtr, false);
  }

  public void setHeartbeatPeriod(Time_t value) {
    FastRTPSJNI.WriterTimes_heartbeatPeriod_set(swigCPtr, this, Time_t.getCPtr(value), value);
  }

  public Time_t getHeartbeatPeriod() {
    long cPtr = FastRTPSJNI.WriterTimes_heartbeatPeriod_get(swigCPtr, this);
    return (cPtr == 0) ? null : new Time_t(cPtr, false);
  }

  public void setNackResponseDelay(Time_t value) {
    FastRTPSJNI.WriterTimes_nackResponseDelay_set(swigCPtr, this, Time_t.getCPtr(value), value);
  }

  public Time_t getNackResponseDelay() {
    long cPtr = FastRTPSJNI.WriterTimes_nackResponseDelay_get(swigCPtr, this);
    return (cPtr == 0) ? null : new Time_t(cPtr, false);
  }

  public void setNackSupressionDuration(Time_t value) {
    FastRTPSJNI.WriterTimes_nackSupressionDuration_set(swigCPtr, this, Time_t.getCPtr(value), value);
  }

  public Time_t getNackSupressionDuration() {
    long cPtr = FastRTPSJNI.WriterTimes_nackSupressionDuration_get(swigCPtr, this);
    return (cPtr == 0) ? null : new Time_t(cPtr, false);
  }

}
