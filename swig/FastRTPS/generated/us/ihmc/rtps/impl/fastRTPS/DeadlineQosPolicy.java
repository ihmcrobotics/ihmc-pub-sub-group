/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.8
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.rtps.impl.fastRTPS;

public class DeadlineQosPolicy extends QosPolicy {
  private transient long swigCPtr;

  protected DeadlineQosPolicy(long cPtr, boolean cMemoryOwn) {
    super(FastRTPSJNI.DeadlineQosPolicy_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(DeadlineQosPolicy obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        FastRTPSJNI.delete_DeadlineQosPolicy(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public DeadlineQosPolicy() {
    this(FastRTPSJNI.new_DeadlineQosPolicy(), true);
  }

  public void setPeriod(Time_t value) {
    FastRTPSJNI.DeadlineQosPolicy_period_set(swigCPtr, this, Time_t.getCPtr(value), value);
  }

  public Time_t getPeriod() {
    long cPtr = FastRTPSJNI.DeadlineQosPolicy_period_get(swigCPtr, this);
    return (cPtr == 0) ? null : new Time_t(cPtr, false);
  }

  public boolean addToCDRMessage(SWIGTYPE_p_CDRMessage_t msg) {
    return FastRTPSJNI.DeadlineQosPolicy_addToCDRMessage(swigCPtr, this, SWIGTYPE_p_CDRMessage_t.getCPtr(msg));
  }

}
