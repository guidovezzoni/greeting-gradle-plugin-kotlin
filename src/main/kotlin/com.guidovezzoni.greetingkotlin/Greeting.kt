package com.guidovezzoni.greetingkotlin;

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

open class Greeting : DefaultTask() {
    var message: String = ""
    var recipient: String = ""


    @TaskAction
    fun sayGreeting() {
        System.out.printf("%s, %s!\n", message, recipient)
    }
}
