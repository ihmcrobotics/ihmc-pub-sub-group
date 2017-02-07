#ifndef NATIVEPARTICIPANTIMPL_H
#define NATIVEPARTICIPANTIMPL_H

#include <fastrtps/rtps/attributes/RTPSParticipantAttributes.h>
#include <fastrtps/rtps/participant/RTPSParticipantListener.h>
#include <fastrtps/rtps/participant/RTPSParticipant.h>
#include <fastrtps/rtps/RTPSDomain.h>

#include "fastrtpsexception.h"


using namespace eprosima::fastrtps::rtps;


class NativeParticipantListener
{
    public:
        virtual void onParticipantDiscovery() {}
};

class NativeParticipantImpl
{
public:
    NativeParticipantImpl(RTPSParticipantAttributes& rtps, NativeParticipantListener* listener) throw(FastRTPSException);
    void getGuid(octet* ret);

private:
    RTPSParticipant* part;
    NativeParticipantListener* listener;
    octet guid[GuidPrefix_t::size + EntityId_t::size];

    class MyRTPSParticipantListener : public RTPSParticipantListener
    {
        public:
            MyRTPSParticipantListener(NativeParticipantImpl* impl): mp_participantimpl(impl){};
            virtual ~MyRTPSParticipantListener(){};
            void onRTPSParticipantDiscovery(RTPSParticipant* part, RTPSParticipantDiscoveryInfo info);
            NativeParticipantImpl* mp_participantimpl;
    } m_rtps_listener;

};

#endif // NATIVEPARTICIPANTIMPL_H
