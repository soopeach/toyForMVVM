package com.soopeach.movietoyproject.rank

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class DetailRankViewModelFactory(private val movieCd: String, private val application: Application): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DetailRankViewModel::class.java)){
            return DetailRankViewModel(movieCd, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}