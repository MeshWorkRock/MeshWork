package com.example.meshworkapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.meshworkapp.R
import com.example.meshworkapp.composables.GradientBackGround


@Composable
fun ChatScreen() {


    Column(
        modifier = Modifier
            .fillMaxHeight()
    ) {
        ChatScreenTopBarComposable()
        LeftSideChat(chat = "Good Morning Mam")
        RightSideChatComposable(chat = "Yes student")
        LeftSideChat(chat = "I am having some doubts\n" +
                "I was confused in problem two")
    }



}

@Composable
fun ChatScreenTopBarComposable() {
    Card(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth(),
        elevation = 8.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back_arrow),
                contentDescription = "Back Arrow",
                modifier = Modifier
                    .size(20.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.dummy_profile_pic),

                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(5.dp)
                    .size(60.dp)
                    .clip(CircleShape)
            )
            Column {
                Text(
                    text = "Pankaj Singh",
                    style = MaterialTheme.typography.h6,
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.Start)
                )
                Text(
                    text = "22MCC20049",
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.Start)
                )
            }
        }
    }
}

@Composable
fun RightSideChatComposable(chat: String) {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.End
    ) {
        Card(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        topStart = 10.dp,
                        bottomEnd = 10.dp,
                        bottomStart = 10.dp
                    )
                )
                .padding(end = 5.dp),
            elevation = 8.dp
        ) {
            Text(
                text = chat,
                textAlign = TextAlign.End
            )
        }
    }
}

@Composable
fun LeftSideChat(chat: String) {
    Column(
        modifier = Modifier
            .padding(10.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Card(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        topEnd = 10.dp,
                        bottomEnd = 10.dp,
                        bottomStart = 10.dp
                    )
                )
                .padding(start = 5.dp),
            elevation = 8.dp
        ) {
            Text(
                text = chat,
                textAlign = TextAlign.Start
            )
        }
    }
}

