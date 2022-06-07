package com.izo.yourney.ui.persona

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.os.bundleOf
import com.izo.yourney.R
import com.izo.yourney.databinding.ActivityPersonaBinding
import com.izo.yourney.ui.login.LoginActivity

class PersonaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPersonaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle = intent.extras

        binding.btnNext.setOnClickListener {
            val intent = Intent(this, AboutOneActivity::class.java)
            if (bundle != null) {
                intent.putExtras(bundle)
            }
            startActivity(intent)
            finish()
        }

        val username = bundle?.getString("username")
        binding.tvUsername.text = username

    }

}