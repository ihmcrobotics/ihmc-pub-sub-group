# IHMC Eggplant

This library implements a Java Pub/Sub API for the RTPS protocol. It also provides a IDL code generator and serializer/deserializer. This allows interoperability with DDS networks.

The API is designed to avoid allocating memory except during initialization. 

## Pub/Sub API

The Pub/Sub API is based on the eProsima Fast-RTPS C++ Api. The API is decoupled from the implementation, allowing multiple implementations. Currently only Fast-RTPS is provided as a backend.

## IDL code generator
The code generator is built on top of the eProsima IDL-Parser and creates pure Java classes. Serialization and deserialization methods are provided. This allows creating new IDL structures without having to compile the underlying C++ library.
 
### Limitations
- Sequences of Arrays are not supported.
- Long Doubles are not supported due to limitations in the Java language
- Union, alias, value, sparse, set and map are not implemented
- Interfaces are not supported
