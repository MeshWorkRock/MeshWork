package com.example.meshworkapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meshworkapp.AnnouncementDataClass



//Announcement Screen Code
@Composable
fun AnnouncementScreen(announcementMessages: List<AnnouncementDataClass>) {

    //Composable for Announcement Screen
    Column {
        AnnouncementSearchBarComposable()

        Scaffold(floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.padding(bottom = 55.dp)
            ) {
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
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(5.dp)
                                .fillMaxWidth()
                        ) {
                            Row() {
                                Text(
                                    text = announcement.Heading,
                                    textAlign = TextAlign.Start,
                                    modifier = Modifier.weight(1f)
                                )
                                Text(
                                    text = announcement.Date,
                                    textAlign = TextAlign.End,
                                    modifier = Modifier.weight(1f)
                                )
                            }
                            Text(
                                text = announcement.announcementBody,
                                fontSize = 18.sp,
                                textAlign = TextAlign.Left,
                                modifier = Modifier
                                    .padding(top = 5.dp)
                            )
                        }
                    }
                })
            }
        }
    }

}

//Announcement Screen Search Bar Composable
@Composable
fun AnnouncementSearchBarComposable() {
    var text by remember { mutableStateOf(("")) }
    var showClearIcon by rememberSaveable { mutableStateOf(false) }

    if (text.isEmpty())
        showClearIcon = false
    else if (text.isNotEmpty())
        showClearIcon = true

    TextField(
        value = text,
        onValueChange = { newText ->
            text = newText
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Search,
                tint = MaterialTheme.colors.onBackground,
                contentDescription = "Search Icon"
            )
        },
        trailingIcon = {
            if (showClearIcon) {
                IconButton(
                    onClick = {
                        text = ""
                    }
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Clear,
                        tint = MaterialTheme.colors.onBackground,
                        contentDescription = "Clear Icon"
                    )
                }
            }
        },
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        placeholder = { Text(text = "Search Student") },
        textStyle = MaterialTheme.typography.subtitle1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(90f)
            .background(color = Color.LightGray, shape = CircleShape)
    )
}

