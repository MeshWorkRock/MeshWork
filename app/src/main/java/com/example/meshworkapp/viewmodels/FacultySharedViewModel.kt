package com.example.meshworkapp.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.meshworkapp.dataclassfiles.FacultyDataClass

class FacultySharedViewModel: ViewModel() {
    var facultyUser by mutableStateOf<FacultyDataClass?>(null)
        private set
    fun addFacultyUser(user: FacultyDataClass){
        facultyUser = user
    }
}