cmake_minimum_required(VERSION 3.1)
project(ihmc-pub-sub-cpp)

#set(CMAKE_MODULE_PATH ${CMAKE_MODULE_PATH} "${CMAKE_SOURCE_DIR}/cmake/Modules/")
set(CMAKE_BUILD_TYPE RelWithDebInfo)

set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

#IF(CMAKE_INSTALL_PREFIX_INITIALIZED_TO_DEFAULT)
#  SET(CMAKE_INSTALL_PREFIX
#    ${CMAKE_SOURCE_DIR} CACHE PATH "IHMC Pub Sub install prefix" FORCE
#    )
#ENDIF(CMAKE_INSTALL_PREFIX_INITIALIZED_TO_DEFAULT)

find_package(JNI REQUIRED)
INCLUDE_DIRECTORIES(${JNI_INCLUDE_DIRS})

find_package(fastrtps REQUIRED)
find_package(fastcdr REQUIRED)
find_package(tinyxml2 REQUIRED)

IF(WIN32)
	set(fastrtps_LIBRARIES libfastrtps-1.5 Iphlpapi Shlwapi)
ELSE()
	set(fastrtps_LIBRARIES fastrtps)
ENDIF()

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
