package com.example.meshworkapp.shared.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.meshworkapp.shared.dataclass.ChatListDataClass

class ChatListViewModel(): ViewModel() {

    //    Don't Declare anything between these three variables
    private var _liveMutableChatList = MutableLiveData<List<ChatListDataClass>>()
    val liveChatList: LiveData<List<ChatListDataClass>>
        get() = this._liveMutableChatList

    //    Only Declare Variables from here on
    private var chatList = ArrayList<ChatListDataClass>()

    fun loadStudents(chatDataList: List<ChatListDataClass>) {

        initializeStudentList(chatDataList)
        this._liveMutableChatList = MutableLiveData<List<ChatListDataClass>>()
        if(_liveMutableChatList.value == null)
            this._liveMutableChatList.postValue(chatList)
    }

    fun performQuery(
        query: String
    ) {
//        Log.i("queryn7", ":1")
        val filteredList = ArrayList<ChatListDataClass>()
        chatList.forEach { chat ->
            if (chat.name.lowercase()
                    .contains(query.lowercase())
            ) {
                filteredList.add(chat)
            }
        }

        this._liveMutableChatList.postValue(filteredList)
    }

    private fun initializeStudentList(chatDataList: List<ChatListDataClass>) {

        val data = chatDataList

        data.forEach {
            chatList.add(it)
        }

        chatList.sortBy { it.lastTime }
//        var i = 0
//        while (i < chatList.size) {
//            if (chatList[i].studentDesignation == "CR") {
//                chatList.add(0, chatList[i])
//                chatList.removeAt(i + 1)
//            }
//            i++
//        }
    }


}