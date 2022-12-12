package com.example.meshworkapp.navigationgraphs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.meshworkapp.R
import com.example.meshworkapp.StudentsDataClass
import com.example.meshworkapp.screens.StudentListScreen
import com.example.meshworkapp.screens.AnnouncementScreen
import com.example.meshworkapp.screens.TimeTableComposable
import com.example.meshworkapp.screens.HomeScreen

@Composable
fun HubNavGraph(
    navHostController: NavHostController
) {

    val data by remember {
        mutableStateOf(
            listOf(
                StudentsDataClass(
                    studentName = "Pankaj Singh",
                    studentUID = "22MCC20049",
                    studentProfile = R.drawable.dummy_profile_pic,
                    studentDesignation = "CR"
                ),
                StudentsDataClass(
                    studentName = "Sahil Vishwakarma",
                    studentUID = "22MCC20030",
                    studentProfile = R.drawable.dummy_profile_pic,
                    studentDesignation = null
                ),
                StudentsDataClass(
                    studentName = "Amandeep Singh",
                    studentUID = "22MCC20050",
                    studentProfile = R.drawable.dummy_profile_pic,
                    studentDesignation = null
                ),
                StudentsDataClass(
                    studentName = "Mrinal Sahni",
                    studentUID = "22MCC20059",
                    studentProfile = R.drawable.dummy_profile_pic,
                    studentDesignation = null
                ),
                StudentsDataClass(
                    studentName = "Mercy",
                    studentUID = "22MCC20090",
                    studentProfile = R.drawable.dummy_profile_pic,
                    studentDesignation = null
                ),
                StudentsDataClass(
                    studentName = "Tejas",
                    studentUID = "22MCC20088",
                    studentProfile = R.drawable.dummy_profile_pic,
                    studentDesignation = "CR"
                ),
                StudentsDataClass(
                    studentName = "Tejveer",
                    studentUID = "22MCC20072",
                    studentProfile = R.drawable.dummy_profile_pic,
                    studentDesignation = null
                ),
                StudentsDataClass(
                    studentName = "Isha Nagpal",
                    studentUID = "22MCC20066",
                    studentProfile = R.drawable.dummy_profile_pic,
                    studentDesignation = null
                )
            )
        )
    }

    NavHost(
        navController = navHostController,
        route = TopLevelGraph.hubGraph,
        startDestination = HubBottomNavigationItems.Home.route
    ) {
        composable(
            route = HubBottomNavigationItems.Home.route
        ) {
            HomeScreen()
        }
        composable(
            route = HubBottomNavigationItems.Chats.route
        ) {
            StudentListScreen(studentDataList = data)
        }
        composable(
            route = HubBottomNavigationItems.TimeTable.route
        ) {
            TimeTableComposable()
        }
        composable(
            route = HubBottomNavigationItems.Announcements.route
        ) {
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