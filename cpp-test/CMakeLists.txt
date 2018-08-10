cmake_minimum_required(VERSION 3.1)
project(ihmc-pub-sub-cpp-test)

find_package(ihmc-pub-sub-cpp REQUIRED)

add_executable(SerializationTest IDLElementTest IDLElementTestPubSubTypes NestedElement idlelementserializetest)
target_link_libraries(SerializationTest ${FastRTPS_LIBRARIES})


