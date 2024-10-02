package com.example.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target
import com.example.main.databinding.ListItemBinding
import com.example.model.Document

internal class MainAdapter: PagingDataAdapter<Document, MainAdapter.MainViewHolder>(diffCallback) {
    inner class MainViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(document: Document) {
            val siteName = if (document.displaySiteName == "") "site명이 없습니다." else document.displaySiteName
            binding.tvTimestamp.text = document.datetime
            binding.tvSitename.text = siteName

            Glide.with(binding.ivThumbnail.context)
                .load(document.imageUrl)
                .centerCrop()
                .into(binding.ivThumbnail)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = getItem(position)
        item?.let { holder.bind(it) }
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Document>() {
            override fun areItemsTheSame(oldItem: Document, newItem: Document): Boolean {
                return oldItem.docUrl == newItem.docUrl
            }

            override fun areContentsTheSame(oldItem: Document, newItem: Document): Boolean {
                return oldItem == newItem
            }
        }
    }
}