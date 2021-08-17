/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.rtps.impl.fastRTPS;

public class RTPSEndpointQos {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected RTPSEndpointQos(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(RTPSEndpointQos obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        FastRTPSJNI.delete_RTPSEndpointQos(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public RTPSEndpointQos() {
    this(FastRTPSJNI.new_RTPSEndpointQos(), true);
  }

  public void setUnicast_locator_list(LocatorList value) {
    FastRTPSJNI.RTPSEndpointQos_unicast_locator_list_set(swigCPtr, this, LocatorList.getCPtr(value), value);
  }

  public LocatorList getUnicast_locator_list() {
    long cPtr = FastRTPSJNI.RTPSEndpointQos_unicast_locator_list_get(swigCPtr, this);
    return (cPtr == 0) ? null : new LocatorList(cPtr, false);
  }

  public void setMulticast_locator_list(LocatorList value) {
    FastRTPSJNI.RTPSEndpointQos_multicast_locator_list_set(swigCPtr, this, LocatorList.getCPtr(value), value);
  }

  public LocatorList getMulticast_locator_list() {
    long cPtr = FastRTPSJNI.RTPSEndpointQos_multicast_locator_list_get(swigCPtr, this);
    return (cPtr == 0) ? null : new LocatorList(cPtr, false);
  }

  public void setRemote_locator_list(LocatorList value) {
    FastRTPSJNI.RTPSEndpointQos_remote_locator_list_set(swigCPtr, this, LocatorList.getCPtr(value), value);
  }

  public LocatorList getRemote_locator_list() {
    long cPtr = FastRTPSJNI.RTPSEndpointQos_remote_locator_list_get(swigCPtr, this);
    return (cPtr == 0) ? null : new LocatorList(cPtr, false);
  }

  public void setUser_defined_id(short value) {
    FastRTPSJNI.RTPSEndpointQos_user_defined_id_set(swigCPtr, this, value);
  }

  public short getUser_defined_id() {
    return FastRTPSJNI.RTPSEndpointQos_user_defined_id_get(swigCPtr, this);
  }

  public void setEntity_id(short value) {
    FastRTPSJNI.RTPSEndpointQos_entity_id_set(swigCPtr, this, value);
  }

  public short getEntity_id() {
    return FastRTPSJNI.RTPSEndpointQos_entity_id_get(swigCPtr, this);
  }

  public void setHistory_memory_policy(MemoryManagementPolicy_t value) {
    FastRTPSJNI.RTPSEndpointQos_history_memory_policy_set(swigCPtr, this, value.swigValue());
  }

  public MemoryManagementPolicy_t getHistory_memory_policy() {
    return MemoryManagementPolicy_t.swigToEnum(FastRTPSJNI.RTPSEndpointQos_history_memory_policy_get(swigCPtr, this));
  }

}
