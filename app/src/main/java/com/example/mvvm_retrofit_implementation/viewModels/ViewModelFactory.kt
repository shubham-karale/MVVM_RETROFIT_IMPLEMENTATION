package com.example.mvvm_retrofit_implementation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_retrofit_implementation.repository.QuoteRepository

// NOTE: Whenever you create paramter in ViewModel class you have to create a ViewModelFactory class

class ViewModelFactory(private val repository: QuoteRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}