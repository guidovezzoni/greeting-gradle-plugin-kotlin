package com.guidovezzoni.greetingkotlin;

import org.gradle.api.Action
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task

class GreetingPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.tasks.create("hello", Greeting::class.java) { greeting ->
            greeting.message = "Hello"
            greeting.recipient = "World"
        }
    }
}
