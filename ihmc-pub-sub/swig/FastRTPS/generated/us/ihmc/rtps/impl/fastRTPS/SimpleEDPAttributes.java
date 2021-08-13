/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.rtps.impl.fastRTPS;

public class SimpleEDPAttributes {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected SimpleEDPAttributes(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(SimpleEDPAttributes obj) {
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
        FastRTPSJNI.delete_SimpleEDPAttributes(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setUse_PublicationWriterANDSubscriptionReader(boolean value) {
    FastRTPSJNI.SimpleEDPAttributes_use_PublicationWriterANDSubscriptionReader_set(swigCPtr, this, value);
  }

  public boolean getUse_PublicationWriterANDSubscriptionReader() {
    return FastRTPSJNI.SimpleEDPAttributes_use_PublicationWriterANDSubscriptionReader_get(swigCPtr, this);
  }

  public void setUse_PublicationReaderANDSubscriptionWriter(boolean value) {
    FastRTPSJNI.SimpleEDPAttributes_use_PublicationReaderANDSubscriptionWriter_set(swigCPtr, this, value);
  }

  public boolean getUse_PublicationReaderANDSubscriptionWriter() {
    return FastRTPSJNI.SimpleEDPAttributes_use_PublicationReaderANDSubscriptionWriter_get(swigCPtr, this);
  }

  public SimpleEDPAttributes() {
    this(FastRTPSJNI.new_SimpleEDPAttributes(), true);
  }

}
