package com.soopeach.movietoyproject.rank

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide.init
import com.soopeach.movietoyproject.models.RankDetail
import com.soopeach.movietoyproject.models.getMovieInfo
import com.soopeach.movietoyproject.retrofit.GetRankDetailData
import com.soopeach.movietoyproject.retrofit.RetrofitConnect
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailRankViewModel(@Suppress("UNUSED_PARAMETER") movieCd: String, app: Application): AndroidViewModel(app) {


    private val _movieInfo = MutableLiveData<RankDetail.MovieInfoResult.MovieInfo>()
    val movieInfo: MutableLiveData<RankDetail.MovieInfoResult.MovieInfo>
        get() = _movieInfo

    init{
        getDetailData(movieCd)
    }

    fun getDetailData(movieCd: String){
        val retrofit = RetrofitConnect.getInstance()
        val retrofitForDetail = retrofit.create(GetRankDetailData::class.java)
        viewModelScope.launch {
            try {
                val list = retrofitForDetail.getRankDetailData(movieCd = movieCd)
                _movieInfo.value = list.getMovieInfo()
                Log.d("통신성공 - rankDetail", "${list}")
            }
            catch (e: Exception){
                Log.d("통신실패 - rankDetail", "$e 예외발생")
            }
        }
    }
}