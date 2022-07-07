package com.soopeach.movietoyproject.search

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.soopeach.movietoyproject.models.SearchDataList

class DetailSearchViewModel(@Suppress("UNUSED_PARAMETER") item: SearchDataList.Item, app: Application): AndroidViewModel(app) {

    private val _item = MutableLiveData<SearchDataList.Item>()
    val item: MutableLiveData<SearchDataList.Item>
        get() = _item

    init {
        setItem(item)
    }

    fun setItem(item: SearchDataList.Item) {
        _item.value = item
    }
}