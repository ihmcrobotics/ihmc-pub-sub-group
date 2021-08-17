/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.rtps.impl.fastRTPS;

public class DurabilityQosPolicy extends QosPolicy {
  private transient long swigCPtr;

  protected DurabilityQosPolicy(long cPtr, boolean cMemoryOwn) {
    super(FastRTPSJNI.DurabilityQosPolicy_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(DurabilityQosPolicy obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        FastRTPSJNI.delete_DurabilityQosPolicy(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public DurabilityQosPolicy() {
    this(FastRTPSJNI.new_DurabilityQosPolicy(), true);
  }

  public DurabilityKind_t durabilityKind() {
    return DurabilityKind_t.swigToEnum(FastRTPSJNI.DurabilityQosPolicy_durabilityKind__SWIG_0(swigCPtr, this));
  }

  public void durabilityKind(DurabilityKind_t new_kind) {
    FastRTPSJNI.DurabilityQosPolicy_durabilityKind__SWIG_1(swigCPtr, this, new_kind.swigValue());
  }

  public void clear() {
    FastRTPSJNI.DurabilityQosPolicy_clear(swigCPtr, this);
  }

  public void setKind(DurabilityQosPolicyKind_t value) {
    FastRTPSJNI.DurabilityQosPolicy_kind_set(swigCPtr, this, value.swigValue());
  }

  public DurabilityQosPolicyKind_t getKind() {
    return DurabilityQosPolicyKind_t.swigToEnum(FastRTPSJNI.DurabilityQosPolicy_kind_get(swigCPtr, this));
  }

}
