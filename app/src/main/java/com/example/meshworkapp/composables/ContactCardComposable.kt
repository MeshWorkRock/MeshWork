package com.example.meshworkapp.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meshworkapp.dataclassfiles.ContactDataClass


@Composable
fun ContactCardComposable(contactList: ContactDataClass) {

    Card(
        shape = RoundedCornerShape(8.dp)
    ) {

        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {

            Row (
                modifier =
                Modifier.fillMaxWidth()
            ){

                Image(
                    painter = painterResource(id = contactList.profile),
                    contentDescription = "Profile image",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(50.dp)

                )
                Text(
                    text = contactList.name,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(5.dp),
                    style = MaterialTheme.typography.h6

                )
                Text(
                    text = contactList.designation,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(5.dp),
                    style = MaterialTheme.typography.h6,
                    fontSize = 16.sp

                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = contactList.subject,
                style = MaterialTheme.typography.h6
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Mail: ${contactList.email}",
                style = MaterialTheme.typography.body2,
                fontSize = 18.sp
            )

        }

    }

}