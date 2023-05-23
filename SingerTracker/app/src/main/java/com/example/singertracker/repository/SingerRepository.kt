package com.example.singertracker.repository

import com.example.singertracker.data.model.SingerModel

class SingerRepository(private val singers: MutableList<SingerModel>) {

    fun getSingers() = singers

    fun addSinger(newSinger: SingerModel){
        singers.add(newSinger)
    }

}