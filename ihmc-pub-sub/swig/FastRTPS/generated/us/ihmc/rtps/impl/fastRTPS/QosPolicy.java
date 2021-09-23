/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.rtps.impl.fastRTPS;

public class QosPolicy {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected QosPolicy(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(QosPolicy obj) {
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
        FastRTPSJNI.delete_QosPolicy(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setHasChanged(boolean value) {
    FastRTPSJNI.QosPolicy_hasChanged_set(swigCPtr, this, value);
  }

  public boolean getHasChanged() {
    return FastRTPSJNI.QosPolicy_hasChanged_get(swigCPtr, this);
  }

  public boolean send_always() {
    return FastRTPSJNI.QosPolicy_send_always(swigCPtr, this);
  }

  public void clear() {
    FastRTPSJNI.QosPolicy_clear(swigCPtr, this);
  }

}
