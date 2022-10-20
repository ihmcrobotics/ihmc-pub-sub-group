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
#include "nativepublisherimpl.h"
#include "rawtopicdatatype.h"

using namespace eprosima::fastrtps::rtps;
using namespace us::ihmc::rtps::impl::fastDDS;

NativePublisherImpl::NativePublisherImpl(
        NativeParticipantImpl *participant,
        NativePublisherListener *listener) throw(FastDDSException) :
        participant(participant->getParticipant()),
        publisherListener(this),
        listener(listener)
{}

NativePublisherImpl::~NativePublisherImpl()
{
    participant->delete_publisher(publisher);
}

bool NativePublisherImpl::createPublisher()
{
    if (!isXMLPofile) {
        try
        {
            publisher = participant->create_publisher(attr, &publisherListener);
            writer = publisher->create_datawriter(attr)
            // publisher = Domain::createPublisher(fastrtpsParticipant, attr, &publisherListener);
        }
        catch (const std::exception &e)
        {
            return false;
        }
    }
    if (publisher == nullptr)
    {
        return false;
    }

    CommonFunctions::guidcpy(publisher->get_participant()->guid(), &guid);

    logInfo(PUBLISHER, "Guid: " << publisher->get_participant()->guid());
    return true;
}

bool NativePublisherImpl::createPublisher(std::string publisherProfile,
                                          const char *XMLConfigData,
                                          size_t XMLdataLength)
{
    try
    {
        // TODO: is this needed?
        // Domain::loadXMLProfilesString(XMLConfigData, XMLdataLength);
        participant->create_publisher_with_profile(publisherProfile, &publisherListener);
    }
    catch (const std::exception &e)
    {
        return false;
    }
    if (publisher == nullptr)
    {
        return false;
    }

    CommonFunctions::guidcpy(publisher->get_participant()->guid(), &guid);

    logInfo(PUBLISHER, "Guid: " << publisher->get_participant()->guid());
    return true;
}

void NativePublisherImpl::write(unsigned char *data, int32_t dataLength, int16_t encapsulation, unsigned char* key, int32_t keyLength)
{
    RawDataWrapper dataWrapper(data, dataLength, (uint16_t)encapsulation, key, keyLength);

    if (writer->write(&dataWrapper) != ReturnCode_t::RETCODE_OK)
    {
        std::cerr << "[nativepublisherimpl.cpp] In function write(): Cannot write data" << std::endl;
    }
}

void NativePublisherImpl::dispose(unsigned char *data, int32_t dataLength, int16_t encapsulation, unsigned char* key, int32_t keyLength)
{
    RawDataWrapper dataWrapper(data, dataLength, (uint16_t)encapsulation, key, keyLength);

    if (writer->dispose(&dataWrapper, c_InstanceHandle_Unknown) != ReturnCode_t::RETCODE_OK)
    {
        std::cerr << "[nativepublisherimpl.cpp] In function dispose(): Cannot dispose data" << std::endl;
    }
}

void NativePublisherImpl::unregister(unsigned char *data, int32_t dataLength, int16_t encapsulation, unsigned char *key, int32_t keyLength)
{
    RawDataWrapper dataWrapper(data, dataLength, (uint16_t)encapsulation, key, keyLength);

    if (writer->unregister_instance(&dataWrapper, c_InstanceHandle_Unknown) != ReturnCode_t::RETCODE_OK)
    {
        std::cerr << "[nativepublisherimpl.cpp] In function unregister(): Cannot unregister data" << std::endl;
    }
}

void NativePublisherImpl::dispose_and_unregister(unsigned char *data, int32_t dataLength, int16_t encapsulation, unsigned char *key, int32_t keyLength)
{
    unregister(data, dataLength, encapsulation, key, keyLength);
    dispose(data, dataLength, encapsulation, key, keyLength);
}

int32_t NativePublisherImpl::removeAllChange()
{
    size_t retVal;

    if (writer->clear_history(&retVal) == ReturnCode_t::RETCODE_OK)
    {
        return retVal;
    }
    else
    {
        return -1;
    }
}

bool NativePublisherImpl::wait_for_all_acked(const eprosima::fastrtps::Duration_t &max_wait)
{
    return publisher->wait_for_acknowledgments(max_wait) != ReturnCode_t::RETCODE_OK;
}

int64_t NativePublisherImpl::getGuidLow()
{
    return guid.primitive.low;
}

int64_t NativePublisherImpl::getGuidHigh()
{
    return guid.primitive.high;
}

const GUID_t& NativePublisherImpl::getGuid()
{
    return participant->guid();
}

void NativePublisherImpl::PublisherWriterListener::onPublicationMatched(Publisher *publisher, MatchingInfo &info)
{
    logInfo(PUBLISHER, "Remote reader Guid: " << info.remoteEndpointGuid);
    GuidUnion retGuid;
    CommonFunctions::guidcpy(info.remoteEndpointGuid, &retGuid);
    publisherImpl->listener->onWriterMatched(info.status, retGuid.primitive.high, retGuid.primitive.low);
}
