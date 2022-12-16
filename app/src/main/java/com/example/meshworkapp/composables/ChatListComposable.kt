package com.example.meshworkapp.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.meshworkapp.common.dataclass.ChatListDataClass
import com.example.meshworkapp.common.viewmodel.ChatListViewModel
import com.example.meshworkapp.ui.theme.DarkBlueText
//
//@Composable
//fun ChatListComposable(
//    chatListViewModel: ChatListViewModel,
//    chatDataList: List<ChatListDataClass>
////    onClick: () -> Unit
//) {
//
//    var initializedStudentList by remember {
//        mutableStateOf(false)
//    }
//    if(!initializedStudentList){
//        chatListViewModel.loadStudents(chatDataList)
//        initializedStudentList = true
//    }
//
//    var chatList = chatListViewModel.liveChatList.observeAsState().value
//    chatList = chatList?.distinct()
////    Toast.makeText(LocalContext.current, "list count = ${studentList?.size}", Toast.LENGTH_SHORT).show()
//    LazyColumn(
//        modifier = Modifier.padding(bottom = 48.dp)
//    ) {
//        if (!chatList.isNullOrEmpty()) {
//            items(items = chatList) { chat ->
//                ChatListCardComposable(
//                    chat = chat
////                    onClick = { onClick }
//                )
//            }
//        }
//    }
//}
//
//// Card which contains student profile composable,
//// student UID composable, student designation badge composable
//@Composable
//fun ChatListCardComposable(
//    chat: ChatListDataClass,
////    onClick: () -> Unit
//) {
//    Card(
//        elevation = 8.dp,
//        shape = RoundedCornerShape(10.dp),
//        modifier = Modifier
//            .padding(5.dp)
////        .clickable{ onClick() },
//    ) {
//        Row(
//            verticalAlignment = Alignment.CenterVertically,
//            modifier = Modifier
//                .fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Row {
//                StudentPr+ofileImageComposable(chat)
//                StudentNameAndLastTextComposable(chat)
//            }
//            Row(
//                modifier = Modifier
//                    .padding(end = 10.dp)
//            ) {
//                StudentLastTime(chat)
//            }
//        }
//    }
//}
//
//// It show student designation in student list
//
//// It will show student Name and Student UID in student list
//@Composable
//fun StudentNameAndLastTextComposable(chat : ChatListDataClass) {
//    Column {
//        Text(
//            text = chat.name,
//            style = MaterialTheme.typography.h6,
//            color = DarkBlueText,
//            modifier = Modifier
////                .padding(horizontal = 20.dp, vertical = 5.dp)
//                .wrapContentWidth(Alignment.Start)
//        )
//        Text(
//            text = chat.lastText,
//            style = MaterialTheme.typography.body2,
//            color = DarkBlueText,
//            modifier = Modifier
////                .padding(horizontal = 20.dp, vertical = 5.dp)
//                .wrapContentWidth(Alignment.Start)
//        )
//    }
//}
//
//// It will show Student Profile Picture in student list
//@Composable
//fun StudentProfileImageComposable(chat : ChatListDataClass) {
//    Image(
//        painter = painterResource(id = chat.profile),
//        contentDescription = null,
//        contentScale = ContentScale.Crop,
//        modifier = Modifier
//            .padding(5.dp)
//            .size(50.dp)
//            .clip(CircleShape)
//    )
//}
//
//@Composable
//fun StudentLastTime(chat: ChatListDataClass) {
//
//
//    Text(
//        text = chat.lastTime,
//
//        )
//
//}
//
//
