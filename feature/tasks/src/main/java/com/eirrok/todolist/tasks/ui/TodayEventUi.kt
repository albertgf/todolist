package com.eirrok.todolist.tasks.ui

import com.eirrok.core.model.Task


sealed class TodayEventUi {
    object ToggleAdd : TodayEventUi()
    class AddTask(val task: Task) : TodayEventUi()
}