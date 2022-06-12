package com.izo.yourney.ui.persona

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.izo.yourney.databinding.ActivityPersonaBinding

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

    companion object {

//        const val USERNAME = "username"

    }

}