package com.example.meshworkapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CreateAnnouncementScreen() {
    Column(horizontalAlignment = Alignment.Start) {
        Text(
            text = "Create ",
            fontSize = 30.sp,
            modifier = Modifier.padding(top = 35.dp, start = 10.dp)
        )
        Text(
            text = "Announcement",
            fontSize = 30.sp,
            modifier = Modifier.padding(bottom = 10.dp, start = 10.dp)
        )

        CreateAnnouncementInfoScreen()
        AnnouncementDataEnterScreen()

    }


}

@Composable
fun CreateAnnouncementInfoScreen() {
    Card(
        elevation = 10.dp,
        modifier = Modifier
            .padding(10.dp),
        shape = RoundedCornerShape(20.dp)

    ) {
        Column(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Batch : 2022",
                fontSize = 18.sp,
                textAlign = TextAlign.Start,
            )
            Text(
                text = "Course: BSc",
                fontSize = 18.sp,
                textAlign = TextAlign.Start,
            )
            Text(
                text = "Section 1",
                fontSize = 18.sp,
                textAlign = TextAlign.Start,
            )
        }
    }
}

@Composable
fun AnnouncementDataEnterScreen() {

    // Creating a variable to store the TextField value
    var value by remember { mutableStateOf("") }

    // Creating a Basic TextField bu adding
    // innerTextField that will display the Text hint
    BasicTextField(
        value = value,
        onValueChange = { value = it },
        decorationBox = { innerTextField ->
            Row(
                Modifier
                    .background(Color.LightGray, RoundedCornerShape(percent = 5))
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {

                if (value.isEmpty()) {
                    Text("Enter Something...", fontSize = 18.sp)
                }
                // <-- Add this
                innerTextField()
            }
        },
        modifier = Modifier
            .padding(top = 35.dp, start = 10.dp, end = 10.dp)
            .fillMaxHeight(),



    )
//    var text by remember { mutableStateOf(("")) }
//    var showClearIcon by rememberSaveable { mutableStateOf(false) }
//    if (text.isEmpty())
//        showClearIcon = false
//    else if (text.isNotEmpty())
//        showClearIcon = true
//    TextField(
//        value = text,
//        onValueChange = { newText ->
//            text = newText
//        },
//
//        trailingIcon = {
//            if (showClearIcon) {
//                IconButton(
//                    onClick = {
//                        text = ""
//                    }
//                ) {
//                    Icon(
//                        imageVector = Icons.Rounded.Clear,
//                        tint = MaterialTheme.colors.onBackground,
//                        contentDescription = "Clear Icon"
//                    )
//                }
//            }
//        },
//        maxLines = 14,
//        colors = TextFieldDefaults.textFieldColors(
//            backgroundColor = Color.Transparent,
//            focusedIndicatorColor = Color.Transparent,
//            unfocusedIndicatorColor = Color.Transparent
//        ),
//        placeholder = { Text(text = "Search Student") },
//        textStyle = MaterialTheme.typography.subtitle1,
//        singleLine = true,
//        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
//        modifier = Modifier
//            .padding(10.dp)
//            .fillMaxWidth(90f)
//            .fillMaxHeight()
//            .background(color = Color.LightGray, shape = RectangleShape)
//    )
}

@Preview(showBackground = true)
@Composable
fun SamplePreviewFunction() {
    CreateAnnouncementScreen()
}