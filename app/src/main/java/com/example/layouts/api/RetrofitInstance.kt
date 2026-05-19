package com.example.layouts.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val apiService: ApiService by lazy {

        Retrofit.Builder()
            .baseUrl("https://syriabookingstage.azurewebsites.net/")
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
            .create(ApiService::class.java)
    }
}