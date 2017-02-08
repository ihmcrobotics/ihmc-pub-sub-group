/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.8
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.rtps.impl.fastRTPS;

public class ReliabilityQosPolicy extends QosPolicy {
  private transient long swigCPtr;

  protected ReliabilityQosPolicy(long cPtr, boolean cMemoryOwn) {
    super(FastRTPSJNI.ReliabilityQosPolicy_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(ReliabilityQosPolicy obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        FastRTPSJNI.delete_ReliabilityQosPolicy(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public ReliabilityQosPolicy() {
    this(FastRTPSJNI.new_ReliabilityQosPolicy(), true);
  }

  public void setKind(ReliabilityQosPolicyKind value) {
    FastRTPSJNI.ReliabilityQosPolicy_kind_set(swigCPtr, this, value.swigValue());
  }

  public ReliabilityQosPolicyKind getKind() {
    return ReliabilityQosPolicyKind.swigToEnum(FastRTPSJNI.ReliabilityQosPolicy_kind_get(swigCPtr, this));
  }

  public void setMax_blocking_time(Time_t value) {
    FastRTPSJNI.ReliabilityQosPolicy_max_blocking_time_set(swigCPtr, this, Time_t.getCPtr(value), value);
  }

  public Time_t getMax_blocking_time() {
    long cPtr = FastRTPSJNI.ReliabilityQosPolicy_max_blocking_time_get(swigCPtr, this);
    return (cPtr == 0) ? null : new Time_t(cPtr, false);
  }

  public boolean addToCDRMessage(SWIGTYPE_p_CDRMessage_t msg) {
    return FastRTPSJNI.ReliabilityQosPolicy_addToCDRMessage(swigCPtr, this, SWIGTYPE_p_CDRMessage_t.getCPtr(msg));
  }

}