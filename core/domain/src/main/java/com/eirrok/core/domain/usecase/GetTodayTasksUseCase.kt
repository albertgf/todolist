package com.eirrok.core.domain.usecase

import com.eirrok.core.model.Task
import com.eirrok.todolist.data.repository.TaskRepository
import kotlinx.coroutines.flow.Flow

class GetTodayTasksUseCase(private val taskRepository: TaskRepository) {

    operator fun invoke() : Flow<List<Task>> = taskRepository.getTasks()
}