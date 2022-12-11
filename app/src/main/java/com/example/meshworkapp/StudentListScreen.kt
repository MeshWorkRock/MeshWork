package com.example.meshworkapp

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material.*

@Composable
fun StudentListScreen(
    searchViewModel: SearchViewModel = viewModel()
) {
    Surface(
        color = MaterialTheme.colors.background
    ) {
        Scaffold {
            Column {
                SearchBarComposable(searchViewModel)
                StudentListComposable(searchViewModel)
            }
        }
    }
}
