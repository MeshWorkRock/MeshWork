package com.example.meshworkapp.faculty.navigationgraphs

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
import com.example.meshworkapp.shared.dataclass.AnnouncementDataClass
import com.example.meshworkapp.shared.dataclass.ChatListDataClass
import com.example.meshworkapp.faculty.screens.AnnouncementFilterScreenComposable
import com.example.meshworkapp.faculty.dataclasses.AssignedClassDataClass
import com.example.meshworkapp.shared.dataclass.TimeTableDataClass
import com.example.meshworkapp.faculty.screens.*
import com.example.meshworkapp.faculty.screens.viewmodels.CurrentCourseSharedViewModel
import com.example.meshworkapp.faculty.screens.viewmodels.FacultySharedViewModel

@Composable
fun FacultyHubNavGraph(
    navHostController: NavHostController,
    facultySharedViewModel: FacultySharedViewModel
) {

    val currentCourseSharedViewModel: CurrentCourseSharedViewModel = viewModel()

    NavHost(
        navController = navHostController,
        route = TopLevelGraph.facultyHubGraph,
        startDestination = FacultyHubNavigationScreens.Home.route
    ) {
        composable(
            route = FacultyHubNavigationScreens.Home.route
        ) {
            FacultyHomeScreen(
                navHostController = navHostController,
                assignedClassesList = fetchAssignedCLassesList(facultySharedViewModel = facultySharedViewModel),
                facultySharedViewModel = facultySharedViewModel,
                currentCourseSharedViewModel = currentCourseSharedViewModel
            )
        }
        composable(
            route = FacultyHubNavigationScreens.StudentsList.route
        ) {
            StudentListScreen(
                facultySharedViewModel = facultySharedViewModel,
                currentCourseSharedViewModel = currentCourseSharedViewModel
            )
        }
        composable(
            route = FacultyHubNavigationScreens.Chats.route
        ) {
            TeacherChatListScreen(chatDataList = fetchChatsList())
        }
        composable(
            route = FacultyHubNavigationScreens.TimeTable.route
        ) {
            TimeTableScreen(timeTableList = fetchTimeTableList())
        }
        composable(
            route = FacultyHubNavigationScreens.Announcements.route
        ) {
            AnnouncementScreen(announcementMessages = fetchAnnouncementsList(), navHostController = navHostController)
        }
        composable(
            route = FacultyHubNavigationScreens.MakeAnnouncement.route
        ) {
            AnnouncementFilterScreenComposable(navHostController = navHostController)                    //TODO Chane file name
        }
        composable(
            route = FacultyHubNavigationScreens.CreatAndPostAnnouncement.route
        ) {
            CreateAnnouncementScreen(facultySharedViewModel = facultySharedViewModel)                    //TODO Chane file name
        }
    }
}

sealed class FacultyHubNavigationScreens(
    val route: String,
    val label: String,
    val icon: ImageVector
) {
    object Home : FacultyHubNavigationScreens(
        route = "home_screen",
        label = "Home",
        icon = Icons.Default.Home
    )

    object TimeTable : FacultyHubNavigationScreens(
        route = "time_table_screen",
        label = "Time Table",
        icon = Icons.Default.Menu
    )

    object StudentsList : FacultyHubNavigationScreens(
        route = "StudentsList_screen",
        label = "Students List",
        icon = Icons.Default.Email
    )

    object Chats : FacultyHubNavigationScreens(
        route = "chats_screen",
        label = "Chat",
        icon = Icons.Default.Email
    )

    object Announcements : FacultyHubNavigationScreens(
        route = "announcements_screen",
        label = "Announcements",
        icon = Icons.Default.Person
    )
    object MakeAnnouncement : FacultyHubNavigationScreens(
        route = "make_announcements_screen",
        label = "Make Announcement",
        icon = Icons.Default.Person
    )
    object CreatAndPostAnnouncement : FacultyHubNavigationScreens(
        route = "create_and_announcement_screen",
        label = "Create Announcement",
        icon = Icons.Default.Person
    )
}

//fun fetchStudentsList(
//    facultySharedViewModel: FacultySharedViewModel,
//    currentCourseSharedViewModel: CurrentCourseSharedViewModel,
//): List<StudentsDataClass> {
//
//    //    Toast.makeText(LocalContext.current, "list count = ${studentList.size}", Toast.LENGTH_SHORT).show()
//    val studentsList = ArrayList<StudentsDataClass>()
//    val firebaseFirestore = FirebaseFirestore.getInstance()
//    firebaseFirestore.collection("students").whereEqualTo(
//        "course",
//        currentCourseSharedViewModel.currentCourse?.className
//    ).get().addOnSuccessListener {
//        it.forEach{doc->
//            studentsList.add(StudentsDataClass(
//                name = doc.getString("name"),
//                studentUID = doc.getString("name"),
//                profile = R.drawable.dummy_profile_pic,
//                studentDesignation = null
//            ))
//        }
//    }
//        Log.e("List", "${studentsList.size}")
//
//
//    /*return listOf(
//        StudentsDataClass(
//            name = "Pankaj Singh",
//            studentUID = "22MCC20049",
//            profile = R.drawable.dummy_profile_pic,
//            studentDesignation = "CR"
//        ),
//        StudentsDataClass(
//            name = "Sahil Vishwakarma",
//            studentUID = "22MCC20030",
//            profile = R.drawable.dummy_profile_pic,
//            studentDesignation = null
//        ),
//        StudentsDataClass(
//            name = "Amandeep Singh",
//            studentUID = "22MCC20050",
//            profile = R.drawable.dummy_profile_pic,
//            studentDesignation = null
//        ),
//        StudentsDataClass(
//            name = "Mrinal Sahni",
//            studentUID = "22MCC20059",
//            profile = R.drawable.dummy_profile_pic,
//            studentDesignation = null
//        ),
//        StudentsDataClass(
//            name = "Mercy",
//            studentUID = "22MCC20090",
//            profile = R.drawable.dummy_profile_pic,
//            studentDesignation = null
//        ),
//        StudentsDataClass(
//            name = "Tejas",
//            studentUID = "22MCC20088",
//            profile = R.drawable.dummy_profile_pic,
//            studentDesignation = "CR"
//        ),
//        StudentsDataClass(
//            name = "Tejveer",
//            studentUID = "22MCC20072",
//            profile = R.drawable.dummy_profile_pic,
//            studentDesignation = null
//        ),
//        StudentsDataClass(
//            name = "Isha Nagpal",
//            studentUID = "22MCC20066",
//            profile = R.drawable.dummy_profile_pic,
//            studentDesignation = null
//        )
//    )*/
//}

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

fun fetchAssignedCLassesList(facultySharedViewModel: FacultySharedViewModel): List<AssignedClassDataClass> {

    val classesList = ArrayList<AssignedClassDataClass>()

    for ((key, value) in facultySharedViewModel.facultyUser?.classes!!){
        classesList.add(AssignedClassDataClass(className = key, subject = value, studentsList = null))
    }
    return classesList.toList()
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
        arrayOf(
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
        arrayOf(
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
        arrayOf(
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
        arrayOf(
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
        arrayOf(
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