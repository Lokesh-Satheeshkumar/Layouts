package com.example.layouts.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.layouts.R
import com.example.layouts.databinding.FragmentHomeBinding
import com.example.layouts.viewmodel.HotelViewModel

class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding ?= null

    private lateinit var viewModel: HotelViewModel

    private lateinit var adapter: HotelAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        setupViewModel()
        setupRecyclerView()
        observeHotels()
        viewModel.fetchHotels()

        return binding?.root
    }



    private fun setupRecyclerView() {
        binding?.recycleView?.layoutManager =
            GridLayoutManager(requireContext(),2)
    }


    private fun setupViewModel() {
        viewModel = ViewModelProvider(this)[HotelViewModel::class.java]
    }

    private fun observeHotels() {
        viewModel.HotelList.observe(
            viewLifecycleOwner
        ) {
            adapter = HotelAdapter(it)
            binding?.recycleView?.adapter = adapter
        }
    }


}