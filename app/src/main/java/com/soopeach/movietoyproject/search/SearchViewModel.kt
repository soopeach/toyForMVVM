package com.soopeach.movietoyproject.search

import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soopeach.movietoyproject.models.SearchDataList
import com.soopeach.movietoyproject.models.getItem
import com.soopeach.movietoyproject.models.getRankList
import com.soopeach.movietoyproject.retrofit.GetSearchData
import com.soopeach.movietoyproject.retrofit.NaverRetrofitConnect
import kotlinx.coroutines.launch
import retrofit2.create

class SearchViewModel: ViewModel() {

    var titleHint: String

    // 제목으로 영화 검색
    var _titleForSearch = MutableLiveData<String>()
    val titleForSearch: LiveData<String>
        get() = _titleForSearch

    private var _searchedMovieList = MutableLiveData<List<SearchDataList.Item>>()
    val searchedMovieList : LiveData<List<SearchDataList.Item>>
        get() = _searchedMovieList

    init {
        searchedMovieListInit()
        clearSearchBar()
        titleHint = "어벤져스"
    }

    fun searchBtnOnClick(){

        val retrofitForNaver = NaverRetrofitConnect.getInstance()
        val retrofitForSearchList = retrofitForNaver.create(GetSearchData::class.java)

        viewModelScope.launch {
            try {

                val searchList = retrofitForSearchList.getSearchData(title = titleForSearch.value ?: "hsjeon")

                // 검색 정보가 없다면
                if (searchList.getItem().isEmpty()) {
                    Log.d("통신성공-rank", "검색 정보가 없음.")
                    searchedMovieListInit()
//                    _listEmpty.value = true
                } else {
                    _searchedMovieList.value = searchList.getItem()
                    Log.d("통신성공-rank", "${_searchedMovieList.value}")
                }

            } catch (e: Exception) {
                Log.d("통신실패-search", "$e")
            }

            clearSearchBar()
        }
    }

    fun clearSearchBar() {
        _titleForSearch.value = null
    }

    fun searchedMovieListInit() {
        _searchedMovieList.value = listOf(
            SearchDataList.Item(
                actor = "null",
                director = "null",
                image = "null",
                link = "null",
                pubDate = "null",
                title = "null",
                subtitle = "null",
                userRating = "null"
            )
        )
    }
}