package com.soopeach.movietoyproject.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.soopeach.movietoyproject.databinding.SearchListBinding
import com.soopeach.movietoyproject.models.RankList
import com.soopeach.movietoyproject.models.SearchDataList

class SearchListAdapter(private val searchOnClickListener: SearchOnClickListener) : ListAdapter<SearchDataList.Item, SearchListAdapter.viewHolder>(SearchDiffCallback){

    inner class viewHolder(val binding: SearchListBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: SearchDataList.Item){
            binding.item = item
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = SearchListBinding.inflate(layoutInflater, parent, false)
        return viewHolder(binding)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val item = getItem(position)
        holder.itemView.setOnClickListener {
            searchOnClickListener.onClick(item)
        }
        holder.bind(item)
    }
}

object SearchDiffCallback : DiffUtil.ItemCallback<SearchDataList.Item>(){
    override fun areItemsTheSame(
        oldItem: SearchDataList.Item,
        newItem: SearchDataList.Item
    ): Boolean {
        return oldItem.image == newItem.image
    }

    override fun areContentsTheSame(
        oldItem: SearchDataList.Item,
        newItem: SearchDataList.Item
    ): Boolean {
        return oldItem == newItem
    }
}

class SearchOnClickListener(val clickListener: (item: SearchDataList.Item) -> Unit) {
    fun onClick(item: SearchDataList.Item) = clickListener(item)
}