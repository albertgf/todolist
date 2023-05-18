package com.eirrok.todolist.data.mapper

import Task
import com.eirrok.core.database.model.TaskEntity

fun Task.asEntity() = TaskEntity(
    uid = id ?: 0,
    title = title,
    repeat = repeat,
    remember = remember,
    date = date,
    completed = completed
)


fun TaskEntity.asDomain() = Task(
    id = uid,
    title = title,
    completed = completed,
    repeat = repeat,
    remember = remember,
    date = date,
)