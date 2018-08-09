cmake_minimum_required(VERSION 3.1)
project(ihmc-pub-sub)

set(HEADER_FILES commonfunctions.h fastrtpsexception.h sampleinfomarshaller.h)
add_library(FastRTPSNativeImpl nativeparticipantimpl nativepublisherimpl nativesubscriberimpl rawtopicdatatype loglevel ${HEADER_FILES})
target_link_libraries(FastRTPSNativeImpl ${fastrtps_LIBRARIES})

add_executable(PublisherExample publisherexample)


add_executable(SubscriberExample subscriberexample)

if(WIN32)
target_link_libraries(PublisherExample FastRTPSNativeImpl ${fastrtps_LIBRARIES})
target_link_libraries(SubscriberExample FastRTPSNativeImpl ${fastrtps_LIBRARIES})

else()
target_link_libraries(PublisherExample FastRTPSNativeImpl ${fastrtps_LIBRARIES} pthread)
target_link_libraries(SubscriberExample FastRTPSNativeImpl ${fastrtps_LIBRARIES} pthread)
endif()

add_dependencies(FastRTPSNativeImpl fastrtps)

set_property(TARGET FastRTPSNativeImpl PROPERTY POSITION_INDEPENDENT_CODE TRUE)

