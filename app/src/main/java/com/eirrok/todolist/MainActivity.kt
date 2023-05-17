package com.eirrok.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.eirrok.core.designsystem.theme.ToDoListTheme
import com.eirrok.todolist.features.home.ui.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoListTheme {
                HomeScreen()
            }
        }
    }
}