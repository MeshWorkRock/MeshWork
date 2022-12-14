package com.example.meshworkapp.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meshworkapp.R
import com.example.meshworkapp.dataclassfiles.FacultyDataClass
import com.example.meshworkapp.viewmodels.FacultySharedViewModel
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun LoginScreenStudentComposable(name: String) {
    val loginId = name
    var uidTextState by remember {
        mutableStateOf("")
    }

    var passwordState by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_baseline_person_24),
            contentDescription = "Logo",
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Gray, CircleShape)
        )
        Spacer(modifier = Modifier.height(40.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id = R.color.light_bg))
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = uidTextState,
                label = {
                    Text(text = "Enter the Uid")
                },
                onValueChange = {
                    uidTextState = it
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = passwordState,
                label = {
                    Text(text = "Enter the Password")
                },
                onValueChange = {
                    uidTextState = it
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { },
                modifier = Modifier.width(150.dp),
            ) {
                Text(text = "LOG IN")
            }
        }
    }
}


@Composable
fun LoginScreenFacultyComposable(
    name: String,
    onSubmit: () -> Unit,
    facultySharedViewModel: FacultySharedViewModel
) {
    var uidTextState by remember {
        mutableStateOf("")
    }

    var passwordState by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_baseline_person_24),
            contentDescription = "Logo",
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Gray, CircleShape)
        )
        Spacer(modifier = Modifier.height(40.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id = R.color.light_bg))
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = uidTextState,
                label = {
                    Text(text = "Enter the Uid")
                },
                onValueChange = {
                    uidTextState = it
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = passwordState,
                label = {
                    Text(text = "Enter the Password")
                },
                onValueChange = {
                    passwordState = it
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    loginFaculty(
                        id = uidTextState,
                        password = passwordState,
                        onSubmit = onSubmit,
                        facultySharedViewModel = facultySharedViewModel
                    )
                },
                modifier = Modifier.width(150.dp),
            ) {
                Text(text = "LOG IN")
            }
        }
    }
}


fun loginFaculty(
    id: String,
    password: String,
    onSubmit: () -> Unit,
    facultySharedViewModel: FacultySharedViewModel
) {

    val firebaseFirestore = FirebaseFirestore.getInstance()
    firebaseFirestore.collection("faculty")
        .whereEqualTo("id", id)
        .whereEqualTo("password", password)
        .get().addOnSuccessListener {
            if (it.size() != 0) {
                val documentSnapshot = it.documents[0]
                val user = FacultyDataClass(
                    id = documentSnapshot.getString("id"),
                    email = documentSnapshot.getString("email"),
                        name = documentSnapshot.getString("name"),
                    classes = documentSnapshot.get("classes") as HashMap<String, String>
                )

                facultySharedViewModel.addFacultyUser(user)
                onSubmit()
            }
        }.addOnFailureListener {
            Log.e("Auth", "Invalid User id password")
        }
}

@Composable
@Preview(showBackground = true)
fun LoginScreenPreview() {
//    LoginScreenFacultyComposable(name = "Faculty", onSubmit = {})
}