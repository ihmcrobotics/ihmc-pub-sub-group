/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.rtps.impl.fastRTPS;

public class UserDataQosPolicy extends QosPolicy {
  private transient long swigCPtr;

  protected UserDataQosPolicy(long cPtr, boolean cMemoryOwn) {
    super(FastRTPSJNI.UserDataQosPolicy_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(UserDataQosPolicy obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        FastRTPSJNI.delete_UserDataQosPolicy(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public UserDataQosPolicy() {
    this(FastRTPSJNI.new_UserDataQosPolicy(), true);
  }

  public boolean addToCDRMessage(SWIGTYPE_p_eprosima__fastrtps__rtps__CDRMessage_t msg) {
    return FastRTPSJNI.UserDataQosPolicy_addToCDRMessage(swigCPtr, this, SWIGTYPE_p_eprosima__fastrtps__rtps__CDRMessage_t.getCPtr(msg));
  }

  public octetVector getDataVec() {
    return new octetVector(FastRTPSJNI.UserDataQosPolicy_getDataVec(swigCPtr, this), true);
  }

  public void setDataVec(octetVector vec) {
    FastRTPSJNI.UserDataQosPolicy_setDataVec(swigCPtr, this, octetVector.getCPtr(vec), vec);
  }

}
