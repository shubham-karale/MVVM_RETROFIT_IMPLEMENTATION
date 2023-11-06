package com.example.mvvm_retrofit_implementation.Api

import com.example.mvvm_retrofit_implementation.models.Quotes
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface{


    @GET("quotes")
   suspend fun getQuotes(@Query("page") page:Int):Response<Quotes>

//   NOTE: BASE_URL + /Quotes + ?page=1

}