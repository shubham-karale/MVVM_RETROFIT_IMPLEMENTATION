package com.example.mvvm_retrofit_implementation.viewModels

import android.view.ViewConfiguration.get
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_retrofit_implementation.models.Quotes
import com.example.mvvm_retrofit_implementation.repository.QuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: QuoteRepository): ViewModel() {

//    NOTE: As soon as ViewModel class created it will call the Repo class and Repo class will call the API and response will be passed to the ViewModel class

    init {

        viewModelScope.launch(Dispatchers.IO) {
            repository.getQuotes(1)
        }
    }

//        NOTE: As soon as we get data from api we will add it to the LiveData object and LiveData changes will be observed by the MainActivity

        val quotes:LiveData<Quotes>
        get() = repository.quotes





}