package com.guidovezzoni.greetingkotlin;

import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

open class GreetingTask : DefaultTask() {

    private val configExtension by lazy {
        project.extensions.getByType(GreetingExtension::class.java)
    }

    @TaskAction
    fun sayGreeting() {
        val extensionConfigModel = configExtension.toExtensionConfigModel()
        System.out.printf("%s, %s!\n", extensionConfigModel.message, extensionConfigModel.recipient)
    }
}
