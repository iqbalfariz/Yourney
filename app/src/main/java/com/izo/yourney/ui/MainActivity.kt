package com.izo.yourney.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.firebase.database.FirebaseDatabase
import com.izo.yourney.R
import com.izo.yourney.ui.chatbot.ChatbotActivity
import com.izo.yourney.ui.counseling.CounselingActivity
import com.izo.yourney.ui.counseling.intro.IntroCounselingActivity
import com.izo.yourney.ui.customview.PasswordView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnChatbot = findViewById<Button>(R.id.btn_chatbot)
        btnChatbot.setOnClickListener {
            val intent = Intent(this, ChatbotActivity::class.java)
            startActivity(intent)
        }

        val btnCounseling = findViewById<Button>(R.id.btn_counseling)
        btnCounseling.setOnClickListener {
            val intent = Intent(this, IntroCounselingActivity::class.java)
            startActivity(intent)
        }
    }
}