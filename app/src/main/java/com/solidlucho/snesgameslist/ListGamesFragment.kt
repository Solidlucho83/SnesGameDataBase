package com.solidlucho.snesgameslist

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.solidlucho.snesgameslist.adapter.SnesGamesAdapter
import com.solidlucho.snesgameslist.repository.Repository


class ListGamesFragment : Fragment(R.layout.fragment_list_games), SnesGamesAdapter.click {

    lateinit var image: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val rvSnesGamesList: RecyclerView = view.findViewById(R.id.rvSuperNesGames)


        fun initReciclerView() {
            rvSnesGamesList.layoutManager = LinearLayoutManager(view.context)
            rvSnesGamesList.addItemDecoration(
                DividerItemDecoration(
                    view.context,
                    DividerItemDecoration.HORIZONTAL
                )
            )
            val adapter = SnesGamesAdapter(Repository().superNesGames, this)
            rvSnesGamesList.adapter = adapter

        }


        initReciclerView()



    }


    override fun onImageClick(image: String) {
        findNavController().navigate(
            R.id.action_listGamesFragment_to_zoomCoverFragment2,
            bundleOf("cover" to image)
        )

    }

    override fun onPlayYoutbue(url: String) {
        findNavController().navigate(
            R.id.action_listGamesFragment_to_wikipediaFragment,
            bundleOf("url" to url)
        )
    }


}