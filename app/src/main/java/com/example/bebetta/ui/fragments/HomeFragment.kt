package com.example.bebetta.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bebetta.R
import com.example.bebetta.adapters.ImageAdapter
import com.example.bebetta.adapters.MatchAdapter
import com.example.bebetta.adapters.TickerAdapter
import com.example.bebetta.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@AndroidEntryPoint
@ExperimentalCoroutinesApi
class HomeFragment: Fragment() {
    private var _binding:FragmentHomeBinding?=null
    private val binding get() = _binding!!
    private val mAdapter by lazy {ImageAdapter()}
    private val tickerAdapter by lazy {TickerAdapter()}
    private val matchAdapter by lazy {MatchAdapter()}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentHomeBinding.inflate(inflater, container, false)
        setupRecyclerView()
        return binding.root
    }





    private fun setupRecyclerView() {
        binding.previewRecyclerview.adapter=mAdapter
        binding.tickerRv.adapter=tickerAdapter
        binding.matchRv.adapter=matchAdapter
        binding.previewRecyclerview.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL,
            true  // Set to true to reverse the layout
        )
        binding.tickerRv.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL,
            true
        )
        binding.matchRv.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL,
            true
        )
    }


}