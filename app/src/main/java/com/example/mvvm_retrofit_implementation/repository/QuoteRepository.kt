package com.example.mvvm_retrofit_implementation.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm_retrofit_implementation.Api.ApiInterface
import com.example.mvvm_retrofit_implementation.models.Quotes

//NOTE: We pass the ApiInterface as a parameter to the constructor

//NOTE: ViewModel will call the Repository and Repository will call the API and REPONSE will be passed to the ViewModel

// 1) We create a LiveData object of type Quotes
// 2) We create a getter method for the LiveData object
// 3) We create a suspend function to get the quotes from the API
// 4) We make the function suspend so that we can call it from a coroutine
// 5) As soon we get Data add into the LiveData object

class QuoteRepository(private val api: ApiInterface) {

    private val quotesLiveData = MutableLiveData<Quotes>()



    val quotes: LiveData<Quotes>
        get() = quotesLiveData


    suspend fun getQuotes(page: Int) {
        val result = api.getQuotes(page)

        if (result?.body() != null) {

//            As soon as we get the response we add the data into LiveDaata
            quotesLiveData.postValue(result.body())


        }

    }

}