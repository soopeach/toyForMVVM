package com.soopeach.movietoyproject.retrofit

import com.soopeach.movietoyproject.BuildConfig
import com.soopeach.movietoyproject.models.SearchDataList
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface GetSearchData {

    @GET("movie.json")
    suspend fun getSearchData(
        @Header("X-Naver-Client-Id") clientId: String = BuildConfig.naverClientId,
        @Header("X-Naver-Client-Secret") clientSecret: String = BuildConfig.naverClientSecret,
        @Query("query") title: String
    ): SearchDataList
}