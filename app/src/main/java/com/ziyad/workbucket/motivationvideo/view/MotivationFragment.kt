package com.ziyad.workbucket.motivationvideo.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ziyad.workbucket.databinding.MotivationFragmentBinding
import com.ziyad.workbucket.motivationvideo.viewmodel.MotivationViewModel

@SuppressLint("SetJavaScriptEnabled")
class MotivationFragment : Fragment() {

private lateinit var binding: MotivationFragmentBinding
    private lateinit var viewModel: MotivationViewModel
private lateinit var link1: WebView
private lateinit var link2: WebView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MotivationFragmentBinding.inflate(layoutInflater)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.video1.settings.javaScriptEnabled = true
        binding.video1.loadUrl("https://www.youtube.com/embed/Qa_4c9zrxf0")
        binding.video2.settings.javaScriptEnabled = true
        binding.video2.loadUrl("https://www.youtube.com/embed/0PbjZ01ObLA")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MotivationViewModel::class.java)
        // TODO: Use the ViewModel
    }

}