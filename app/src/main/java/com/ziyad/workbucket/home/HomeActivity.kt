package com.ziyad.workbucket.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.ziyad.workbucket.R
import com.ziyad.workbucket.biografigenerator.view.BiogenFragment
import com.ziyad.workbucket.findpartner.view.FindPartnerFragment
import com.ziyad.workbucket.mainviewmodel.MainViewModel
import com.ziyad.workbucket.motivationvideo.view.MotivationFragment
import com.ziyad.workbucket.setting.view.SettingFragment

class HomeActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    val findPartnerFragment=FindPartnerFragment()
    val biogenFragment=BiogenFragment()
    val motivationFragment=MotivationFragment()
    val settingFragment=SettingFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setCurrentFragment(findPartnerFragment)
        val user= Firebase.auth
        if (user.currentUser == null) {

            startActivity(
                viewModel.signIntent.value
            )
            finish()
            setCurrentFragment(findPartnerFragment)
            return
        }
        findViewById<BottomNavigationView>(R.id.bottomNavigationView).setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navigation_find->setCurrentFragment(findPartnerFragment)
                R.id.navigation_biogen->setCurrentFragment(biogenFragment)
                R.id.navigation_motivation->setCurrentFragment(motivationFragment)
                R.id.navigation_setting->setCurrentFragment(settingFragment)

            }
            true
        }
    }

    override fun onResume() {
        super.onResume()
        setCurrentFragment(findPartnerFragment)
        findViewById<BottomNavigationView>(R.id.bottomNavigationView).setSelectedItemId(R.id.navigation_find)
    }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            commit()

}}