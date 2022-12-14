package com.example.meshworkapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material.*
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

@Composable
fun StudentListScreen(
    studentViewModel: StudentViewModel = viewModel(),
    studentDataList: List<StudentsDataClass>
//    onClick: () -> Unit
) {
    Surface(
        color = MaterialTheme.colors.background
    ) {
        Scaffold {
            Box {
                GradientBackGround()
                Column {
                    StudentListTopBar(className = "22BSc - 1")
                    StudentSearchBarComposable(
                        viewModel = studentViewModel,
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth(90f)
                            .background(color = Color.White, shape = CircleShape),
                    )
                    StudentListComposable(
                        searchViewModel = studentViewModel,
                        studentDataList = studentDataList
                        //                    onClick = { onClick() }
                    )
                }
            }
        }
    }
}
