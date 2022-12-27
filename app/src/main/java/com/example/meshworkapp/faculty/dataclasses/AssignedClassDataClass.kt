package com.example.meshworkapp.faculty.dataclasses

import android.os.Parcelable
import com.example.meshworkapp.student.dataclass.StudentDataClass
import kotlinx.parcelize.Parcelize

@Parcelize
data class AssignedClassDataClass(
    val className: String,
    val subject: String,
    var studentsList: List<StudentDataClass>?

): Parcelable