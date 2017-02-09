#include "nativeparticipantimpl.h"

NativeParticipantImpl::NativeParticipantImpl(RTPSParticipantAttributes& rtps, NativeParticipantListener* listener) throw(FastRTPSException) :
    listener(listener),
    m_rtps_listener(this)
{
    part = RTPSDomain::createParticipant(rtps, &m_rtps_listener);

    if(part == nullptr)
    {
        throw FastRTPSException("Problem creating RTPSParticipant");
    }
    CommonFunctions::guidcpy(part->getGuid(), &guid);

}

NativeParticipantImpl::~NativeParticipantImpl()
{
    RTPSDomain::removeRTPSParticipant(part);
}

int64_t NativeParticipantImpl::getGuidLow()
{
    return guid.primitive.low;
}

int64_t NativeParticipantImpl::getGuidHigh()
{
    return guid.primitive.high;
}

RTPSParticipant* NativeParticipantImpl::getParticipant()
{
    return part;
}

void NativeParticipantImpl::MyRTPSParticipantListener::onRTPSParticipantDiscovery(RTPSParticipant* part, RTPSParticipantDiscoveryInfo rtpsinfo)
{
    if(this->mp_participantimpl->listener!=nullptr)
    {
        GuidUnion retGuid;
        CommonFunctions::guidcpy(rtpsinfo.m_guid, &retGuid);

        this->mp_participantimpl->listener->onParticipantDiscovery((int64_t)&rtpsinfo, retGuid.primitive.high, retGuid.primitive.low, rtpsinfo.m_status);
    }
}


std::string NativeParticipantListener::getName(int64_t infoPtr)
{
    return ((RTPSParticipantDiscoveryInfo*) infoPtr)->m_RTPSParticipantName;
}


