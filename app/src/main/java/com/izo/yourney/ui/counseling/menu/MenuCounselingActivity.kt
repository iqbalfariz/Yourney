package com.izo.yourney.ui.counseling.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.izo.yourney.R
import com.izo.yourney.databinding.ActivityMenuCounselingBinding
import com.izo.yourney.ui.counseling.payment.PaymentActivity

class MenuCounselingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuCounselingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuCounselingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener {
            val intentToPayment = Intent(this, PaymentActivity::class.java)
            startActivity(intentToPayment)
        }

    }
}