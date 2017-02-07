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

    GUID_t rtps_guid = part->getGuid();

    for(int g_c = 0; g_c < GuidPrefix_t::size; g_c++)
    {
        guid[g_c] = rtps_guid.guidPrefix.value[g_c];
    }

    for(int g_c = 0; g_c < EntityId_t::size; g_c++)
    {
        guid[g_c] = rtps_guid.guidPrefix.value[GuidPrefix_t::size + g_c];
    }

}


void NativeParticipantImpl::getGuid(octet* ret)
{
    memcpy(ret, guid, GuidPrefix_t::size + EntityId_t::size);
}


void NativeParticipantImpl::MyRTPSParticipantListener::onRTPSParticipantDiscovery(RTPSParticipant* part,RTPSParticipantDiscoveryInfo rtpsinfo)
{
    if(this->mp_participantimpl->listener!=nullptr)
    {
        this->mp_participantimpl->listener->onParticipantDiscovery();
    }
}
