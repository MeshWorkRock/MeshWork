package com.example.meshworkapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.meshworkapp.*
import com.example.meshworkapp.composables.ChatListComposable
import com.example.meshworkapp.composables.ChatSearchBarComposable
import com.example.meshworkapp.composables.StudentListComposable

@Composable
fun ChatListScreen(
    chatViewModel: ChatListViewModel = viewModel(),
    chatDataList: List<ChatListDataClass>
//    onClick: () -> Unit
) {
    Surface(
        color = MaterialTheme.colors.background
    ) {
        Scaffold {
            Column {
                ChatSearchBarComposable(viewModel = chatViewModel)
                ChatListComposable(
                    chatListViewModel = chatViewModel,
                    chatDataList = chatDataList
//                    onClick = { onClick() }
                )
            }
        }
    }
}