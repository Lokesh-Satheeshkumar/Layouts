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

    private var _hotelList = MutableLiveData<List<Data>>()
    val hotelList = MutableLiveData<List<Data>>()

    fun fetchHotels() {
        viewModelScope.launch {
                _hotelList.value = repo.getHotels()
                hotelList.value = _hotelList.value
        }
    }
}