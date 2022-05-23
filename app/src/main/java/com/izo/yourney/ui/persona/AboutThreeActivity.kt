package com.izo.yourney.ui.persona

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import com.izo.yourney.R
import com.izo.yourney.databinding.ActivityAboutThreeBinding
import com.izo.yourney.ui.login.LoginActivity

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

        binding.btnNext.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {

        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.custom_dialog)


        val btnOk = dialog.findViewById<Button>(R.id.btn_ok)

        btnOk.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        dialog.show()

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