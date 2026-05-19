package com.example.layouts.api

import com.example.layouts.model.Data
import com.example.layouts.model.HotelModel
import retrofit2.Call

class HotelRepository {
    suspend fun getHotels(): List<Data> {
        return RetrofitInstance.apiService.getHotels().data ?:emptyList()
    }
}