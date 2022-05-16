package com.izo.yourney.ui.persona

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
        }

        binding.tvCollage.setOnClickListener {
            binding.tvCollage.setBackgroundResource(R.drawable.circle_picker_bg)
        }

        binding.tvLulus.setOnClickListener {
            binding.tvLulus.setBackgroundResource(R.drawable.circle_picker_bg)
        }

        binding.tvPutus.setOnClickListener {
            binding.tvPutus.setBackgroundResource(R.drawable.circle_picker_bg)
        }

    }
}