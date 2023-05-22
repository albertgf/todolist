package com.eirrok.todolist.tasks.ui

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eirrok.core.designsystem.component.*
import com.eirrok.core.model.Task
import org.koin.androidx.compose.getViewModel

@Composable
fun TodayScreen(modifier: Modifier, viewModel: TodayViewModel = getViewModel()) {
    TodayScreen(
        modifier = modifier,
        state = viewModel.state.collectAsState().value,
        tasksUiState = viewModel.tasksUiState.collectAsState().value,
        onEventUI = viewModel::eventUi,
    )
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TodayScreen(
    modifier: Modifier,
    state: TodayState,
    tasksUiState: TodayViewModel.TasksUiState,
    onEventUI: (TodayEventUi) -> Unit
) {
    BackHandler {
        if (state.addExpanded) {
            onEventUI(TodayEventUi.ToggleAdd)
        }
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        floatingActionButton = {
            AnimatedVisibility(
                visible = !state.addExpanded,
                enter = scaleIn(),
                exit = scaleOut()
            ) {
                FloatingAddButton(onClick = { onEventUI(TodayEventUi.ToggleAdd) })
            }
        },

        ) {
        val statel = rememberLazyListState()
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                state = statel,
                modifier = Modifier.fillMaxWidth()
            ) {
                when (tasksUiState) {
                    is TodayViewModel.TasksUiState.Loading -> {
                        item {
                            Text("Loading")
                        }
                    }
                    is TodayViewModel.TasksUiState.Error -> {
                        item {
                            Text("Error")
                        }
                    }
                    is TodayViewModel.TasksUiState.Success -> {
                        items(tasksUiState.tasks.size) { index ->
                            val task = tasksUiState.tasks[index]
                            TaskItem(task = task, onEventUI = onEventUI)
                        }
                    }
                }
            }
            AnimatedVisibility(
                visible = state.addExpanded, modifier = Modifier
                    .align(Alignment.BottomCenter)
            ) {
                AddTaskContainer(state.newTask, onEventUI = onEventUI)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TaskItem(task: Task, onEventUI: (TodayEventUi) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = task.title,
            color = Color.Black,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AddTaskContainer(taskAdd: Task? = null, onEventUI: (TodayEventUi) -> Unit) {
    taskAdd?.let {
        var task by remember { mutableStateOf(taskAdd) }
        val onValueChange = remember { mutableStateOf("") }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Cyan)
                .padding(16.dp)
        ) {
            TDLTextField(
                modifier = Modifier.fillMaxWidth(),
                value = onValueChange.value,
                onValueChange = { onValueChange.value = it },
                label = { Text("task name") }
            )

            Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                TDLFilterChip(
                    label = { Text("Recorda'm") },
                    leadingIcon = { if (task.remember) Icon(Icons.Default.Check, contentDescription = null) },
                    onClick = {task = task.copy(remember = task.remember.not())  },
                    selected = task.remember
                )
                TDLFilterChip(
                    label = { Text("Repeteix") },
                    leadingIcon = { if (task.repeat) Icon(Icons.Default.Check, contentDescription = null) },
                    onClick = { task = task.copy(repeat = task.repeat.not()) },
                    selected = task.repeat
                )
            }
            Row (modifier = Modifier.align(Alignment.End),
                horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                TDLButton(
                    type = ButtonType.TextButton,
                    onClick = { onEventUI(TodayEventUi.ToggleAdd) },
                    text = "cancel"
                )
                TDLButton(
                    type = ButtonType.DefaultButton,
                    onClick = { onEventUI(TodayEventUi.AddTask(task.copy(title = onValueChange.value))) },
                    text = "add"
                )
            }
        }
    }

}

@Preview
@Composable
private fun TodayScreenPreview() {
    TodayScreen(Modifier)
}

@Preview
@Composable
private fun AddTaskContainerPreview() {
    val task = Task.build()
    AddTaskContainer(task, {})
}

@Preview
@Composable
private fun TaskItemPreview() {
    val task = Task.build()
    TaskItem(task, {})
}