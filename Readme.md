# IHMC Pub Sub

Allocation free Java libraries for DDSI-RTPS messaging using eProsima's Fast-RTPS.

## Features

- Allocation free Publisher and Subscriber API in Java
- Java data type generator for Object Management Group (OMG) IDL files (*.idl)
- Serialize messages to JSON, BSON, YAML, Java Properties, and XML
- Gradle plugin to generate Java types from IDL files

The eProsima Fast RTPS documentation can be useful as a reference guide on more advanced features and the inner working of the RTPS layer [http://eprosima-fast-rtps.readthedocs.io/en/latest/](http://eprosima-fast-rtps.readthedocs.io/en/latest/). 

#### Java type generator:

The IHMC Pub/Sub generator creates Java classes from OMG DDS IDL formatted files. The resulting classes can be used in conjunction with [IHMC Pub/Sub](https://github.com/ihmcrobotics/ihmc-pub-sub) to serialize and deserialize to the Common Data Representation(CDR) format.

##### Features
- Pure Java serialization/deserialization. Allows message generation without having to compile native libraries.
- Allocation free during serialization/deserialization. All elements of the message are preallocated. 
- StringBuilder instead of string allow allocation free string deserialzation.
- Support for wchar and wstring to map directly to Java's UTF-16.
- Automatically generated equals() and toString() methods for testing and debugging.
- Support for #include directives and other C preprocessor directives. The include search path is the current directory and the parent directory of the .idl file.
- Optional (using [IHMC pub/sub serializers extra](https://github.com/ihmcrobotics/ihmc-pub-sub) ) serialization and deserialization to JSON/BSON/YAML and XML.
- @Abstract(type="[fully qualified class name]") annotation to generate an abstract Pub/Sub type. This allows reusing exisiting Java data objects in combination with IDL specified data without marshalling. Use [Name]PubSubType.setImplementation() to implement.  
 
##### Limitations
- Sequences of arrays and arrays of sequences are not supported.
- Long Doubles are not supported due to limitations in the Java language.
- Union, alias, value, sparse, set and map are not implemented.
- Interfaces are not implemented.

##### Compatibility notes
- CDR Byte stream is validated against FastCDR generated byte stream.
- FastRTPS's fastrtpsgen does not seem to support wstring and Sequence\<Enum\>

#### Extra serializers:

The IHMC pub sub extra datatypes library provides support for serializing and deserialization of IDL datatypes to JSON, BSON, YAML, and XML.

This library uses Jackson internally. Unlike IHMC Pub Sub, the functionality in this library will allocate objects when used.

See [test/us/ihmc/idl/serializers/extra](ihmc-pub-sub-serializers-extra/src/test/java/us/ihmc/idl/serializers/extra) for examples as test cases.

## Maven artifact coordinates

`compile group: "us.ihmc", name: "ihmc-pub-sub", version: `
[ ![ihmc-pub-sub](https://maven-badges.herokuapp.com/maven-central/us.ihmc/ihmc-pub-sub/badge.svg?style=plastic) ](https://maven-badges.herokuapp.com/maven-central/us.ihmc/ihmc-pub-sub)
`  // IHMC Pub Sub RTPS library`

`compile group: "us.ihmc", name: "ihmc-pub-sub-generator", version: `
[ ![ihmc-pub-sub-generator](https://maven-badges.herokuapp.com/maven-central/us.ihmc/ihmc-pub-sub-generator/badge.svg?style=plastic) ](https://maven-badges.herokuapp.com/maven-central/us.ihmc/ihmc-pub-sub-generator)
`  // Generate java classes from .idl messages`

`compile group: "us.ihmc", name: "ihmc-pub-sub-serializers-extra", version: `
[ ![ihmc-pub-sub-serializers-extra](https://maven-badges.herokuapp.com/maven-central/us.ihmc/ihmc-pub-sub-serializers-extra/badge.svg?style=plastic) ](https://maven-badges.herokuapp.com/maven-central/us.ihmc/ihmc-pub-sub-serializers-extra)
`  // Serializers for JSON, BSON, YAML, Java Properties, and XML`

## Supported platforms

IHMC Pub Sub has a native component that is compiled for different operating systems

#### Linux

- Tested on Ubuntu 14.04, Ubuntu 16.04 and Ubuntu 17.04
- Requires a 64 bit Java 8 compatible JRE.
- Native library is compiled statically, should work on most distributions with a recent glibc

#### Windows 

- Tested on Windows 10
- Requires a 64 bit Java 8 compatible JRE.
- Requires Microsoft Visual C++ 2017 Redistributable (x64). [Download](https://go.microsoft.com/fwlink/?LinkId=746572)

#### Mac OSX

- Compiled and tested on Sierra

## User guide

### Generating Java code from .idl messages

Use the IDLGenerator to compile your .idl messages into [MessageType].java and [MessagePubSubType].java.

```java
FileTools.deleteQuietly(Paths.get("generated-java")); // remove old files

// Generate Java types for all (*.idl) files in `src/test/idl` and put them in `src/test/generated-java`
for (Path idl : Files.list(Paths.get("idl")).toArray(Path[]::new))
{
   IDLGenerator.execute(idl.toFile(), // *.idl file
                        "us.ihmc.idl.generated", // package prefix
                        Paths.get("generated-java").toFile(), // output directory
                        Arrays.asList(Paths.get("idl").toFile())); // include path
}
```

The IHMC Pub/Sub generator can either be used as a gradle plugin (recommended) or standalone library.

This creates a task to compile IDL files. The following properties can be set
- idlFiles: FileCollection of idl files to compile [Required]
- inludeDirs: FileCollection of include directories
- targetDirectory: File target directory

```
task generateIDL(type: us.ihmc.idl.generator.IDLGeneratorTask) {
	idlFiles = fileTree(dir: 'idl')
	includeDirs = files(".")
	targetDirectory = file("generated")
	packagePrefix = "us.ihmc.idl.generated"
}
```

### Java application
Run us.ihmc.idl.generator.IDLGenerator. There are three options for generating IDL files

- No command line arguments: Dialogs will popup to select the IDL file and provide a target directory and package name.
- Command line arguments: us.ihmc.idl.generator.IDLGenerator \[idl filename\] \[package\] \[target directory\] 
- Call directly from Java: us.ihmc.idl.generator.IDLGenerator.execute(String idlFilename, String packageName, File targetDirectory)

### Examples

Examples for a creating simple publisher and subscriber can also be found in [ihmc-pub-sub-generator/src/test/java/us/ihmc/pubsub/examples](ihmc-pub-sub-generator/src/test/java/us/ihmc/pubsub/examples).

#### Participant

A single participant is needed to join a domain. Multiple publisher/subscribers can be added to a participant.
```
Domain domain = DomainFactory.getDomain(PubSubImplementation.FAST_RTPS);
ParticipantAttributes attributes = domain.createParticipantAttributes([numeric domain ID], [participant name]);
Participant participant = domain.createParticipant(attributes);
```

#### Publisher 

```
TopicDataType dataType = // IHMC Pub/Sub generator generated PubSubType
PublisherAttributes publisherAttributes = domain.createPublisherAttributes(participant, dataType, [Topic name], ReliabilityKind.RELIABLE);           
Publisher publisher = domain.createPublisher(participant, publisherAttributes);

[Type] message = // IHMC Pub/Sub generator generated message
publisher.write(message);
```

#### Subscriber

```
private class SubscriberListenerImpl implements SubscriberListener
{
   private final [Type] message = // IHMC Pub/Sub generator generated message
   private final SampleInfo info = new SampleInfo();

   @Override
   public void onNewDataMessage(Subscriber subscriber)
   {
      if (subscriber.takeNextData(message, info))	// Note: No memory is allocated as the message is re-used. 
      {
         // Use data here
      }
   }

   @Override
   public void onSubscriptionMatched(Subscriber subscriber, MatchingInfo info)
   {
   }
}

TopicDataType dataType = // IHMC Pub/Sub generator generated PubSubType
SubscriberAttributes subscriberAttributes = domain.createSubscriberAttributes(participant, dataType, [Topic name], ReliabilityKind.BEST_EFFORT);
domain.createSubscriber(participant, subscriberAttributes, new SubscriberListenerImpl());      
```

## Developing

Make sure to build the java code using gradle to generate the java classes for the XML definitions.

## Building


### Java code compilation
```
ihmc-pub-sub-group $ gradle compositeTask -PtaskName=compileJava
```

### Native code Compilation

This section is for rebuilding the native side of the project.
Compiled binaries have already been included in the source code repository.
Therefore, this section is mainly for maintainers.

Fast-DDS and foonathan_memory_vendor are included as Git submodules. Update the submodules to make sure they are included:

```
git submodule update --init --recursive
```

#### Linux


##### Manually

###### Requirements:

- CMake 3.1 or later
- GNU C++
- Swig 3.0.8 or later
- OpenJDK 1.8

```
cd ihmc-pub-sub-group/ihmc-pub-sub
mkdir buildc
cd buildc
cmake -DCMAKE_BUILD_TYPE=Release -DSTANDALONE_PLUGIN=ON ..
make
make install/strip
```

Note: Replace /usr/lib/jvm/java-8-openjdk-amd64/ with your installation of the OpenJDK 8.

Make install copies the generated library in the resources folder. Two C++ test applications are provided, "SubscriberExample" and "PublisherExample". These are not installed but can be found in the cmake build folder under "cppsrc/FastRTPS/SubscriberExample" and "cppsrc/FastRTPS/PublisherExample".

Note: When debugging, set CMAKE_BUILD_TYPE to "Debug" and use "make install" instead of "make install/strip" to preserve debugging information.
Note: make with multiple thread (-j?) does not seem to work well. You have to run it multiple times because the swig plugin does not define dependencies in the right order.

##### Cross-Compiling

Install required compilers
```
sudo apt install qemu-user gcc-aarch64-linux-gnu binutils-aarch64-linux-gnu g++-aarch64-linux-gnu
```

And change the cmake command to
```
cmake -DSWIG_EXECUTABLE=/usr/bin/swig3.0 -DCMAKE_BUILD_TYPE=Release -DSTANDALONE_PLUGIN=ON -DCMAKE_TOOLCHAIN_FILE=../aarch64-toolchain.cmake ..
```


#### Windows

Note: Due to path length limitations, the commpilation can fail. If you did not setup long paths on windows, it is recommended to checkout in C:\ws and compile from there.

##### Requirements:

- CMake [https://cmake.org/download/](https://cmake.org/download/). Recommended edition: Windows win64-x64 installer. Make sure to add to your path.
- Visual Studio 2022 Community [https://www.visualstudio.com/downloads/](https://www.visualstudio.com/downloads/). 
	- Make sure to select "Desktop Development with C++" and select "C++ MFC for latest v147 build tools" under Optional.
	- Restart after installation and start visual studio (!)
- Swig: Version 3.0.12 or later (make sure to use version 3. 3.0.12 is recommended, as it is the same version as in Ubuntu 18.04)
	- Unpack in C:\swigwin-3.0.12 or modify later commands accordingly
- 64 bit Git for Windows  setup [https://git-scm.com/download/win](https://git-scm.com/download/win).
	- Make sure to have "Use Git from the Windows Command Prompt" selected so it gets added to your path.

##### Configuration and compilation:

Use CMake GUI to create the Visual Studio makefiles.
- Start the x64 Native Tools Command Prompt for VS 2019

```
cd [Source directory]\ihmc-pub-sub-group\ihmc-pub-sub
md buildc
cd buildc
"C:\Program Files\CMake\bin\cmake.exe" -G "Visual Studio 17 2022" -A x64 -DSWIG_EXECUTABLE="C:\swigwin-3.0.12\swig.exe"  -DSTANDALONE_PLUGIN=ON ..
"C:\Program Files\CMake\bin\cmake.exe" --build . --config Release --target install
```


Note: On Windows, only the Release configuration builds.


#### Mac OS X

Note: You can use macincloud.com to get a VM with a build setup

Requirements 
- XCode (run at least once to accept the license terms)
- CMake
- JDK 1.8+

#### Setup Java include path
echo export "JAVA_HOME=\$(/usr/libexec/java_home)" >> ~/.zshrc
echo export "JAVA_INCLUDE_PATH=$JAVA_HOME/include" >> ~/.zshrc

##### Installing Swig

Note: If you have brew installed, you can do brew install swig instead of compiling from source.


- Download swig swig-3.0.12.tar.gz from https://sourceforge.net/projects/swig/files/swig/swig-3.0.12/
- Unpack swig-3.0.12.tar.gz in ~/Downloads

```
cd ~/Downloads/swig-3.0.12
./configure --prefix=/Users/[username]/usr --without-pcre
make -j4
make install
```


#### Compiling ihmc-pub-sub


```
cd ihmc-pub-sub-group/ihmc-pub-sub
mkdir buildc
cd buildc
cmake -DSWIG_EXECUTABLE=/Users/[username]/usr/bin/swig -DCMAKE_BUILD_TYPE=Release -DSTANDALONE_PLUGIN=ON ..
make
make install
```

## Updating FastDDS

Several steps needs to be taken to update to the latest version of FastDDS. Mostly to do with fixing the version numbers in filenames.

- Edit [SOURCE_DIR]/ihmc-pub-sub/CMakeLists.txt, scroll down to ### UPDATE FASTDDS VERSIONS HERE ### and update the versions
- Build and update the native code on all platforms
- [SOURCE_DIR]/ihmc-pub-sub/src/main/java/us/ihmc/pubsub/impl/fastRTPS/FastRtpsNativeLibrary.java and update the getLibrariesWithDependencies(OperatingSystem os, Architecture arch) function


## License

The IHMC Pub/Sub library is licensed under the Apache 2.0. See LICENSE.txt
