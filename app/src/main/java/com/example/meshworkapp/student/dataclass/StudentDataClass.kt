package com.example.meshworkapp.student.dataclass

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StudentDataClass     (
    val id: String?,
    val name: String?,
    val course: String?,
    val studentProfile: Int?,
    val studentDesignation: String? = null
): Parcelable
