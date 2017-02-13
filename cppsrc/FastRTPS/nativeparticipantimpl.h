#ifndef NATIVEPARTICIPANTIMPL_H
#define NATIVEPARTICIPANTIMPL_H

#include <fastrtps/rtps/attributes/RTPSParticipantAttributes.h>
#include <fastrtps/rtps/participant/RTPSParticipantListener.h>
#include <fastrtps/rtps/participant/RTPSParticipant.h>
#include <fastrtps/rtps/RTPSDomain.h>

#include "fastrtpsexception.h"
#include "commonfunctions.h"


using namespace eprosima::fastrtps::rtps;

namespace us{
namespace ihmc{
namespace rtps{
namespace impl{
namespace fastRTPS{

    class NativeParticipantListener
    {
    public:
        virtual void onParticipantDiscovery(int64_t infoPtr, int64_t guidHigh, int64_t guidLow, DISCOVERY_STATUS status) {}
        std::string getName(int64_t infoPtr);
        virtual ~NativeParticipantListener() {}
    };

    class NativeParticipantImpl
    {
    public:
        NativeParticipantImpl(RTPSParticipantAttributes& rtps, NativeParticipantListener* listener) throw(FastRTPSException);
        int64_t getGuidLow();
        int64_t getGuidHigh();
        RTPSParticipant* getParticipant();
        virtual ~NativeParticipantImpl();

    private:
        RTPSParticipant* part;
        NativeParticipantListener* listener;
        GuidUnion guid;

        class MyRTPSParticipantListener : public RTPSParticipantListener
        {
            public:
                MyRTPSParticipantListener(NativeParticipantImpl* impl): mp_participantimpl(impl){}
                virtual ~MyRTPSParticipantListener(){}
                void onRTPSParticipantDiscovery(RTPSParticipant* part, RTPSParticipantDiscoveryInfo info);
                NativeParticipantImpl* mp_participantimpl;
        } m_rtps_listener;



    };

}}}}}
#endif // NATIVEPARTICIPANTIMPL_H
