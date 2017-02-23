# IHMC Pub/Sub

This library implements a Java Pub/Sub API for the RTPS protocol. RTPS is the interoperability wire protocol for DDS. This library also implements serialization methods for the 
Common Data Representation (CDR) format, allowing interoperability with DDS domains. IHMC Pub/Sub generator can be used to generate a Java implementation from OMG DDS IDL formatted files.

The API is designed to avoid allocating memory except during initialization. 

## Pub/Sub API

The Pub/Sub API is based on the eProsima Fast-RTPS C++ Api. The API is decoupled from the implementation, allowing multiple implementations. Currently only Fast-RTPS is provided as a backend.


