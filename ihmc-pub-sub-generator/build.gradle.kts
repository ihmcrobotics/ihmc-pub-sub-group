plugins {
   id("us.ihmc.ihmc-build") version "0.19.5"
   id("us.ihmc.ihmc-ci") version "5.0"
   id("us.ihmc.ihmc-cd") version "1.7"
}

app.entrypoint("idl-generator", "us.ihmc.idl.generator.IDLGenerator")
app.entrypoint("publisher-example", "us.ihmc.pubsub.examples.PublisherExample")

ihmc {
   loadProductProperties("../group.gradle.properties")

   configureDependencyResolution()
   resourceDirectory("main", "templates")
   javaDirectory("test", "generated-java")
   resourceDirectory("test", "idl")
   configurePublications()
}

dependencies {
   api(gradleApi())
   api("us.ihmc:eprosima-idl-parser:source")
   api("org.anarres:jcpp:1.4.12")
   api("us.ihmc:euclid:0.12.1")
}

testDependencies {
   api("us.ihmc:ihmc-pub-sub-test:source")
   api("us.ihmc:ihmc-commons-testing:0.26.6")
}

//
//task generateIDLElementTest(type: us.ihmc.idl.generator.IDLGeneratorTask) {
//   idlFiles = fileTree(dir: "src/test/idl")
//   includeDirs = files(".", "idl")
//   targetDirectory = file("src/test/generated-java")
//   packagePrefix = "us.ihmc.idl.generated"
//}
