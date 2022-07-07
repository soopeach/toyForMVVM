package com.soopeach.movietoyproject.search

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.soopeach.movietoyproject.models.SearchDataList
import com.soopeach.movietoyproject.rank.DetailRankViewModel
import java.lang.IllegalArgumentException

class DetailSearchViewModelFactory(private val item: SearchDataList.Item, private val application: Application): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DetailSearchViewModel::class.java)){
            return DetailSearchViewModel(item, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}