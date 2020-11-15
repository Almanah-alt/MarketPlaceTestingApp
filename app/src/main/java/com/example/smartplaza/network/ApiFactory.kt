package com.example.smartplaza.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory{
    private const val ENDPOINT = "https://api.smartplaza.kz/"

    fun getRetrofit() =
        Retrofit.Builder()
            .baseUrl(ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun getApiService() =
        getRetrofit().create(ApiService::class.java)
}