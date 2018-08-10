cmake_minimum_required(VERSION 3.1)
project(pub-sub-cpp-test)

find_package(pub-sub-cpp-extension REQUIRED)

add_executable(SerializationTest IDLElementTest IDLElementTestPubSubTypes NestedElement idlelementserializetest)
target_link_libraries(SerializationTest ${FastRTPS_LIBRARIES})


