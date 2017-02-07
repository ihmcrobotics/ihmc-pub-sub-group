cmake_minimum_required(VERSION 3.1)
project(IHMCJavaRTPS)

find_package(Boost REQUIRED COMPONENTS system thread date_time)

add_library(FastRTPSNativeImpl nativeparticipantimpl)
target_link_libraries(FastRTPSNativeImpl ${Boost_LIBRARIES} fastcdr fastrtps)


set_property(TARGET FastRTPSNativeImpl PROPERTY POSITION_INDEPENDENT_CODE TRUE)

