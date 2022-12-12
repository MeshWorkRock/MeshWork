package com.example.meshworkapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material.*
import com.example.meshworkapp.SearchBarComposable
import com.example.meshworkapp.SearchViewModel
import com.example.meshworkapp.StudentsDataClass
import com.example.meshworkapp.composables.StudentListComposable

@Composable
fun StudentListScreen(
    searchViewModel: SearchViewModel = viewModel(),
    studentDataList: List<StudentsDataClass>
//    onClick: () -> Unit
) {
    Surface(
        color = MaterialTheme.colors.background
    ) {
        Scaffold {
            Column {
                SearchBarComposable(searchViewModel)
                StudentListComposable(
                    searchViewModel = searchViewModel,
                    studentDataList = studentDataList
//                    onClick = { onClick() }
                )
            }
        }
    }
}
