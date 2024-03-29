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
#include <fastrtps/log/Log.h>

#include <fastrtps/Domain.h>
#include <fastrtps/attributes/ParticipantAttributes.h>

#include <fastrtps/rtps/builtin/data/WriterProxyData.h>
#include <fastrtps/rtps/builtin/data/ReaderProxyData.h>
#include <fastrtps/rtps/reader/StatefulReader.h>


using namespace us::ihmc::rtps::impl::fastRTPS;

NativeParticipantImpl::NativeParticipantImpl(std::string participantProfile, const char *XMLConfigData, size_t XMLdataLength, NativeParticipantListener *listener) throw(FastRTPSException) :
    listener(listener),
    m_rtps_listener(this)
{


    ParticipantAttributes attributes;

    try
    {
        Domain::loadXMLProfilesString(XMLConfigData, XMLdataLength);
        part = Domain::createParticipant(participantProfile, &m_rtps_listener);
        attributes = part->getAttributes();

    }
    catch(const std::exception &e)
    {
        std::cerr << "[ERROR]" << e.what() << std::endl;
        throw FastRTPSException("Problem creating RTPSParticipant");
        return;
    }

    if(part == nullptr)
    {
        throw FastRTPSException("Problem creating RTPSParticipant");
        return;
    }

    logInfo(PARTICIPANT,"Guid: " << part->getGuid());
    CommonFunctions::guidcpy(part->getGuid(), &guid);
}

NativeParticipantImpl::~NativeParticipantImpl()
{

    Domain::removeParticipant(part);
}

int64_t NativeParticipantImpl::getGuidLow()
{
    return guid.primitive.low;
}

int64_t NativeParticipantImpl::getGuidHigh()
{
    return guid.primitive.high;
}

Participant* NativeParticipantImpl::getParticipant()
{
    return part;
}

void NativeParticipantImpl::registerType(std::string name, int32_t maximumDataSize, bool hasKey)
{
    // This functions adds registered types to a vector of shared ptrs, so they get destroyed when this class gets destructed
    std::shared_ptr<RawTopicDataType> topicDataType = std::make_shared<RawTopicDataType>(name, maximumDataSize, hasKey);
    Domain::registerType(part, topicDataType.get());
    registeredTypes.push_back(topicDataType);
}

void NativeParticipantImpl::MyParticipantListener::onParticipantDiscovery(Participant *participant, ParticipantDiscoveryInfo &&info)
{
    if(this->mp_participantimpl->listener!=nullptr)
    {
        const ParticipantProxyData& proxy_data = info.info;

        logInfo(PARTICIPANT,"Remote participant Guid: " << rtpsinfo.m_guid);
        GuidUnion retGuid;
        CommonFunctions::guidcpy(proxy_data.m_guid, &retGuid);

        this->mp_participantimpl->listener->onParticipantDiscovery((int64_t)&proxy_data, retGuid.primitive.high, retGuid.primitive.low, info.status);
    }
}


std::string NativeParticipantListener::getName(int64_t infoPtr)
{
    return ((ParticipantProxyData*) infoPtr)->m_participantName.to_string();
}
