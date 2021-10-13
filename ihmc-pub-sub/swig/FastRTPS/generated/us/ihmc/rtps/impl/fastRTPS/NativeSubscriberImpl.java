/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.rtps.impl.fastRTPS;

public class NativeSubscriberImpl {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected NativeSubscriberImpl(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(NativeSubscriberImpl obj) {
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
        FastRTPSJNI.delete_NativeSubscriberImpl(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public NativeSubscriberImpl(NativeParticipantImpl participant, NativeSubscriberListener listener) throws java.io.IOException {
    this(FastRTPSJNI.new_NativeSubscriberImpl(NativeParticipantImpl.getCPtr(participant), participant, NativeSubscriberListener.getCPtr(listener), listener), true);
  }

  public boolean createSubscriber() {
    return FastRTPSJNI.NativeSubscriberImpl_createSubscriber__SWIG_0(swigCPtr, this);
  }

  public boolean createSubscriber(String subscriberProfile, String XMLConfigData, long XMLdataLength) {
    return FastRTPSJNI.NativeSubscriberImpl_createSubscriber__SWIG_1(swigCPtr, this, subscriberProfile, XMLConfigData, XMLdataLength);
  }

  public long getGuidLow() {
    return FastRTPSJNI.NativeSubscriberImpl_getGuidLow(swigCPtr, this);
  }

  public long getGuidHigh() {
    return FastRTPSJNI.NativeSubscriberImpl_getGuidHigh(swigCPtr, this);
  }

  public void waitForUnreadMessage() {
    FastRTPSJNI.NativeSubscriberImpl_waitForUnreadMessage(swigCPtr, this);
  }

  public boolean readnextData(int maxDataLength, java.nio.ByteBuffer data, SampleInfoMarshaller marshaller) {
  assert data.isDirect() : "Buffer must be allocated direct.";
    {
      return FastRTPSJNI.NativeSubscriberImpl_readnextData(swigCPtr, this, maxDataLength, data, SampleInfoMarshaller.getCPtr(marshaller), marshaller);
    }
  }

  public boolean takeNextData(int maxDataLength, java.nio.ByteBuffer data, SampleInfoMarshaller marshaller) {
  assert data.isDirect() : "Buffer must be allocated direct.";
    {
      return FastRTPSJNI.NativeSubscriberImpl_takeNextData(swigCPtr, this, maxDataLength, data, SampleInfoMarshaller.getCPtr(marshaller), marshaller);
    }
  }

  public boolean isInCleanState() {
    return FastRTPSJNI.NativeSubscriberImpl_isInCleanState(swigCPtr, this);
  }

  public long getUnreadCount() {
    return FastRTPSJNI.NativeSubscriberImpl_getUnreadCount(swigCPtr, this);
  }

}
