package com.example.bebetta.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bebetta.databinding.MatchRowLayoutBinding
import com.example.bebetta.databinding.TickerRowLayoutBinding
import com.example.bebetta.models.Matches
import com.example.bebetta.utils.Constants

class MatchAdapter : RecyclerView.Adapter<MatchAdapter.MyViewHolder>() {
    var matches = Constants.sportMatches

    class MyViewHolder(private val binding: MatchRowLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(currentmatch: Matches) {
            binding.result = currentmatch
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = MatchRowLayoutBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentmatch = matches[position]
        holder.bind(currentmatch)
    }

    override fun getItemCount(): Int {
        return matches.size
    }
}