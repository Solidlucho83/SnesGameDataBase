package com.solidlucho.snesgameslist.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.webkit.*
import android.widget.FrameLayout
import androidx.core.os.bundleOf
import com.solidlucho.snesgameslist.R
import com.solidlucho.snesgameslist.databinding.FragmentListGamesBinding
import com.solidlucho.snesgameslist.databinding.FragmentWikipediaBinding

class WikipediaFragment : Fragment(R.layout.fragment_wikipedia) {

    private var _binding: FragmentWikipediaBinding? = null
    private val binding get() = _binding!!
    private var url: String? = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWikipediaBinding.inflate(inflater)
        var view: FrameLayout = binding.root
        return view
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            url = it.getString(URL)
        }

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.webView.webViewClient = object : WebViewClient() {

        }

        val setting = binding.webView.settings
        setting.javaScriptEnabled

        binding.webView.loadUrl(url.toString())
        onDestroy()
    }

    companion object {
        private const val URL = "url"
        fun newInstance(url: String) = WikipediaFragment().apply {
            arguments = bundleOf(URL to url)
        }


    }
}