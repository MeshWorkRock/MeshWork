package com.example.meshworkapp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun TimeTableScreen(viewModel: TimeTableViewModel) {
    val timeTableList: List<TimeTableDataClass> = viewModel.liveTimeTable

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

            SubjectGroupTeacherComposable(SubjectGroupTeacher = timeTable)

            BlockComposable(Block = timeTable)
        }

    }

}

@Composable
fun TimeStampComposable(Time: TimeTableDataClass) {

    Box(
        modifier = Modifier,
        contentAlignment = Alignment.CenterStart
    ) {
        Text(text = Time.time)
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
    ))
}

