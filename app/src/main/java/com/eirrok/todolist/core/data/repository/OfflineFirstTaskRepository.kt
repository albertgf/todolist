package com.eirrok.todolist.core.data.repository

import com.eirrok.todolist.core.data.mapper.asDomain
import com.eirrok.todolist.core.data.mapper.asEntity
import com.eirrok.core.database.dao.TaskDao
import com.eirrok.todolist.core.domain.model.Task
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class OfflineFirstTaskRepository(
    private val taskDao: com.eirrok.core.database.dao.TaskDao
) : TaskRepository {
    override suspend fun addTask(task: Task) {
        taskDao.insertAll(task.asEntity())
    }

    override suspend fun updateTask(task: Task) {
        taskDao.insertAll(task.asEntity())
    }

    override suspend fun deleteTask(task: Task) {
        taskDao.delete(task.asEntity())
    }

    override fun getTasks(): Flow<List<Task>> =
        taskDao.getAllSinceYesterday().map { tasks ->
            tasks.map { task ->
                task.asDomain()
            }
    }
}