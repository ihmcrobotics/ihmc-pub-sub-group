/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.rtps.impl.fastRTPS;

public class RTPSParticipantAttributes {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected RTPSParticipantAttributes(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(RTPSParticipantAttributes obj) {
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
        FastRTPSJNI.delete_RTPSParticipantAttributes(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public RTPSParticipantAttributes() {
    this(FastRTPSJNI.new_RTPSParticipantAttributes(), true);
  }

  public void setDefaultUnicastLocatorList(LocatorList value) {
    FastRTPSJNI.RTPSParticipantAttributes_defaultUnicastLocatorList_set(swigCPtr, this, LocatorList.getCPtr(value), value);
  }

  public LocatorList getDefaultUnicastLocatorList() {
    long cPtr = FastRTPSJNI.RTPSParticipantAttributes_defaultUnicastLocatorList_get(swigCPtr, this);
    return (cPtr == 0) ? null : new LocatorList(cPtr, false);
  }

  public void setDefaultMulticastLocatorList(LocatorList value) {
    FastRTPSJNI.RTPSParticipantAttributes_defaultMulticastLocatorList_set(swigCPtr, this, LocatorList.getCPtr(value), value);
  }

  public LocatorList getDefaultMulticastLocatorList() {
    long cPtr = FastRTPSJNI.RTPSParticipantAttributes_defaultMulticastLocatorList_get(swigCPtr, this);
    return (cPtr == 0) ? null : new LocatorList(cPtr, false);
  }

  public void setSendSocketBufferSize(long value) {
    FastRTPSJNI.RTPSParticipantAttributes_sendSocketBufferSize_set(swigCPtr, this, value);
  }

  public long getSendSocketBufferSize() {
    return FastRTPSJNI.RTPSParticipantAttributes_sendSocketBufferSize_get(swigCPtr, this);
  }

  public void setListenSocketBufferSize(long value) {
    FastRTPSJNI.RTPSParticipantAttributes_listenSocketBufferSize_set(swigCPtr, this, value);
  }

  public long getListenSocketBufferSize() {
    return FastRTPSJNI.RTPSParticipantAttributes_listenSocketBufferSize_get(swigCPtr, this);
  }

  public void setPrefix(SWIGTYPE_p_GuidPrefix_t value) {
    FastRTPSJNI.RTPSParticipantAttributes_prefix_set(swigCPtr, this, SWIGTYPE_p_GuidPrefix_t.getCPtr(value));
  }

  public SWIGTYPE_p_GuidPrefix_t getPrefix() {
    return new SWIGTYPE_p_GuidPrefix_t(FastRTPSJNI.RTPSParticipantAttributes_prefix_get(swigCPtr, this), true);
  }

  public boolean ReadguidPrefix(String pfx) {
    return FastRTPSJNI.RTPSParticipantAttributes_ReadguidPrefix(swigCPtr, this, pfx);
  }

  public void setBuiltin(BuiltinAttributes value) {
    FastRTPSJNI.RTPSParticipantAttributes_builtin_set(swigCPtr, this, BuiltinAttributes.getCPtr(value), value);
  }

  public BuiltinAttributes getBuiltin() {
    long cPtr = FastRTPSJNI.RTPSParticipantAttributes_builtin_get(swigCPtr, this);
    return (cPtr == 0) ? null : new BuiltinAttributes(cPtr, false);
  }

  public void setPort(SWIGTYPE_p_PortParameters value) {
    FastRTPSJNI.RTPSParticipantAttributes_port_set(swigCPtr, this, SWIGTYPE_p_PortParameters.getCPtr(value));
  }

  public SWIGTYPE_p_PortParameters getPort() {
    return new SWIGTYPE_p_PortParameters(FastRTPSJNI.RTPSParticipantAttributes_port_get(swigCPtr, this), true);
  }

  public void setUserData(octetVector value) {
    FastRTPSJNI.RTPSParticipantAttributes_userData_set(swigCPtr, this, octetVector.getCPtr(value), value);
  }

  public octetVector getUserData() {
    long cPtr = FastRTPSJNI.RTPSParticipantAttributes_userData_get(swigCPtr, this);
    return (cPtr == 0) ? null : new octetVector(cPtr, false);
  }

  public void setParticipantID(int value) {
    FastRTPSJNI.RTPSParticipantAttributes_participantID_set(swigCPtr, this, value);
  }

  public int getParticipantID() {
    return FastRTPSJNI.RTPSParticipantAttributes_participantID_get(swigCPtr, this);
  }

  public void setUseBuiltinTransports(boolean value) {
    FastRTPSJNI.RTPSParticipantAttributes_useBuiltinTransports_set(swigCPtr, this, value);
  }

  public boolean getUseBuiltinTransports() {
    return FastRTPSJNI.RTPSParticipantAttributes_useBuiltinTransports_get(swigCPtr, this);
  }

  public void setAllocation(SWIGTYPE_p_RTPSParticipantAllocationAttributes value) {
    FastRTPSJNI.RTPSParticipantAttributes_allocation_set(swigCPtr, this, SWIGTYPE_p_RTPSParticipantAllocationAttributes.getCPtr(value));
  }

  public SWIGTYPE_p_RTPSParticipantAllocationAttributes getAllocation() {
    return new SWIGTYPE_p_RTPSParticipantAllocationAttributes(FastRTPSJNI.RTPSParticipantAttributes_allocation_get(swigCPtr, this), true);
  }

  public void setProperties(SWIGTYPE_p_PropertyPolicy value) {
    FastRTPSJNI.RTPSParticipantAttributes_properties_set(swigCPtr, this, SWIGTYPE_p_PropertyPolicy.getCPtr(value));
  }

  public SWIGTYPE_p_PropertyPolicy getProperties() {
    return new SWIGTYPE_p_PropertyPolicy(FastRTPSJNI.RTPSParticipantAttributes_properties_get(swigCPtr, this), true);
  }

  public void setName(String nam) {
    FastRTPSJNI.RTPSParticipantAttributes_setName(swigCPtr, this, nam);
  }

  public String getName() {
    return FastRTPSJNI.RTPSParticipantAttributes_getName(swigCPtr, this);
  }

}
