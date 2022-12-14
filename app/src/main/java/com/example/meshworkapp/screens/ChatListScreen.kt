package com.example.meshworkapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.meshworkapp.*
import com.example.meshworkapp.composables.*

@Composable
fun ChatListScreen(
    chatViewModel: ChatListViewModel = viewModel(),
    chatDataList: List<ChatListDataClass>
//    onClick: () -> Unit
) {
    Surface(
//        color = MaterialTheme.colors.background
    ) {
        Scaffold {
            Box {
                GradientBackGround()
                Column {
                    ChatListTopBar()
                    ChatSearchBarComposable(viewModel = chatViewModel, modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(90f)
                        .background(color = Color.White, shape = CircleShape)
                    )
                    ChatListComposable(
                        chatListViewModel = chatViewModel,
                        chatDataList = chatDataList
                        //                    onClick = { onClick() }
                    )
                }
            }
        }
    }
}

