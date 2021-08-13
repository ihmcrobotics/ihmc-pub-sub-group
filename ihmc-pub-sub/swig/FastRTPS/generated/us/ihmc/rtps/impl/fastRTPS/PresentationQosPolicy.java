/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.rtps.impl.fastRTPS;

public class PresentationQosPolicy extends QosPolicy {
  private transient long swigCPtr;

  protected PresentationQosPolicy(long cPtr, boolean cMemoryOwn) {
    super(FastRTPSJNI.PresentationQosPolicy_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(PresentationQosPolicy obj) {
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
        FastRTPSJNI.delete_PresentationQosPolicy(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public PresentationQosPolicy() {
    this(FastRTPSJNI.new_PresentationQosPolicy(), true);
  }

  public void clear() {
    FastRTPSJNI.PresentationQosPolicy_clear(swigCPtr, this);
  }

  public void setAccess_scope(PresentationQosPolicyAccessScopeKind value) {
    FastRTPSJNI.PresentationQosPolicy_access_scope_set(swigCPtr, this, value.swigValue());
  }

  public PresentationQosPolicyAccessScopeKind getAccess_scope() {
    return PresentationQosPolicyAccessScopeKind.swigToEnum(FastRTPSJNI.PresentationQosPolicy_access_scope_get(swigCPtr, this));
  }

  public void setCoherent_access(boolean value) {
    FastRTPSJNI.PresentationQosPolicy_coherent_access_set(swigCPtr, this, value);
  }

  public boolean getCoherent_access() {
    return FastRTPSJNI.PresentationQosPolicy_coherent_access_get(swigCPtr, this);
  }

  public void setOrdered_access(boolean value) {
    FastRTPSJNI.PresentationQosPolicy_ordered_access_set(swigCPtr, this, value);
  }

  public boolean getOrdered_access() {
    return FastRTPSJNI.PresentationQosPolicy_ordered_access_get(swigCPtr, this);
  }

}
