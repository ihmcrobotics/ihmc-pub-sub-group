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
    %template(stringVector) vector<std::string>;
}



%array_functions(unsigned char, octetArray)



// Support for RTPSParticipantAttribuges
namespace eprosima{
namespace fastrtps{
namespace rtps{
    %ignore LocatorList_t::begin;
    %ignore LocatorList_t::end;
    %ignore RTPSParticipantAttributes::throughputController;
    %ignore RTPSParticipantAttributes::userTransports;

    %ignore ThroughputController::mAssociatedParticipant;
    %ignore ThroughputController::mAssociatedWriter;

    %ignore Locator_t::Locator_t(const Locator_t& loc);
    %ignore LocatorList_t::LocatorList_t(const LocatorList_t& list);

    %ignore ThroughputController;
    %ignore FlowController;
    %ignore RemoteReaderAttributes::guid;
    %ignore GUID_t;
}
    %ignore TopicAttributes::getTopicKind;
    %ignore TopicAttributes::getTopicName;
    %ignore TopicAttributes::getTopicDataType;

}}

%ignore operator=;
%ignore operator==;
%ignore operator<<;



%{
#include <fastrtps/rtps/common/Locator.h>
#include <fastrtps/rtps/common/Time_t.h>
#include <fastrtps/rtps/flowcontrol/ThroughputController.h>
#include <fastrtps/rtps/attributes/RTPSParticipantAttributes.h>


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


// Support for PublisherAttributes
%{
#include <fastrtps/attributes/PublisherAttributes.h>
%}

//!Reliability enum used for internal purposes
//!@ingroup COMMON_MODULE
typedef enum ReliabilityKind_t{
    RELIABLE,
    BEST_EFFORT
}ReliabilityKind_t;

//!Durability kind
//!@ingroup COMMON_MODULE
typedef enum DurabilityKind_t
{
    VOLATILE,
    TRANSIENT_LOCAL
}DurabilityKind_t;

//!Endpoint kind
//!@ingroup COMMON_MODULE
typedef enum EndpointKind_t{
    READER,
    WRITER
}EndpointKind_t;

//!Topic kind
typedef enum TopicKind_t{
    NO_KEY,
    WITH_KEY
}TopicKind_t;


enum ChangeKind_t{
    ALIVE,                //!< ALIVE
    NOT_ALIVE_DISPOSED,   //!< NOT_ALIVE_DISPOSED
    NOT_ALIVE_UNREGISTERED,//!< NOT_ALIVE_UNREGISTERED
    NOT_ALIVE_DISPOSED_UNREGISTERED //!<NOT_ALIVE_DISPOSED_UNREGISTERED
};

enum MatchingStatus{
MATCHED_MATCHING,//!< MATCHED_MATCHING, new publisher/subscriber found
REMOVED_MATCHING //!< REMOVED_MATCHING, publisher/subscriber removed

};

%include <fastrtps/rtps/flowcontrol/FlowController.h>
%include <fastrtps/rtps/flowcontrol/ThroughputController.h>
%include <fastrtps/qos/QosPolicies.h>
%include <fastrtps/qos/WriterQos.h>
%include <fastrtps/rtps/resources/ResourceManagement.h>
%include <fastrtps/attributes/TopicAttributes.h>
%include <fastrtps/rtps/attributes/EndpointAttributes.h>
%include <fastrtps/rtps/attributes/WriterAttributes.h>
%include <fastrtps/attributes/PublisherAttributes.h>


%typemap(throws, throws="java.io.IOException") FastRTPSException {
  jclass excep = jenv->FindClass("java/io/IOException");
  if (excep)
    jenv->ThrowNew(excep, $1.what());
  return $null;
}

%feature("director") NativeParticipantListener;
%feature("director") NativePublisherListener;


%ignore NativeParticipantImpl::getParticipant;
%ignore NativePublisherImpl::getGuid();
%ignore NativePublisherImpl::getTopicKind;
%{
#include "nativeparticipantimpl.h"
#include "nativepublisherimpl.h"
#include "loglevel.h"
%}

%include "nativeparticipantimpl.h"
%include "nativepublisherimpl.h"
%include "loglevel.h"


