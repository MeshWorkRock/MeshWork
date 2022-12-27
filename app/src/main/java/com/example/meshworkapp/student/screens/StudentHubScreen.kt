package com.example.meshworkapp.student.screens

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
import com.example.meshworkapp.student.viewmodels.StudentSharedViewModel
import com.example.meshworkapp.student.navigationgraphs.StudentHubNavGraph
import com.example.meshworkapp.student.navigationgraphs.StudentHubNavigationScreens
import com.example.meshworkapp.ui.theme.DarkBlueText

@Composable
fun StudentHubScreen(
    navHostController: NavHostController = rememberNavController(),
    studentSharedViewModel: StudentSharedViewModel
) {
    Scaffold(
        bottomBar = {
            StudentBottomNavigationBarComposable(navHostController = navHostController)
        },
    ) {
        StudentHubNavGraph(navHostController = navHostController, studentSharedViewModel = studentSharedViewModel)
    }
}

@Composable
fun StudentBottomNavigationBarComposable(
    navHostController: NavHostController
) {
    val bottomNavigationItems = listOf(
        StudentHubNavigationScreens.Chats,
        StudentHubNavigationScreens.Home,
        StudentHubNavigationScreens.TimeTable,
        StudentHubNavigationScreens.Contacts
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
    item: StudentHubNavigationScreens,
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