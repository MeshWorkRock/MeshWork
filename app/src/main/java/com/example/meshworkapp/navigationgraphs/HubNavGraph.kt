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
import com.example.meshworkapp.AnnouncementDataClass
import com.example.meshworkapp.R
import com.example.meshworkapp.StudentsDataClass
import com.example.meshworkapp.TimeTableDataClass
import com.example.meshworkapp.screens.*

@Composable
fun HubNavGraph(
    navHostController: NavHostController
) {

    //Data for the Time Table
    var timeTable = arrayOf(
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

    //Data for the Announcement Screen
    val announcementMessages = listOf(
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
            TimeTableScreen(timeTableList = timeTable)
        }
        composable(
            route = HubBottomNavigationItems.Announcements.route
        ) {
            AnnouncementScreen(announcementMessages)
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