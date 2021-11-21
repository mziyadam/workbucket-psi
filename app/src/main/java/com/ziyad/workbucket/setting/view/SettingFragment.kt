package com.ziyad.workbucket.setting.view

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.ziyad.workbucket.databinding.SettingFragmentBinding
import com.ziyad.workbucket.findpartner.chat.FriendlyMessageAdapter.Companion.TAG
import com.ziyad.workbucket.home.HomeActivity
import com.ziyad.workbucket.mainviewmodel.MainViewModel
import com.ziyad.workbucket.setting.viewmodel.SettingViewModel

class SettingFragment : Fragment() {

    companion object {
        fun newInstance() = SettingFragment()
    }
    private lateinit var user: FirebaseUser
    private lateinit var binding: SettingFragmentBinding
    private lateinit var viewModel: SettingViewModel
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        user = FirebaseAuth.getInstance().currentUser!!

        binding=SettingFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.user.observe(requireActivity(), Observer{
            binding.tvProfileName.text = it.displayName.toString()
            binding.etName.setText(it.displayName.toString())
            binding.etEmail.setText(it.email.toString())
        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

            viewModel = ViewModelProvider(this).get(SettingViewModel::class.java)
            mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
            // TODO: Use the ViewModel




        doAsync {
            binding.btnLogout.setOnClickListener {
                mainViewModel.toFind(requireContext())
                AuthUI.getInstance().signOut(requireContext())
                    .addOnCompleteListener {
                        startActivity(
                            Intent(requireContext(), HomeActivity::class.java)

                        )
                        // ...
                    }
            }
            binding.btnChange.setOnClickListener {
                var pwt=true
                if(binding.etPassword.text.toString()!=""||binding.etReenterPassword.text.toString()!="") {
                    if(binding.etPassword.text.toString()==binding.etReenterPassword.text.toString()) {
                        user!!.updatePassword(binding.etPassword.text.toString())
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    Log.d(TAG, "User password updated.")
                                }
                            }
                    }else{
                        Toast.makeText(requireContext(), "Password tidak sama", Toast.LENGTH_SHORT).show()
                        pwt=false
                    }
                }
                if(binding.etName.text.toString()!=""&&pwt){
                    val profileUpdates = userProfileChangeRequest {
                        displayName = binding.etName.text.toString()
                    }
                    user!!.updateProfile(profileUpdates)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                Log.d(TAG, "User profile updated.")
                            }
                        }
                    binding.tvProfileName.text=binding.etName.text.toString()
                }

                if(binding.etEmail.text.toString()!=""&&pwt) {
                    user!!.updateEmail(binding.etEmail.text.toString())
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                Log.d(TAG, "User email address updated.")
                            }
                        }
                }
                Toast.makeText(requireContext(), "Perubahan telah disimpan", Toast.LENGTH_SHORT).show()
            }

        }.execute()

}
    class doAsync(val handler: () -> Unit) : AsyncTask<Void, Void, Void>() {
        override fun doInBackground(vararg params: Void?): Void? {
            handler()
            return null
        }
    }
}