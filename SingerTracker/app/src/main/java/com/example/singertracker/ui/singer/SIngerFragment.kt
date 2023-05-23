package com.example.singertracker.ui.singer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.singertracker.R
import com.example.singertracker.databinding.FragmentSIngerBinding
import com.example.singertracker.ui.singer.viewmodel.SingerViewModel


class SIngerFragment : Fragment() {

    private lateinit var binding: FragmentSIngerBinding

    private val viewModel: SingerViewModel by activityViewModels{
        SingerViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_s_inger, container, false)
        binding = FragmentSIngerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
    }


}