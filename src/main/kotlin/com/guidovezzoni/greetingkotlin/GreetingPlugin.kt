package com.guidovezzoni.greetingkotlin;

import org.gradle.api.Plugin
import org.gradle.api.Project

class GreetingPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.extensions.create(EXTENSION_NAME, GreetingExtension::class.java)
        project.tasks.create(TASK_NAME, GreetingTask::class.java)
    }

    companion object {
        const val EXTENSION_NAME = "greetingPlugin"
        const val TASK_NAME = "hello"
    }
}
