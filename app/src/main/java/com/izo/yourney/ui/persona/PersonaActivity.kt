package com.izo.yourney.ui.persona

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.izo.yourney.R
import com.izo.yourney.ui.MainActivity
import com.izo.yourney.ui.chatbot.ChatbotActivity

class PersonaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_persona)

        val btn = findViewById<Button>(R.id.btn_start)

        btn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}