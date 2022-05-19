package com.izo.yourney.ui.persona

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.izo.yourney.R

class RecommendHobbyAdapter(private val listRecommendHobby: ArrayList<String>): RecyclerView.Adapter<RecommendHobbyAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback
    private lateinit var recommendHobby: String

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_container_recommend_hobby, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.tvRecommendHobby.text = listRecommendHobby[position]
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listRecommendHobby[holder.adapterPosition])
        }
        recommendHobby = listRecommendHobby[position]
    }


    override fun getItemCount(): Int = listRecommendHobby.size

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvRecommendHobby = itemView.findViewById<TextView>(R.id.tv_recommend_hobby)
    }

    interface OnItemClickCallback {
        fun onItemClicked(dataRecommend: String)
    }
}