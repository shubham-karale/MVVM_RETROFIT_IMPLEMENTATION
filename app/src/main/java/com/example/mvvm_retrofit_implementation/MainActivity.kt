package com.example.mvvm_retrofit_implementation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.mvvm_retrofit_implementation.Api.ApiInterface
import com.example.mvvm_retrofit_implementation.Api.RetrofitBuilder
import com.example.mvvm_retrofit_implementation.repository.QuoteRepository
import com.example.mvvm_retrofit_implementation.viewModels.MainViewModel
import com.example.mvvm_retrofit_implementation.viewModels.ViewModelFactory

class MainActivity : AppCompatActivity() {

   lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//       Create Object of Api Interface
        val apiInterface = RetrofitBuilder.getInstance().create(ApiInterface::class.java)
//    Create Object of Repository class
        val repository = QuoteRepository(apiInterface)
//        Create Object of ViewModel class -> ViewModelFactory class
        viewModel = ViewModelProvider(this,ViewModelFactory(repository)).get(MainViewModel::class.java)
//      Observes the LiveData object
        viewModel!!.quotes.observe(this,{
           Log.d("TAG", "onCreate: ${it.results[0].content}")
        })

        





    }
}