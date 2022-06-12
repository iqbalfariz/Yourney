package com.izo.yourney.ui.option

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.izo.yourney.R
import com.izo.yourney.databinding.ActivityOptionBinding
import com.izo.yourney.ui.chatbot.ChatbotActivity
import com.izo.yourney.ui.counseling.CounselingActivity
import com.izo.yourney.ui.counseling.intro.IntroCounselingActivity

class OptionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOptionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        clickEvents()
    }

    private fun clickEvents() {

        binding.btnCounseling.setOnClickListener {
            val intentToCounseling = Intent(this, IntroCounselingActivity::class.java)
            startActivity(intentToCounseling)
            finish()
        }

        binding.btnChatbot.setOnClickListener {
            val intentToChatbot = Intent(this, ChatbotActivity::class.java)
            startActivity(intentToChatbot)
            finish()
        }

    }
}