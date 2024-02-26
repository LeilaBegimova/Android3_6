package com.example.android3_6.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android3_6.data.remote.models.Post
import com.example.android3_6.databinding.ItemBinding

class JsonAdapter : RecyclerView.Adapter<JsonAdapter.JsonViewHolder>() {

    private var jsonList = mutableListOf<Post>()

    fun setJson(jsonList: List<Post>) {
        this.jsonList = jsonList.toMutableList()
        notifyDataSetChanged()
    }

    inner class JsonViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(post: Post) {
            binding.item.text = post.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JsonViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return JsonViewHolder(binding)
    }

    override fun getItemCount() = jsonList.size

    override fun onBindViewHolder(holder: JsonViewHolder, position: Int) {
        holder.onBind(jsonList[position])
    }
}