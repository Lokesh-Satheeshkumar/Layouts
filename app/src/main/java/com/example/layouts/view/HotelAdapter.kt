package com.example.layouts.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.layouts.databinding.HotelGridItemBinding
import com.example.layouts.model.Data
import com.example.layouts.model.Landmark

class HotelAdapter(private val hotelList: List<Data>) : RecyclerView.Adapter<HotelAdapter.HotelViewHolder>() {

    class HotelViewHolder(val binding: HotelGridItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelViewHolder {
        val binding = HotelGridItemBinding.inflate(LayoutInflater.from(parent.context), parent, false
        )
        return HotelViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HotelViewHolder, position: Int) {
        val hotel = hotelList[position]

        val StarRating = hotel.starRating ?: 0


        holder.binding.hotelname.text = "${hotel.name} ${"★".repeat(StarRating)}"
        holder.binding.hotelAvarageRating.text = hotel.averageRating
        holder.binding.hotelPrice.text = hotel.minRoomPrice
        holder.binding.hotelLocation.text = hotel.city

        Glide.with(holder.itemView.context)
            .load(hotel.coverImageUrl)
            .into(holder.binding.hotelImage)
    }

    override fun getItemCount(): Int {
        return hotelList.size
    }
}