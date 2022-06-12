package com.izo.yourney.ui.persona

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.izo.yourney.R
import com.izo.yourney.databinding.ActivityAboutOneBinding
import java.util.*

class AboutOneActivity() : AppCompatActivity() {

    private lateinit var binding: ActivityAboutOneBinding
    private lateinit var gender: String
    private lateinit var city: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        clickEvents()

    }


    private fun clickEvents() {

        val current = Calendar.getInstance()
        var born = ""
        binding.bornDate.init(
            current.get(Calendar.YEAR),
            current.get(Calendar.MONTH),
            current.get(Calendar.DAY_OF_MONTH)
        ) { view, year, month, day ->
            val month = month
            born = "$day/$month/$year"
        }

        binding.tvMale.setOnClickListener {
            gender = "pria"
            Toast.makeText(applicationContext, gender, Toast.LENGTH_SHORT).show()

            binding.tvMale.setBackgroundResource(R.drawable.circle_picker_bg)
            binding.tvFemale.setBackgroundResource(R.drawable.circle_not_pick_bg)
        }

        binding.tvFemale.setOnClickListener {
            gender = "wanita"
            Toast.makeText(applicationContext, gender, Toast.LENGTH_SHORT).show()

            binding.tvFemale.setBackgroundResource(R.drawable.circle_picker_bg)
            binding.tvMale.setBackgroundResource(R.drawable.circle_not_pick_bg)
        }

        binding.btnNext.setOnClickListener {
            city = binding.edCity.text.toString()

            val bundle = intent.extras

            val intent = Intent(this, AboutTwoActivity::class.java)
            bundle?.putString("city", city)
            bundle?.putString("born", born)
            bundle?.putString("gender", gender)
            if (bundle != null) {
                intent.putExtras(bundle)
            }
            startActivity(intent)
            finish()
        }

    }

}