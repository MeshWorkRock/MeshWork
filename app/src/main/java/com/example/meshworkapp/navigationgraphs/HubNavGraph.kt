package com.example.meshworkapp.navigationgraphs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.meshworkapp.screens.StudentListScreen
import com.example.meshworkapp.screens.AnnouncementScreen
import com.example.meshworkapp.screens.TimeTableComposable
import com.example.meshworkapp.screens.HomeScreen

@Composable
fun HubNavGraph(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        route = TopLevelGraph.hubGraph,
        startDestination = HubBottomNavigationItems.Home.route
    ){
        composable(
            route = HubBottomNavigationItems.Home.route
        ){
            HomeScreen()
        }
        composable(
            route = HubBottomNavigationItems.Chats.route
        ){
            StudentListScreen()
        }
        composable(
            route = HubBottomNavigationItems.TimeTable.route
        ){
            TimeTableComposable()
        }
        composable(
            route = HubBottomNavigationItems.Announcements.route
        ){
            AnnouncementScreen()
        }
    }
}

sealed class HubBottomNavigationItems(
    val route: String,
    val label: String,
    val icon: ImageVector
) {
    object Home : HubBottomNavigationItems(
        route = "home_screen",
        label = "Home",
        icon = Icons.Default.Home
    )
    object TimeTable : HubBottomNavigationItems(
        route = "time_table_screen",
        label = "Time Table",
        icon = Icons.Default.Menu
    )
    object Chats : HubBottomNavigationItems(
        route = "chats_screen",
        label = "Chats",
        icon = Icons.Default.Email
    )
    object Announcements : HubBottomNavigationItems(
        route = "announcements_screen",
        label = "Announcements",
        icon = Icons.Default.Person
    )
}