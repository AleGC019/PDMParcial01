package com.example.singertracker.ui.singer.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.singertracker.data.model.SingerModel
import com.example.singertracker.databinding.SingerItemBinding

class SingerViewHolder(private val binding: SingerItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(singer: SingerModel, clickListener: (SingerModel) -> Unit){
        binding.sgname.text = singer.nombre
        binding.sggneder.text = singer.gender

        binding.cardviewSinger.setOnClickListener{
            clickListener(singer)
        }
    }
}