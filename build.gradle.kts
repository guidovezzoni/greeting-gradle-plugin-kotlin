plugins {
    java
    id("java-gradle-plugin")
    id ("com.gradle.plugin-publish") version "0.10.1"
}

repositories {
    mavenCentral()
}

dependencies {
    testCompile("junit", "junit", "4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

gradlePlugin {
    plugins {
        create("greetingsPlugin") {
            id = "com.guidovezzoni.greetingkotlin"
            version = "1.0.0"
            displayName = "Greeting Plugin"
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
