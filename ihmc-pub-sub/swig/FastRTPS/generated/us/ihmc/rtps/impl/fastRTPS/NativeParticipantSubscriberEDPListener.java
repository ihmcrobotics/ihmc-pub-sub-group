/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.rtps.impl.fastRTPS;

public class NativeParticipantSubscriberEDPListener {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected NativeParticipantSubscriberEDPListener(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(NativeParticipantSubscriberEDPListener obj) {
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
        FastRTPSJNI.delete_NativeParticipantSubscriberEDPListener(swigCPtr);
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
    FastRTPSJNI.NativeParticipantSubscriberEDPListener_change_ownership(this, swigCPtr, false);
  }

  public void swigTakeOwnership() {
    swigCMemOwn = true;
    FastRTPSJNI.NativeParticipantSubscriberEDPListener_change_ownership(this, swigCPtr, true);
  }

  public NativeParticipantSubscriberEDPListener() {
    this(FastRTPSJNI.new_NativeParticipantSubscriberEDPListener(), true);
    FastRTPSJNI.NativeParticipantSubscriberEDPListener_director_connect(this, swigCPtr, true, true);
  }

  public void subscriberTopicChange(boolean isAlive, long guidHigh, long guidLow, boolean expectsInlineQos, LocatorList_t unicastLocatorList, LocatorList_t multicastLocatorList, long participantGuidHigh, long participantGuidLow, String typeName, String topicName, int userDefinedId, TopicKind_t topicKind, ReaderQos readerQoS) {
    if (getClass() == NativeParticipantSubscriberEDPListener.class) FastRTPSJNI.NativeParticipantSubscriberEDPListener_subscriberTopicChange(swigCPtr, this, isAlive, guidHigh, guidLow, expectsInlineQos, LocatorList_t.getCPtr(unicastLocatorList), unicastLocatorList, LocatorList_t.getCPtr(multicastLocatorList), multicastLocatorList, participantGuidHigh, participantGuidLow, typeName, topicName, userDefinedId, topicKind.swigValue(), ReaderQos.getCPtr(readerQoS), readerQoS); else FastRTPSJNI.NativeParticipantSubscriberEDPListener_subscriberTopicChangeSwigExplicitNativeParticipantSubscriberEDPListener(swigCPtr, this, isAlive, guidHigh, guidLow, expectsInlineQos, LocatorList_t.getCPtr(unicastLocatorList), unicastLocatorList, LocatorList_t.getCPtr(multicastLocatorList), multicastLocatorList, participantGuidHigh, participantGuidLow, typeName, topicName, userDefinedId, topicKind.swigValue(), ReaderQos.getCPtr(readerQoS), readerQoS);
  }

}
