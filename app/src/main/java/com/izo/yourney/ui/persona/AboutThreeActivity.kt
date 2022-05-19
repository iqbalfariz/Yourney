package com.izo.yourney.ui.persona

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.izo.yourney.R
import com.izo.yourney.databinding.ActivityAboutThreeBinding

class AboutThreeActivity : AppCompatActivity() {

    private lateinit var adapter: RecommendHobbyAdapter
    private lateinit var binding: ActivityAboutThreeBinding
    private val list = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutThreeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // rv untuk recommend hobby
        list.addAll(resources.getStringArray(R.array.recommend_hobby))
        showRecyclerView()

        // click events
        clickEvents()
    }

    private fun clickEvents() {
        binding.tvDontHaveHobby.setOnClickListener {
            binding.edHobby.setText(binding.tvDontHaveHobby.text)
        }
    }

    private fun showRecyclerView() {
        adapter = RecommendHobbyAdapter(list)
        binding.rvRecommendHobby.adapter = adapter
        binding.rvRecommendHobby.layoutManager = GridLayoutManager(this, 2)
        adapter.setOnItemClickCallback(object : RecommendHobbyAdapter.OnItemClickCallback{
            override fun onItemClicked(dataRecommend: String) {
                binding.edHobby.setText(dataRecommend)
            }
        })
    }

}