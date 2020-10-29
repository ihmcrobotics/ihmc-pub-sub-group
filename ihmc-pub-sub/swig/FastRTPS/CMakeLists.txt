cmake_minimum_required(VERSION 3.5)
project(ihmc-pub-sub)

cmake_policy(SET CMP0078 NEW)
cmake_policy(SET CMP0086 NEW)

include(FindSWIG REQUIRED)
message(STATUS "Using SWIG version ${SWIG_VERSION} at ${SWIG_DIR}")
include(UseSWIG)

include_directories("${CMAKE_CURRENT_SOURCE_DIR}/../../cppsrc/FastRTPS")

set_property(SOURCE FastRTPS.i PROPERTY CPLUSPLUS ON)
set_property(SOURCE FastRTPS.i PROPERTY SWIG_FLAGS "-package" "us.ihmc.rtps.impl.fastRTPS")

swig_add_library(FastRTPSWrapper
        LANGUAGE java
        OUTPUT_DIR "${CMAKE_CURRENT_SOURCE_DIR}/generated/us/ihmc/rtps/impl/fastRTPS"
        SOURCES FastRTPS.i
        )
add_dependencies(FastRTPSWrapper FastRTPSNativeImpl JDK)
swig_link_libraries(FastRTPSWrapper FastRTPSNativeImpl)

if(STANDALONE_PLUGIN)
    # Install in classpath
    message(STATUS "Installing FastRTPSWrapper to ${LIBRARY_RESOURCES_DIRECTORY}")
    install(TARGETS FastRTPSWrapper RUNTIME DESTINATION ${LIBRARY_RESOURCES_DIRECTORY} LIBRARY DESTINATION ${LIBRARY_RESOURCES_DIRECTORY})
else()
    # Install in library
    message(STATUS "Installing FastRTPSWrapper to bin and lib")
    install(TARGETS FastRTPSWrapper RUNTIME DESTINATION bin LIBRARY DESTINATION lib)
endif()
