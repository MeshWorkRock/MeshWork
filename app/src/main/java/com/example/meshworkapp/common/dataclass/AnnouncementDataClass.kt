package com.example.meshworkapp.common.dataclass

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AnnouncementDataClass(
    var Heading : String,
    var Date : String,
    var announcementBody : String
): Parcelable
