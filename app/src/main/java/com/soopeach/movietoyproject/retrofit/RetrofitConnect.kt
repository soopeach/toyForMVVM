package com.soopeach.movietoyproject.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitConnect {

    companion object{

        private val BASE_URL = "https://kobis.or.kr/kobisopenapi/webservice/rest/"
        private var INSTANCE : Retrofit? = null

        fun getInstance() : Retrofit{
            if(INSTANCE == null){
                INSTANCE =  Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }

            return INSTANCE!!
        }

    }
}