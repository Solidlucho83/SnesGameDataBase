package com.solidlucho.snesgameslist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.webkit.*
import androidx.core.os.bundleOf

class WikipediaFragment : Fragment(R.layout.fragment_wikipedia) {


    private var url: String? = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            url = it.getString(WikipediaFragment.URL)
        }


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val webView = view.findViewById(R.id.wvWikipedia) as WebView

        webView.webViewClient = object : WebViewClient(){

        }

        val setting = webView.settings
        setting.javaScriptEnabled

        webView.loadUrl(url.toString())
        onDestroy()
    }

    companion object {
        private const val URL = "url"
        fun newInstance(url: String) = WikipediaFragment().apply {
            arguments = bundleOf(URL to url)
        }


    }
}