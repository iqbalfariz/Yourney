package com.izo.yourney.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.izo.yourney.R
import com.izo.yourney.databinding.ActivityLoginBinding
import com.izo.yourney.ui.chatbot.ChatbotActivity
import com.izo.yourney.ui.persona.PersonaActivity
import com.izo.yourney.ui.register.RegisterActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        supportActionBar?.hide()


        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, PersonaActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.tvRegis.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}