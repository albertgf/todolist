package com.eirrok.core.domain.usecase

import com.eirrok.core.model.Task
import com.eirrok.todolist.data.repository.TaskRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AddTaskUseCase(
    private val taskRepository: TaskRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO) {
    
    suspend fun addTask(task: Task) = withContext(dispatcher) {
        taskRepository.addTask(task)
    }
}