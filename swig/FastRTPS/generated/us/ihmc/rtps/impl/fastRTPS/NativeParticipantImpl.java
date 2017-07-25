/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.8
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.rtps.impl.fastRTPS;

public class NativeParticipantImpl {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected NativeParticipantImpl(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(NativeParticipantImpl obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        FastRTPSJNI.delete_NativeParticipantImpl(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public NativeParticipantImpl(RTPSParticipantAttributes rtps, NativeParticipantListener listener) throws java.io.IOException {
    this(FastRTPSJNI.new_NativeParticipantImpl(RTPSParticipantAttributes.getCPtr(rtps), rtps, NativeParticipantListener.getCPtr(listener), listener), true);
  }

  public long getGuidLow() {
    return FastRTPSJNI.NativeParticipantImpl_getGuidLow(swigCPtr, this);
  }

  public long getGuidHigh() {
    return FastRTPSJNI.NativeParticipantImpl_getGuidHigh(swigCPtr, this);
  }

  public void registerEDPReaderListeners(NativeParticipantPublisherEDPListener publisherListener, NativeParticipantSubscriberEDPListener subscriberListener) throws java.io.IOException {
    FastRTPSJNI.NativeParticipantImpl_registerEDPReaderListeners(swigCPtr, this, NativeParticipantPublisherEDPListener.getCPtr(publisherListener), publisherListener, NativeParticipantSubscriberEDPListener.getCPtr(subscriberListener), subscriberListener);
  }

}
