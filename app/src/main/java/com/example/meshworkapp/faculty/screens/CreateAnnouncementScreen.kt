package com.example.meshworkapp.faculty.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meshworkapp.R
import com.example.meshworkapp.composables.HomeBackGround
import com.example.meshworkapp.ui.theme.DarkBlueText
import com.example.meshworkapp.faculty.screens.viewmodels.FacultySharedViewModel
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun CreateAnnouncementScreen(facultySharedViewModel: FacultySharedViewModel) {
    Box {
        HomeBackGround()
        Column(horizontalAlignment = Alignment.Start) {
            Text(
                text = "Create ",
                fontSize = 30.sp,
                modifier = Modifier.padding(top = 35.dp, start = 15.dp),
                fontWeight = FontWeight.ExtraBold,
                color = Color.White
            )
            Text(
                text = "Announcement",
                fontSize = 30.sp,
                modifier = Modifier.padding(bottom = 10.dp, start = 15.dp),
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
    var  title by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    Card(
        modifier = Modifier
            .padding(top = 25.dp, start = 10.dp, end = 10.dp, bottom = 15.dp)
            .fillMaxHeight()
            .fillMaxWidth(),
        shape = RoundedCornerShape(20.dp)
    ) {
        Box() {
            Column() {
                //Title Field
                TextField(
                    value = title,
                    onValueChange = { title = it },
                    placeholder = {
                        Text("Title",
                            color = Color.White,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 25.sp,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, start = 4.dp, end = 4.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = DarkBlueText,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(20.dp)
                )


                //Announcement Field
                TextField(
                    value = message,
                    onValueChange = { message = it },
                    placeholder = {
                        Text("Type your message here...",
                            color = DarkBlueText,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            modifier = Modifier
                                .padding(start = 10.dp)
                                .verticalScroll(
                                    rememberScrollState())
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(start = 4.dp, end = 4.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White
                    ),
                )

            }


            //Send button
            Button(onClick = { sendAnnouncement(title = title, message = message,facultySharedViewModel = facultySharedViewModel) },
                modifier = Modifier
                    .align(alignment = Alignment.BottomEnd)
                    .padding(13.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(color = DarkBlueText),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = DarkBlueText
                )) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_send_24),
                    modifier = Modifier
                        .size(25.dp)
                        .padding(0.dp),
                    contentDescription = "send_icon",
                    tint = Color.White
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

//@Preview(showBackground = true)
//@Composable
//fun SamplePreviewFunction() {
//    CreateAnnouncementScreen()
//}