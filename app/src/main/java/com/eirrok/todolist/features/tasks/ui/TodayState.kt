package com.eirrok.todolist.features.tasks.ui

import com.eirrok.core.model.Task


data class TodayState(
    val loading: Boolean = false,
    val addExpanded: Boolean = false,
    val newTask: Task = Task.build(),
)
