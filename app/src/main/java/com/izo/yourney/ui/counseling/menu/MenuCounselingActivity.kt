package com.izo.yourney.ui.counseling.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.izo.yourney.R
import com.izo.yourney.databinding.ActivityMenuCounselingBinding
import com.izo.yourney.ui.counseling.payment.PaymentActivity

class MenuCounselingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuCounselingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuCounselingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Menu Konsultasi"
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        clickEvents()

    }

    private fun clickEvents() {
        binding.tvTopic1.setOnClickListener {
            binding.tvTopic1.setBackgroundResource(R.drawable.shape_pick_bg)
            binding.tvTopic2.setBackgroundResource(R.drawable.shape_not_pick_bg)
            binding.tvTopic3.setBackgroundResource(R.drawable.shape_not_pick_bg)
            binding.tvTopic4.setBackgroundResource(R.drawable.shape_not_pick_bg)
            binding.tvTopic5.setBackgroundResource(R.drawable.shape_not_pick_bg)
            binding.tvTopic6.setBackgroundResource(R.drawable.shape_not_pick_bg)
        }

        binding.tvTopic2.setOnClickListener {
            binding.tvTopic2.setBackgroundResource(R.drawable.shape_pick_bg)
            binding.tvTopic1.setBackgroundResource(R.drawable.shape_not_pick_bg)
            binding.tvTopic3.setBackgroundResource(R.drawable.shape_not_pick_bg)
            binding.tvTopic4.setBackgroundResource(R.drawable.shape_not_pick_bg)
            binding.tvTopic5.setBackgroundResource(R.drawable.shape_not_pick_bg)
            binding.tvTopic6.setBackgroundResource(R.drawable.shape_not_pick_bg)
        }

        binding.tvTopic3.setOnClickListener {
            binding.tvTopic3.setBackgroundResource(R.drawable.shape_pick_bg)
            binding.tvTopic2.setBackgroundResource(R.drawable.shape_not_pick_bg)
            binding.tvTopic1.setBackgroundResource(R.drawable.shape_not_pick_bg)
            binding.tvTopic4.setBackgroundResource(R.drawable.shape_not_pick_bg)
            binding.tvTopic5.setBackgroundResource(R.drawable.shape_not_pick_bg)
            binding.tvTopic6.setBackgroundResource(R.drawable.shape_not_pick_bg)
        }

        binding.tvTopic4.setOnClickListener {
            binding.tvTopic4.setBackgroundResource(R.drawable.shape_pick_bg)
            binding.tvTopic2.setBackgroundResource(R.drawable.shape_not_pick_bg)
            binding.tvTopic1.setBackgroundResource(R.drawable.shape_not_pick_bg)
            binding.tvTopic3.setBackgroundResource(R.drawable.shape_not_pick_bg)
            binding.tvTopic5.setBackgroundResource(R.drawable.shape_not_pick_bg)
            binding.tvTopic6.setBackgroundResource(R.drawable.shape_not_pick_bg)
        }

        binding.tvTopic4.setOnClickListener {
            binding.tvTopic4.setBackgroundResource(R.drawable.shape_pick_bg)
            binding.tvTopic2.setBackgroundResource(R.drawable.shape_not_pick_bg)
            binding.tvTopic1.setBackgroundResource(R.drawable.shape_not_pick_bg)
            binding.tvTopic3.setBackgroundResource(R.drawable.shape_not_pick_bg)
            binding.tvTopic5.setBackgroundResource(R.drawable.shape_not_pick_bg)
            binding.tvTopic6.setBackgroundResource(R.drawable.shape_not_pick_bg)
        }

        binding.tvTopic5.setOnClickListener {
            binding.tvTopic5.setBackgroundResource(R.drawable.shape_pick_bg)
            binding.tvTopic2.setBackgroundResource(R.drawable.shape_not_pick_bg)
            binding.tvTopic1.setBackgroundResource(R.drawable.shape_not_pick_bg)
            binding.tvTopic4.setBackgroundResource(R.drawable.shape_not_pick_bg)
            binding.tvTopic3.setBackgroundResource(R.drawable.shape_not_pick_bg)
            binding.tvTopic6.setBackgroundResource(R.drawable.shape_not_pick_bg)
        }

        binding.tvTopic6.setOnClickListener {
            binding.tvTopic6.setBackgroundResource(R.drawable.shape_pick_bg)
            binding.tvTopic2.setBackgroundResource(R.drawable.shape_not_pick_bg)
            binding.tvTopic1.setBackgroundResource(R.drawable.shape_not_pick_bg)
            binding.tvTopic4.setBackgroundResource(R.drawable.shape_not_pick_bg)
            binding.tvTopic5.setBackgroundResource(R.drawable.shape_not_pick_bg)
            binding.tvTopic3.setBackgroundResource(R.drawable.shape_not_pick_bg)
        }

        binding.cvPacketOne.setOnClickListener {
            binding.layoutPacketOne.setBackgroundResource(R.drawable.shape_pick_packet_bg)
            binding.tvPricePacketOne.setBackgroundResource(R.drawable.shape_pick_packet_bg)
            binding.layoutPacketTwo.setBackgroundResource(R.drawable.shape_not_pick_packet_bg)
            binding.tvPricePacketTwo.setBackgroundResource(R.drawable.shape_not_pick_packet_bg)
        }

        binding.cvPacketTwo.setOnClickListener {
            binding.layoutPacketTwo.setBackgroundResource(R.drawable.shape_pick_packet_bg)
            binding.tvPricePacketTwo.setBackgroundResource(R.drawable.shape_pick_packet_bg)
            binding.layoutPacketOne.setBackgroundResource(R.drawable.shape_not_pick_packet_bg)
            binding.tvPricePacketOne.setBackgroundResource(R.drawable.shape_not_pick_packet_bg)
        }

        binding.btnNext.setOnClickListener {
            val intentToPayment = Intent(this, PaymentActivity::class.java)
            startActivity(intentToPayment)
            finish()
        }
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if (item.itemId == android.R.id.home) {
//            onBackPressed()
//        }
//        return super.onOptionsItemSelected(item)
//    }
}