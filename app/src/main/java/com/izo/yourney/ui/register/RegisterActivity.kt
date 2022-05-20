package com.izo.yourney.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.izo.yourney.R
import com.izo.yourney.ui.login.LoginActivity
import com.izo.yourney.ui.persona.PersonaActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val btn = findViewById<Button>(R.id.btn_regis)

        btn.setOnClickListener {
            val intent = Intent(this, PersonaActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}