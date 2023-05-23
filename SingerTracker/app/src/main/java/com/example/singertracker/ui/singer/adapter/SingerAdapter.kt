package com.example.singertracker.ui.singer.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.singertracker.data.model.SingerModel
import com.example.singertracker.data.singers
import com.example.singertracker.databinding.SingerItemBinding

class SingerAdapter(private val clickListener: (SingerModel) -> Unit): RecyclerView.Adapter<SingerViewHolder>(){

    private val singers = ArrayList<SingerModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingerViewHolder {
        val binding = SingerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SingerViewHolder(binding)

    }

    override fun getItemCount(): Int = singers.size

    override fun onBindViewHolder(holder: SingerViewHolder, position: Int) {
        val singer = singers[position]
        holder.bind(singer, clickListener)
    }

    fun setData(singersList: List<SingerModel>){
        singers.clear()
        singers.addAll(singersList)

    }

}