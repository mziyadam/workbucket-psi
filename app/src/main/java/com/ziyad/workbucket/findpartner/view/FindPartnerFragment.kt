package com.ziyad.workbucket.findpartner.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ziyad.workbucket.R
import com.ziyad.workbucket.findpartner.viewmodel.FindPartnerViewModel

class FindPartnerFragment : Fragment() {

    companion object {
        fun newInstance() = FindPartnerFragment()
    }

    private lateinit var viewModel: FindPartnerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.find_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FindPartnerViewModel::class.java)
        // TODO: Use the ViewModel
    }

}