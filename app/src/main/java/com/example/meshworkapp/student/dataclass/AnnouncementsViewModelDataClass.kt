package com.example.meshworkapp.student.dataclass

import android.os.Parcelable
import com.example.meshworkapp.shared.dataclass.AnnouncementDataClass
import kotlinx.parcelize.Parcelize

@Parcelize
data class AnnouncementsViewModelDataClass (
    var announcementsList: List<AnnouncementDataClass>
): Parcelable