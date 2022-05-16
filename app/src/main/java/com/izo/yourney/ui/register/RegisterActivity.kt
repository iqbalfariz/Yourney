package com.izo.yourney.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.izo.yourney.R
import com.izo.yourney.databinding.ActivityRegisterBinding
import com.izo.yourney.ui.login.LoginActivity
import com.izo.yourney.ui.persona.PersonaActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnRegis.setOnClickListener {
            val intent = Intent(this, PersonaActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.tvLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}