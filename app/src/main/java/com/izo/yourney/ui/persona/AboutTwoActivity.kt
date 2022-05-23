package com.izo.yourney.ui.persona

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.izo.yourney.R
import com.izo.yourney.databinding.ActivityAboutTwoBinding

class AboutTwoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutTwoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvSma.setOnClickListener {
            binding.tvSma.setBackgroundResource(R.drawable.circle_picker_bg)
            binding.tvCollage.setBackgroundResource(R.drawable.circle_not_pick_bg)
            binding.tvLulus.setBackgroundResource(R.drawable.circle_not_pick_bg)
            binding.tvPutus.setBackgroundResource(R.drawable.circle_not_pick_bg)
        }

        binding.tvCollage.setOnClickListener {
            binding.tvCollage.setBackgroundResource(R.drawable.circle_picker_bg)
            binding.tvSma.setBackgroundResource(R.drawable.circle_not_pick_bg)
            binding.tvLulus.setBackgroundResource(R.drawable.circle_not_pick_bg)
            binding.tvPutus.setBackgroundResource(R.drawable.circle_not_pick_bg)
        }

        binding.tvLulus.setOnClickListener {
            binding.tvLulus.setBackgroundResource(R.drawable.circle_picker_bg)
            binding.tvCollage.setBackgroundResource(R.drawable.circle_not_pick_bg)
            binding.tvSma.setBackgroundResource(R.drawable.circle_not_pick_bg)
            binding.tvPutus.setBackgroundResource(R.drawable.circle_not_pick_bg)
        }

        binding.tvPutus.setOnClickListener {
            binding.tvPutus.setBackgroundResource(R.drawable.circle_picker_bg)
            binding.tvCollage.setBackgroundResource(R.drawable.circle_not_pick_bg)
            binding.tvLulus.setBackgroundResource(R.drawable.circle_not_pick_bg)
            binding.tvSma.setBackgroundResource(R.drawable.circle_not_pick_bg)
        }

        binding.btnNext.setOnClickListener {
            val intent = Intent(this, AboutThreeActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}