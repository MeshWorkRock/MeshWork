package com.example.meshworkapp.student.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.meshworkapp.student.dataclass.StudentDataClass

class StudentSharedViewModel : ViewModel() {

    var studentUser by mutableStateOf<StudentDataClass?>(null)
        private set
    fun addStudentUser(user: StudentDataClass){
        studentUser = user
    }

}