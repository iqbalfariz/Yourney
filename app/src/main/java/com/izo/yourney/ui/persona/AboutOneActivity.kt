package com.izo.yourney.ui.persona

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.widget.Toast
import com.izo.yourney.R
import com.izo.yourney.databinding.ActivityAboutOneBinding
import java.text.SimpleDateFormat
import java.util.*

class AboutOneActivity() : AppCompatActivity() {

    private lateinit var binding: ActivityAboutOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        clickEvents()

        // calendar
        myCalendar()

    }

    private fun myCalendar() {
        val current = Calendar.getInstance()
        binding.datePicker.init(current.get(Calendar.YEAR), current.get(Calendar.MONTH), current.get(Calendar.DAY_OF_MONTH)){
            view, year, month, day ->
            val month = month
            Toast.makeText(this, "Tanggal yang dipilih : $day/$month/$year", Toast.LENGTH_SHORT).show()
        }
    }

    private fun clickEvents() {
        binding.tvMale.setOnClickListener {
            binding.tvMale.setBackgroundResource(R.drawable.circle_picker_bg)
            binding.tvFemale.setBackgroundResource(R.drawable.circle_not_pick_bg)
        }

        binding.tvFemale.setOnClickListener {
            binding.tvFemale.setBackgroundResource(R.drawable.circle_picker_bg)
            binding.tvMale.setBackgroundResource(R.drawable.circle_not_pick_bg)
        }

        binding.btnNext.setOnClickListener {
            val intent = Intent(this, AboutTwoActivity::class.java)
            startActivity(intent)
        }

    }


}