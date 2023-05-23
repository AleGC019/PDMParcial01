package com.example.singertracker.ui.singer.newsinger

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.singertracker.R
import com.example.singertracker.databinding.FragmentNewSIngerBinding
import com.example.singertracker.ui.singer.viewmodel.SingerViewModel


class NewSIngerFragment : Fragment() {

    private lateinit var binding: FragmentNewSIngerBinding

    private val viewModel: SingerViewModel by activityViewModels{
        SingerViewModel.Factory
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_new_s_inger, container, false)
        binding = FragmentNewSIngerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        setObserver()
    }

    private fun setObserver() {
        viewModel.status.observe(viewLifecycleOwner){status ->
            when{
                status.equals(SingerViewModel.SINGER_CREATED) -> {
                    viewModel.clearStatus()
                    viewModel.clearData()

                    findNavController().popBackStack()
                }

                status.equals(SingerViewModel.SINGER_WRONG) ->{
                    viewModel.clearStatus()
                }

            }

        }


    }

    private fun setViewModel() {
        binding.viewmodel = viewModel
    }


}