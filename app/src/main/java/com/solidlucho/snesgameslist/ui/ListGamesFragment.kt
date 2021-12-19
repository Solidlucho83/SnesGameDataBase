package com.solidlucho.snesgameslist.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.solidlucho.snesgameslist.R
import com.solidlucho.snesgameslist.adapter.SnesGamesAdapter
import com.solidlucho.snesgameslist.data.model.Model
import com.solidlucho.snesgameslist.databinding.FragmentListGamesBinding
import com.solidlucho.snesgameslist.repository.Repository
import java.util.*
import kotlin.collections.ArrayList


class ListGamesFragment : Fragment(R.layout.fragment_list_games), SnesGamesAdapter.click {

    private var _binding: FragmentListGamesBinding? = null
    private val binding get() = _binding!!

    lateinit var image: String

    var snesGamesList = Repository().superNesGames
    lateinit var adapter: RecyclerView.Adapter<*>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListGamesBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvSuperNesGames.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = SnesGamesAdapter(Repository().superNesGames, this@ListGamesFragment)

        }
        binding.btClear.setOnClickListener(){
            binding.tvSearch.text.clear()
        }



        binding.tvSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {


            }


            override fun onTextChanged(newText: CharSequence?,start: Int,
                before: Int,
                count: Int
            ) {
                val filteredCustomer = ArrayList<Model>()
                if (binding.tvSearch.text!!.isNotEmpty()) {
                    for (i in 0..snesGamesList.size - 1) {
                        if (snesGamesList.get(i).title.lowercase(Locale.getDefault())
                                .contains(newText.toString().lowercase(Locale.getDefault()))
                        )
                            filteredCustomer.add(snesGamesList[i])
                    }
                    binding.rvSuperNesGames.apply {
                        layoutManager = LinearLayoutManager(activity)
                        adapter = SnesGamesAdapter(filteredCustomer, this@ListGamesFragment)

                    }

                } else {
                    binding.rvSuperNesGames.apply {
                        layoutManager = LinearLayoutManager(activity)
                        adapter =
                            SnesGamesAdapter(Repository().superNesGames, this@ListGamesFragment)

                    }
                }

            }

        })
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