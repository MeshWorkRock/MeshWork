package com.example.meshworkapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meshworkapp.R
import com.example.meshworkapp.composables.HomeBackGround
import com.example.meshworkapp.ui.theme.DarkBlueText
import com.example.meshworkapp.viewmodels.FacultySharedViewModel
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun CreateAnnouncementScreen(facultySharedViewModel: FacultySharedViewModel) {
    Box {
        HomeBackGround()
        Column(horizontalAlignment = Alignment.Start) {
            Text(
                text = "Create ",
                fontSize = 30.sp,
                modifier = Modifier.padding(top = 35.dp, start = 10.dp),
                fontWeight = FontWeight.ExtraBold,
                color = Color.White
            )
            Text(
                text = "Announcement",
                fontSize = 30.sp,
                modifier = Modifier.padding(bottom = 10.dp, start = 10.dp),
                fontWeight = FontWeight.ExtraBold,
                color = Color.White
            )

            CreateAnnouncementInfoScreen()
            AnnouncementDataEnterScreen(facultySharedViewModel = facultySharedViewModel)
        }

    }


}

@Composable
fun CreateAnnouncementInfoScreen() {
    Card(
        elevation = 10.dp,
        modifier = Modifier
            .padding(10.dp),
        shape = RoundedCornerShape(20.dp)

    ) {
        Column(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Batch : 2022",
                fontSize = 18.sp,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "Course: BSc",
                fontSize = 18.sp,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "Section 1",
                fontSize = 18.sp,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
fun AnnouncementDataEnterScreen(facultySharedViewModel: FacultySharedViewModel) {
    var message by remember { mutableStateOf("") }

    Box {
        Column() {
            TextField(
                value = message,
                onValueChange = { message = it },
                placeholder = {
                    Column {
                        Text("Title",
                            color = Color.Black,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 25.sp,
                            modifier = Modifier.padding(bottom = 10.dp))
                        Text("Type your announcement here...",
                            color = Color.Black,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold)
                    }
                },
                modifier = Modifier
                    .padding(top = 35.dp, start = 15.dp, end = 15.dp)
                    .fillMaxHeight()
                    .fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White
                ),
                shape = RoundedCornerShape(20.dp)
            )
        }
        Row(Modifier
            .align(Alignment.BottomEnd)
            .padding(15.dp)
            .background(color = DarkBlueText)) {
            Button(
                onClick = {
                    sendAnnouncement(
                        title = "this Title",
                        message = message,
                        facultySharedViewModel = facultySharedViewModel
                    )
                },
                modifier = Modifier.background(color = DarkBlueText)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.paper_plane),
                    contentDescription = "Icon",
                    Modifier.size(40.dp),
                    alignment = Alignment.BottomEnd,
                )
            }
        }
    }

}

fun sendAnnouncement(
//    coursesList: List<String>,
    title: String,
    message: String,
    facultySharedViewModel: FacultySharedViewModel,
) {
    val firebaseFirestore = FirebaseFirestore.getInstance()

    val data = hashMapOf(
        "title" to title,
        "message" to message,
        "sender" to facultySharedViewModel.facultyUser?.name
    )

    firebaseFirestore
        .collection("courses/22_mcd/announcements/1_b/announcements")
        .document().set(data)
//    coursesList.forEach { course ->
//
//    }

}

@Preview(showBackground = true)
@Composable
fun SamplePreviewFunction() {
    CreateAnnouncementScreen(facultySharedViewModel = FacultySharedViewModel())
}