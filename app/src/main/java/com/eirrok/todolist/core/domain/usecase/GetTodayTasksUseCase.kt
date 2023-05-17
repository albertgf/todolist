package com.eirrok.todolist.core.domain.usecase

import com.eirrok.todolist.core.data.repository.TaskRepository
import com.eirrok.todolist.core.domain.model.Task
import kotlinx.coroutines.flow.Flow

class GetTodayTasksUseCase(private val taskRepository: TaskRepository) {

    operator fun invoke() : Flow<List<Task>> = taskRepository.getTasks()
}