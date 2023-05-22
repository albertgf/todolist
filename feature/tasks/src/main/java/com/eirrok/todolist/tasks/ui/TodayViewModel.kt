package com.eirrok.todolist.tasks.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eirrok.core.domain.usecase.AddTaskUseCase
import com.eirrok.core.domain.usecase.GetTodayTasksUseCase
import com.eirrok.core.model.Task
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class TodayViewModel(
    private val addTaskUseCase: AddTaskUseCase,
    private val getTodayTasksUseCase: GetTodayTasksUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow(TodayState())
    var state = _state.asStateFlow()

    val tasksUiState: StateFlow<TasksUiState> = getTodayTasksUiState().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = TasksUiState.Loading
    )

    sealed class TodayError {
        object AddTaskError : TodayError()
    }

    fun eventUi(event: TodayEventUi) {
        when (event) {
            is TodayEventUi.ToggleAdd -> toggleAdd()
            is TodayEventUi.AddTask -> addTask(event.task)
        }
    }

    private fun toggleAdd() {
        _state.value = _state.value.copy(addExpanded = !_state.value.addExpanded)
    }

    private fun addTask(task: Task) = viewModelScope.launch {
        addTaskUseCase.addTask(task)
    }

    private fun getTodayTasksUiState() : Flow<TasksUiState> {
        return getTodayTasksUseCase.invoke().map {
            TasksUiState.Success(it)
        }
    }

    sealed interface TasksUiState {
        object Loading : TasksUiState
        data class Success(val tasks: List<Task>) : TasksUiState
        data class Error(val error: TodayError) : TasksUiState
    }
}