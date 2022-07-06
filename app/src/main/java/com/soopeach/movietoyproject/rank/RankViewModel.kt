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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class RankViewModel : ViewModel() {

    // 오늘 날짜
    val today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))

    // 일별 박스오피스 순위를 검색할 날짜 (20220622 형식)
    val _dateForSearch = MutableLiveData<String>()
    val dateForSearch: LiveData<String>
        get() = _dateForSearch

    // 일별 박스오피스 1 ~ 10위의 영화들을 남을 리스트
    private val _movieRankList = MutableLiveData<List<RankList.BoxOfficeResult.DailyBoxOffice>>()
    val movieRankList: LiveData<List<RankList.BoxOfficeResult.DailyBoxOffice>>
        get() = _movieRankList

    private val _selectedMovieCd = MutableLiveData<String>()
    val selectedMovieCd: LiveData<String>
        get() = _selectedMovieCd

    // 검색결과가 없을 경우를 확인하기 위한 변수
    private val _listEmpty = MutableLiveData<Boolean>()
    val listEmpty: LiveData<Boolean>
        get() = _listEmpty

    init {
        movieRankListInit()
        listInit()
        initSelectedMovieCd()
    }

    fun searchBtnOnClick() {

        val retrofit = RetrofitConnect.getInstance()
        val retrofitForRankList = retrofit.create(GetRankData::class.java)

        viewModelScope.launch {
            try {
                val rankList =
                    retrofitForRankList.getRankData(targetDt = dateForSearch.value ?: today)

                // 검색 정보가 없다면
                if (rankList.getRankList().isEmpty()) {
                    Log.d("통신성공-rank", "검색 정보가 없음.")
                    movieRankListInit()
                    _listEmpty.value = true
                } else {
                    _movieRankList.value = rankList.getRankList()
                    Log.d("통신성공-rank", "${_movieRankList.value}")
                }

            } catch (e: Exception) {
                Log.d("통신실패-rank", "$e 에러발생")

            }
            clearSearchBar()
        }

    }

    // 검색창 초기화
    fun clearSearchBar() {
        _dateForSearch.value = null
    }

    // listIsEmpty false로 초기화
    fun listInit() {
        _listEmpty.value = false
    }

    // movieRankList 초기화
    fun movieRankListInit() {
        _movieRankList.value = listOf(
            RankList.BoxOfficeResult.DailyBoxOffice(
                audiAcc = "null",
                audiChange = "null",
                audiCnt = "null",
                audiInten = "null",
                movieCd = null,
                movieNm = "검색기록 없음.",
                openDt = "null",
                rank = "0",
                rankInten = "null",
                rankOldAndNew = "null",
                rnum = "null",
                salesAcc = "null",
                salesAmt = "null",
                salesChange = "null",
                salesInten = "null",
                salesShare = "null",
                scrnCnt = "null",
                showCnt = "null",
            )
        )
    }

    fun setSelectedMovieCd(movieData: RankList.BoxOfficeResult.DailyBoxOffice) {
        _selectedMovieCd.value = movieData.movieCd
    }

    fun initSelectedMovieCd() {
        _selectedMovieCd.value = null
    }

}