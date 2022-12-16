package com.example.meshworkapp.studentmodule.dataclass

import android.os.Parcelable
import com.example.meshworkapp.common.dataclass.AnnouncementDataClass
import kotlinx.parcelize.Parcelize

@Parcelize
data class AnnouncementsViewModelDataClass (
    var announcementsList: List<AnnouncementDataClass>
): Parcelable