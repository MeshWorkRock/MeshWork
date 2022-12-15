package com.example.meshworkapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StudentViewModel() : ViewModel() {

    //    Don't Declare anything between these three variables
    private var _liveMutableStudentsList = MutableLiveData<List<StudentsDataClass>>()
    val liveStudentsList: LiveData<List<StudentsDataClass>>
        get() = this._liveMutableStudentsList

    //    Only Declare Variables from here on
    private var studentList = ArrayList<StudentsDataClass>()

    fun loadStudents(studentDataList: List<StudentsDataClass>) {

        initializeStudentList(studentDataList)
        this._liveMutableStudentsList = MutableLiveData<List<StudentsDataClass>>()
        if(_liveMutableStudentsList.value == null)
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
                filteredList.add(student)
            }
        }

        this._liveMutableStudentsList.postValue(filteredList)
    }

    private fun initializeStudentList(studentDataList: List<StudentsDataClass>) {

        studentDataList.forEach {
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
