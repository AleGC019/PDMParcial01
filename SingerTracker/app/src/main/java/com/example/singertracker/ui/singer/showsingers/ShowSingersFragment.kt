package com.example.singertracker.ui.singer.showsingers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.singertracker.R
import com.example.singertracker.databinding.FragmentShowSingersBinding
import com.example.singertracker.ui.singer.viewmodel.SingerViewModel


class ShowSingersFragment : Fragment() {

    private lateinit var binding: FragmentShowSingersBinding

    private val viewModel: SingerViewModel by activityViewModels{
        SingerViewModel.Factory
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_show_singers, container, false)
        binding = FragmentShowSingersBinding.inflate(inflater, container, false)
        return binding.root
    }


}