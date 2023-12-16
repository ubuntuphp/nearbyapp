package com.example.myapplication.repos

import com.example.nearbyapp.repos.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitModule {

    private lateinit var retrofitModule: Retrofit
    fun getRetrofitModule(): Retrofit {
        if (::retrofitModule.isInitialized) return retrofitModule
        retrofitModule = Retrofit.Builder().baseUrl("https://api.seatgeek.com")
            .addConverterFactory(GsonConverterFactory.create()).build()
        return retrofitModule
    }

    fun getApi(): ApiInterface {
        return getRetrofitModule().create(ApiInterface::class.java)
    }
}