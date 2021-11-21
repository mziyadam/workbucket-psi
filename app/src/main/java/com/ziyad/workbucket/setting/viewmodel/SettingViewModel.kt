package com.ziyad.workbucket.setting.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class SettingViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    var user=MutableLiveData<FirebaseUser>(FirebaseAuth.getInstance().currentUser!!)


}