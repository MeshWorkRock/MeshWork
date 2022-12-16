package com.example.meshworkapp.dataclassfiles

import android.os.Parcelable
import com.example.meshworkapp.studentmodule.StudentDataClass
import kotlinx.parcelize.Parcelize

@Parcelize
data class AssignedClassDataClass(
    val className: String,
    val subject: String,
    var studentsList: List<StudentDataClass>?

): Parcelable