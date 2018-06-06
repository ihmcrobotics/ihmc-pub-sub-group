#include "nativeparticipantimpl.h"
#include "nativesubscriberimpl.h"
#include "loglevel.h"

#include <iostream>
#include <chrono>
#include <thread>
using namespace us::ihmc::rtps::impl::fastRTPS;


class ExampleParticipantListener : public NativeParticipantListener
{
    void onParticipantDiscovery(int64_t infoPtr, int64_t guidHigh, int64_t guidLow, DISCOVERY_STATUS status)
    {
        std::cout << "Discovered participant " << getName(infoPtr) << std::endl;
    }

};


class ExampleSubscriberListener : public NativeSubscriberListener
{



    virtual void onSubscriptionMatched(MatchingStatus status, int64_t guidHigh, int64_t guidLow)
    {
        std::cout << "Found publisher" << std::endl;
    }
    virtual void onNewDataMessage()
    {
        std::cout << "Got callback" << std::endl;
        if(subscriber->takeNextData(23, data.data(), &marshaller, NO_KEY, SHARED_OWNERSHIP_QOS))
        {
            std::cout << "Got message of length " << marshaller.dataLength << " guid " << std::to_string(marshaller.sampleIdentity_GuidHigh) << " " << std::to_string(marshaller.sampleIdentity_GuidLow) << " " << (int)data[18] << std::endl;
        }
    }
public:
    ExampleSubscriberListener() : data(23)
    {

    }

    NativeSubscriberImpl* subscriber;
    std::vector<unsigned char> data;
    SampleInfoMarshaller marshaller;


};

int main()
{

    LogLevel::setLogLevel(2);
    RTPSParticipantAttributes rtps;
    rtps.setName("Participant");
    rtps.builtin.domainId = 1;

    ExampleParticipantListener participantListener;

    NativeParticipantImpl participant(rtps, &participantListener);

    participant.registerType("us::ihmc::robotDataLogger::VariableChangeRequest", 20, false);

    SubscriberAttributes attr;
    attr.topic.topicName = "testTopic";
    attr.topic.topicDataType = "us::ihmc::robotDataLogger::VariableChangeRequest";


    attr.qos.m_reliability.kind = RELIABLE_RELIABILITY_QOS;
    attr.qos.m_partition.push_back("us/ihmc");

    ExampleSubscriberListener subscriberListener;

    NativeSubscriberImpl subscriber(-1, -1, 20, PREALLOCATED_MEMORY_MODE,
                                    &attr.topic, &attr.qos, &attr.times, &attr.unicastLocatorList, &attr.multicastLocatorList, &attr.outLocatorList,
                                    false, &participant, &subscriberListener);
    subscriber.createSubscriber();
    subscriberListener.subscriber = &subscriber;

    while(true)
    {
        std::this_thread::sleep_for(std::chrono::milliseconds(1000));
    }


}
