package com.soopeach.movietoyproject.retrofit

import com.soopeach.movietoyproject.BuildConfig
import com.soopeach.movietoyproject.models.RankDetail
import retrofit2.http.GET
import retrofit2.http.Query

interface GetRankDetailData {
    @GET("movie/searchMovieInfo.json")
    suspend fun getRankDetailData(
        @Query("key") key: String = BuildConfig.rankKey,
        @Query("movieCd") movieCd: String,
    ) : RankDetail
}