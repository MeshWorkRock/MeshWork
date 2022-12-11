package com.example.meshworkapp.screens

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.meshworkapp.navigationgraphs.HubBottomNavigationItems
import com.example.meshworkapp.navigationgraphs.HubNavGraph

@Composable
fun HubScreen(
    navHostController: NavHostController = rememberNavController()
) {
    Scaffold(
        bottomBar = {
            BottomNavigationBarComposable(navHostController = navHostController)
        }
    ) {
        HubNavGraph(navHostController = navHostController)
    }
}

@Composable
fun BottomNavigationBarComposable(
    navHostController: NavHostController
) {
    val bottomNavigationItems = listOf(
        HubBottomNavigationItems.Chats,
        HubBottomNavigationItems.Home,
        HubBottomNavigationItems.Announcements,
        HubBottomNavigationItems.TimeTable,
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
    item: HubBottomNavigationItems,
    currentDestination: NavDestination?,
    navHostController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(text = item.label)
        },
        icon = {
            Icon(imageVector = item.icon, contentDescription = item.label)
        },
        selected = item.route == currentDestination?.route,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navHostController.navigate(item.route) {
                popUpTo(navHostController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}