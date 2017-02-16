cmake_minimum_required(VERSION 3.1)
project(IHMCJavaRTPS)

find_package(Boost REQUIRED COMPONENTS system thread date_time)

add_executable(SerializationTest IDLElementTest IDLElementTestPubSubTypes idlelementserializetest)
target_link_libraries(SerializationTest ${Boost_LIBRARIES} fastcdr fastrtps)


