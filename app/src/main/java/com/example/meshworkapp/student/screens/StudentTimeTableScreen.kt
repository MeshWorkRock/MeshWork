package com.example.meshworkapp.studentmodule

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.meshworkapp.faculty.navigationgraphs.fetchTimeTableList
import com.example.meshworkapp.faculty.screens.TimeTableScreen

@Composable
fun StudentTimeTableScreen() {

    val timetable = fetchTimeTableList()
    TimeTableScreen(
        timeTableList = timetable
    )
    
}

@Preview(showBackground = true)
@Composable
fun StudentTimeTableScreenPreview() {

    val timetable = fetchTimeTableList()

    TimeTableScreen(timetable)

}