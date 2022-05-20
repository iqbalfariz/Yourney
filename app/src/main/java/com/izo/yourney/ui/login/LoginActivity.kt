package com.izo.yourney.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.izo.yourney.R
import com.izo.yourney.ui.MainActivity
import com.izo.yourney.ui.persona.PersonaActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
//        supportActionBar?.hide()

        val btn = findViewById<Button>(R.id.btn_login)

        btn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}