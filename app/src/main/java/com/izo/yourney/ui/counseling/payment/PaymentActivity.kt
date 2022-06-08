package com.izo.yourney.ui.counseling.payment

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.Window
import android.widget.Button
import android.widget.TextView
import com.izo.yourney.R
import com.izo.yourney.databinding.ActivityPaymentBinding
import com.izo.yourney.ui.MainActivity
import com.izo.yourney.ui.login.LoginActivity

class PaymentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPaymentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Pembayaran"
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // click events
        clickEvents()
    }

    private fun clickEvents() {

        binding.btnConfirm.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {

        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.custom_dialog)


        val btnOk = dialog.findViewById<Button>(R.id.btn_ok)
        val tvTitle = dialog.findViewById<TextView>(R.id.tv_title)
        val tvContent = dialog.findViewById<TextView>(R.id.tv_content)

        tvTitle.setText(getString(R.string.title_dialog_payment))
        tvContent.setText(getString(R.string.content_dialog_payment))

        btnOk.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
            dialog.dismiss()
        }

        dialog.show()
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if (item.itemId == android.R.id.home) {
//            onBackPressed()
//        }
//        return super.onOptionsItemSelected(item)
//    }
}