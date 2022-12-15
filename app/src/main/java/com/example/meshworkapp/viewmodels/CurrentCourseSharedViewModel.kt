package com.example.meshworkapp.viewmodels

import android.os.Parcelable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.meshworkapp.StudentsDataClass
import com.example.meshworkapp.dataclassfiles.AssignedClassDataClass
import kotlinx.android.parcel.Parcelize


class CurrentCourseSharedViewModel: ViewModel() {
    var currentCourse = MutableLiveData<AssignedClassDataClass>()
        private set

    fun addCurrentCourse(course: AssignedClassDataClass){
        currentCourse.postValue(course)
    }
    fun setCurrentCourseStudentList(list: List<StudentsDataClass>){
        currentCourse.value?.studentsList = list
    }
}