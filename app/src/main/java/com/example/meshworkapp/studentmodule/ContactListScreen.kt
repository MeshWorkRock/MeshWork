package com.example.meshworkapp.studentmodule

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meshworkapp.R
import com.example.meshworkapp.composables.AnnouncementBackground
import com.example.meshworkapp.composables.ContactCardComposable
import com.example.meshworkapp.composables.HomeBackGround
import com.example.meshworkapp.dataclassfiles.ContactDataClass

@Composable
fun ContactListScreen(contactList: List<ContactDataClass>) {

    Box {
        AnnouncementBackground()
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(10.dp),
            ) {
                Text(
                    text = "Contacts",
                    style = MaterialTheme.typography.h4,
                    textAlign = TextAlign.Start,
                    color = Color.White
                )
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                if (!contactList.isNullOrEmpty()) {
                    items(items = contactList) { contactList ->                            //TODO Optimise By using Other than List.distinct()
                        ContactCardComposable(
                            contactList
                            //                    onClick = { onClick }
                        )
                        Spacer(modifier = Modifier
                            .height(5.dp)
                        )
                    }
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ContactListScreenPreview() {

    ContactListScreen(listOf(
        ContactDataClass(name = "Rythem",
            profile = R.drawable.profile_image_dummy,
            email = "pankajsingh13042000@gmail.com",
            subject = "Python Programing",
            designation = "Programme Lead"
        ),
        ContactDataClass(name = "Rythem",
            profile = R.drawable.profile_image_dummy,
            email = "pankajsingh13042000@gmail.com",
            subject = "Python Programing",
            designation = "Programme Lead"
        ),
        ContactDataClass(name = "Rythem",
            profile = R.drawable.profile_image_dummy,
            email = "pankajsingh13042000@gmail.com",
            subject = "Python Programing",
            designation = "Programme Lead"
        )
    ))

}