package com.eirrok.todolist.features.home.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.eirrok.core.designsystem.theme.ToDoListTheme
import com.eirrok.todolist.features.settings.ui.SettingsScreen
import com.eirrok.todolist.features.stats.ui.StatsScreen
import com.eirrok.todolist.features.tasks.ui.TodayScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    val bottomNavItems = listOf(
        HomeNavigationScreens.TodayScreen,
        HomeNavigationScreens.StatsScreen,
        HomeNavigationScreens.SettingsScreen
    )
    Scaffold(
        bottomBar = {
            NavigationBar {
                val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
                bottomNavItems.forEachIndexed {  index, item ->
                    NavigationBarItem(
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = "Home"
                            )
                        },
                        label = { Text(text = stringResource(id =item.resourceId)) },
                        selected = item.route == currentRoute,
                        onClick = { navController.navigate(item.route) }
                    )
                }
            }
        },
        content = { paddingValues ->
            HomeScreenNavigationConfig(modifier = Modifier.fillMaxSize().padding(bottom = paddingValues.calculateBottomPadding()), navController = navController)
        }
    )
}

@Composable
private fun HomeScreenNavigationConfig(modifier: Modifier, navController: NavHostController) {
    NavHost(navController = navController, startDestination = HomeNavigationScreens.TodayScreen.route) {
        composable(HomeNavigationScreens.TodayScreen.route) {
            TodayScreen(modifier)
        }
        composable(HomeNavigationScreens.StatsScreen.route) {
            StatsScreen()
        }
        composable(HomeNavigationScreens.SettingsScreen.route) {
            SettingsScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ToDoListTheme {
        HomeScreen()
    }
}