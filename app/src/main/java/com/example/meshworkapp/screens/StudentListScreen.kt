package com.example.meshworkapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material.*
import com.example.meshworkapp.StudentSearchBarComposable
import com.example.meshworkapp.StudentViewModel
import com.example.meshworkapp.StudentsDataClass
import com.example.meshworkapp.composables.ChatListComposable
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
            Column {
                StudentSearchBarComposable(viewModel = studentViewModel)
                StudentListComposable(
                    searchViewModel = studentViewModel,
                    studentDataList = studentDataList
//                    onClick = { onClick() }
                )
            }
        }
    }
}
