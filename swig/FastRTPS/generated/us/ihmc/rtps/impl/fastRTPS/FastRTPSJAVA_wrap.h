/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.8
 *
 * This file is not intended to be easily readable and contains a number of
 * coding conventions designed to improve portability and efficiency. Do not make
 * changes to this file unless you know what you are doing--modify the SWIG
 * interface file instead.
 * ----------------------------------------------------------------------------- */

#ifndef SWIG_FastRTPS_WRAP_H_
#define SWIG_FastRTPS_WRAP_H_

class SwigDirector_NativeParticipantListener : public us::ihmc::rtps::impl::fastRTPS::NativeParticipantListener, public Swig::Director {

public:
    void swig_connect_director(JNIEnv *jenv, jobject jself, jclass jcls, bool swig_mem_own, bool weak_global);
    SwigDirector_NativeParticipantListener(JNIEnv *jenv);
    virtual void onParticipantDiscovery(int64_t infoPtr, int64_t guidHigh, int64_t guidLow, eprosima::fastrtps::rtps::DISCOVERY_STATUS status);
    virtual ~SwigDirector_NativeParticipantListener();
public:
    bool swig_overrides(int n) {
      return (n < 1 ? swig_override[n] : false);
    }
protected:
    Swig::BoolArray<1> swig_override;
};

class SwigDirector_NativeParticipantPublisherEDPListener : public us::ihmc::rtps::impl::fastRTPS::NativeParticipantPublisherEDPListener, public Swig::Director {

public:
    void swig_connect_director(JNIEnv *jenv, jobject jself, jclass jcls, bool swig_mem_own, bool weak_global);
    SwigDirector_NativeParticipantPublisherEDPListener(JNIEnv *jenv);
    virtual void publisherTopicChange(bool isAlive, int64_t guidHigh, int64_t guidLow, eprosima::fastrtps::rtps::LocatorList_t *unicastLocatorList, eprosima::fastrtps::rtps::LocatorList_t *multicastLocatorList, int64_t participantGuidHigh, int64_t participantGuidLow, std::string typeName, std::string topicName, int32_t userDefinedId, int64_t typeMaxSerialized, eprosima::fastrtps::rtps::TopicKind_t topicKind, eprosima::fastrtps::WriterQos *writerQoS);
    virtual ~SwigDirector_NativeParticipantPublisherEDPListener();
public:
    bool swig_overrides(int n) {
      return (n < 1 ? swig_override[n] : false);
    }
protected:
    Swig::BoolArray<1> swig_override;
};

class SwigDirector_NativeParticipantSubscriberEDPListener : public us::ihmc::rtps::impl::fastRTPS::NativeParticipantSubscriberEDPListener, public Swig::Director {

public:
    void swig_connect_director(JNIEnv *jenv, jobject jself, jclass jcls, bool swig_mem_own, bool weak_global);
    SwigDirector_NativeParticipantSubscriberEDPListener(JNIEnv *jenv);
    virtual void subscriberTopicChange(bool isAlive, int64_t guidHigh, int64_t guidLow, bool expectsInlineQos, eprosima::fastrtps::rtps::LocatorList_t *unicastLocatorList, eprosima::fastrtps::rtps::LocatorList_t *multicastLocatorList, int64_t participantGuidHigh, int64_t participantGuidLow, std::string typeName, std::string topicName, int32_t userDefinedId, eprosima::fastrtps::rtps::TopicKind_t topicKind, eprosima::fastrtps::ReaderQos *readerQoS);
    virtual ~SwigDirector_NativeParticipantSubscriberEDPListener();
public:
    bool swig_overrides(int n) {
      return (n < 1 ? swig_override[n] : false);
    }
protected:
    Swig::BoolArray<1> swig_override;
};

class SwigDirector_NativePublisherListener : public us::ihmc::rtps::impl::fastRTPS::NativePublisherListener, public Swig::Director {

public:
    void swig_connect_director(JNIEnv *jenv, jobject jself, jclass jcls, bool swig_mem_own, bool weak_global);
    SwigDirector_NativePublisherListener(JNIEnv *jenv);
    virtual void onWriterMatched(eprosima::fastrtps::rtps::MatchingStatus status, int64_t guidHigh, int64_t guidLow);
    virtual ~SwigDirector_NativePublisherListener();
public:
    bool swig_overrides(int n) {
      return (n < 1 ? swig_override[n] : false);
    }
protected:
    Swig::BoolArray<1> swig_override;
};

class SwigDirector_NativeSubscriberListener : public us::ihmc::rtps::impl::fastRTPS::NativeSubscriberListener, public Swig::Director {

public:
    void swig_connect_director(JNIEnv *jenv, jobject jself, jclass jcls, bool swig_mem_own, bool weak_global);
    SwigDirector_NativeSubscriberListener(JNIEnv *jenv);
    virtual void onReaderMatched(eprosima::fastrtps::rtps::MatchingStatus status, int64_t guidHigh, int64_t guidLow);
    virtual void onNewCacheChangeAdded();
    virtual bool getKey(int64_t cacheChangePtr, int16_t encoding, int32_t dataLength);
    virtual ~SwigDirector_NativeSubscriberListener();
public:
    bool swig_overrides(int n) {
      return (n < 3 ? swig_override[n] : false);
    }
protected:
    Swig::BoolArray<3> swig_override;
};


#endif
