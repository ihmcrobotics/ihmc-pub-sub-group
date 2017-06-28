/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.rtps.impl.fastRTPS;

public class TopicAttributes {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected TopicAttributes(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(TopicAttributes obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        FastRTPSJNI.delete_TopicAttributes(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public TopicAttributes() {
    this(FastRTPSJNI.new_TopicAttributes__SWIG_0(), true);
  }

  public TopicAttributes(String name, String dataType, TopicKind_t tKind) {
    this(FastRTPSJNI.new_TopicAttributes__SWIG_1(name, dataType, tKind.swigValue()), true);
  }

  public TopicAttributes(String name, String dataType) {
    this(FastRTPSJNI.new_TopicAttributes__SWIG_2(name, dataType), true);
  }

  public void setTopicKind(TopicKind_t value) {
    FastRTPSJNI.TopicAttributes_topicKind_set(swigCPtr, this, value.swigValue());
  }

  public TopicKind_t getTopicKind() {
    return TopicKind_t.swigToEnum(FastRTPSJNI.TopicAttributes_topicKind_get(swigCPtr, this));
  }

  public void setTopicName(String value) {
    FastRTPSJNI.TopicAttributes_topicName_set(swigCPtr, this, value);
  }

  public String getTopicName() {
    return FastRTPSJNI.TopicAttributes_topicName_get(swigCPtr, this);
  }

  public void setTopicDataType(String value) {
    FastRTPSJNI.TopicAttributes_topicDataType_set(swigCPtr, this, value);
  }

  public String getTopicDataType() {
    return FastRTPSJNI.TopicAttributes_topicDataType_get(swigCPtr, this);
  }

  public void setHistoryQos(HistoryQosPolicy value) {
    FastRTPSJNI.TopicAttributes_historyQos_set(swigCPtr, this, HistoryQosPolicy.getCPtr(value), value);
  }

  public HistoryQosPolicy getHistoryQos() {
    long cPtr = FastRTPSJNI.TopicAttributes_historyQos_get(swigCPtr, this);
    return (cPtr == 0) ? null : new HistoryQosPolicy(cPtr, false);
  }

  public void setResourceLimitsQos(ResourceLimitsQosPolicy value) {
    FastRTPSJNI.TopicAttributes_resourceLimitsQos_set(swigCPtr, this, ResourceLimitsQosPolicy.getCPtr(value), value);
  }

  public ResourceLimitsQosPolicy getResourceLimitsQos() {
    long cPtr = FastRTPSJNI.TopicAttributes_resourceLimitsQos_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ResourceLimitsQosPolicy(cPtr, false);
  }

  public boolean checkQos() {
    return FastRTPSJNI.TopicAttributes_checkQos(swigCPtr, this);
  }

}
