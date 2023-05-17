package com.eirrok.todolist

@Suppress("unused")
enum class ToDoListBuildType(val applicationIdSuffix: String? = null) {
    DEBUG(".debug"),
    RELEASE,
    BENCHMARK(".benchmark")
}