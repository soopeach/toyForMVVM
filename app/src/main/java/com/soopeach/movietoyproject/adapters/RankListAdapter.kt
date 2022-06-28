package com.soopeach.movietoyproject.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.soopeach.movietoyproject.databinding.RankListBinding
import com.soopeach.movietoyproject.models.RankList

class RankListAdapter : ListAdapter<RankList.BoxOfficeResult.DailyBoxOffice, RankListAdapter.viewHolder>(DiffCallback){

    inner class viewHolder(val binding: RankListBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(dailyBoxOffice: RankList.BoxOfficeResult.DailyBoxOffice){
            binding.dailyBoxOffice = dailyBoxOffice
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RankListBinding.inflate(layoutInflater, parent, false)
        return viewHolder(binding)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

object DiffCallback : DiffUtil.ItemCallback<RankList.BoxOfficeResult.DailyBoxOffice>(){
    override fun areItemsTheSame(
        oldItem: RankList.BoxOfficeResult.DailyBoxOffice,
        newItem: RankList.BoxOfficeResult.DailyBoxOffice
    ): Boolean {
        return oldItem.rank == newItem.rank
    }

    override fun areContentsTheSame(
        oldItem: RankList.BoxOfficeResult.DailyBoxOffice,
        newItem: RankList.BoxOfficeResult.DailyBoxOffice
    ): Boolean {
        return oldItem == newItem
    }

}