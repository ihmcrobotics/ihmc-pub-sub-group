/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.8
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.rtps.impl.fastRTPS;

public class PublisherAttributes {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected PublisherAttributes(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(PublisherAttributes obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        FastRTPSJNI.delete_PublisherAttributes(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public PublisherAttributes() {
    this(FastRTPSJNI.new_PublisherAttributes(), true);
  }

  public void setTopic(TopicAttributes value) {
    FastRTPSJNI.PublisherAttributes_topic_set(swigCPtr, this, TopicAttributes.getCPtr(value), value);
  }

  public TopicAttributes getTopic() {
    long cPtr = FastRTPSJNI.PublisherAttributes_topic_get(swigCPtr, this);
    return (cPtr == 0) ? null : new TopicAttributes(cPtr, false);
  }

  public void setQos(WriterQos value) {
    FastRTPSJNI.PublisherAttributes_qos_set(swigCPtr, this, WriterQos.getCPtr(value), value);
  }

  public WriterQos getQos() {
    long cPtr = FastRTPSJNI.PublisherAttributes_qos_get(swigCPtr, this);
    return (cPtr == 0) ? null : new WriterQos(cPtr, false);
  }

  public void setTimes(WriterTimes value) {
    FastRTPSJNI.PublisherAttributes_times_set(swigCPtr, this, WriterTimes.getCPtr(value), value);
  }

  public WriterTimes getTimes() {
    long cPtr = FastRTPSJNI.PublisherAttributes_times_get(swigCPtr, this);
    return (cPtr == 0) ? null : new WriterTimes(cPtr, false);
  }

  public void setUnicastLocatorList(LocatorList_t value) {
    FastRTPSJNI.PublisherAttributes_unicastLocatorList_set(swigCPtr, this, LocatorList_t.getCPtr(value), value);
  }

  public LocatorList_t getUnicastLocatorList() {
    long cPtr = FastRTPSJNI.PublisherAttributes_unicastLocatorList_get(swigCPtr, this);
    return (cPtr == 0) ? null : new LocatorList_t(cPtr, false);
  }

  public void setMulticastLocatorList(LocatorList_t value) {
    FastRTPSJNI.PublisherAttributes_multicastLocatorList_set(swigCPtr, this, LocatorList_t.getCPtr(value), value);
  }

  public LocatorList_t getMulticastLocatorList() {
    long cPtr = FastRTPSJNI.PublisherAttributes_multicastLocatorList_get(swigCPtr, this);
    return (cPtr == 0) ? null : new LocatorList_t(cPtr, false);
  }

  public void setOutLocatorList(LocatorList_t value) {
    FastRTPSJNI.PublisherAttributes_outLocatorList_set(swigCPtr, this, LocatorList_t.getCPtr(value), value);
  }

  public LocatorList_t getOutLocatorList() {
    long cPtr = FastRTPSJNI.PublisherAttributes_outLocatorList_get(swigCPtr, this);
    return (cPtr == 0) ? null : new LocatorList_t(cPtr, false);
  }

  public void setThroughputController(ThroughputControllerDescriptor value) {
    FastRTPSJNI.PublisherAttributes_throughputController_set(swigCPtr, this, ThroughputControllerDescriptor.getCPtr(value), value);
  }

  public ThroughputControllerDescriptor getThroughputController() {
    long cPtr = FastRTPSJNI.PublisherAttributes_throughputController_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ThroughputControllerDescriptor(cPtr, false);
  }

  public void setHistoryMemoryPolicy(MemoryManagementPolicy_t value) {
    FastRTPSJNI.PublisherAttributes_historyMemoryPolicy_set(swigCPtr, this, value.swigValue());
  }

  public MemoryManagementPolicy_t getHistoryMemoryPolicy() {
    return MemoryManagementPolicy_t.swigToEnum(FastRTPSJNI.PublisherAttributes_historyMemoryPolicy_get(swigCPtr, this));
  }

  public short getUserDefinedID() {
    return FastRTPSJNI.PublisherAttributes_getUserDefinedID(swigCPtr, this);
  }

  public short getEntityID() {
    return FastRTPSJNI.PublisherAttributes_getEntityID(swigCPtr, this);
  }

  public void setUserDefinedID(short id) {
    FastRTPSJNI.PublisherAttributes_setUserDefinedID(swigCPtr, this, id);
  }

  public void setEntityID(short id) {
    FastRTPSJNI.PublisherAttributes_setEntityID(swigCPtr, this, id);
  }

}
