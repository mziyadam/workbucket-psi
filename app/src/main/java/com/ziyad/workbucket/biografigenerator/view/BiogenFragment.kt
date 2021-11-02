package com.ziyad.workbucket.biografigenerator.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ziyad.workbucket.biografigenerator.viewmodel.BiogenViewModel
import com.ziyad.workbucket.databinding.BiogenFragmentBinding

class BiogenFragment : Fragment() {
    private lateinit var binding: BiogenFragmentBinding
    private lateinit var viewModel: BiogenViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BiogenFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BiogenViewModel::class.java)
        // TODO: Use the ViewModel
        viewModel.nama.observe(viewLifecycleOwner, Observer {
            binding.nama.setText(it.toString())
        })
        viewModel.asal.observe(viewLifecycleOwner, Observer {
            binding.etNim.setText(it.toString())
        })
        viewModel.ide.observe(viewLifecycleOwner, Observer {
            binding.etKelas.setText(it.toString())
        })
        viewModel.paragraf.observe(viewLifecycleOwner, Observer {
            binding.paragraf.text = it.toString()
        })
        binding.submitBtn.setOnClickListener {
            viewModel.generateParagraf(
                binding.nama.text.toString(),
                binding.etNim.text.toString(),
                binding.etKelas.text.toString()
            )
            binding.paragraf.text = viewModel.paragraf.value
        }
        binding.resetBtn.setOnClickListener { viewModel.clear() }
        binding.copyBtn.setOnClickListener { viewModel.copyToClipboard(requireActivity(), requireContext()) }
    }

}