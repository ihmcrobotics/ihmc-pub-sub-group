/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
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

  public void setDiscovery_config(DiscoverySettings value) {
    FastRTPSJNI.BuiltinAttributes_discovery_config_set(swigCPtr, this, DiscoverySettings.getCPtr(value), value);
  }

  public DiscoverySettings getDiscovery_config() {
    long cPtr = FastRTPSJNI.BuiltinAttributes_discovery_config_get(swigCPtr, this);
    return (cPtr == 0) ? null : new DiscoverySettings(cPtr, false);
  }

  public void setUse_WriterLivelinessProtocol(boolean value) {
    FastRTPSJNI.BuiltinAttributes_use_WriterLivelinessProtocol_set(swigCPtr, this, value);
  }

  public boolean getUse_WriterLivelinessProtocol() {
    return FastRTPSJNI.BuiltinAttributes_use_WriterLivelinessProtocol_get(swigCPtr, this);
  }

  public void setTypelookup_config(TypeLookupSettings value) {
    FastRTPSJNI.BuiltinAttributes_typelookup_config_set(swigCPtr, this, TypeLookupSettings.getCPtr(value), value);
  }

  public TypeLookupSettings getTypelookup_config() {
    long cPtr = FastRTPSJNI.BuiltinAttributes_typelookup_config_get(swigCPtr, this);
    return (cPtr == 0) ? null : new TypeLookupSettings(cPtr, false);
  }

  public void setMetatrafficUnicastLocatorList(LocatorList value) {
    FastRTPSJNI.BuiltinAttributes_metatrafficUnicastLocatorList_set(swigCPtr, this, LocatorList.getCPtr(value), value);
  }

  public LocatorList getMetatrafficUnicastLocatorList() {
    long cPtr = FastRTPSJNI.BuiltinAttributes_metatrafficUnicastLocatorList_get(swigCPtr, this);
    return (cPtr == 0) ? null : new LocatorList(cPtr, false);
  }

  public void setMetatrafficMulticastLocatorList(LocatorList value) {
    FastRTPSJNI.BuiltinAttributes_metatrafficMulticastLocatorList_set(swigCPtr, this, LocatorList.getCPtr(value), value);
  }

  public LocatorList getMetatrafficMulticastLocatorList() {
    long cPtr = FastRTPSJNI.BuiltinAttributes_metatrafficMulticastLocatorList_get(swigCPtr, this);
    return (cPtr == 0) ? null : new LocatorList(cPtr, false);
  }

  public void setInitialPeersList(LocatorList value) {
    FastRTPSJNI.BuiltinAttributes_initialPeersList_set(swigCPtr, this, LocatorList.getCPtr(value), value);
  }

  public LocatorList getInitialPeersList() {
    long cPtr = FastRTPSJNI.BuiltinAttributes_initialPeersList_get(swigCPtr, this);
    return (cPtr == 0) ? null : new LocatorList(cPtr, false);
  }

  public void setReaderHistoryMemoryPolicy(MemoryManagementPolicy_t value) {
    FastRTPSJNI.BuiltinAttributes_readerHistoryMemoryPolicy_set(swigCPtr, this, value.swigValue());
  }

  public MemoryManagementPolicy_t getReaderHistoryMemoryPolicy() {
    return MemoryManagementPolicy_t.swigToEnum(FastRTPSJNI.BuiltinAttributes_readerHistoryMemoryPolicy_get(swigCPtr, this));
  }

  public void setReaderPayloadSize(long value) {
    FastRTPSJNI.BuiltinAttributes_readerPayloadSize_set(swigCPtr, this, value);
  }

  public long getReaderPayloadSize() {
    return FastRTPSJNI.BuiltinAttributes_readerPayloadSize_get(swigCPtr, this);
  }

  public void setWriterHistoryMemoryPolicy(MemoryManagementPolicy_t value) {
    FastRTPSJNI.BuiltinAttributes_writerHistoryMemoryPolicy_set(swigCPtr, this, value.swigValue());
  }

  public MemoryManagementPolicy_t getWriterHistoryMemoryPolicy() {
    return MemoryManagementPolicy_t.swigToEnum(FastRTPSJNI.BuiltinAttributes_writerHistoryMemoryPolicy_get(swigCPtr, this));
  }

  public void setWriterPayloadSize(long value) {
    FastRTPSJNI.BuiltinAttributes_writerPayloadSize_set(swigCPtr, this, value);
  }

  public long getWriterPayloadSize() {
    return FastRTPSJNI.BuiltinAttributes_writerPayloadSize_get(swigCPtr, this);
  }

  public void setMutation_tries(long value) {
    FastRTPSJNI.BuiltinAttributes_mutation_tries_set(swigCPtr, this, value);
  }

  public long getMutation_tries() {
    return FastRTPSJNI.BuiltinAttributes_mutation_tries_get(swigCPtr, this);
  }

  public void setAvoid_builtin_multicast(boolean value) {
    FastRTPSJNI.BuiltinAttributes_avoid_builtin_multicast_set(swigCPtr, this, value);
  }

  public boolean getAvoid_builtin_multicast() {
    return FastRTPSJNI.BuiltinAttributes_avoid_builtin_multicast_get(swigCPtr, this);
  }

  public BuiltinAttributes() {
    this(FastRTPSJNI.new_BuiltinAttributes(), true);
  }

}
