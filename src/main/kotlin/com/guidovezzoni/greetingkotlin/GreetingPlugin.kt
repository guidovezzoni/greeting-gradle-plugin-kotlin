package com.guidovezzoni.greetingkotlin;

import com.android.build.gradle.AppExtension
import com.android.build.gradle.api.SourceKind
import com.guidovezzoni.greetingkotlin.logger.CustomLogging
import org.gradle.api.Plugin
import org.gradle.api.Project

class GreetingPlugin : Plugin<Project> {
    private val logger = CustomLogging.getLogger(GreetingPlugin::class.java)

    override fun apply(project: Project) {
        project.extensions.create(EXTENSION_NAME, GreetingExtension::class.java)
        project.tasks.create(TASK_NAME, GreetingTask::class.java)

        listProjectInfo(project)
        listAndroidPluginInfo(project)
    }

    private fun listProjectInfo(project: Project) {
        println("\n***** Project Info **********")
        println("* Name=${project.name} ***")
    }

    private fun listAndroidPluginInfo(project: Project) {
        val android = project.extensions.findByName("android") as AppExtension?
                ?: throw Exception("Not an Android application")

        println("\n***** Android Extension **********")
        println("* productFlavors=${android.productFlavors.names} ***")
//        println("* flavorDimensionList=${android.flavorDimensionList.toSet()} ***")
        println("* buildTypes=${android.buildTypes.names} ***")


        println("\n***** Available Android variants **********")
        android.applicationVariants.all { androidVariant ->
            println("* Name=${androidVariant.name} ***")
            println("* description=${androidVariant.description}")
            println("* dirName=${androidVariant.dirName}")
            println("* baseName=${androidVariant.baseName}")
            println("* flavorName=${androidVariant.flavorName}")
//            println("* outputs=${androidVariant.outputs}")
            println("* buildType=${androidVariant.buildType.name}")
            println("* mergedFlavor=${androidVariant.mergedFlavor.name}")
//            println("* productFlavors=${androidVariant.productFlavors}")

            println("* sourceSets=${androidVariant.sourceSets.toSet()}")
            println("* getSourceFolders=${androidVariant.getSourceFolders(SourceKind.JAVA).toSet()}")

            println("* generateBuildConfigProvider=${androidVariant.generateBuildConfigProvider.name}")

            println("*")
        }
    }

    companion object {
        const val EXTENSION_NAME = "greetingPlugin"
        const val TASK_NAME = "hello"
    }
}
