package com.ziyad.workbucket.findpartner.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.ziyad.workbucket.databinding.FindFragmentBinding
import com.ziyad.workbucket.findpartner.chat.ChatActivity
import com.ziyad.workbucket.mainviewmodel.MainViewModel

class FindPartnerFragment : Fragment() {
    private lateinit var user: FirebaseAuth
private lateinit var binding:FindFragmentBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var container: SharedPreferences
private val CATEGORY="CATEGORY"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FindFragmentBinding.inflate(layoutInflater)
        user = Firebase.auth
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
        container = requireActivity().getSharedPreferences("KeyShared", Context.MODE_PRIVATE)
        binding.bahanmentah.setOnClickListener {
            container.edit().putString(CATEGORY,"Produksi Bahan Mentah").apply()
            viewModel.setCategory("Bahan Mentah")
            startActivity(
                Intent(requireContext(),ChatActivity::class.java)
            )
        }
        binding.perdagangankecil.setOnClickListener {
            container.edit().putString(CATEGORY,"Perdagangan Kecil").apply()
            viewModel.setCategory("Perdagangan Kecil")
            startActivity(
                Intent(requireContext(),ChatActivity::class.java)
            )
        }
        binding.finansial.setOnClickListener {
            container.edit().putString(CATEGORY,"Finansial").apply()
            viewModel.setCategory("Finansial")
            startActivity(
                Intent(requireContext(),ChatActivity::class.java)
            )
        }
        binding.teknologi.setOnClickListener {
            container.edit().putString(CATEGORY,"Teknologi").apply()
            viewModel.setCategory("Teknologi")
            startActivity(
                Intent(requireContext(),ChatActivity::class.java)
            )
        }
        binding.jasa.setOnClickListener {
            container.edit().putString(CATEGORY,"Jasa").apply()
            viewModel.setCategory("Jasa")
            startActivity(
                Intent(requireContext(),ChatActivity::class.java)
            )
        }
        binding.konstruksi.setOnClickListener {
            container.edit().putString(CATEGORY,"Konstruksi").apply()
            viewModel.setCategory("Konstruksi")
            startActivity(
                Intent(requireContext(),ChatActivity::class.java)
            )
        }
        binding.pertanian.setOnClickListener {
            container.edit().putString(CATEGORY,"Pertanian").apply()
            viewModel.setCategory("Pertanian")
            startActivity(
                Intent(requireContext(),ChatActivity::class.java)
            )
        }
        binding.transportasi.setOnClickListener {
            container.edit().putString(CATEGORY,"Transportasi").apply()
            viewModel.setCategory("Transportasi")
            startActivity(
                Intent(requireContext(),ChatActivity::class.java)
            )
        }

    }

}