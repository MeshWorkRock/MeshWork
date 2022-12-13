package com.example.meshworkapp

import androidx.lifecycle.ViewModel
import com.example.meshworkapp.dataclassfiles.TimeTableDataClass

class TimeTableViewModel : ViewModel() {

    private var timeTableList = ArrayList<TimeTableDataClass>()
    val liveTimeTable: List<TimeTableDataClass>
        get() = this.timeTableList

    init {
        getTimeTable()
    }

    private fun getTimeTable() {

        val timeTableData = listOf(
            TimeTableDataClass(
                time = "09:55\n|\n10:40",
                subject = "Python Programming",
                group = "GP-B",
                teacherName = "Anjul Bhardwaj(E13327)",
                block = "Block-DD6-401-A"
            ),
            TimeTableDataClass(
                time = "10:40 - 11:25",
                subject = "Python Programming",
                group = "GP-B",
                teacherName = "Anjul Bhardwaj(E13327)",
                block = "Block-DD6-401-A"
            ),
            TimeTableDataClass(
                time = "12:10 - 12:55",
                subject = "Design and Analysis of Algorithms",
                group = "GP-All",
                teacherName = "Disha Handa Mahendru(E11162)",
                block = "Block-DD6-401-A"
            ),
            TimeTableDataClass(
                time = "01:40 - 2:25",
                subject = "Advanced Database Management",
                group = "GP-All",
                teacherName = "Anil Kumar(E11187)",
                block = "Block-DD6-401-A"
            )
        )

        timeTableData.forEach {
            timeTableList.add(it)
        }

    }

}