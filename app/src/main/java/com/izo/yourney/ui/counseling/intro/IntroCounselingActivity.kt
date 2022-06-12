package com.izo.yourney.ui.counseling.intro

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.izo.yourney.databinding.ActivityIntroCounselingBinding
import com.izo.yourney.ui.counseling.menu.MenuCounselingActivity

class IntroCounselingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntroCounselingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroCounselingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Konsultasi"

        binding.btnStart.setOnClickListener {
            val intentToMenu = Intent(this, MenuCounselingActivity::class.java)
            startActivity(intentToMenu)
            finish()
        }

    }

}