package com.example.meshworkapp.composables

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meshworkapp.dataclassfiles.ListItemDataClass
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AnnouncementFilterBottomScreenComposable(batchList: List<String>): List<ListItemDataClass> {
    val sheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = sheetState
    )

    val scope = rememberCoroutineScope()

    //list of selection element
    var selectedList = listOf<ListItemDataClass>()

    @Composable
    fun SubmitButton(items:List<ListItemDataClass>){
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {
                scope.launch {
                    if (sheetState.isExpanded) {
                        sheetState.collapse()
                    } else {
                        sheetState.collapse()
                    }
                    selectedList = items

                }
            }, modifier = Modifier.padding(bottom = 15.dp)) {
                Text(text = "Submit", textAlign = TextAlign.Center)
            }
        }
    }
     Log.d("selectedtext","$selectedList")
    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetContent = {
            //Selected Item in the list
            var items by remember {
                mutableStateOf(batchList.map {
                    ListItemDataClass(
                        title = it,
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
        },
        sheetBackgroundColor = Color.LightGray,
        backgroundColor = Color.Transparent,
        sheetPeekHeight = 0.dp,
        sheetShape = RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp)
    ) {

        //BatchFilterCard
        Box (){
            Card(
                shape = RoundedCornerShape(20.dp),
                backgroundColor = Color.White,
                elevation = 8.dp,
                modifier = Modifier
                    .padding(10.dp)
                    .clickable(onClick = {
                        scope.launch {
                            if (sheetState.isCollapsed) {
                                sheetState.expand()
                            } else {
                                sheetState.collapse()
                            }
                        }
                    })
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                )
                {
                    Text(
                        text = "Batch",
                        Modifier
                            .weight(1f)
                            .align(alignment = Alignment.CenterVertically)
                            .padding(start = 10.dp),
                        fontSize = 30.sp,
                        fontWeight = FontWeight.ExtraBold,
                    )
                    Text(
                        text = "selected",
                        Modifier
                            .weight(1f)
                            .align(alignment = Alignment.CenterVertically)
                            .padding(start = 10.dp),
                        fontSize = 30.sp,
                        fontWeight = FontWeight.ExtraBold,
                    )
                }
            }
        }
    }
    return selectedList
}


@Preview(showBackground = true)
@Composable
fun Samplepreview(){
    AnnouncementFilterBottomScreenComposable(batchList = listOf("Sahil","rahul"))
}