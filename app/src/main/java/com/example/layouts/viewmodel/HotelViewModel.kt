package com.example.layouts.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.layouts.api.HotelRepository
import com.example.layouts.model.Data
import com.example.layouts.model.HotelModel
import kotlinx.coroutines.launch

class HotelViewModel : ViewModel(){

    private val repo = HotelRepository()

    val HotelList = MutableLiveData<List<Data>>()

    fun fetchHotels() {
        viewModelScope.launch {
            try {
                HotelList.value = repo.getHotels()
            }catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }
}