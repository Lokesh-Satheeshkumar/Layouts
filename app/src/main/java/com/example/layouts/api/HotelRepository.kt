package com.example.layouts.api

import com.example.layouts.model.Data
import com.example.layouts.model.HotelModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call

class HotelRepository {
    suspend fun getHotels(): List<Data> {
        return withContext(Dispatchers.IO) {
            try {
                RetrofitInstance
                    .apiService
                    .getHotels()
                    .data ?: emptyList()

            } catch (e: Exception) {

                emptyList()
            }
        }


    }
}