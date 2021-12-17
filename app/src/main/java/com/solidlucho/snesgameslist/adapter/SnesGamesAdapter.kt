package com.solidlucho.snesgameslist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.solidlucho.snesgameslist.R
import com.solidlucho.snesgameslist.data.model.Model
import com.solidlucho.snesgameslist.databinding.SnesGamesListBinding

class SnesGamesAdapter(val snesgames: List<Model>, val onClick: click) :
    RecyclerView.Adapter<SnesGamesAdapter.SnesHolder>() {


    interface click {
        fun onImageClick(image: String)
        fun toWikipedia(url: String)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SnesHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val listBinding = SnesGamesListBinding.inflate(layoutInflater, parent, false)
        return SnesHolder(listBinding)


    }

    override fun getItemCount(): Int = snesgames.size

    override fun onBindViewHolder(holder: SnesHolder, position: Int) {
        holder.render(snesgames[position])
    }

    inner class SnesHolder(val binding: SnesGamesListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun render(model: Model) {

            binding.tvTitle.text = model.title
            binding.tvRelease.text = model.release
            Glide.with(binding.imCover)
                .load(model.image)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.ic_baseline_cloud_download_24)
                .error(R.drawable.ic_baseline_broken_image_24)
                .into(binding.imCover)
            binding.imCover.setOnClickListener { onClick.onImageClick(model.image) }
            binding.btWikipedia.setOnClickListener { onClick.toWikipedia(model.url) }


        }


    }
}