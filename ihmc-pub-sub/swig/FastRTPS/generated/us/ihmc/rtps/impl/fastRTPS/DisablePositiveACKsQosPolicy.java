/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.rtps.impl.fastRTPS;

public class DisablePositiveACKsQosPolicy extends QosPolicy {
  private transient long swigCPtr;

  protected DisablePositiveACKsQosPolicy(long cPtr, boolean cMemoryOwn) {
    super(FastRTPSJNI.DisablePositiveACKsQosPolicy_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(DisablePositiveACKsQosPolicy obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        FastRTPSJNI.delete_DisablePositiveACKsQosPolicy(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public DisablePositiveACKsQosPolicy() {
    this(FastRTPSJNI.new_DisablePositiveACKsQosPolicy(), true);
  }

  public boolean addToCDRMessage(SWIGTYPE_p_eprosima__fastrtps__rtps__CDRMessage_t msg) {
    return FastRTPSJNI.DisablePositiveACKsQosPolicy_addToCDRMessage(swigCPtr, this, SWIGTYPE_p_eprosima__fastrtps__rtps__CDRMessage_t.getCPtr(msg));
  }

  public void setEnabled(boolean value) {
    FastRTPSJNI.DisablePositiveACKsQosPolicy_enabled_set(swigCPtr, this, value);
  }

  public boolean getEnabled() {
    return FastRTPSJNI.DisablePositiveACKsQosPolicy_enabled_get(swigCPtr, this);
  }

  public void setDuration(Time_t value) {
    FastRTPSJNI.DisablePositiveACKsQosPolicy_duration_set(swigCPtr, this, Time_t.getCPtr(value), value);
  }

  public Time_t getDuration() {
    long cPtr = FastRTPSJNI.DisablePositiveACKsQosPolicy_duration_get(swigCPtr, this);
    return (cPtr == 0) ? null : new Time_t(cPtr, false);
  }

}