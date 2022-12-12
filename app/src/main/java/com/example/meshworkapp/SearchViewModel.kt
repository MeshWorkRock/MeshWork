package com.example.meshworkapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchViewModel() : ViewModel() {

    //    Don't Declare anything between these three variables
    private var _liveMutableStudentsList = MutableLiveData<List<StudentsDataClass>>()
    val liveStudentsList: LiveData<List<StudentsDataClass>>
        get() = this._liveMutableStudentsList

    //    Only Declare Variables from here on
    private var studentList = ArrayList<StudentsDataClass>()


//    init {
//        loadStudents()
//    }

    fun loadStudents(studentDataList: List<StudentsDataClass>) {

        initializeStudentList(studentDataList)
        this._liveMutableStudentsList = MutableLiveData<List<StudentsDataClass>>()
        this._liveMutableStudentsList.postValue(studentList)
    }

    fun performQuery(
        query: String
    ) {
//        Log.i("queryn7", ":1")
        val filteredList = ArrayList<StudentsDataClass>()
        studentList.forEach { student ->
            if (student.studentName.lowercase()
                    .contains(query.lowercase()) || student.studentUID.lowercase()
                    .contains(query.lowercase())
            ) {
                filteredList.add(
                    StudentsDataClass(
                        student.studentName,
                        student.studentUID,
                        student.studentProfile,
                        student.studentDesignation
                    )
                )
            }
        }
        this._liveMutableStudentsList.postValue(filteredList)
    }

    private fun initializeStudentList(studentDataList: List<StudentsDataClass>) {

        val data = studentDataList
//        val data = listOf(
//            StudentsDataClass(
//                studentName = "Pankaj Singh",
//                studentUID = "22MCC20049",
//                studentProfile = R.drawable.dummy_profile_pic,
//                studentDesignation = "CR"
//            ),
//            StudentsDataClass(
//                studentName = "Sahil Vishwakarma",
//                studentUID = "22MCC20030",
//                studentProfile = R.drawable.dummy_profile_pic,
//                studentDesignation = null
//            ),
//            StudentsDataClass(
//                studentName = "Amandeep Singh",
//                studentUID = "22MCC20050",
//                studentProfile = R.drawable.dummy_profile_pic,
//                studentDesignation = null
//            ),
//            StudentsDataClass(
//                studentName = "Mrinal Sahni",
//                studentUID = "22MCC20059",
//                studentProfile = R.drawable.dummy_profile_pic,
//                studentDesignation = null
//            ),
//            StudentsDataClass(
//                studentName = "Mercy",
//                studentUID = "22MCC20090",
//                studentProfile = R.drawable.dummy_profile_pic,
//                studentDesignation = null
//            ),
//            StudentsDataClass(
//                studentName = "Tejas",
//                studentUID = "22MCC20088",
//                studentProfile = R.drawable.dummy_profile_pic,
//                studentDesignation = "CR"
//            ),
//            StudentsDataClass(
//                studentName = "Tejveer",
//                studentUID = "22MCC20072",
//                studentProfile = R.drawable.dummy_profile_pic,
//                studentDesignation = null
//            ),
//            StudentsDataClass(
//                studentName = "Isha Nagpal",
//                studentUID = "22MCC20066",
//                studentProfile = R.drawable.dummy_profile_pic,
//                studentDesignation = null
//            )
//        )

        data.forEach {
            studentList.add(it)
        }

        studentList.sortBy { it.studentUID }
        var i = 0
        while (i < studentList.size) {
            if (studentList[i].studentDesignation == "CR") {
                studentList.add(0, studentList[i])
                studentList.removeAt(i + 1)
            }
            i++
        }
    }
}
