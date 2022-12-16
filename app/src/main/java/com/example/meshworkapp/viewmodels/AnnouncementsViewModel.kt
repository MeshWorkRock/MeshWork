package com.example.meshworkapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.meshworkapp.common.dataclass.AnnouncementDataClass
import com.example.meshworkapp.studentmodule.StudentDataClass
import com.example.meshworkapp.studentmodule.dataclass.AnnouncementsViewModelDataClass

class AnnouncementsViewModel: ViewModel() {
    var announcements = MutableLiveData<AnnouncementsViewModelDataClass>()
        private set

    fun addAnnouncements(course: AnnouncementsViewModelDataClass){
        announcements.postValue(course)
    }
    fun setAnnouncementList(list: List<AnnouncementDataClass>){
        announcements.value?.announcementsList = list
    }
}