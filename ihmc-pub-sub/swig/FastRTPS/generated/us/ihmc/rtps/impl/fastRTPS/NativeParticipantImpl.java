/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
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

  @SuppressWarnings("deprecation")
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

  public NativeParticipantImpl(int domainId, SWIGTYPE_p_RTPSParticipantAttributes rtps, NativeParticipantListener listener) throws java.io.IOException {
    this(FastRTPSJNI.new_NativeParticipantImpl(domainId, SWIGTYPE_p_RTPSParticipantAttributes.getCPtr(rtps), NativeParticipantListener.getCPtr(listener), listener), true);
  }

  public long getGuidLow() {
    return FastRTPSJNI.NativeParticipantImpl_getGuidLow(swigCPtr, this);
  }

  public long getGuidHigh() {
    return FastRTPSJNI.NativeParticipantImpl_getGuidHigh(swigCPtr, this);
  }

  public void registerType(String name, int maximumDataSize, boolean hasKey) {
    FastRTPSJNI.NativeParticipantImpl_registerType(swigCPtr, this, name, maximumDataSize, hasKey);
  }

}
