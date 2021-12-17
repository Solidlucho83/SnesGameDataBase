package com.solidlucho.snesgameslist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.solidlucho.snesgameslist.R
import com.solidlucho.snesgameslist.adapter.SnesGamesAdapter
import com.solidlucho.snesgameslist.databinding.FragmentListGamesBinding
import com.solidlucho.snesgameslist.repository.Repository


class ListGamesFragment : Fragment(R.layout.fragment_list_games), SnesGamesAdapter.click {

    private var _binding: FragmentListGamesBinding? = null
    private val binding get() = _binding!!

    lateinit var image: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListGamesBinding.inflate(inflater)
        var view: FrameLayout = binding.root
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvSuperNesGames.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = SnesGamesAdapter(Repository().superNesGames, this@ListGamesFragment)

        }

    }


    override fun onImageClick(image: String) {
        findNavController().navigate(
            R.id.action_listGamesFragment_to_zoomCoverFragment2,
            bundleOf("cover" to image)
        )

    }

    override fun toWikipedia(url: String) {
        findNavController().navigate(
            R.id.action_listGamesFragment_to_wikipediaFragment,
            bundleOf("url" to url)
        )
    }


}