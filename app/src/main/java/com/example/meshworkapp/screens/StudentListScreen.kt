package com.example.meshworkapp.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meshworkapp.R
import com.example.meshworkapp.StudentListTopBar
import com.example.meshworkapp.StudentSearchBarComposable
import com.example.meshworkapp.StudentViewModel
import com.example.meshworkapp.StudentsDataClass
import com.example.meshworkapp.composables.ChatListComposable
import com.example.meshworkapp.composables.GradientBackGround
import com.example.meshworkapp.composables.StudentListComposable
import com.example.meshworkapp.viewmodels.CurrentCourseSharedViewModel
import com.example.meshworkapp.viewmodels.FacultySharedViewModel
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun StudentListScreen(
    studentViewModel: StudentViewModel = viewModel(),
    currentCourseSharedViewModel: CurrentCourseSharedViewModel,
    facultySharedViewModel: FacultySharedViewModel
//    studentDataList: List<StudentsDataClass>
//    onClick: () -> Unit
) {

    fetchStudentsList(
        currentCourseSharedViewModel = currentCourseSharedViewModel,
        studentViewModel = studentViewModel
    )


    Surface(
        color = MaterialTheme.colors.background
    ) {
        Scaffold {
            Box {
                GradientBackGround()
                Column {
                    StudentListTopBar(className = currentCourseSharedViewModel.currentCourse.value?.className!!)
                    StudentSearchBarComposable(
                        viewModel = studentViewModel,
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth(90f)
                            .background(color = Color.White, shape = CircleShape),
                    )
                    StudentListComposable(
                        searchViewModel = studentViewModel,
                        currentCourseSharedViewModel = currentCourseSharedViewModel
                        //                    onClick = { onClick() }
                    )
                }
            }
        }
    }
}

@Composable
fun fetchStudentsList(
    currentCourseSharedViewModel: CurrentCourseSharedViewModel,
    studentViewModel: StudentViewModel,
) {

    val studentsList = ArrayList<StudentsDataClass>()
    val firebaseFirestore = FirebaseFirestore.getInstance()
    firebaseFirestore.collection("students").whereEqualTo(
        "course",
        currentCourseSharedViewModel.currentCourse.value?.className
    ).get().addOnSuccessListener {
        it.forEach{doc->
            studentsList.add(StudentsDataClass(
                studentName = doc.getString("name"),
                studentUID = doc.getString("name"),
                studentProfile = R.drawable.dummy_profile_pic,
                studentDesignation = null
            ))
        }
        currentCourseSharedViewModel.setCurrentCourseStudentList(studentsList.toList())
    }
    Log.e("List", "${studentsList.size}")


    /*return listOf(
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
    )*/
}
