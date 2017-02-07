%module(directors="1") FastRTPS
%javaconst(1);
%include "typemaps.i"
%include "various.i"
%include "stdint.i"
%include "std_string.i"
%include "std_vector.i"
%include "carrays.i"


%apply unsigned char *NIOBUFFER { unsigned char* };

namespace std {
    %template(octetVector) vector<unsigned char>;
}


namespace eprosima{
namespace fastrtps{
namespace rtps{
    %ignore LocatorList_t::begin;
    %ignore LocatorList_t::end;
    %ignore RTPSParticipantAttributes::throughputController;
    %ignore RTPSParticipantAttributes::userTransports;
}}}


%array_functions(unsigned char, octetArray)

%typemap(throws, throws="java.io.IOException") FastRTPSException {
  jclass excep = jenv->FindClass("java/io/IOException");
  if (excep)
    jenv->ThrowNew(excep, $1.what());
  return $null;
}

%feature("director") NativeParticipantListener;


%{
#include <fastrtps/rtps/common/Locator.h>
#include <fastrtps/rtps/common/Time_t.h>
#include <fastrtps/rtps/flowcontrol/ThroughputController.h>
#include <fastrtps/rtps/attributes/RTPSParticipantAttributes.h>

#include "nativeparticipantimpl.h"

%}

#define DOXYGEN_SHOULD_SKIP_THIS_PUBLIC Y
#define RTPS_DllAPI
typedef unsigned char octet;


struct Time_t{
    //!Seconds
    int32_t seconds;
    //!Fraction of second (1 fraction = 1/(2^32) seconds)
    uint32_t fraction;
    //! Default constructor. Sets values to zero.
    Time_t();
    /**
    * @param sec Seconds
    * @param frac Fraction of second
    */
    Time_t(int32_t sec,uint32_t frac);

};
typedef Time_t Duration_t;

enum  DISCOVERY_STATUS
{
    DISCOVERED_RTPSPARTICIPANT,
    CHANGED_QOS_RTPSPARTICIPANT,
    REMOVED_RTPSPARTICIPANT
};


%include <fastrtps/rtps/common/Locator.h>
%include <fastrtps/rtps/attributes/RTPSParticipantAttributes.h>

%include "nativeparticipantimpl.h"



