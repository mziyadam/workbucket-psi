package com.ziyad.workbucket.mainviewmodel

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ziyad.workbucket.R
import com.ziyad.workbucket.biografigenerator.view.BiogenFragment
import com.ziyad.workbucket.findpartner.view.FindPartnerFragment
import com.ziyad.workbucket.motivationvideo.view.MotivationFragment
import com.ziyad.workbucket.setting.view.SettingFragment

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
init{
    currentFragment.value= findPartnerFragment
}
    fun toFind(context: Context){
        findDrawable.value= ContextCompat.getDrawable(context, R.drawable.find_on)
        motivationDrawable.value= ContextCompat.getDrawable(context, R.drawable.motivation_off)
        settingDrawable.value= ContextCompat.getDrawable(context, R.drawable.setting_off)
        biogenDrawable.value= ContextCompat.getDrawable(context, R.drawable.biogen_off)
        currentFragment.value= findPartnerFragment
    }
    fun toBiogen(context: Context){
        findDrawable.value= ContextCompat.getDrawable(context, R.drawable.find_off)
        motivationDrawable.value= ContextCompat.getDrawable(context, R.drawable.motivation_off)
        settingDrawable.value= ContextCompat.getDrawable(context, R.drawable.setting_off)
        biogenDrawable.value= ContextCompat.getDrawable(context, R.drawable.biogen_on)
        currentFragment.value= biogenFragment
    }
    fun toMotivation(context: Context){
        findDrawable.value= ContextCompat.getDrawable(context, R.drawable.find_off)
        motivationDrawable.value= ContextCompat.getDrawable(context, R.drawable.motivation_on)
        settingDrawable.value= ContextCompat.getDrawable(context, R.drawable.setting_off)
        biogenDrawable.value= ContextCompat.getDrawable(context, R.drawable.biogen_off)
        currentFragment.value= motivationFragment
    }
    fun toSetting(context: Context){
        findDrawable.value= ContextCompat.getDrawable(context, R.drawable.find_off)
        motivationDrawable.value= ContextCompat.getDrawable(context, R.drawable.motivation_off)
        settingDrawable.value= ContextCompat.getDrawable(context, R.drawable.setting_on)
        biogenDrawable.value= ContextCompat.getDrawable(context, R.drawable.biogen_off)
        currentFragment.value= settingFragment
    }


}