package com.izo.yourney.ui.persona

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.izo.yourney.R
import com.izo.yourney.databinding.ActivityPersonaBinding
import com.izo.yourney.ui.login.LoginActivity

class PersonaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPersonaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            val intent = Intent(this, AboutOneActivity::class.java)
            startActivity(intent)
        }

    }
}