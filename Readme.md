# IHMC Eggplant

This library implements a Java Pub/Sub API for the RTPS protocol. It also provides a IDL code generator and serializer/deserializer. This allows interoperability with DDS networks.

The API is designed to avoid allocating memory except during initialization. 

## Pub/Sub API

The Pub/Sub API is based on the eProsima Fast-RTPS C++ Api. The API is decoupled from the implementation, allowing multiple implementations. Currently only Fast-RTPS is provided as a backend.

## IDL code generator
The code generator is built on top of the eProsima IDL-Parser and creates pure Java classes. Serialization and deserialization methods are provided. This allows creating new IDL structures without having to compile the underlying C++ library.

### Usage
Run us.ihmc.idl.generator.IDLGenerator. There are three options for generating IDL files

- No command line arguments: Dialogs will popup to select the IDL file and provide a target directory and package name.
- Command line arguments: us.ihmc.idl.generator.IDLGenerator \[idl filename\] \[package\] \[target directory\] 
- Call directly from Java: us.ihmc.idl.generator.IDLGenerator.execute(String idlFilename, String packageName, File targetDirectory)


### Features
- Pure Java serialization/deserialization. Allows message generation without having to compile native libraries.
- Allocation free during serialization/deserialization. All elements of the message are preallocated. 
- StringBuilder instead of string allow allocation free string deserialzation.
- Support for wchar and wstring to map directly to Java's UTF-16.
- Automatically generated equals() and toString() methods for testing and debugging.
 
### Limitations
- Sequences of arrays and arrays of sequences are not supported.
- Long Doubles are not supported due to limitations in the Java language.
- Union, alias, value, sparse, set and map are not implemented.
- Interfaces are not implemented.

### Compatibility notes
- FastRTPS's fastrtpsgen does not seem to support wstring and Sequence<Enum>
