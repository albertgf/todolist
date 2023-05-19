package com.eirrok.todolist.data.repository

import com.eirrok.core.model.Task
import com.eirrok.todolist.data.mapper.asDomain
import com.eirrok.todolist.data.mapper.asEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class OfflineFirstTaskRepository(
    private val persistenceTaskDataSource: com.eirrok.core.database.datasource.PersistenceTaskDataSource
) : TaskRepository {
    override suspend fun addTask(task: Task) {
        persistenceTaskDataSource.insertAll(task.asEntity())
    }

    override suspend fun updateTask(task: Task) {
        persistenceTaskDataSource.insertAll(task.asEntity())
    }

    override suspend fun deleteTask(task: Task) {
        persistenceTaskDataSource.delete(task.asEntity())
    }

    override fun getTasks(): Flow<List<Task>> =
        persistenceTaskDataSource.getAllSinceYesterday().map { tasks ->
            tasks.map { task ->
                task.asDomain()
            }
    }
}