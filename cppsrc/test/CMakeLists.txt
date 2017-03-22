cmake_minimum_required(VERSION 3.1)
project(IHMCJavaRTPS)

add_executable(SerializationTest IDLElementTest IDLElementTestPubSubTypes idlelementserializetest)
target_link_libraries(SerializationTest fastcdr fastrtps)


