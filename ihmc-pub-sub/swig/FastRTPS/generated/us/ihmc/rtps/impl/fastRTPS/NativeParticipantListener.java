/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.rtps.impl.fastRTPS;

public class NativeParticipantListener {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected NativeParticipantListener(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(NativeParticipantListener obj) {
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
        FastRTPSJNI.delete_NativeParticipantListener(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  protected void swigDirectorDisconnect() {
    swigCMemOwn = false;
    delete();
  }

  public void swigReleaseOwnership() {
    swigCMemOwn = false;
    FastRTPSJNI.NativeParticipantListener_change_ownership(this, swigCPtr, false);
  }

  public void swigTakeOwnership() {
    swigCMemOwn = true;
    FastRTPSJNI.NativeParticipantListener_change_ownership(this, swigCPtr, true);
  }

  public void onParticipantDiscovery(long infoPtr, long guidHigh, long guidLow, int discoveryStatus) {
    if (getClass() == NativeParticipantListener.class) FastRTPSJNI.NativeParticipantListener_onParticipantDiscovery(swigCPtr, this, infoPtr, guidHigh, guidLow, discoveryStatus); else FastRTPSJNI.NativeParticipantListener_onParticipantDiscoverySwigExplicitNativeParticipantListener(swigCPtr, this, infoPtr, guidHigh, guidLow, discoveryStatus);
  }

  public String getName(long infoPtr) {
    return FastRTPSJNI.NativeParticipantListener_getName(swigCPtr, this, infoPtr);
  }

  public NativeParticipantListener() {
    this(FastRTPSJNI.new_NativeParticipantListener(), true);
    FastRTPSJNI.NativeParticipantListener_director_connect(this, swigCPtr, true, true);
  }

}
