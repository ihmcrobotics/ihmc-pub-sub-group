#include "nativeparticipantimpl.h"
#include "commonfunctions.h"

NativeParticipantImpl::NativeParticipantImpl(RTPSParticipantAttributes& rtps, NativeParticipantListener* listener) throw(FastRTPSException) :
    listener(listener),
    m_rtps_listener(this)
{
    part = RTPSDomain::createParticipant(rtps, &m_rtps_listener);

    if(part == nullptr)
    {
        throw FastRTPSException("Problem creating RTPSParticipant");
    }
    CommonFunctions::guidcpy(part->getGuid(), guid);

}

NativeParticipantImpl::~NativeParticipantImpl()
{
    RTPSDomain::removeRTPSParticipant(part);
}

void NativeParticipantImpl::getGuid(octet* ret)
{
    memcpy(ret, guid, GuidPrefix_t::size + EntityId_t::size);
}


void NativeParticipantImpl::MyRTPSParticipantListener::onRTPSParticipantDiscovery(RTPSParticipant* part, RTPSParticipantDiscoveryInfo rtpsinfo)
{
    if(this->mp_participantimpl->listener!=nullptr)
    {
        this->mp_participantimpl->listener->onParticipantDiscovery((int64_t)&rtpsinfo, rtpsinfo.m_status);
    }
}

void NativeParticipantListener::getGuid(int64_t infoPtr, octet* ret)
{
    CommonFunctions::guidcpy(((RTPSParticipantDiscoveryInfo*) infoPtr)->m_guid, ret);
}


std::string NativeParticipantListener::getName(int64_t infoPtr)
{
    return ((RTPSParticipantDiscoveryInfo*) infoPtr)->m_RTPSParticipantName;
}


