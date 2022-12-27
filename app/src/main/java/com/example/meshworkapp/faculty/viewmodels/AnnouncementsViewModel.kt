package com.example.meshworkapp.faculty.screens.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.meshworkapp.shared.dataclass.AnnouncementDataClass
import com.example.meshworkapp.student.dataclass.AnnouncementsViewModelDataClass

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