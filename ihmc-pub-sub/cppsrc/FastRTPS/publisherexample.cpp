#include "nativeparticipantimpl.h"
#include "nativepublisherimpl.h"

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


class ExamplePublisherListener : public NativePublisherListener
{
    void onWriterMatched(MatchingStatus status, int64_t guidHigh, int64_t guidLow)
    {
        std::cout << "Found subscriber " << std::endl;
    }

};


int main()
{
    RTPSParticipantAttributes rtps;
    rtps.setName("Participant");
    rtps.builtin.domainId = 1;

    ExampleParticipantListener participantListener;

    NativeParticipantImpl participant(rtps, &participantListener);

    participant.registerType("us::ihmc::robotDataLogger::VariableChangeRequest", 20, false);

    PublisherAttributes attr;

    attr.topic.topicName = "testTopic";
    attr.topic.topicDataType = "us::ihmc::robotDataLogger::VariableChangeRequest";


    attr.qos.m_reliability.kind = RELIABLE_RELIABILITY_QOS;
    attr.qos.m_partition.push_back("us/ihmc");


    ExamplePublisherListener publisherListener;
    ExamplePublisherListener publisherListener2;

    NativePublisherImpl publisher(-1, -1, 20, PREALLOCATED_MEMORY_MODE, &attr.topic, &attr.qos,
                                  &attr.times, &attr.unicastLocatorList, &attr.multicastLocatorList,
                                  &attr.outLocatorList, &attr.throughputController, &participant, &publisherListener);
    publisher.createPublisher();

    NativePublisherImpl publisher2(-1, -1, 20, PREALLOCATED_MEMORY_MODE, &attr.topic, &attr.qos,
                                  &attr.times, &attr.unicastLocatorList, &attr.multicastLocatorList,
                                  &attr.outLocatorList, &attr.throughputController, &participant, &publisherListener2);
    publisher2.createPublisher();


    char data[] = {0, 1, 0, 0, 101, 0, 0, 0, 0, 0, 0, 0, 61, 10, -41, -93, 112, -67, 42, 64};

    char data2[] = {0, 1, 0, 0, 102, 0, 0, 0, 0, 0, 0, 0, 61, 10, -41, -93, 112, -67, 58, 64};

   // while(true)
    for(int i = 0; i < 4; i++)
    {
        std::cout << "Publishing message of length 20" << std::endl;
        publisher.write((unsigned char*)data,20,CDR_LE, nullptr, 0);
        publisher2.write((unsigned char*)data2,20,CDR_LE, nullptr, 0);
        std::this_thread::sleep_for(std::chrono::milliseconds(1000));

    }
    while(true)
    {
        std::this_thread::sleep_for(std::chrono::milliseconds(1000));
    }

}
