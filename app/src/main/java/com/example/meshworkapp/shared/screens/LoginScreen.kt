package com.example.meshworkapp.faculty.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meshworkapp.R
import com.example.meshworkapp.composables.LoginBackground
import com.example.meshworkapp.faculty.dataclasses.FacultyDataClass
import com.example.meshworkapp.student.dataclass.StudentDataClass
import com.example.meshworkapp.student.viewmodels.StudentSharedViewModel
import com.example.meshworkapp.ui.theme.DarkBlueText
import com.example.meshworkapp.faculty.screens.viewmodels.FacultySharedViewModel
import com.google.firebase.firestore.FirebaseFirestore

//@Composable
//fun LoginScreenStudentComposable(name: String) {
//    val loginId = name
//    var uidTextState by remember {
//        mutableStateOf("")
//    }
//
//    var passwordState by remember {
//        mutableStateOf("")
//    }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(30.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//
//        Spacer(modifier = Modifier.height(40.dp))
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .background(colorResource(id = R.color.light_bg))
//                .padding(12.dp),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            TextField(
//                value = uidTextState,
//                label = {
//                    Text(text = "Enter the Uid")
//                },
//                onValueChange = {
//                    uidTextState = it
//                },
//                singleLine = true,
//                modifier = Modifier.fillMaxWidth()
//            )
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            TextField(
//                value = passwordState,
//                label = {
//                    Text(text = "Enter the Password")
//                },
//                onValueChange = {
//                    passwordState = it
//                },
//                singleLine = true,
//                modifier = Modifier.fillMaxWidth()
//            )
//
//            Spacer(modifier = Modifier.height(20.dp))
//            Button(
//                onClick = { },
//                modifier = Modifier.width(150.dp),
//            ) {
//                Text(text = "LOG IN")
//            }
//        }
//    }
//}


@Composable
fun LoginScreen(
    user: String,
    onSubmit: () -> Unit,
    facultySharedViewModel: FacultySharedViewModel,
    studentSharedViewModel: StudentSharedViewModel,
) {
    var uidTextState by remember {
        mutableStateOf("")
    }

    var passwordState by remember {
        mutableStateOf("")
    }

    Box {
        LoginBackground()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "MeshWork",
                color = Color.White,
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()

            )

            Spacer(modifier = Modifier.height(5.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                //                .background(colorResource(id = R.color.light_bg))
                //                .padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "User ID",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp)
                )

                TextField(
                    value = uidTextState,
                    onValueChange = {
                        uidTextState = it
                    },
                    singleLine = true,
                    textStyle = MaterialTheme.typography.subtitle1,

                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),

                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.White, shape = CircleShape)

                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Password",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp)
                )

                TextField(
                    value = passwordState,
                    onValueChange = {
                        passwordState = it
                    },
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.White, shape = CircleShape)
                )

                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    onClick = {
                        loginScreen(
                            facultySharedViewModel = facultySharedViewModel,
                            studentSharedViewModel = studentSharedViewModel,
                            id = uidTextState,
                            password = passwordState,
                            user = user,
                            onSubmit = onSubmit,
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                ) {
                    Text(
                        text = "Sign In",
                        color = DarkBlueText,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(top = 5.dp, bottom = 5.dp)
                    )
                }
            }
        }
    }


}

fun loginScreen(
    id: String,
    password: String,
    user: String,
    onSubmit: () -> Unit,
    facultySharedViewModel: FacultySharedViewModel,
    studentSharedViewModel: StudentSharedViewModel,
) {

    val firebaseFirestore = FirebaseFirestore.getInstance()
    firebaseFirestore.collection(user).whereEqualTo("uid", id)
        .whereEqualTo("password", password).get().addOnSuccessListener {
            if (it.size() != 0) {
                val documentSnapshot = it.documents[0]
                if (user == "faculty") {
                    val mUser = FacultyDataClass(
                        id = documentSnapshot.getString("id"),
                        email = documentSnapshot.getString("email"),
                        name = documentSnapshot.getString("name"),
                        classes = documentSnapshot.get("classes") as HashMap<String, String>,
                    )
                    facultySharedViewModel.addFacultyUser(mUser)
                } else {
                    val mUser = StudentDataClass(
                        name = documentSnapshot.getString("name"),
                        id = documentSnapshot.getString("uid"),
                        studentProfile = R.drawable.dummy_profile_pic,
                        course = documentSnapshot.getString("course")
                    )

                    studentSharedViewModel.addStudentUser(mUser)
                }

                onSubmit()
            }
        }.addOnFailureListener {
            Log.e("Auth", "Invalid User id password")
        }
}

//fun StudentDataClass(name: String?, id: String?, studentProfile: Int): StudentDataClass {
//
//                facultySharedViewModel.addFacultyUser(user)
//                onSubmit()
//            }
//        }.addOnFailureListener {
//            Log.e("Auth", "Invalid User id password")
//        }
