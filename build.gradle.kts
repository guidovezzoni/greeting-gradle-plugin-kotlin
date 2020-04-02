repositories {
    mavenCentral()
    jcenter()
}

plugins {
    kotlin("jvm") version "1.3.70"
    id("java-gradle-plugin")
    id("com.gradle.plugin-publish") version "0.10.1"
    `maven-publish`
}

dependencies {
    implementation("com.android.tools.build:gradle:3.6.1")

//    testCompile("junit", "junit", "4.12")
}

allprojects {
    repositories {
        google()
    }
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

gradlePlugin {
    plugins {
        create("greetingsPlugin") {
            id = "com.guidovezzoni.greetingkotlin"
            group = "com.guidovezzoni"
            version = "1.0.1"
            @Suppress("UnstableApiUsage")
            displayName = "Greeting Plugin"
            @Suppress("UnstableApiUsage")
            description = "Template for people to start their own plugin adventure - in Kotlin"
            implementationClass = "com.guidovezzoni.greetingkotlin.GreetingPlugin"
        }
    }
}

pluginBundle {
    website = "https://github.com/guidovezzoni/greeting-gradle-plugin-kotlin"
    vcsUrl = "https://github.com/guidovezzoni/greeting-gradle-plugin-kotlin.git"
    tags = listOf("example", "template", "kotlin")
}
