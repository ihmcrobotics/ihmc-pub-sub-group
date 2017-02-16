cmake_minimum_required(VERSION 3.1)
project(IHMCJavaRTPS)

set(CMAKE_MODULE_PATH ${CMAKE_MODULE_PATH} "${CMAKE_SOURCE_DIR}/cmake/Modules/")
set(CMAKE_BUILD_TYPE RelWithDebInfo)


set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

IF(CMAKE_INSTALL_PREFIX_INITIALIZED_TO_DEFAULT)
  SET(CMAKE_INSTALL_PREFIX
    ${CMAKE_SOURCE_DIR} CACHE PATH "IHMCJavaRTPS install prefix" FORCE
    )
ENDIF(CMAKE_INSTALL_PREFIX_INITIALIZED_TO_DEFAULT)


find_package(JNI REQUIRED)



add_subdirectory(cppsrc/FastRTPS)
add_subdirectory(swig/FastRTPS)
add_subdirectory(cppsrc/test)

