package com.eirrok.todolist.core.data.mapper

import com.eirrok.core.database.model.TaskEntity
import com.eirrok.todolist.core.domain.model.Task

fun Task.asEntity() = com.eirrok.core.database.model.TaskEntity(
    uid = id ?: 0,
    title = title,
    repeat = repeat,
    remember = remember,
    date = date,
    completed = completed
)


fun com.eirrok.core.database.model.TaskEntity.asDomain() = Task(
    id = uid,
    title = title,
    completed = completed,
    repeat = repeat,
    remember = remember,
    date = date,
)