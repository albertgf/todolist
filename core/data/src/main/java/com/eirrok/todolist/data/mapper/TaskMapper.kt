package com.eirrok.todolist.data.mapper

import com.eirrok.core.database.model.TaskEntity
import com.eirrok.core.model.Task

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