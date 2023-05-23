package com.example.singertracker.ui.singer.showsingers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.singertracker.R
import com.example.singertracker.data.model.SingerModel
import com.example.singertracker.databinding.FragmentShowSingersBinding
import com.example.singertracker.ui.singer.adapter.SingerAdapter
import com.example.singertracker.ui.singer.viewmodel.SingerViewModel


class ShowSingersFragment : Fragment() {

    private lateinit var binding: FragmentShowSingersBinding

    private val viewModel: SingerViewModel by activityViewModels{
        SingerViewModel.Factory
    }

    private lateinit var adapter: SingerAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentShowSingersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.floatingActionButton.setOnClickListener{
            viewModel.clearData()
            it.findNavController().navigate(R.id.action_showSingersFragment_to_newSIngerFragment)

        }

    }

    private fun setRecyclerView(view: View) {
        binding.recyclerViewSingers.layoutManager = LinearLayoutManager(view.context)

        adapter = SingerAdapter{ SingerSelected ->
            showSelectedItem(SingerSelected)
        }

        binding.recyclerViewSingers.adapter = adapter

        displaySingers()

    }

    private fun showSelectedItem(singer: SingerModel){
        viewModel.setSelectedSinger(singer)
        findNavController().navigate(R.id.action_showSingersFragment_to_SIngerFragment)

    }

    private fun displaySingers() {
        adapter.setData(viewModel.getSingers())
        adapter.notifyDataSetChanged()
    }



}