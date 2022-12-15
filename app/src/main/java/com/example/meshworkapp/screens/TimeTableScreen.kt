package com.example.meshworkapp.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meshworkapp.dataclassfiles.TimeTableDataClass
import com.example.meshworkapp.composables.HomeBackGround
import com.example.meshworkapp.composables.TimeTableBackground
import com.example.meshworkapp.ui.theme.DarkBlueText
import java.text.DateFormatSymbols
import java.util.*

@Composable
fun TimeTableScreen(timeTableList: Array<Array<TimeTableDataClass>>) {
    val date: Calendar = Calendar.getInstance()
    val currentDay = date.get(Calendar.DAY_OF_WEEK)

    Box {
        TimeTableBackground()
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            DayChipComposable(currentDay, timeTableList)
        }
    }
}


///Function for the Day Chip
@Composable
fun DayChipComposable(currentDay: Int, timeTableList: Array<Array<TimeTableDataClass>>) {

    //
    val weekday: String = DateFormatSymbols().getWeekdays().get(currentDay)

    //Defining variable
    var pressedDay by remember { mutableStateOf(currentDay) }
    var selectedDay by remember { mutableStateOf(weekday) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        LazyRow(horizontalArrangement = Arrangement.SpaceBetween) {
            itemsIndexed(
                listOf("M", "T", "W", "T", "F")
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
                                selectedDay = weekday
                            }
                        }
                    },
                    shape = CircleShape,
                    colors = if (index == pressedDay) ButtonDefaults.buttonColors(backgroundColor = Color.Gray)
                    else ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    modifier = Modifier
                        .padding(end = 5.dp, top = 5.dp)
                        .size(55.dp),
                ) {
                    Text(text = string, fontSize = 20.sp)
                }

            }
        }
    }
    TimeTableComposable(
//        viewModel = TimeTableViewModel(),
        selectedDay = selectedDay,
        timeTableList
    )
}


//Function for Daily Lectures List
@Composable
fun TimeTableComposable(
//    viewModel: TimeTableViewModel,
    selectedDay: String,
    arrLectureList: Array<Array<TimeTableDataClass>>
) {

    var timeTableList: Array<TimeTableDataClass> = arrLectureList[4]

    when (selectedDay) {
        "Monday" -> timeTableList = arrLectureList[0]
        "Tuesday" -> timeTableList = arrLectureList[1]
        "Wednesday" -> timeTableList = arrLectureList[2]
        "Thursday" -> timeTableList = arrLectureList[3]
        "Friday" -> timeTableList = arrLectureList[4]
        else -> {
            Toast.makeText(
                LocalContext.current,
                "The day is $selectedDay is not shown",
                Toast.LENGTH_LONG
            )
                .show()
        }
    }



    LazyColumn(
        modifier = Modifier
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

            Column {
                SubjectComposable(Subject = timeTable)
                GroupAndBlockComposable(GroupBlock = timeTable)
                TeacherNameComposable(Teacher = timeTable)
            }
        }
    }
}

@Composable
fun TimeStampComposable(Time: TimeTableDataClass) {
    Column(verticalArrangement = Arrangement.Center,
    modifier = Modifier
        .padding(5.dp)
        .fillMaxHeight()) {
        Text(
            text = Time.time,
            textAlign = TextAlign.Center,
            color = DarkBlueText
        )
    }
}


@Composable
fun SubjectComposable(Subject: TimeTableDataClass) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text(
            text = Subject.subject,
            color = DarkBlueText
        )
    }
}

@Composable
fun GroupAndBlockComposable(GroupBlock: TimeTableDataClass) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = GroupBlock.group,
            color = DarkBlueText
        )
        Text(
            text = GroupBlock.block,
            color = DarkBlueText
        )
    }
}

@Composable
fun TeacherNameComposable(Teacher: TimeTableDataClass) {
    Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Center) {
        Text(
            text = Teacher.teacherName,
            color = DarkBlueText
        )
    }
}

