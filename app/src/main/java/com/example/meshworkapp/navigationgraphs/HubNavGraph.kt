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
import com.example.meshworkapp.AssignedClassDataClass
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

    NavHost(
        navController = navHostController,
        route = TopLevelGraph.hubGraph,
        startDestination = HubNavigationScreens.Home.route
    ) {
        composable(
            route = HubNavigationScreens.Home.route
        ) {
            HomeScreen(navHostController = navHostController, assignedClassesList = fetchAssignedCLassesList())
        }
        composable(
            route = HubNavigationScreens.StudentsList.route
        ) {
            StudentListScreen(studentDataList = fetchStudentsList())
        }
        composable(
            route = HubNavigationScreens.Chats.route
        ) {
            StudentListScreen(studentDataList = fetchChatsList())
        }
        composable(
            route = HubNavigationScreens.TimeTable.route
        ) {
//            TimeTableComposable()
        }
        composable(
            route = HubNavigationScreens.Announcements.route
        ) {
            AnnouncementScreen()
        }
    }
}

sealed class HubNavigationScreens(
    val route: String,
    val label: String,
    val icon: ImageVector
) {
    object Home : HubNavigationScreens(
        route = "home_screen",
        label = "Home",
        icon = Icons.Default.Home
    )

    object TimeTable : HubNavigationScreens(
        route = "time_table_screen",
        label = "Time Table",
        icon = Icons.Default.Menu
    )

    object StudentsList : HubNavigationScreens(
        route = "StudentsList_screen",
        label = "Students List",
        icon = Icons.Default.Email
    )
    object Chats : HubNavigationScreens(
        route = "chats_screen",
        label = "Chat",
        icon = Icons.Default.Email
    )

    object Announcements : HubNavigationScreens(
        route = "announcements_screen",
        label = "Announcements",
        icon = Icons.Default.Person
    )
}


fun fetchStudentsList(): List<StudentsDataClass> {

    //    Toast.makeText(LocalContext.current, "list count = ${studentList.size}", Toast.LENGTH_SHORT).show()

    return listOf(
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

}

fun fetchChatsList(): List<StudentsDataClass> {

    //    Toast.makeText(LocalContext.current, "list count = ${studentList.size}", Toast.LENGTH_SHORT).show()

    return listOf(
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
        )
    )

}

fun fetchAssignedCLassesList(): List<AssignedClassDataClass> {
    return listOf(
        AssignedClassDataClass("22BSC-1", "Digital Electronics"),
        AssignedClassDataClass("22BSC-1", "Digital Electronics"),
        AssignedClassDataClass("22BSC-1", "Digital Electronics"),
        AssignedClassDataClass("22BSC-1", "Digital Electronics"),
        AssignedClassDataClass("22BSC-1", "Digital Electronics")
    )
}