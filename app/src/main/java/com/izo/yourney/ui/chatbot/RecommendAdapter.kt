package com.izo.yourney.ui.chatbot

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.izo.yourney.R

class RecommendAdapter(private val listRecommend: ArrayList<String>): RecyclerView.Adapter<RecommendAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback
    private lateinit var recommendMessage: String

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_container_recommend_message, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.tvRecommend.text = listRecommend[position]
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listRecommend[holder.adapterPosition])
        }
        recommendMessage = listRecommend[position]
    }

    override fun getItemCount(): Int = listRecommend.size

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvRecommend = itemView.findViewById<TextView>(R.id.tv_recommend)
    }

    interface OnItemClickCallback {
        fun onItemClicked(dataRecommend: String)
    }
}

