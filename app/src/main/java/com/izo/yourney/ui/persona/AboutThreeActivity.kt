package com.izo.yourney.ui.persona

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.izo.yourney.R
import com.izo.yourney.databinding.ActivityAboutThreeBinding
import com.izo.yourney.ui.MainActivity
import com.izo.yourney.ui.login.LoginActivity

class AboutThreeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutThreeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutThreeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}