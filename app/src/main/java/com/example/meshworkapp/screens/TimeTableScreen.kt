package com.example.meshworkapp.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meshworkapp.TimeTableDataClass
import com.example.meshworkapp.TimeTableViewModel
import java.util.*

@Composable
fun TimeTableScreen() {
    val date: Calendar = Calendar.getInstance()
    val currentDay = date.get(Calendar.DAY_OF_WEEK)


    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        DayChipComposable(currentDay)
//        TimeTableComposable(viewModel = TimeTableViewModel())
    }

}


@Composable
fun DayChipComposable(currentDay: Int) {
    var pressedDay by remember {
        mutableStateOf(currentDay)
    }

    var selectedDay by remember {
        mutableStateOf("")
    }


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        LazyRow {
            itemsIndexed(
                listOf("M", "T", "W", "T", "F"),
            ) { index, string ->
                Button(
                    onClick = {
                              pressedDay = index
                        when (index) {
                            0 -> selectedDay = "Monday"
                            1 -> selectedDay = "Tuesday"
                            2 -> selectedDay = "Wednesday"
                            3 -> selectedDay = "Thursday"
                            4 -> selectedDay = "Friday"
                            else -> {
                                 selectedDay = "Monday"
                            }
                        }
                    },
                    shape = CircleShape,
                    colors = if(index == pressedDay) ButtonDefaults.buttonColors(backgroundColor = Color.Blue)
                                else ButtonDefaults.buttonColors(backgroundColor = Color.Gray) ,
                    modifier = Modifier
                        .padding(end = 5.dp, top = 5.dp)
                        .size(55.dp),
                ) {
                    Text(text = string, fontSize = 20.sp)
                }

            }
        }
    }

sampleComposable(context = LocalContext.current, selectedDay = selectedDay)
}

//Sample Bottom Composable
@Composable
fun sampleComposable(context : Context, selectedDay: String){
    Toast.makeText(context, "The selected day is $selectedDay", Toast.LENGTH_LONG).show()
}



//Daily Lectures List
@Composable
fun TimeTableComposable(viewModel: TimeTableViewModel, selectedDay: String) {
    val timeTableList: List<TimeTableDataClass> = viewModel.liveTimeTable

    LazyColumn(        modifier = Modifier
            .fillMaxSize()
    ) {

        if (timeTableList.isNotEmpty()) {
            items(items = timeTableList) { timeTable ->
                TimeTableCard(timeTable = timeTable)
            }
        }

    }

}

@Composable
fun TimeTableCard(timeTable: TimeTableDataClass) {

    Card(
        elevation = 8.dp,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(20.dp)
    ) {

        Row(
            modifier = Modifier
                .padding(10.dp)
        ) {
            TimeStampComposable(Time = timeTable)

            SubjectGroupTeacherComposable(SubjectGroupTeacher = timeTable)

            BlockComposable(Block = timeTable)
        }

    }

}

@Composable
fun TimeStampComposable(Time: TimeTableDataClass) {

    Box(
        contentAlignment = Alignment.Center,
    ) {
        Row(verticalAlignment = Alignment.CenterVertically){
            Text(text = Time.time, textAlign = TextAlign.Center)
        }
    }

}

@Composable
fun SubjectGroupTeacherComposable(SubjectGroupTeacher: TimeTableDataClass) {

    Box(
        modifier = Modifier
            .size(100.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
            //            .fillMaxWidth()
        ) {

            Text(text = SubjectGroupTeacher.subject)

            Text(text = SubjectGroupTeacher.group)

            Text(text = SubjectGroupTeacher.teacherName)

        }
    }

}

@Composable
fun BlockComposable(Block: TimeTableDataClass) {

    Box(
        modifier = Modifier,
        contentAlignment = Alignment.CenterEnd
    ) {
        Text(
            text = Block.block
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TimeTableCard(timeTable = TimeTableDataClass(
        time = "9:55 - 10:40",
        subject = "Python Programming",
        group = "all",
        teacherName = "Anjul Bhardwaj",
        block = "DD6 - 413"
    )
    )
}


