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
#include "nativeparticipantimpl.h"

#include <fastdds/dds/domain/DomainParticipantFactory.hpp>
#include <fastdds/rtps/builtin/data/ParticipantProxyData.h>

using namespace eprosima::fastdds::dds;
using namespace us::ihmc::rtps::impl::fastDDS;

NativeParticipantImpl::NativeParticipantImpl(std::string participantProfile, const char *XMLConfigData, size_t XMLdataLength, NativeParticipantListener *listener) throw(FastDDSException) :
    listener(listener),
    m_rtps_listener(this)
{
    try
    {
        auto factory = DomainParticipantFactory::get_instance();
        factory->load_XML_profiles_string(XMLConfigData, XMLdataLength);
        participant = factory->create_participant_with_profile(participantProfile, &m_rtps_listener);
    }
    catch (const std::exception &e)
    {
        std::cerr << "[ERROR]" << e.what() << std::endl;
        throw FastDDSException("Problem creating participant");
        return;
    }

    if (participant == nullptr)
    {
        throw FastDDSException("Problem creating participant");
        return;
    }

    logInfo(PARTICIPANT,"Guid: " << participant->guid());
    CommonFunctions::guidcpy(participant->guid(), &guid);
}

NativeParticipantImpl::~NativeParticipantImpl()
{
    DomainParticipantFactory::get_instance()->delete_participant(participant);
}

int64_t NativeParticipantImpl::getGuidLow()
{
    return guid.primitive.low;
}

int64_t NativeParticipantImpl::getGuidHigh()
{
    return guid.primitive.high;
}

DomainParticipant* NativeParticipantImpl::getParticipant()
{
    return participant;
}

void NativeParticipantImpl::registerType(std::string name, int32_t maximumDataSize, bool hasKey)
{
    // This functions adds registered types to a vector of shared ptrs, so they get destroyed when this class gets destructed
    RawTopicDataType topicDataType(name, maximumDataSize, hasKey);
    participant->register_type(TypeSupport(&topicDataType));
    registeredTypes.push_back(std::make_shared<RawTopicDataType>(topicDataType));
}

void NativeParticipantImpl::MyParticipantListener::on_participant_discovery(DomainParticipant *participant, eprosima::fastrtps::rtps::ParticipantDiscoveryInfo&& info)
{
    if (this->mp_participantimpl->listener != nullptr)
    {
        const eprosima::fastrtps::rtps::ParticipantProxyData &proxy_data = info.info;

        logInfo(PARTICIPANT,"Remote participant Guid: " << rtpsinfo.m_guid);
        GuidUnion retGuid;
        CommonFunctions::guidcpy(proxy_data.m_guid, &retGuid);

        this->mp_participantimpl->listener->onParticipantDiscovery((int64_t)&proxy_data, retGuid.primitive.high, retGuid.primitive.low, info.status);
    }
}

std::string NativeParticipantListener::getName(int64_t infoPtr)
{
    return ((eprosima::fastrtps::rtps::ParticipantProxyData*) infoPtr)->m_participantName.to_string();
}
