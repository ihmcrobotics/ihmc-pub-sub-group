/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.1.1
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.rtps.impl.fastRTPS;

public class SampleInfoMarshaller {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected SampleInfoMarshaller(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(SampleInfoMarshaller obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected static long swigRelease(SampleInfoMarshaller obj) {
    long ptr = 0;
    if (obj != null) {
      if (!obj.swigCMemOwn)
        throw new RuntimeException("Cannot release ownership as memory is not owned");
      ptr = obj.swigCPtr;
      obj.swigCMemOwn = false;
      obj.delete();
    }
    return ptr;
  }

  @SuppressWarnings("deprecation")
  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        FastRTPSJNI.delete_SampleInfoMarshaller(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setEncapsulation(short value) {
    FastRTPSJNI.SampleInfoMarshaller_encapsulation_set(swigCPtr, this, value);
  }

  public short getEncapsulation() {
    return FastRTPSJNI.SampleInfoMarshaller_encapsulation_get(swigCPtr, this);
  }

  public void setDataLength(int value) {
    FastRTPSJNI.SampleInfoMarshaller_dataLength_set(swigCPtr, this, value);
  }

  public int getDataLength() {
    return FastRTPSJNI.SampleInfoMarshaller_dataLength_get(swigCPtr, this);
  }

  public void setChangeKind(int value) {
    FastRTPSJNI.SampleInfoMarshaller_changeKind_set(swigCPtr, this, value);
  }

  public int getChangeKind() {
    return FastRTPSJNI.SampleInfoMarshaller_changeKind_get(swigCPtr, this);
  }

  public void setOwnershipStrength(int value) {
    FastRTPSJNI.SampleInfoMarshaller_ownershipStrength_set(swigCPtr, this, value);
  }

  public int getOwnershipStrength() {
    return FastRTPSJNI.SampleInfoMarshaller_ownershipStrength_get(swigCPtr, this);
  }

  public void setTime_seconds(int value) {
    FastRTPSJNI.SampleInfoMarshaller_time_seconds_set(swigCPtr, this, value);
  }

  public int getTime_seconds() {
    return FastRTPSJNI.SampleInfoMarshaller_time_seconds_get(swigCPtr, this);
  }

  public void setTime_nsec(long value) {
    FastRTPSJNI.SampleInfoMarshaller_time_nsec_set(swigCPtr, this, value);
  }

  public long getTime_nsec() {
    return FastRTPSJNI.SampleInfoMarshaller_time_nsec_get(swigCPtr, this);
  }

  public void setInstanceHandle_value(SWIGTYPE_p_unsigned_char value) {
    FastRTPSJNI.SampleInfoMarshaller_instanceHandle_value_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value));
  }

  public SWIGTYPE_p_unsigned_char getInstanceHandle_value() {
    long cPtr = FastRTPSJNI.SampleInfoMarshaller_instanceHandle_value_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_unsigned_char(cPtr, false);
  }

  public void setSampleIdentity_GuidHigh(long value) {
    FastRTPSJNI.SampleInfoMarshaller_sampleIdentity_GuidHigh_set(swigCPtr, this, value);
  }

  public long getSampleIdentity_GuidHigh() {
    return FastRTPSJNI.SampleInfoMarshaller_sampleIdentity_GuidHigh_get(swigCPtr, this);
  }

  public void setSampleIdentity_GuidLow(long value) {
    FastRTPSJNI.SampleInfoMarshaller_sampleIdentity_GuidLow_set(swigCPtr, this, value);
  }

  public long getSampleIdentity_GuidLow() {
    return FastRTPSJNI.SampleInfoMarshaller_sampleIdentity_GuidLow_get(swigCPtr, this);
  }

  public void setSampleIdentity_sequenceNumberHigh(int value) {
    FastRTPSJNI.SampleInfoMarshaller_sampleIdentity_sequenceNumberHigh_set(swigCPtr, this, value);
  }

  public int getSampleIdentity_sequenceNumberHigh() {
    return FastRTPSJNI.SampleInfoMarshaller_sampleIdentity_sequenceNumberHigh_get(swigCPtr, this);
  }

  public void setSampleIdentity_sequenceNumberLow(long value) {
    FastRTPSJNI.SampleInfoMarshaller_sampleIdentity_sequenceNumberLow_set(swigCPtr, this, value);
  }

  public long getSampleIdentity_sequenceNumberLow() {
    return FastRTPSJNI.SampleInfoMarshaller_sampleIdentity_sequenceNumberLow_get(swigCPtr, this);
  }

  public void setRelatedSampleIdentity_GuidHigh(long value) {
    FastRTPSJNI.SampleInfoMarshaller_relatedSampleIdentity_GuidHigh_set(swigCPtr, this, value);
  }

  public long getRelatedSampleIdentity_GuidHigh() {
    return FastRTPSJNI.SampleInfoMarshaller_relatedSampleIdentity_GuidHigh_get(swigCPtr, this);
  }

  public void setRelatedSampleIdentity_GuidLow(long value) {
    FastRTPSJNI.SampleInfoMarshaller_relatedSampleIdentity_GuidLow_set(swigCPtr, this, value);
  }

  public long getRelatedSampleIdentity_GuidLow() {
    return FastRTPSJNI.SampleInfoMarshaller_relatedSampleIdentity_GuidLow_get(swigCPtr, this);
  }

  public void setRelatedSampleIdentity_sequenceNumberHigh(int value) {
    FastRTPSJNI.SampleInfoMarshaller_relatedSampleIdentity_sequenceNumberHigh_set(swigCPtr, this, value);
  }

  public int getRelatedSampleIdentity_sequenceNumberHigh() {
    return FastRTPSJNI.SampleInfoMarshaller_relatedSampleIdentity_sequenceNumberHigh_get(swigCPtr, this);
  }

  public void setRelatedSampleIdentity_sequenceNumberLow(long value) {
    FastRTPSJNI.SampleInfoMarshaller_relatedSampleIdentity_sequenceNumberLow_set(swigCPtr, this, value);
  }

  public long getRelatedSampleIdentity_sequenceNumberLow() {
    return FastRTPSJNI.SampleInfoMarshaller_relatedSampleIdentity_sequenceNumberLow_get(swigCPtr, this);
  }

  public void getInstanceHandleValue(java.nio.ByteBuffer dest) {
  assert dest.isDirect() : "Buffer must be allocated direct.";
    {
      FastRTPSJNI.SampleInfoMarshaller_getInstanceHandleValue(swigCPtr, this, dest);
    }
  }

  public SampleInfoMarshaller() {
    this(FastRTPSJNI.new_SampleInfoMarshaller(), true);
  }

}
