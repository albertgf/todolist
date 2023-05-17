package com.eirrok.todolist.core.data.repository

import com.eirrok.todolist.core.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    suspend fun addTask(task: Task)
    suspend fun updateTask(task: Task)
    suspend fun deleteTask(task: Task)
    fun getTasks(): Flow<List<Task>>
}