package com.example.meshworkapp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AnnouncementComposable() {
    val announcementMessages = listOf(
        AnnouncementDataClass(
            "Sahil",
            "Python Programming",
            "Dear Students (22MCA 4B; Python Programming) Submit Worksheet and quiz 2.4 by 4/11/2022"
        ),
        AnnouncementDataClass(
            "Pankaj",
            "Linux",
            "Dear Students You are advised to pay your TPP fees before deadline.No extension will be given."
        ),
        AnnouncementDataClass(
            "Aman",
            "Adbms",
            "Dear Students You are advised to pay your TPP fees before deadline.No extension will be given."
        )

    )

    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = { /*TODO*/ }) {
            Text(
                text = "+", fontSize = 30.sp
            )
        }
    }) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(items = announcementMessages, itemContent = { announcement ->
                Card(
                    elevation = 10.dp,
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(5.dp)) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = announcement.senderName)
                            Text(text = announcement.programDetail)
                        }
                        Text(
                            text = announcement.announcementMessage,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Left,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 5.dp)
                        )
                    }
                }
            })
        }
    }

}


@Preview(showBackground = true)
@Composable
fun AnnouncementPreview() {
    AnnouncementComposable()
}