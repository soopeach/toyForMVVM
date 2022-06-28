package com.soopeach.movietoyproject.rank

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soopeach.movietoyproject.models.RankList
import com.soopeach.movietoyproject.models.getRankList
import com.soopeach.movietoyproject.retrofit.GetRankData
import com.soopeach.movietoyproject.retrofit.RetrofitConnect
import kotlinx.coroutines.launch
import java.lang.Exception
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class RankViewModel : ViewModel() {

    val today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))

    val _dateForSearch = MutableLiveData<String>()
    val dateForSearch : LiveData<String>
        get() = _dateForSearch

    private val _movieRankList = MutableLiveData<List<RankList.BoxOfficeResult.DailyBoxOffice>>()
    val movieRankList : LiveData<List<RankList.BoxOfficeResult.DailyBoxOffice>>
        get() = _movieRankList

    init {
        // 검색을 시작하기위한 기본값은 오늘 날짜
//        _dateForSearch.value = today
        Log.d("RankViewModel", "${dateForSearch.value}")
    }

    fun searchBtnOnClick() {

        // ** 날짜 출력 형식에 맞지 않는다면 토스트를 띄워줘야함.

        val retrofit = RetrofitConnect.getInstance()
        val retrofitForRankList = retrofit.create(GetRankData::class.java)

        viewModelScope.launch {
            try {
                val rankList = retrofitForRankList.getRankData(targetDt = dateForSearch.value ?: today)
                _movieRankList.value = rankList.getRankList()
                Log.d("통신성공-rank","${_movieRankList.value}")
            } catch (e: Exception){
                Log.d("통신실패-rank", "$e 에러발생")
            }
        }

    }
}