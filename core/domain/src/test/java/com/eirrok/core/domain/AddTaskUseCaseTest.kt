package com.eirrok.core.domain

import com.eirrok.core.domain.usecase.AddTaskUseCase
import com.eirrok.core.model.Task
import com.eirrok.core.testing.util.MainDispatcherRule
import com.eirrok.todolist.data.repository.TaskRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

class AddTaskUseCaseTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val taskRepository = mockk<TaskRepository>()

    val useCase = AddTaskUseCase(taskRepository)

    @Test
    fun add_task() = runTest {
        val task = Task.build()

        coEvery { taskRepository.addTask(any()) } answers {  }

        useCase.addTask(task)
    }
}