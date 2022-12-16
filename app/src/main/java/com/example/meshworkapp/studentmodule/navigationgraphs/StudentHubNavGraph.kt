package com.example.meshworkapp.studentmodule.navigationgraphs

import com.example.meshworkapp.navigationgraphs.TopLevelGraph
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.meshworkapp.R
import com.example.meshworkapp.common.dataclass.AnnouncementDataClass
import com.example.meshworkapp.common.dataclass.ChatListDataClass
import com.example.meshworkapp.composables.AnnouncementFilterScreenComposable
import com.example.meshworkapp.dataclassfiles.AssignedClassDataClass
import com.example.meshworkapp.dataclassfiles.TimeTableDataClass
import com.example.meshworkapp.screens.*
import com.example.meshworkapp.studentmodule.StudentChatListScreen
import com.example.meshworkapp.studentmodule.StudentHomeScreen
import com.example.meshworkapp.studentmodule.StudentSharedViewModel
import com.example.meshworkapp.viewmodels.AnnouncementsViewModel
import com.example.meshworkapp.viewmodels.FacultySharedViewModel

@Composable
fun StudentHubNavGraph(
    navHostController: NavHostController,
    studentSharedViewModel: StudentSharedViewModel,
) {

//    val currentCourseSharedViewModel: CurrentCourseSharedViewModel = viewModel()
    val announcementsViewModel: AnnouncementsViewModel = viewModel()
    NavHost(
        navController = navHostController,
        route = TopLevelGraph.facultyHubGraph,
        startDestination = StudentHubNavigationScreens.Home.route
    ) {
        composable(
            route = StudentHubNavigationScreens.Home.route
        ) {
            StudentHomeScreen(
                studentSharedViewModel = studentSharedViewModel,
                announcementsViewModel = announcementsViewModel
            )
        }
        composable(
            route = StudentHubNavigationScreens.Chats.route
        ) {
            StudentChatListScreen(chatDataList = fetchChatsList())
        }
        composable(
            route = StudentHubNavigationScreens.TimeTable.route
        ) {
            TimeTableScreen(timeTableList = fetchTimeTableList())
        }
    }
}

sealed class StudentHubNavigationScreens(
    val route: String,
    val label: String,
    val icon: ImageVector,
) {
    object Home : StudentHubNavigationScreens(
        route = "student_home_screen",
        label = "Home",
        icon = Icons.Default.Home
    )

    object TimeTable : StudentHubNavigationScreens(
        route = "student_time_table_screen",
        label = "Time Table",
        icon = Icons.Default.Menu
    )

    object Chats : StudentHubNavigationScreens(
        route = "student_chats_screen",
        label = "Chat",
        icon = Icons.Default.Email
    )
    object Contacts : StudentHubNavigationScreens(
        route = "contacts_screen",
        label = "Contacts",
        icon = Icons.Default.Email
    )
}

fun fetchChatsList(): List<ChatListDataClass> {


    return listOf(
        ChatListDataClass(
            name = "Pankaj Singh",
            lastText = "Hello",
            profile = R.drawable.dummy_profile_pic,
            lastTime = "11:00 PM"
        ),
        ChatListDataClass(
            name = "Aman Singh",
            lastText = "Hello",
            profile = R.drawable.dummy_profile_pic,
            lastTime = "10:00 PM"
        ),
        ChatListDataClass(
            name = "Sahil Vishwakarma",
            lastText = "Hello",
            profile = R.drawable.dummy_profile_pic,
            lastTime = "12:00 PM"
        ),
        ChatListDataClass(
            name = "Iqra Khan",
            lastText = "Hello",
            profile = R.drawable.dummy_profile_pic,
            lastTime = "09:00 PM"
        ),
        ChatListDataClass(
            name = "Mrinal Sahni",
            lastText = "Hello",
            profile = R.drawable.dummy_profile_pic,
            lastTime = "05:00 PM"
        ),
    )

}

