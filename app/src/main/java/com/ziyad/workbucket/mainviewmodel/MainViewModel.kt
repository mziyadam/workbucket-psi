package com.ziyad.workbucket.mainviewmodel

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.ziyad.workbucket.R
import com.ziyad.workbucket.biografigenerator.view.BiogenFragment
import com.ziyad.workbucket.findpartner.view.FindPartnerFragment
import com.ziyad.workbucket.motivationvideo.view.MotivationFragment
import com.ziyad.workbucket.setting.view.SettingFragment
import java.util.*

class MainViewModel: ViewModel() {
    var currentFragment = MutableLiveData<Fragment>()
    val findPartnerFragment = FindPartnerFragment()
    val biogenFragment = BiogenFragment()
    val motivationFragment = MotivationFragment()
    val settingFragment = SettingFragment()
    var findDrawable = MutableLiveData<Drawable>()
    var motivationDrawable = MutableLiveData<Drawable>()
    var settingDrawable = MutableLiveData<Drawable>()
    var biogenDrawable = MutableLiveData<Drawable>()
    var category = MutableLiveData<String>("messages")
    var signIntent = MutableLiveData<Intent>()
    val findOn=R.drawable.find_on
    val findOff=R.drawable.find_off
    val motivationOn=R.drawable.motivation_on
    val motivationOff=R.drawable.motivation_off
    val biogenOn=R.drawable.biogen_on
    val biogenOff=R.drawable.biogen_off
    val settingOn=R.drawable.setting_on
    val settingOff=R.drawable.setting_off
    val logo=R.drawable.logo
    var user = Firebase.auth
init{
    currentFragment.value= findPartnerFragment

        signIntent.value =AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(
                Arrays.asList(
                    AuthUI.IdpConfig.GoogleBuilder().build(),
                    AuthUI.IdpConfig.EmailBuilder().build(),
                    AuthUI.IdpConfig.PhoneBuilder().build(),
                )
            )
            .setLogo(logo) // Set logo drawable
            .setTheme(R.style.Theme_Login) // Set theme
            .build()


}
    fun setCategory(cat: String){
        category.value=cat
    }
    fun toFind(context: Context){
            findDrawable.value = ContextCompat.getDrawable(context, findOn)
            motivationDrawable.value = ContextCompat.getDrawable(context, motivationOff)
            settingDrawable.value = ContextCompat.getDrawable(context, settingOff)
            biogenDrawable.value = ContextCompat.getDrawable(context, biogenOff)
            currentFragment.value = findPartnerFragment


    }
    fun toBiogen(context: Context){

            findDrawable.value= ContextCompat.getDrawable(context, findOff)
            motivationDrawable.value= ContextCompat.getDrawable(context, motivationOff)
            settingDrawable.value= ContextCompat.getDrawable(context, settingOff)
            biogenDrawable.value= ContextCompat.getDrawable(context, biogenOn)
            currentFragment.value= biogenFragment


    }
    fun toMotivation(context: Context){

            findDrawable.value= ContextCompat.getDrawable(context, findOff)
            motivationDrawable.value= ContextCompat.getDrawable(context, motivationOn)
            settingDrawable.value= ContextCompat.getDrawable(context, settingOff)
            biogenDrawable.value= ContextCompat.getDrawable(context, biogenOff)
            currentFragment.value= motivationFragment


    }
    fun toSetting(context: Context){

            findDrawable.value = ContextCompat.getDrawable(context, findOff)
            motivationDrawable.value = ContextCompat.getDrawable(context, motivationOff)
            settingDrawable.value = ContextCompat.getDrawable(context, settingOn)
            biogenDrawable.value = ContextCompat.getDrawable(context, biogenOff)
            currentFragment.value = settingFragment

    }

}