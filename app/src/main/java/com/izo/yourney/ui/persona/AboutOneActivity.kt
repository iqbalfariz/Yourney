package com.izo.yourney.ui.persona

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.izo.yourney.R
import com.izo.yourney.databinding.ActivityAboutOneBinding
import java.text.SimpleDateFormat
import java.util.*

class AboutOneActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val calendar = Calendar.getInstance()

        val datePicker = DatePickerDialog.OnDateSetListener {view, year, month, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLabel(calendar)
        }

        binding.btnDatePicker.setOnClickListener {
            DatePickerDialog(this, datePicker, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)).show()
        }

        binding.tvMale.setOnClickListener {
            binding.tvMale.setBackgroundResource(R.drawable.circle_picker_bg)
        }

        binding.tvFemale.setOnClickListener {
            binding.tvFemale.setBackgroundResource(R.drawable.circle_picker_bg)
        }

        binding.btnStart.setOnClickListener {
            val intent = Intent(this, AboutTwoActivity::class.java)
            startActivity(intent)
        }
    }

    private fun updateLabel(calendar: Calendar) {
        val dateFormat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(dateFormat, Locale.US)
        binding.btnDatePicker.setText(sdf.format(calendar.time))
    }
}