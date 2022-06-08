package com.izo.yourney.ui.counseling.intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.izo.yourney.R
import com.izo.yourney.databinding.ActivityIntroCounselingBinding
import com.izo.yourney.ui.counseling.menu.MenuCounselingActivity

class IntroCounselingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntroCounselingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroCounselingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Konsultasi"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.btnStart.setOnClickListener {
            val intentToMenu = Intent(this, MenuCounselingActivity::class.java)
            startActivity(intentToMenu)
            finish()
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}