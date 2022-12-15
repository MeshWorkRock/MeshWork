package com.example.meshworkapp.dataclassfiles

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FacultyDataClass(
    val id: String?,
    val email: String?,
    val name: String?,
    val classes: HashMap<String, String>
): Parcelable