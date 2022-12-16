package com.example.meshworkapp.composables

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meshworkapp.dataclassfiles.ListItemDataClass

@Composable
fun AnnouncementFilterSelectorScreenComposable(batchList: List<ListItemDataClass>): List<ListItemDataClass>{

    var items by remember {
        mutableStateOf(batchList.map {
            ListItemDataClass(
                title = "it",
                isSelected = false
            )
        })
    }

    LazyColumn(modifier = Modifier
        .padding(12.dp)
        .height(150.dp)) {
        items(items.size) { i ->
            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    items = items.mapIndexed { j, item ->
                        if (i == j) {
                            item.copy(isSelected = !item.isSelected)
                        } else item
                    }
                },
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically) {

                Text(text = items[i].title, modifier = Modifier
                    .padding(2.dp), fontSize =18.sp )
                if (items[i].isSelected) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "Selected",
                        tint = Color.Blue,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
    }
    SubmitButton(items.filter { it.isSelected })
    Log.d("BatchList","$items")

  return batchList
}

@Composable
fun SubmitButton(items:List<ListItemDataClass>){
    //list of selection element
    var selectedList = listOf<ListItemDataClass>()
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {
       selectedList = items
        }, modifier = Modifier.padding(bottom = 15.dp)) {
            Text(text = "Submit", textAlign = TextAlign.Center)
        }
    }
}