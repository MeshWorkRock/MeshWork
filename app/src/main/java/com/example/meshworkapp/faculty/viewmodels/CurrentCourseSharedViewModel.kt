package com.example.meshworkapp.faculty.screens.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.meshworkapp.faculty.dataclasses.AssignedClassDataClass
import com.example.meshworkapp.student.dataclass.StudentDataClass


class CurrentCourseSharedViewModel: ViewModel() {
    var currentCourse = MutableLiveData<AssignedClassDataClass>()
        private set

    fun addCurrentCourse(course: AssignedClassDataClass){
        currentCourse.postValue(course)
    }
    fun setCurrentCourseStudentList(list: List<StudentDataClass>){
        currentCourse.value?.studentsList = list
    }
}