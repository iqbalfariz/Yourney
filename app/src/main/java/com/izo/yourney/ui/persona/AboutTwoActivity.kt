package com.izo.yourney.ui.persona

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.izo.yourney.R
import com.izo.yourney.databinding.ActivityAboutTwoBinding

class AboutTwoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutTwoBinding
    private lateinit var study: String
    private lateinit var phoneNumber: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        clickEvents()

        study = ""
        phoneNumber = ""
    }

    private fun clickEvents() {
        binding.tvSma.setOnClickListener {
            study = "SMA"
            binding.tvSma.setBackgroundResource(R.drawable.circle_picker_bg)
            binding.tvCollage.setBackgroundResource(R.drawable.circle_not_pick_bg)
            binding.tvLulus.setBackgroundResource(R.drawable.circle_not_pick_bg)
            binding.tvPutus.setBackgroundResource(R.drawable.circle_not_pick_bg)
        }

        binding.tvCollage.setOnClickListener {
            study = "Kuliah"
            binding.tvCollage.setBackgroundResource(R.drawable.circle_picker_bg)
            binding.tvSma.setBackgroundResource(R.drawable.circle_not_pick_bg)
            binding.tvLulus.setBackgroundResource(R.drawable.circle_not_pick_bg)
            binding.tvPutus.setBackgroundResource(R.drawable.circle_not_pick_bg)
        }

        binding.tvLulus.setOnClickListener {
            study = "Lulus Kuliah"
            binding.tvLulus.setBackgroundResource(R.drawable.circle_picker_bg)
            binding.tvCollage.setBackgroundResource(R.drawable.circle_not_pick_bg)
            binding.tvSma.setBackgroundResource(R.drawable.circle_not_pick_bg)
            binding.tvPutus.setBackgroundResource(R.drawable.circle_not_pick_bg)
        }

        binding.tvPutus.setOnClickListener {
            study = "Tidak Lulus SMA/SMK"
            binding.tvPutus.setBackgroundResource(R.drawable.circle_picker_bg)
            binding.tvCollage.setBackgroundResource(R.drawable.circle_not_pick_bg)
            binding.tvLulus.setBackgroundResource(R.drawable.circle_not_pick_bg)
            binding.tvSma.setBackgroundResource(R.drawable.circle_not_pick_bg)
        }

        binding.btnNext.setOnClickListener {
            phoneNumber = binding.edPhoneNumber.text.toString()

            val bundle = intent.extras
            val intent = Intent(this, AboutThreeActivity::class.java)

            bundle?.putString("study", study)
            bundle?.putString("phone", phoneNumber)
            Log.d("bundle sekarang di 2", bundle.toString())

            if (bundle != null) {
                intent.putExtras(bundle)
            }
            startActivity(intent)
            finish()
        }
    }
}