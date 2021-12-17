package com.solidlucho.snesgameslist

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

class ZoomCoverFragment : Fragment(R.layout.fragment_zoom_cover) {

    private var cover: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            cover = it.getString(COVER)
        }


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imagenZoom = view.findViewById<ImageView>(R.id.imageZoom)

        Glide.with(this).load(cover).into(imagenZoom)

    }
companion object{
    private const val COVER = "cover"
    fun newInstance(cover: String)= ZoomCoverFragment().apply {
        arguments = bundleOf(COVER to cover)
    }

    }
}





