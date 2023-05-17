package com.eirrok.todolist.features.home.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.ui.graphics.vector.ImageVector
import com.eirrok.todolist.R

sealed class HomeNavigationScreens(val route: String, val resourceId: Int, val icon: ImageVector) {
    object TodayScreen : HomeNavigationScreens("today", R.string.today_title, Icons.Default.Home)
    object StatsScreen : HomeNavigationScreens("stats", R.string.stats_title, Icons.Default.Share)
    object SettingsScreen : HomeNavigationScreens("settings", R.string.settings_title, Icons.Default.Settings)
}