package com.eirrok.todolist.features.tasks.ui

import com.eirrok.todolist.core.domain.model.Task

data class TodayState(
    val loading: Boolean = false,
    val addExpanded: Boolean = false,
    val newTask: Task = Task.build(),
)
