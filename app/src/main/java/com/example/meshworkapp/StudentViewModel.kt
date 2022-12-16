package com.example.meshworkapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.meshworkapp.studentmodule.StudentDataClass

class StudentViewModel() : ViewModel() {

    //    Don't Declare anything between these three variables
    private var _liveMutableStudentsList = MutableLiveData<List<StudentDataClass>>()
    val liveStudentsList: LiveData<List<StudentDataClass>>
        get() = this._liveMutableStudentsList

    //    Only Declare Variables from here on
    private var studentList = ArrayList<StudentDataClass>()

    fun loadStudents(studentDataList: List<StudentDataClass>?) {

        initializeStudentList(studentDataList)
        this._liveMutableStudentsList = MutableLiveData<List<StudentDataClass>>()
        if(_liveMutableStudentsList.value == null)
            this._liveMutableStudentsList.postValue(studentList)
    }

    fun performQuery(
        query: String
    ) {
//        Log.i("queryn7", ":1")
        val filteredList = ArrayList<StudentDataClass>()
        studentList.forEach { student ->
            if (student.name?.lowercase()
                    !!.contains(query.lowercase()) || student.id?.lowercase()
                    !!.contains(query.lowercase())
            ) {
                filteredList.add(student)
            }
        }

        this._liveMutableStudentsList.postValue(filteredList)
    }

    private fun initializeStudentList(studentDataList: List<StudentDataClass>?) {

        val data = studentDataList
//        val data = listOf(
//            StudentDataClass(
//                studentName = "Pankaj Singh",
//                studentUID = "22MCC20049",
//                studentProfile = R.drawable.dummy_profile_pic,
//                studentDesignation = "CR"
//            ),
//            StudentDataClass(
//                studentName = "Sahil Vishwakarma",
//                studentUID = "22MCC20030",
//                studentProfile = R.drawable.dummy_profile_pic,
//                studentDesignation = null
//            ),
//            StudentDataClass(
//                studentName = "Amandeep Singh",
//                studentUID = "22MCC20050",
//                studentProfile = R.drawable.dummy_profile_pic,
//                studentDesignation = null
//            ),
//            StudentDataClass(
//                studentName = "Mrinal Sahni",
//                studentUID = "22MCC20059",
//                studentProfile = R.drawable.dummy_profile_pic,
//                studentDesignation = null
//            ),
//            StudentDataClass(
//                studentName = "Mercy",
//                studentUID = "22MCC20090",
//                studentProfile = R.drawable.dummy_profile_pic,
//                studentDesignation = null
//            ),
//            StudentDataClass(
//                studentName = "Tejas",
//                studentUID = "22MCC20088",
//                studentProfile = R.drawable.dummy_profile_pic,
//                studentDesignation = "CR"
//            ),
//            StudentDataClass(
//                studentName = "Tejveer",
//                studentUID = "22MCC20072",
//                studentProfile = R.drawable.dummy_profile_pic,
//                studentDesignation = null
//            ),
//            StudentDataClass(
//                studentName = "Isha Nagpal",
//                studentUID = "22MCC20066",
//                studentProfile = R.drawable.dummy_profile_pic,
//                studentDesignation = null
//            )
//        )

        data?.forEach {
            studentList.add(it)
        }

        studentList.sortBy { it.id }
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
