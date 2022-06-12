package com.izo.yourney.ui.dailycheckin

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.Window
import android.widget.Button
import android.widget.TextView
import com.izo.yourney.R
import com.izo.yourney.databinding.ActivityDailyBinding
import com.izo.yourney.ui.login.LoginActivity
import com.izo.yourney.ui.main.MainActivity

class DailyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDailyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDailyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Daily Activity"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.btnSend.setOnClickListener {
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

            tvTitle.setText(getString(R.string.title_dialog_daily))
            tvContent.setText(getString(R.string.content_dialog_daily))

            btnOk.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
                dialog.dismiss()
            }

            dialog.show()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}