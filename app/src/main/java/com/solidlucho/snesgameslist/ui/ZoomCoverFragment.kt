package com.solidlucho.snesgameslist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.solidlucho.snesgameslist.R
import com.solidlucho.snesgameslist.databinding.FragmentWikipediaBinding
import com.solidlucho.snesgameslist.databinding.FragmentZoomCoverBinding

class ZoomCoverFragment : Fragment(R.layout.fragment_zoom_cover) {

    private var _binding: FragmentZoomCoverBinding? = null
    private val binding get() = _binding!!


    private var cover: String? = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentZoomCoverBinding.inflate(inflater)
        var view: FrameLayout = binding.root
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            cover = it.getString(COVER)
        }


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        Glide.with(this).load(cover).into(binding.imageZoom)

    }

    companion object {
        private const val COVER = "cover"
        fun newInstance(cover: String) = ZoomCoverFragment().apply {
            arguments = bundleOf(COVER to cover)
        }

    }
}





