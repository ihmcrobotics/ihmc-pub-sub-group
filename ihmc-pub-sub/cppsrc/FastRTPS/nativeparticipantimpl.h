/**
 * Copyright 2017 Florida Institute for Human and Machine Cognition (IHMC)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
#ifndef NATIVEPARTICIPANTIMPL_H
#define NATIVEPARTICIPANTIMPL_H

#include <memory>
#include <vector>

#include "rawtopicdatatype.h"
#include "fastddsexception.h"
#include "commonfunctions.h"

#include <fastdds/dds/domain/DomainParticipant.hpp>
#include <fastdds/dds/domain/DomainParticipantListener.hpp>
#include <fastdds/dds/publisher/qos/WriterQos.hpp>
#include <fastdds/dds/subscriber/qos/ReaderQos.hpp>
#include <fastdds/rtps/reader/ReaderListener.h>

using namespace eprosima::fastdds::dds;

namespace us {
namespace ihmc {
namespace rtps {
namespace impl {
namespace fastDDS {

    class NativeParticipantListener
    {
    public:
        virtual void onParticipantDiscovery(int64_t infoPtr, int64_t guidHigh, int64_t guidLow, int discoveryStatus) {}

        std::string getName(int64_t infoPtr);
        virtual ~NativeParticipantListener() {}
    };

    class NativeParticipantImpl
    {
    public:
        NativeParticipantImpl(std::string participantProfile, const char* XMLConfigData, size_t XMLdataLength, NativeParticipantListener* listener) throw(FastDDSException);
        int64_t getGuidLow();
        int64_t getGuidHigh();
        DomainParticipant* getParticipant();
        void registerType(std::string name, int32_t maximumDataSize, bool hasKey);
        virtual ~NativeParticipantImpl();

    private:
        DomainParticipant* participant;
        NativeParticipantListener* listener;
        GuidUnion guid;
        std::vector<std::shared_ptr<RawTopicDataType>> registeredTypes;

        class MyParticipantListener : public DomainParticipantListener
        {
            public:
                MyParticipantListener(NativeParticipantImpl* impl): mp_participantimpl(impl){}
                virtual ~MyParticipantListener(){}

                void on_participant_discovery(DomainParticipant* participant, eprosima::fastrtps::rtps::ParticipantDiscoveryInfo&& info) override;

                NativeParticipantImpl* mp_participantimpl;
        } m_rtps_listener;
    };

}}}}}
#endif // NATIVEPARTICIPANTIMPL_H
