package com.ziyad.workbucket.findpartner.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FindPartnerViewModel : ViewModel() {
    var category = MutableLiveData<String>()
    init {
        category.value="messages"
    }
    fun setCategory(cat: String){
        category.value=cat
    }
}