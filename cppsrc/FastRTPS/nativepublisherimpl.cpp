#include "nativepublisherimpl.h"
#include "commonfunctions.h"
#include <fastrtps/rtps/RTPSDomain.h>
#include <fastrtps/log/Log.h>

using namespace eprosima::fastrtps::rtps;
using namespace us::ihmc::rtps::impl::fastRTPS;

NativePublisherImpl::NativePublisherImpl(
        int32_t entityId,
        int32_t userDefinedID,
        int32_t maximumPayloadSize,
        MemoryManagementPolicy_t memoryManagementPolicy,
        TopicAttributes* topic,
        WriterQos* qos,
        WriterTimes* times,
        LocatorList_t* unicastLocatorList,
        LocatorList_t* multicastLocatorList,
        LocatorList_t* outLocatorList,
        ThroughputControllerDescriptor* throughputController,
        NativeParticipantImpl* participant,
        NativePublisherListener* listener) throw(FastRTPSException) :
        throughputController(throughputController),
        rtpsParticipant(participant->getParticipant()),
        writerListener(this),
        publisherhistory(this, maximumPayloadSize, topic->historyQos, topic->resourceLimitsQos, memoryManagementPolicy),
        topicKind(topic->topicKind),
        publishModeKind(qos->m_publishMode.kind),
        historyQosKind(topic->historyQos.kind),
        high_mark_for_frag_(0),
        listener(listener)
{
    WriterAttributes watt;
    watt.throughputController = *throughputController;
    watt.endpoint.durabilityKind = qos->m_durability.kind == VOLATILE_DURABILITY_QOS ? VOLATILE : TRANSIENT_LOCAL;
    watt.endpoint.endpointKind = WRITER;
    watt.endpoint.multicastLocatorList = *multicastLocatorList;
    watt.endpoint.reliabilityKind = qos->m_reliability.kind == RELIABLE_RELIABILITY_QOS ? RELIABLE : BEST_EFFORT;
    watt.endpoint.topicKind = topic->topicKind;
    watt.endpoint.unicastLocatorList = *unicastLocatorList;
    watt.endpoint.outLocatorList = *outLocatorList;
    watt.mode = qos->m_publishMode.kind == eprosima::fastrtps::SYNCHRONOUS_PUBLISH_MODE ? SYNCHRONOUS_WRITER : ASYNCHRONOUS_WRITER;
    if(entityId>0)
        watt.endpoint.setEntityID((uint8_t)entityId);
    if(userDefinedID>0)
        watt.endpoint.setUserDefinedID((uint8_t)userDefinedID);
    watt.times = *times;

    mp_writer = RTPSDomain::createRTPSWriter(participant->getParticipant(), watt, &publisherhistory, &writerListener);
    CommonFunctions::guidcpy(mp_writer->getGuid(), &guid);
    this->rtpsParticipant->registerWriter(mp_writer,*topic,*qos);

    logInfo(PUBLISHER, "Guid: " << mp_writer->getGuid());

}

NativePublisherImpl::~NativePublisherImpl()
{
    RTPSDomain::removeRTPSWriter(mp_writer);
}

int64_t NativePublisherImpl::getGuidLow()
{
    return guid.primitive.low;
}

int64_t NativePublisherImpl::getGuidHigh()
{
    return guid.primitive.high;
}

TopicKind_t NativePublisherImpl::getTopicKind()
{
    return topicKind;
}

const GUID_t& NativePublisherImpl::getGuid()
{
    return mp_writer->getGuid();
}

int32_t NativePublisherImpl::removeAllChange()
{
    size_t removed;

    if(publisherhistory.removeAllChange(&removed))
    {
        return removed;
    }
    else
    {
        return -1;
    }
}

bool NativePublisherImpl::wait_for_all_acked(const Time_t& max_wait)
{
    return mp_writer->wait_for_all_acked(max_wait);
}

bool NativePublisherImpl::clean_history(unsigned int max)
{
    if(historyQosKind == HistoryQosPolicyKind::KEEP_ALL_HISTORY_QOS)
        return mp_writer->clean_history(max);
    else
        return mp_writer->remove_older_changes(max);
}

void NativePublisherImpl::create_new_change(ChangeKind_t changeKind, unsigned char* data, int32_t dataLength, int16_t encapsulation, octet* key) throw(FastRTPSException)
{
    if(changeKind == NOT_ALIVE_UNREGISTERED || changeKind == NOT_ALIVE_DISPOSED ||
            changeKind == NOT_ALIVE_DISPOSED_UNREGISTERED)
    {
        if(topicKind == NO_KEY)
        {
            throw FastRTPSException("Topic is NO_KEY, operation not permitted");
        }
    }
    InstanceHandle_t handle;
    if(topicKind == WITH_KEY)
    {
        memcpy(handle.value, key, 16);
    }

    CacheChange_t* ch = mp_writer->new_change([dataLength]() -> uint32_t {return (uint32_t)dataLength;} ,changeKind, handle);
    if(ch != nullptr)
    {
        if(changeKind == ALIVE)
        {
            if(dataLength > ch->serializedPayload.max_size)
            {
                publisherhistory.release_Cache(ch);
                throw FastRTPSException("Data length is larger than maximum data length for this topic");
            }

            ch->serializedPayload.encapsulation = (uint16_t) encapsulation;
            ch->serializedPayload.length = dataLength;
            memcpy(ch->serializedPayload.data, data, dataLength);
        }

        if(high_mark_for_frag_ == 0)
        {
            high_mark_for_frag_ = rtpsParticipant->getMaxMessageSize() > throughputController->bytesPerPeriod ? throughputController->bytesPerPeriod :
                rtpsParticipant->getMaxMessageSize();
            if(high_mark_for_frag_ > rtpsParticipant->getRTPSParticipantAttributes().throughputController.bytesPerPeriod)
                high_mark_for_frag_ = rtpsParticipant->getRTPSParticipantAttributes().throughputController.bytesPerPeriod;
            if(high_mark_for_frag_ > RTPSMESSAGE_COMMON_RTPS_PAYLOAD_SIZE)
                high_mark_for_frag_ -= RTPSMESSAGE_COMMON_RTPS_PAYLOAD_SIZE;
        }

        if(ch->serializedPayload.length > high_mark_for_frag_)
        {
            // Check ASYNCHRONOUS_PUBLISH_MODE is being used, but it is an error case.
            if( publishModeKind != ASYNCHRONOUS_PUBLISH_MODE)
            {
                publisherhistory.release_Cache(ch);
                throw FastRTPSException("Data cannot be sent. It's serialized size exceeds the maximum payload size and therefore ASYNCHRONOUS_PUBLISH_MODE must be used.");
            }

            /// Fragment the data.
            // Set the fragment size to the cachechange.
            // Note: high_mark will always be a value that can be casted to uint16_t)
            ch->setFragmentSize((uint16_t)high_mark_for_frag_);
        }

        if(!this->publisherhistory.add_pub_change(ch))
        {
            publisherhistory.release_Cache(ch);
            throw FastRTPSException("Cannot add change to history");
        }
    }
    else
    {
        throw FastRTPSException("Cannot create change");
    }
}

void NativePublisherImpl::PublisherWriterListener::onWriterMatched(RTPSWriter *writer, MatchingInfo &info)
{
    logInfo(PUBLISHER, "Remote reader Guid: " << info.remoteEndpointGuid);
    GuidUnion retGuid;
    CommonFunctions::guidcpy(info.remoteEndpointGuid, &retGuid);
    publisherImpl->listener->onWriterMatched(info.status, retGuid.primitive.high, retGuid.primitive.low);
}
