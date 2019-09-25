import com.gradle.publish.MavenCoordinates

// this file really just a test

plugins {
   id("us.ihmc.ihmc-build") version "0.19.5"
   id("us.ihmc.ihmc-ci") version "5.0"
   id("us.ihmc.ihmc-cd") version "1.7"
   `kotlin-dsl`
   `java-gradle-plugin`
   `maven-publish`
   id("com.gradle.plugin-publish") version "0.10.0"
}

app.entrypoint("idl-generator", "us.ihmc.idl.generator.IDLGenerator")
app.entrypoint("publisher-example", "us.ihmc.pubsub.examples.PublisherExample")

ihmc {
   loadProductProperties("../../group.gradle.properties")
   version = "0.11.0" // TODO: will this change at different times?

   configureDependencyResolution()
   resourceDirectory("main", "templates")
//   javaDirectory("test", "generated-java")
//   resourceDirectory("test", "idl")
   configurePublications()
}

dependencies {
   // fill in?
}

val pluginDisplayName = "IHMC Pub Sub Generator"
val pluginDescription = "Gradle plugin for generating Fast RTPS IHMC Pub Sub types."
val pluginVcsUrl = "https://github.com/ihmcrobotics/ihmc-pub-sub-group"
val pluginTags = listOf("rtps", "fastrtps", "pubsub", "dds", "generator", "ihmc", "robotics")

gradlePlugin {
   plugins.register(project.name) {
      id = project.group as String + "." + project.name
      implementationClass = "us.ihmc.idl.generator.IDLGeneratorTask"
      displayName = pluginDisplayName
      description = pluginDescription
   }
}

pluginBundle {
   website = pluginVcsUrl
   vcsUrl = pluginVcsUrl
   description = pluginDescription
   tags = pluginTags

   plugins.getByName(project.name) {
      id = project.group as String + "." + project.name
      version = project.version as String
      displayName = pluginDisplayName
      description = pluginDescription
      tags = pluginTags
   }

   mavenCoordinates(closureOf<MavenCoordinates> {
      groupId = project.group as String
      artifactId = project.name
      version = project.version as String
   })
}
