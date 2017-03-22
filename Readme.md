# IHMC Pub/Sub

This library implements a Java Pub/Sub API for the RTPS protocol. RTPS is the interoperability wire protocol for DDS. This library also implements serialization methods for the 
Common Data Representation (CDR) format, allowing interoperability with DDS domains. IHMC Pub/Sub generator can be used to generate a Java implementation from OMG DDS IDL formatted files.

The API is designed to avoid allocating memory except during initialization. 

## Pub/Sub API

The Pub/Sub API is based on the eProsima Fast-RTPS C++ Api. The API is decoupled from the implementation, allowing multiple implementations. Currently only Fast-RTPS is provided as a backend.

## Native code Compilation

This step is optional, the native libraries have been included in the source code repository.

Prerequisites
- Install FastRTPS using the README.md found on https://github.com/eProsima/Fast-RTPS. Use -DCMAKE_BUILD_TYPE=Debug if you want to enable info level debug. 
	- Current libraries are compiled with commit ad59a6c
- Set the environment variable FASTRTPSHOME to point to your FastRTPS installation prefix

### Linux
```
mkdir build
cd build
cmake ..
make 
make install
```



