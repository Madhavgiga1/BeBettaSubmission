package com.example.bebetta.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bebetta.databinding.TickerRowLayoutBinding
import com.example.bebetta.utils.Constants

class TickerAdapter : RecyclerView.Adapter<TickerAdapter.MyViewHolder>() {
    var images = Constants.sportimgs

    class MyViewHolder(private val binding: TickerRowLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(image: String) {
            binding.imgLink = image
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = TickerRowLayoutBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentImg = images[position]
        holder.bind(currentImg)
    }

    override fun getItemCount(): Int {
        return images.size
    }
}