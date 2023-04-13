/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.1.1
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.rtps.impl.fastRTPS;

public class NativePublisherListener {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected NativePublisherListener(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(NativePublisherListener obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected static long swigRelease(NativePublisherListener obj) {
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
        FastRTPSJNI.delete_NativePublisherListener(swigCPtr);
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
    FastRTPSJNI.NativePublisherListener_change_ownership(this, swigCPtr, false);
  }

  public void swigTakeOwnership() {
    swigCMemOwn = true;
    FastRTPSJNI.NativePublisherListener_change_ownership(this, swigCPtr, true);
  }

  public void onWriterMatched(int matchingStatus, long guidHigh, long guidLow) {
    if (getClass() == NativePublisherListener.class) FastRTPSJNI.NativePublisherListener_onWriterMatched(swigCPtr, this, matchingStatus, guidHigh, guidLow); else FastRTPSJNI.NativePublisherListener_onWriterMatchedSwigExplicitNativePublisherListener(swigCPtr, this, matchingStatus, guidHigh, guidLow);
  }

  public NativePublisherListener() {
    this(FastRTPSJNI.new_NativePublisherListener(), true);
    FastRTPSJNI.NativePublisherListener_director_connect(this, swigCPtr, true, true);
  }

}
