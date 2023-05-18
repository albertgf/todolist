package com.eirrok.todolist.features.tasks.ui

import Task


sealed class TodayEventUi {
    object ToggleAdd : TodayEventUi()
    class AddTask(val task: Task) : TodayEventUi()
}