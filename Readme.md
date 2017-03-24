# IHMC Pub/Sub

This library implements a Java Pub/Sub API for the RTPS protocol. RTPS is the interoperability wire protocol for DDS. This library also implements serialization methods for the 
Common Data Representation (CDR) format, allowing interoperability with DDS domains. The IHMC Pub/Sub generator can be used to generate a Java implementation from OMG DDS IDL formatted files.

The API is designed to avoid allocating memory except during initialization. 

## Toolchain
- [IHMC Pub/Sub](https://github.com/ihmcrobotics/ihmc-pub-sub): IHMC Pub/Sub RTPS library
- [IHMC Pub/Sub generator](https://github.com/ihmcrobotics/ihmc-pub-sub-generator): Gradle plugin and standalone application to generate java classes from .idl messages.
- [IHMC RTPS Visualizer](https://github.com/ihmcrobotics/ihmc-rtps-visualizer): GUI to display partitions, topics, participants, subscribers, publisher and publisher data on a RTPS domain.
- [IHMC Pub/Sub serializers extra](https://github.com/ihmcrobotics/ihmc-pub-sub-serializers-extra): Optional serializer to generated JSON, BSON, YAML, Java Properties and XML(limited) output from .idl messages. 

## License
The IHMC Pub/Sub library is licensed under the Apache 2.0. See LICENSE.txt

## Usage

## Generating Java code from .idl messages
Use the [IHMC Pub/Sub generator](https://github.com/ihmcrobotics/ihmc-pub-sub-generator) to compile your .idl messages into [MessageType].java and [MessagePubSubType].java.

### Gradle
Add the IHMC Pub Sub library as dependency
```
repositories {
    maven {
        url  "http://dl.bintray.com/ihmcrobotics/maven-release"
    }
}
	
dependencies {
	compile group: 'us.ihmc', name: 'IHMCPubSub', version: '0.2'
}
```

### Quick start

Examples for a simple publisher and subscriber can be found in src/us/ihmc/pubsub/example.

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
      try
      {
         if (subscriber.takeNextData(message, info))	// Note: No memory is allocated as the message is re-used. 
         {
            // Use data here
         }
      }
      catch (IOException | InterruptedException e)
      {
         // Handle exception
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


## Implementation

The IHMC Pub/Sub library consists of three parts. A generic Pub/Sub API, a RTPS implementation and an IDL serializer/deserializer. 

### Pub/Sub API

The Pub/Sub API is based on the eProsima Fast-RTPS C++ Api. The API is decoupled from the implementation, allowing multiple implementations. Currently only Fast-RTPS is provided as a backend.

### RTPS implementation

The RTPS implementation uses eProsima Fast-RTPS under the hood. Care has been taken to avoid any allocations in the Java code when reader/writing to topics. All functionality in the Pub/Sub API is implemented for 
the eProsima Fast-RTPS layer.  


## Documentation

All classes contain JavaDoc, which can be accessed on [https://readthedocs.org/projects/ihmc-pubsub/](https://readthedocs.org/projects/ihmc-pubsub/).


### See also
The eProsima Fast RTPS documentation can be useful as a reference guide on more advanced features and the inner working of the RTPS layer [http://eprosima-fast-rtps.readthedocs.io/en/latest/](http://eprosima-fast-rtps.readthedocs.io/en/latest/). 

## Supported platforms

The library is supported on Linux (Ubuntu 16.04). Compiled versions of the Mac OS X and Windows native code will be available soon. 


## Compilation
### Java code compilation
```
gradle build
gradle publishToMavenLocal

```

### Native code Compilation

This step is optional, the native libraries have been included in the source code repository.

Prerequisites
- Install FastRTPS using the README.md found on https://github.com/eProsima/Fast-RTPS. Use -DCMAKE_BUILD_TYPE=Debug if you want to enable info level debug. 
	- Current libraries are compiled with commit ad59a6c
- Set the environment variable FASTRTPSHOME to point to your FastRTPS installation prefix

#### Linux
```
mkdir build
cd build
cmake ..
make 
make install
```



