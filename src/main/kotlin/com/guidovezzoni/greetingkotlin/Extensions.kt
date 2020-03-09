package com.guidovezzoni.greetingkotlin

import com.guidovezzoni.greetingkotlin.model.ExtensionConfigModel

fun GreetingExtension.toExtensionConfigModel(): ExtensionConfigModel {
    return ExtensionConfigModel(this.message,
            this.recipient)
}
