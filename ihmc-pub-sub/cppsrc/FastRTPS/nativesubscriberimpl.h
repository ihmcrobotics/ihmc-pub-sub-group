// Copyright 2017 Florida Institute for Human and Machine Cognition
// Copyright 2016 Proyectos y Sistemas de Mantenimiento SL (eProsima).
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

#ifndef NATIVESUBSCRIBERIMPL_H
#define NATIVESUBSCRIBERIMPL_H

#include <fastdds/rtps/attributes/ReaderAttributes.h>
#include <fastdds/dds/subscriber/Subscriber.hpp>
#include <fastdds/dds/subscriber/SubscriberListener.hpp>
#include <fastdds/dds/subscriber/SampleInfo.hpp>
#include <fastdds/rtps/common/Guid.h>
#include <fastdds/rtps/common/MatchingInfo.h>

#include "fastddsexception.h"
#include "nativeparticipantimpl.h"
#include "commonfunctions.h"
#include "sampleinfomarshaller.h"

namespace us {
namespace ihmc {
namespace rtps {
namespace impl {
namespace fastDDS {

    class NativeSubscriberListener
    {
    public:
        virtual void onSubscriptionMatched(int matchingStatus, int64_t guidHigh, int64_t guidLow) {}
        virtual void onNewDataMessage() {}
        virtual ~NativeSubscriberListener() {}
    };

    class NativeSubscriberImpl
    {
    public:

        NativeSubscriberImpl(
                NativeParticipantImpl* participant,
                NativeSubscriberListener* listener) throw(FastDDSException);


        bool createSubscriber();
        bool createSubscriber(std::string subscriberProfile, const char *XMLConfigData, size_t XMLdataLength);

        int64_t getGuidLow()
        {
            return guidUnion.primitive.low;
        }

        int64_t getGuidHigh()
        {
            return guidUnion.primitive.high;
        }

        void waitForUnreadMessage();

        bool readnextData(int32_t maxDataLength, unsigned char* data, SampleInfoMarshaller* marshaller);
        bool takeNextData(int32_t maxDataLength, unsigned char* data, SampleInfoMarshaller* marshaller);

        bool isInCleanState();
        int64_t getUnreadCount();

        virtual ~NativeSubscriberImpl();
    private:
        class SubscriberReaderListener : public SubscriberListener
        {
        public:
            SubscriberReaderListener(NativeSubscriberImpl* s): subscriberImpl(s) {}
            virtual ~SubscriberReaderListener() {}
            void onSubscriptionMatched(Subscriber* subscriber, eprosima::fastrtps::rtps::MatchingInfo& info);
            void onNewDataMessage(Subscriber* subscriber);
            NativeSubscriberImpl* subscriberImpl;
        }readerListener;

        DomainParticipant* participant;

        NativeSubscriberListener* listener;
        std::string topicName;

        Subscriber* subscriber;

        eprosima::fastrtps::rtps::GUID_t guid;
        GuidUnion guidUnion;

        SubscriberQos qos;
        // SubscriberAttributes attr;

        void updateMarshaller(SampleInfoMarshaller* marshaller, SampleInfo& sampleInfo);
    };
}}}}}
#endif // NATIVESUBSCRIBERIMPL_H
