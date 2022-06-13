package com.izo.yourney.ui.main

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.izo.yourney.R
import com.izo.yourney.data.local.StatePreference
import com.izo.yourney.ui.ViewModelFactory
import com.izo.yourney.ui.dailycheckin.DailyActivity
import com.izo.yourney.ui.launchscreen.LaunchScreenActivity
import com.izo.yourney.ui.login.LoginActivity
import com.izo.yourney.ui.option.OptionActivity


private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding: com.izo.yourney.databinding.ActivityMainBinding

    private lateinit var bottomNavView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = com.izo.yourney.databinding.ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()
        clickEvents()

        bottomNavView = binding.BottomNavigationView

        mainViewModel.getState().observe(this) { state ->
            if (state.username == "") {
                binding.tvUname.text = "Friney"
            } else {
                binding.tvUname.text = state.username
            }
        }

    }

    private fun clickEvents() {
        binding.btnFab.setOnClickListener {
            val intentToOption = Intent(this, OptionActivity::class.java)
            startActivity(intentToOption)
        }

        binding.btnGood.setOnClickListener {
            val intentToDaily = Intent(this, DailyActivity::class.java)
            startActivity(intentToDaily)
        }

        binding.btnVeryGood.setOnClickListener {
            val intentToDaily = Intent(this, DailyActivity::class.java)
            startActivity(intentToDaily)
        }

        binding.btnBad.setOnClickListener {
            val intentToDaily = Intent(this, DailyActivity::class.java)
            startActivity(intentToDaily)
        }

        binding.btnVeryBad.setOnClickListener {
            val intentToDaily = Intent(this, DailyActivity::class.java)
            startActivity(intentToDaily)
        }
    }

    private fun setupViewModel() {
        mainViewModel = ViewModelProvider(
            this,
            ViewModelFactory(StatePreference.getInstance(dataStore))
        )[MainViewModel::class.java]
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

//        mainViewModel.logout()
//        val moveToWelcome = Intent(this, WelcomeActivity::class.java)
//        startActivity(moveToWelcome)
//        finish()
        showDialog()

        return super.onOptionsItemSelected(item)
    }

    private fun showDialog() {

        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.custom_dialog_logout)


        val btnOk = dialog.findViewById<Button>(R.id.btn_yes)
        val btnNo = dialog.findViewById<Button>(R.id.btn_no)

        btnOk.setOnClickListener {
            val intent = Intent(this, LaunchScreenActivity::class.java)
            startActivity(intent)
            finish()
            dialog.dismiss()
        }

        btnNo.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()

    }

}
