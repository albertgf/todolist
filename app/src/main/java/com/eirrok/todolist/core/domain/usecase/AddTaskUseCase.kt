package com.eirrok.todolist.core.domain.usecase

import com.eirrok.todolist.core.data.repository.TaskRepository
import com.eirrok.todolist.core.domain.model.Task
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