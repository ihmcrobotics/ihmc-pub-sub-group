/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.rtps.impl.fastRTPS;

public class PartitionQosPolicy extends QosPolicy {
  private transient long swigCPtr;

  protected PartitionQosPolicy(long cPtr, boolean cMemoryOwn) {
    super(FastRTPSJNI.PartitionQosPolicy_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(PartitionQosPolicy obj) {
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
        FastRTPSJNI.delete_PartitionQosPolicy(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public PartitionQosPolicy() {
    this(FastRTPSJNI.new_PartitionQosPolicy(), true);
  }

  public boolean addToCDRMessage(SWIGTYPE_p_eprosima__fastrtps__rtps__CDRMessage_t msg) {
    return FastRTPSJNI.PartitionQosPolicy_addToCDRMessage(swigCPtr, this, SWIGTYPE_p_eprosima__fastrtps__rtps__CDRMessage_t.getCPtr(msg));
  }

  public void push_back(String name) {
    FastRTPSJNI.PartitionQosPolicy_push_back(swigCPtr, this, name);
  }

  public void clear() {
    FastRTPSJNI.PartitionQosPolicy_clear(swigCPtr, this);
  }

  public stringVector getNames() {
    return new stringVector(FastRTPSJNI.PartitionQosPolicy_getNames(swigCPtr, this), true);
  }

  public void setNames(stringVector nam) {
    FastRTPSJNI.PartitionQosPolicy_setNames(swigCPtr, this, stringVector.getCPtr(nam), nam);
  }

}
