package com.izo.yourney.ui.launchscreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.izo.yourney.databinding.ActivityLaunchScreenBinding
import com.izo.yourney.ui.login.LoginActivity
import com.izo.yourney.ui.register.RegisterActivity

class LaunchScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLaunchScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLaunchScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val intentToLogin = Intent(this, LoginActivity::class.java)
            startActivity(intentToLogin)
            finish()
        }

        binding.btnRegis.setOnClickListener {
            val intentToRegis = Intent(this, RegisterActivity::class.java)
            startActivity(intentToRegis)
            finish()
        }
    }
}