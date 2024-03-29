/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.1.1
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.rtps.impl.fastRTPS;

public class NativePublisherImpl {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected NativePublisherImpl(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(NativePublisherImpl obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected static long swigRelease(NativePublisherImpl obj) {
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
        FastRTPSJNI.delete_NativePublisherImpl(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public NativePublisherImpl(NativeParticipantImpl participant, NativePublisherListener listener) throws java.io.IOException {
    this(FastRTPSJNI.new_NativePublisherImpl(NativeParticipantImpl.getCPtr(participant), participant, NativePublisherListener.getCPtr(listener), listener), true);
  }

  public boolean createPublisher() {
    return FastRTPSJNI.NativePublisherImpl_createPublisher__SWIG_0(swigCPtr, this);
  }

  public boolean createPublisher(String publisherProfile, String XMLConfigData, long XMLdataLength) {
    return FastRTPSJNI.NativePublisherImpl_createPublisher__SWIG_1(swigCPtr, this, publisherProfile, XMLConfigData, XMLdataLength);
  }

  public void write(java.nio.ByteBuffer data, int dataLength, short encapsulation, java.nio.ByteBuffer key, int keyLength) {
  assert data.isDirect() : "Buffer must be allocated direct.";
  assert key.isDirect() : "Buffer must be allocated direct.";
    {
      FastRTPSJNI.NativePublisherImpl_write(swigCPtr, this, data, dataLength, encapsulation, key, keyLength);
    }
  }

  public void dispose(java.nio.ByteBuffer data, int dataLength, short encapsulation, java.nio.ByteBuffer key, int keyLength) {
  assert data.isDirect() : "Buffer must be allocated direct.";
  assert key.isDirect() : "Buffer must be allocated direct.";
    {
      FastRTPSJNI.NativePublisherImpl_dispose(swigCPtr, this, data, dataLength, encapsulation, key, keyLength);
    }
  }

  public void unregister(java.nio.ByteBuffer data, int dataLength, short encapsulation, java.nio.ByteBuffer key, int keyLength) {
  assert data.isDirect() : "Buffer must be allocated direct.";
  assert key.isDirect() : "Buffer must be allocated direct.";
    {
      FastRTPSJNI.NativePublisherImpl_unregister(swigCPtr, this, data, dataLength, encapsulation, key, keyLength);
    }
  }

  public void dispose_and_unregister(java.nio.ByteBuffer data, int dataLength, short encapsulation, java.nio.ByteBuffer key, int keyLength) {
  assert data.isDirect() : "Buffer must be allocated direct.";
  assert key.isDirect() : "Buffer must be allocated direct.";
    {
      FastRTPSJNI.NativePublisherImpl_dispose_and_unregister(swigCPtr, this, data, dataLength, encapsulation, key, keyLength);
    }
  }

  public int removeAllChange() {
    return FastRTPSJNI.NativePublisherImpl_removeAllChange(swigCPtr, this);
  }

  public boolean wait_for_all_acked(Time_t max_wait) {
    return FastRTPSJNI.NativePublisherImpl_wait_for_all_acked(swigCPtr, this, Time_t.getCPtr(max_wait), max_wait);
  }

  public long getGuidLow() {
    return FastRTPSJNI.NativePublisherImpl_getGuidLow(swigCPtr, this);
  }

  public long getGuidHigh() {
    return FastRTPSJNI.NativePublisherImpl_getGuidHigh(swigCPtr, this);
  }

}
