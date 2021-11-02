package com.ziyad.workbucket

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.firebase.ui.auth.AuthUI
import com.ziyad.workbucket.databinding.ActivityMainBinding
import com.ziyad.workbucket.login.Login
import com.ziyad.workbucket.mainviewmodel.MainViewModel
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // TODO: Use the ViewModel
        viewModel.currentFragment.observe(this, Observer {
            supportFragmentManager.beginTransaction().apply {
                replace(binding.fragmentMain.id, it)
                commit()
            }
        })
        viewModel.findDrawable.observe(this, {
            binding.btnFind.setImageDrawable(it)
        })
        viewModel.motivationDrawable.observe(this, {
            binding.btnMotivation.setImageDrawable(it)
        })
        viewModel.settingDrawable.observe(this, {
            binding.btnSetting.setImageDrawable(it)
        })
        viewModel.biogenDrawable.observe(this, {
            binding.btnBiogen.setImageDrawable(it)
        })
        binding.btnFind.setOnClickListener {
            viewModel.toFind(this)
        }
        binding.btnMotivation.setOnClickListener {
            viewModel.toMotivation(this)
        }
        binding.btnSetting.setOnClickListener {
            /*val customLayout = AuthMethodPickerLayout.Builder(R.layout.your_custom_layout_xml)
                .setGoogleButtonId(R.id.bar)
                .setEmailButtonId(R.id.foo) // ...
                .setTosAndPrivacyPolicyId(R.id.baz)
                .build()*/
            /*val signInIntent: Intent = AuthUI.getInstance(this).createSignInIntentBuilder() // ...
                .setAuthMethodPickerLayout(customLayout)
                .build()*/
            /*viewModel.toSetting(this)*/
            val signInIntent = AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(
                    Arrays.asList(
                        AuthUI.IdpConfig.GoogleBuilder().build(),
                        AuthUI.IdpConfig.EmailBuilder().build(),
                        AuthUI.IdpConfig.PhoneBuilder().build(),
                        )
                )
                .setLogo(R.drawable.logo) // Set logo drawable
                .setTheme(R.style.Theme_WorkBucket) // Set theme
                .build()

            startActivity(
                Intent(this, Login::class.java)
                /*signInIntent*/
            )
        }
        binding.btnBiogen.setOnClickListener {
            viewModel.toBiogen(this)
        }
    }
}