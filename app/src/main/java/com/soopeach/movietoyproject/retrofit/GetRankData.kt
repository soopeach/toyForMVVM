package com.soopeach.movietoyproject.retrofit

import com.soopeach.movietoyproject.BuildConfig
import com.soopeach.movietoyproject.models.RankList
import retrofit2.http.GET
import retrofit2.http.Query

interface GetRankData {
    @GET("searchDailyBoxOfficeList.json")
    suspend fun getRankData(
        @Query("key") key: String = BuildConfig.rankKey,
        @Query("targetDt") targetDt: String,
    ) : RankList

}