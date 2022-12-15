package com.example.meshworkapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.meshworkapp.dataclassfiles.FacultyDataClass
import com.example.meshworkapp.navigationgraphs.HubNavigationScreens
import com.example.meshworkapp.navigationgraphs.HubNavGraph
import com.example.meshworkapp.viewmodels.FacultySharedViewModel
import com.example.meshworkapp.ui.theme.DarkBlueText

@Composable
fun HubScreen(
    navHostController: NavHostController = rememberNavController(),
    facultySharedViewModel: FacultySharedViewModel
) {
    Scaffold(
        bottomBar = {
            BottomNavigationBarComposable(navHostController = navHostController)
        },
    ) {
        HubNavGraph(navHostController = navHostController, facultySharedViewModel = facultySharedViewModel)
    }
}

@Composable
fun BottomNavigationBarComposable(
    navHostController: NavHostController
) {
    val bottomNavigationItems = listOf(
        HubNavigationScreens.Chats,
        HubNavigationScreens.Home,
        HubNavigationScreens.Announcements,
        HubNavigationScreens.TimeTable,
    )

    val backStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = backStackEntry?.destination

    val isHubScreen = bottomNavigationItems.any {
        it.route == currentDestination?.route
    }

    if (isHubScreen) {
        BottomNavigation {
            bottomNavigationItems.forEach { item ->
                AddItem(
                    item = item,
                    currentDestination = currentDestination,
                    navHostController = navHostController
                )
            }
        }
    }
}

@Composable
fun RowScope.AddItem(
    item: HubNavigationScreens,
    currentDestination: NavDestination?,
    navHostController: NavHostController
) {
    BottomNavigationItem(
        icon = {
            Icon(
                imageVector = item.icon,
                contentDescription = item.label,
                modifier = Modifier.size(30.dp)
            )
        },
        selected = item.route == currentDestination?.route,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        modifier = Modifier.background(DarkBlueText),
        onClick = {
            navHostController.navigate(item.route) {
                popUpTo(navHostController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}