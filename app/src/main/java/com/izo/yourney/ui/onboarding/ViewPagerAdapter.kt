package com.izo.yourney.ui.onboarding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.izo.yourney.R

class ViewPagerAdapter(private val introSlides: List<IntroSlide>) :
    RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        return ViewPagerViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.slide_item_container,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.bind(introSlides[position])
    }

    override fun getItemCount(): Int = introSlides.size

    inner class ViewPagerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textTitle = view.findViewById<TextView>(R.id.tv_title)
        private val textDesc = view.findViewById<TextView>(R.id.tv_desc)
        private val imageIcon = view.findViewById<ImageView>(R.id.iv_Slide_Icon)

        fun bind(introSlide: IntroSlide) {
            textTitle.text = introSlide.title
            textDesc.text = introSlide.description
            imageIcon.setImageResource(introSlide.icon)
        }
    }

}