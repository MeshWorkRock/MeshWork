package com.example.meshworkapp.studentmodule

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.meshworkapp.R
import com.example.meshworkapp.UserInfoDataClass
import com.example.meshworkapp.common.AnnouncementList
import com.example.meshworkapp.common.OrganizationNameAndLogoComposable
import com.example.meshworkapp.common.UserInfoCard
import com.example.meshworkapp.common.dataclass.AnnouncementDataClass
import com.example.meshworkapp.composables.GradientBackGround

@Composable
fun StudentHomeScreen(
//    navHostController: NavHostController,
    studentSharedViewModel: StudentSharedViewModel,
    announcementMessages: List<AnnouncementDataClass>
) {
    val userInfo = UserInfoDataClass(
        name = studentSharedViewModel.studentUser?.name!!,
        id = studentSharedViewModel.studentUser?.id!!,
        profilePhoto = painterResource(id = R.drawable.profile_image_dummy)
    )
    Box {
        GradientBackGround()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp)
            //            .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            OrganizationNameAndLogoComposable(
                name = "Chandigarh University",
                logo = painterResource(id = R.drawable.cu_logo),
                modifier = Modifier.padding(top = 30.dp, bottom = 20.dp, start = 30.dp, end = 30.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            UserInfoCard(userInfo = userInfo,
                modifier = Modifier.padding(start = 30.dp,
                    bottom = 20.dp,
                    end = 30.dp,
                    top = 10.dp))

            Spacer(modifier = Modifier.height(5.dp))
            
            Text(text = "Announcements")

            Spacer(modifier = Modifier.height(5.dp))
            
            AnnouncementList(announcementMessages = announcementMessages)

        }
    }
}

@Preview(showBackground = true)
@Composable
fun StudentHomeScreenPreview() {

    val studentSharedViewModel = StudentSharedViewModel()
    studentSharedViewModel.addStudentUser(user = StudentDataClass(
        id = "22MCC20049",
        name = "Pankaj Singh"
    ))
    val Announcement = listOf(
        AnnouncementDataClass(
            Heading = "Cr Meating",
            Date = "12 nov 2022",
            announcementBody = "cr meeting happen"
        )
    )

    StudentHomeScreen(studentSharedViewModel = studentSharedViewModel,
        announcementMessages = Announcement)

}
