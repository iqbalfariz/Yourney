package com.izo.yourney.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.izo.yourney.data.local.StatePreference
import com.izo.yourney.ui.ViewModelFactory
import com.izo.yourney.ui.dailycheckin.DailyActivity
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

        supportActionBar?.hide()
        bottomNavView = binding.BottomNavigationView

        mainViewModel.getState().observe(this) { state ->
            binding.tvUname.text = state.username
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


}
