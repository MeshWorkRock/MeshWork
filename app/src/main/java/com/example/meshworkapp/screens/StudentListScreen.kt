package com.example.meshworkapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material.*
import androidx.compose.ui.unit.sp
import com.example.meshworkapp.SearchBarComposable
import com.example.meshworkapp.SearchViewModel
import com.example.meshworkapp.composables.StudentListComposable

@Composable
fun StudentListScreen(
    searchViewModel: SearchViewModel = viewModel(),
//    onClick: () -> Unit
) {
    Surface(
        color = MaterialTheme.colors.background
    ) {
        Scaffold {
            Column {
//                Text(text = "CHat", fontSize = 42.sp)
                SearchBarComposable(searchViewModel)
                StudentListComposable(
                    viewModel = searchViewModel,
//                    onClick = { onClick() }
                )
            }
        }
    }
}
