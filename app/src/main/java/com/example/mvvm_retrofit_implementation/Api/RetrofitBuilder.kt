package com.example.mvvm_retrofit_implementation.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

//    val BASE_URL = "https://zenquotes.io/api/"
    val BASE_URL = "https://quotable.io/"

    fun getInstance():Retrofit {

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    }

}