package com.doyeonkim.repositorysearch

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.doyeonkim.repositorysearch.databinding.ListItemBinding
import com.doyeonkim.repositorysearch.models.Item

class RepoAdapter(val context: Context) : RecyclerView.Adapter<RepoAdapter.RepoHolder>() {
    var items: MutableList<Item> = mutableListOf()

    class RepoHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.apply {
                this.item = item
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoHolder {
        return RepoHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.list_item, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RepoHolder, position: Int) {
        val dto = items[position]
        holder.apply {
            bind(dto)
        }
    }

    override fun getItemCount() = items.size
}