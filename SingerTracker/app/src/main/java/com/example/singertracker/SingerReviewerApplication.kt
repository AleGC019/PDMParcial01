package com.example.singertracker

import android.app.Application
import com.example.singertracker.data.singers
import com.example.singertracker.repository.SingerRepository

class SingerReviewerApplication : Application() {

    val singerRepository: SingerRepository by lazy {
        SingerRepository(singers)
    }

}