fun fetchAnnouncementsList(): List<AnnouncementDataClass> {
    return listOf(
        AnnouncementDataClass(
            "CR meeting",
            "12.12.22",
            "A meeting has been scheduled for CR’s on 20th December 2022, the meeting will at 2 pm in seminar hall."
        ),
        AnnouncementDataClass(
            "Holiday",
            "5.12.22",
            "Dear Students the university will be close at 9 December 2022."
        ),
        AnnouncementDataClass(
            "Android Fest",
            "4.12.22",
            "Android Fest is an all-day event being hosted by UIC, Chandigarh University. Google Developer Experts will teach the basics of Android at the event anyone can attend. "
        ),
        AnnouncementDataClass(
            "CR meeting",
            "12.12.22",
            "A meeting has been scheduled for CR’s on 20th December 2022, the meeting will at 2 pm in seminar hall."
        ),
        AnnouncementDataClass(
            "Holiday",
            "5.12.22",
            "Dear Students the university will be close at 9 December 2022."
        ),
        AnnouncementDataClass(
            "Android Fest",
            "4.12.22",
            "Android Fest is an all-day event being hosted by UIC, Chandigarh University. Google Developer Experts will teach the basics of Android at the event anyone can attend. "
        ), AnnouncementDataClass(
            "CR meeting",
            "12.12.22",
            "A meeting has been scheduled for CR’s on 20th December 2022, the meeting will at 2 pm in seminar hall."
        ),
        AnnouncementDataClass(
            "Holiday",
            "5.12.22",
            "Dear Students the university will be close at 9 December 2022."
        ),
        AnnouncementDataClass(
            "Android Fest",
            "4.12.22",
            "Android Fest is an all-day event being hosted by UIC, Chandigarh University. Google Developer Experts will teach the basics of Android at the event anyone can attend. "
        )
    )
}

