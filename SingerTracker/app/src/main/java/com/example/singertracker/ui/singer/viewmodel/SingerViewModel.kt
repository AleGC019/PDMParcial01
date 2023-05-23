package com.example.singertracker.ui.singer.viewmodel

import android.text.Spannable.Factory
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.singertracker.SingerReviewerApplication
import com.example.singertracker.data.model.SingerModel
import com.example.singertracker.repository.SingerRepository

class SingerViewModel(private val repository: SingerRepository): ViewModel() {

    var name = MutableLiveData("")
    var gender = MutableLiveData("")
    var status = MutableLiveData("")

    fun getSingers() = repository.getSingers()

    fun addSinger(singer: SingerModel) = repository.addSinger(singer)

    private fun validationOfFields(): Boolean{
        when{
            name.value.isNullOrEmpty() -> return false
            gender.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun createNewSinger(){
        if(!validationOfFields()){
            status.value = SINGER_WRONG
            return
        }
        val newSinger = SingerModel(
            name.value.toString(),
            gender.value.toString()
        )
        addSinger(newSinger)
        status.value = SINGER_CREATED

    }

    fun setSelectedSinger(singer: SingerModel){
        name.value = singer.nombre
        gender.value = singer.gender
    }



    fun clearData(){
        name.value = ""
        gender.value = ""
    }

    fun clearStatus(){
        status.value = SINGER_BASE
    }



    companion object{

        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as SingerReviewerApplication
                SingerViewModel(app.singerRepository)

            }
        }


        const val SINGER_CREATED = "SINGER CREATED"
        const val SINGER_WRONG = "SINGER WRONG"
        const val SINGER_BASE = " "

    }





}