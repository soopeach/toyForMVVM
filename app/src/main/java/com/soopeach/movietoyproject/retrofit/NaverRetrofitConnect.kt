package com.soopeach.movietoyproject.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NaverRetrofitConnect {

    companion object{
        val BASE_URL = "https://openapi.naver.com/v1/search/"
        var INSTANCE : Retrofit? = null

        fun getInstance(): Retrofit{

            if(INSTANCE == null){

                INSTANCE = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }

            return INSTANCE!!
        }
    }
}