fun fetchTimeTableList(): Array<Array<TimeTableDataClass>> {
    return arrayOf(
        arrayOf<TimeTableDataClass>(
            TimeTableDataClass(
                time = "9:55\n|\n10:40",
                subject = "22CAH-604_Python Programming",
                group = "GP-B",
                teacherName = "Mr. Keshav Kumar_E12170",
                block = "North Campus"
            ),
            TimeTableDataClass(
                time = "10:40\n|\n11:25",
                subject = "22CAT-602_Advanced Computer Networks",
                group = "GP-ALL",
                teacherName = "Ms. Sandeep Kour_E9416",
                block = "North Campus"
            ),
            TimeTableDataClass(
                time = "11:25\n|\n12:10",
                subject = "22CAT-603_Front-end Web UI Framework and Tools",
                group = "GP-All",
                teacherName = "Ms. Payal Sharma_E13636",
                block = "North Campus"
            ),
            TimeTableDataClass(
                time = "12:55\n|\n2:25",
                subject = "22CAP-605_Advanced Database Management System Lab",
                group = "GP-All",
                teacherName = "Dr.Syed Mohtashim Mian_E11559 / Dr. Joe Arun Raja_E12319",
                block = "North Campus"
            ),
            TimeTableDataClass(
                time = "2:25\n|\n3:55",
                subject = "22CAH-604_Python Programming",
                group = "GP-All",
                teacherName = "Mr. Keshav Kumar_E12170 / Ms. Isha Sethi_E13476",
                block = "North Campus"
            )
        ),
        arrayOf<TimeTableDataClass>(
            TimeTableDataClass(
                time = "12:55\n|\n2:25",
                subject = "22CAP-606_Front-end Web UI Framework and Tools Lab",
                group = "GP-All",
                teacherName = "Ms. Payal Sharma_E13636 / Ms. Jyoti Rani_E13135",
                block = "North Campus"
            ),
            TimeTableDataClass(
                time = "2:25\n|\n3:55",
                subject = "22CAH-604_Python Programming",
                group = "GP-All",
                teacherName = "Mr. Keshav Kumar_E12170 / Ms. Isha Sethi_E13476",
                block = "North Campus"
            )
        ),
        arrayOf<TimeTableDataClass>(
            TimeTableDataClass(
                time = "10:40\n|\n11:25",
                subject = "22CAH-604_Python Programming\n",
                group = "GP-B",
                teacherName = "Ms. Isha Sethi_E13476",
                block = "North Campus"
            ),
            TimeTableDataClass(
                time = "11:25\n|\n12:10",
                subject = "22CAT-603_Front-end Web UI Framework and Tools",
                group = "GP-ALL",
                teacherName = "Ms. Payal Sharma_E13636",
                block = "North Campus"
            ),
            TimeTableDataClass(
                time = "12:55\n|\n13:40",
                subject = "22CAT-601_Advanced Database Management System",
                group = "GP-All",
                teacherName = "Dr.Syed Mohtashim Mian_E11559",
                block = "North Campus"
            ),
            TimeTableDataClass(
                time = "01:40\n|\n2:25",
                subject = "22CAT-602_Advanced Computer Networks",
                group = "GP-All",
                teacherName = "Ms. Sandeep Kour_E9416",
                block = "North Campus"
            )
        ),
        arrayOf<TimeTableDataClass>(
            TimeTableDataClass(
                time = "09:55\n|\n11:25",
                subject = "22CAP-606_Front-end Web UI Framework and Tools Lab",
                group = "GP-ALL",
                teacherName = "Ms. Payal Sharma_E13636 / Ms. Jyoti Rani_E13135",
                block = "North Campus"
            ),
            TimeTableDataClass(
                time = "11:25\n|\n12:10",
                subject = "22CAT-602_Advanced Computer Networks",
                group = "GP-B",
                teacherName = "Ms. Sandeep Kour_E9416",
                block = "North Campus"
            ),
            TimeTableDataClass(
                time = "12:10\n|\n12:55",
                subject = "22CAT-601_Advanced Database Management System",
                group = "GP-All",
                teacherName = "Dr.Syed Mohtashim Mian_E11559",
                block = "North Campus"
            ),
            TimeTableDataClass(
                time = "13:40\n|\n14:25",
                subject = "22CAT-603_Front-end Web UI Framework and Tools",
                group = "GP-All",
                teacherName = "Ms. Payal Sharma_E13636",
                block = "North Campus"
            ),
            TimeTableDataClass(
                time = "14:25\n|\n15:55",
                subject = "22CAP-607_Linux Administration Lab",
                group = "GP-All",
                teacherName = "Ms. Palwinder Kaur_E9422",
                block = "North Campus"
            )
        ),
        arrayOf<TimeTableDataClass>(
            TimeTableDataClass(
                time = "11:25\n|\n12:55",
                subject = "22CAH-604_Python Programming",
                group = "GP-ALL",
                teacherName = "Mr. Keshav Kumar_E12170 / Ms. Isha Sethi_E13476",
                block = "North Campus"
            ),
            TimeTableDataClass(
                time = "10:40 - 11:25",
                subject = "Python Programming",
                group = "GP-B",
                teacherName = "Anjul Bhardwaj(E13327)",
                block = "Block-DD6-401-A"
            ),
            TimeTableDataClass(
                time = "13:40\n|\n14:25",
                subject = "22CAT-601_Advanced Database Management System",
                group = "GP-All",
                teacherName = "Dr.Syed Mohtashim Mian_E11559",
                block = "Block-DD6-401-A"
            ),
            TimeTableDataClass(
                time = "14:25\n|\n15:55",
                subject = "22CAP-605_Advanced Database Management System Lab",
                group = "GP-All",
                teacherName = "Dr.Syed Mohtashim Mian_E11559 / Dr. Joe Arun Raja_E12319\n",
                block = "Block-DD6-401-A"
            )
        )
    )
}