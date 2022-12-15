package com.example.meshworkapp.dataclassfiles

import android.os.Parcelable
import com.example.meshworkapp.StudentsDataClass
import kotlinx.parcelize.Parcelize

data class AssignedClassDataClass(
    val className: String,
    val subject: String,
    var studentsList: List<StudentsDataClass>?

)