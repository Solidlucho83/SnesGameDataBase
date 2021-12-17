package com.solidlucho.snesgameslist.adapter

import android.app.Activity
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.solidlucho.snesgameslist.R
import com.solidlucho.snesgameslist.data.model.Model

class SnesGamesAdapter(val snesgames: List<Model>, val onClick: click): RecyclerView.Adapter<SnesGamesAdapter.SnesHolder>() {

    interface click{
        fun onImageClick(image: String)
        fun onPlayYoutbue(url: String)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SnesHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SnesHolder(layoutInflater.inflate(R.layout.snes_games_list, parent, false))
    }
    override fun getItemCount(): Int = snesgames.size

    override fun onBindViewHolder(holder: SnesHolder, position: Int) {
        holder.render(snesgames[position])
    }

    inner class SnesHolder(val view: View) : RecyclerView.ViewHolder(view) {

        val title = view.findViewById(R.id.tvTitle) as TextView
        val release = view.findViewById(R.id.tvRelease) as TextView
        val image = view.findViewById(R.id.imCover) as ImageView
        val play = view.findViewById(R.id.btPlayYoutube) as ImageButton


        fun render(model: Model) {

            title.text = model.title
            release.text = model.release
            Glide.with(image)
                .load(model.image)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.ic_baseline_cloud_download_24)
                .error(R.drawable.ic_baseline_broken_image_24)
                .into(image)
            image.setOnClickListener { onClick.onImageClick(model.image) }
            play.setOnClickListener{ onClick.onPlayYoutbue(model.url)}



        }


    }
    }