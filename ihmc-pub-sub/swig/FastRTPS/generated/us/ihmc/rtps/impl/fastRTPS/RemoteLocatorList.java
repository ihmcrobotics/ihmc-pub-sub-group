/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.rtps.impl.fastRTPS;

public class RemoteLocatorList {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected RemoteLocatorList(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(RemoteLocatorList obj) {
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
        FastRTPSJNI.delete_RemoteLocatorList(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

}
