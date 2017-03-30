/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.8
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.rtps.impl.fastRTPS;

public class BuiltinAttributes {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected BuiltinAttributes(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(BuiltinAttributes obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        FastRTPSJNI.delete_BuiltinAttributes(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setUse_SIMPLE_RTPSParticipantDiscoveryProtocol(boolean value) {
    FastRTPSJNI.BuiltinAttributes_use_SIMPLE_RTPSParticipantDiscoveryProtocol_set(swigCPtr, this, value);
  }

  public boolean getUse_SIMPLE_RTPSParticipantDiscoveryProtocol() {
    return FastRTPSJNI.BuiltinAttributes_use_SIMPLE_RTPSParticipantDiscoveryProtocol_get(swigCPtr, this);
  }

  public void setUse_WriterLivelinessProtocol(boolean value) {
    FastRTPSJNI.BuiltinAttributes_use_WriterLivelinessProtocol_set(swigCPtr, this, value);
  }

  public boolean getUse_WriterLivelinessProtocol() {
    return FastRTPSJNI.BuiltinAttributes_use_WriterLivelinessProtocol_get(swigCPtr, this);
  }

  public void setUse_SIMPLE_EndpointDiscoveryProtocol(boolean value) {
    FastRTPSJNI.BuiltinAttributes_use_SIMPLE_EndpointDiscoveryProtocol_set(swigCPtr, this, value);
  }

  public boolean getUse_SIMPLE_EndpointDiscoveryProtocol() {
    return FastRTPSJNI.BuiltinAttributes_use_SIMPLE_EndpointDiscoveryProtocol_get(swigCPtr, this);
  }

  public void setUse_STATIC_EndpointDiscoveryProtocol(boolean value) {
    FastRTPSJNI.BuiltinAttributes_use_STATIC_EndpointDiscoveryProtocol_set(swigCPtr, this, value);
  }

  public boolean getUse_STATIC_EndpointDiscoveryProtocol() {
    return FastRTPSJNI.BuiltinAttributes_use_STATIC_EndpointDiscoveryProtocol_get(swigCPtr, this);
  }

  public void setDomainId(long value) {
    FastRTPSJNI.BuiltinAttributes_domainId_set(swigCPtr, this, value);
  }

  public long getDomainId() {
    return FastRTPSJNI.BuiltinAttributes_domainId_get(swigCPtr, this);
  }

  public void setLeaseDuration(Time_t value) {
    FastRTPSJNI.BuiltinAttributes_leaseDuration_set(swigCPtr, this, Time_t.getCPtr(value), value);
  }

  public Time_t getLeaseDuration() {
    long cPtr = FastRTPSJNI.BuiltinAttributes_leaseDuration_get(swigCPtr, this);
    return (cPtr == 0) ? null : new Time_t(cPtr, false);
  }

  public void setLeaseDuration_announcementperiod(Time_t value) {
    FastRTPSJNI.BuiltinAttributes_leaseDuration_announcementperiod_set(swigCPtr, this, Time_t.getCPtr(value), value);
  }

  public Time_t getLeaseDuration_announcementperiod() {
    long cPtr = FastRTPSJNI.BuiltinAttributes_leaseDuration_announcementperiod_get(swigCPtr, this);
    return (cPtr == 0) ? null : new Time_t(cPtr, false);
  }

  public void setM_simpleEDP(SimpleEDPAttributes value) {
    FastRTPSJNI.BuiltinAttributes_m_simpleEDP_set(swigCPtr, this, SimpleEDPAttributes.getCPtr(value), value);
  }

  public SimpleEDPAttributes getM_simpleEDP() {
    long cPtr = FastRTPSJNI.BuiltinAttributes_m_simpleEDP_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SimpleEDPAttributes(cPtr, false);
  }

  public void setMetatrafficUnicastLocatorList(LocatorList_t value) {
    FastRTPSJNI.BuiltinAttributes_metatrafficUnicastLocatorList_set(swigCPtr, this, LocatorList_t.getCPtr(value), value);
  }

  public LocatorList_t getMetatrafficUnicastLocatorList() {
    long cPtr = FastRTPSJNI.BuiltinAttributes_metatrafficUnicastLocatorList_get(swigCPtr, this);
    return (cPtr == 0) ? null : new LocatorList_t(cPtr, false);
  }

  public void setMetatrafficMulticastLocatorList(LocatorList_t value) {
    FastRTPSJNI.BuiltinAttributes_metatrafficMulticastLocatorList_set(swigCPtr, this, LocatorList_t.getCPtr(value), value);
  }

  public LocatorList_t getMetatrafficMulticastLocatorList() {
    long cPtr = FastRTPSJNI.BuiltinAttributes_metatrafficMulticastLocatorList_get(swigCPtr, this);
    return (cPtr == 0) ? null : new LocatorList_t(cPtr, false);
  }

  public void setInitialPeersList(LocatorList_t value) {
    FastRTPSJNI.BuiltinAttributes_initialPeersList_set(swigCPtr, this, LocatorList_t.getCPtr(value), value);
  }

  public LocatorList_t getInitialPeersList() {
    long cPtr = FastRTPSJNI.BuiltinAttributes_initialPeersList_get(swigCPtr, this);
    return (cPtr == 0) ? null : new LocatorList_t(cPtr, false);
  }

  public BuiltinAttributes() {
    this(FastRTPSJNI.new_BuiltinAttributes(), true);
  }

  public String getStaticEndpointXMLFilename() {
    return FastRTPSJNI.BuiltinAttributes_getStaticEndpointXMLFilename(swigCPtr, this);
  }

  public void setStaticEndpointXMLFilename(String str) {
    FastRTPSJNI.BuiltinAttributes_setStaticEndpointXMLFilename(swigCPtr, this, str);
  }

}
