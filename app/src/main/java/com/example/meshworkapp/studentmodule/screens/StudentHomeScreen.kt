package com.example.meshworkapp.studentmodule

import AnnouncementList
import OrganizationNameAndLogoComposable
import UserInfoCard
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.meshworkapp.R
import com.example.meshworkapp.UserInfoDataClass
import com.example.meshworkapp.common.dataclass.AnnouncementDataClass
import com.example.meshworkapp.composables.HomeBackGround
import com.example.meshworkapp.ui.theme.DarkBlueText
import com.example.meshworkapp.studentmodule.dataclass.AnnouncementsViewModelDataClass
import com.example.meshworkapp.viewmodels.AnnouncementsViewModel
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun StudentHomeScreen(
//    navHostController: NavHostController,
    studentSharedViewModel: StudentSharedViewModel,
    announcementsViewModel: AnnouncementsViewModel
//    announcementMessages: List<AnnouncementDataClass>
) {
    announcementsViewModel.addAnnouncements(AnnouncementsViewModelDataClass(listOf(AnnouncementDataClass(
        Heading = " ",
        Date = " ",
        announcementBody = " "
    ))))
    fetchAnnouncements(
        studentSharedViewModel = studentSharedViewModel,
        announcementsViewModel = announcementsViewModel
    )
    val userInfo = UserInfoDataClass(
        name = studentSharedViewModel.studentUser?.name!!,
        id = studentSharedViewModel.studentUser?.id!!,
        profilePhoto = painterResource(id = R.drawable.profile_image_dummy)
    )
    Box {
        HomeBackGround()
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

            Text(
                text = "Announcements",
                color = Color.White,
                style = MaterialTheme.typography.h5,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(5.dp))
            
            AnnouncementList(announcementMessages = announcementsViewModel)

        }
    }
}

fun fetchAnnouncements(
    studentSharedViewModel: StudentSharedViewModel,
    announcementsViewModel: AnnouncementsViewModel,
){
    val firebaseFirestore = FirebaseFirestore.getInstance()
    val announcementsList = ArrayList<AnnouncementDataClass>()
    firebaseFirestore.collection("courses/22_mcd/announcements/1_b/announcements").get()
        .addOnSuccessListener {
            it.forEach{ anc ->
                announcementsList.add(AnnouncementDataClass(
                    anc.getString("title")!!,
                    Date = "12-12-12",
                    anc.getString("message")!!
                ))
            }
            Log.d("Announce", "${announcementsList.size}")
            announcementsViewModel.setAnnouncementList(announcementsList.toList())
        }
}

@Preview(showBackground = true)
@Composable
fun StudentHomeScreenPreview() {

    val studentSharedViewModel = StudentSharedViewModel()
    studentSharedViewModel.addStudentUser(user = StudentDataClass(
        id = "22MCC20049",
        name = "Pankaj Singh",
        course = "22MCC20050",
        studentProfile = R.drawable.dummy_profile_pic
    ))
    val Announcement = listOf(
        AnnouncementDataClass(
            Heading = "Cr Meating",
            Date = "12 nov 2022",
            announcementBody = "cr meeting happen"
        )
    )

//    StudentHomeScreen(studentSharedViewModel = studentSharedViewModel)

}
