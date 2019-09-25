import com.gradle.publish.MavenCoordinates

plugins {
   `kotlin-dsl`
   `java-gradle-plugin`
   `maven-publish`
   id("com.gradle.plugin-publish") version "0.10.0"
}

group = "us.ihmc"
version = "0.11.0" // or get version from group file

repositories {
   mavenCentral()
   jcenter()
   maven{
      url = uri("https://dl.bintray.com/ihmcrobotics/maven-release")
   }
}

dependencies {
   api("us.ihmc:ihmc-pub-sub-generator:$version")
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
