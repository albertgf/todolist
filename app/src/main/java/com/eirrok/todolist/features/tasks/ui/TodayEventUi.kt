package com.eirrok.todolist.features.tasks.ui

import com.eirrok.todolist.core.domain.model.Task

sealed class TodayEventUi {
    object ToggleAdd : TodayEventUi()
    class AddTask(val task: Task) : TodayEventUi()
}