package com.example.layouts.api

import com.example.layouts.model.Data
import com.example.layouts.model.HotelModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("public-api/api/HotelPublic/aggregates/")
    suspend fun getHotels(): HotelModel

}