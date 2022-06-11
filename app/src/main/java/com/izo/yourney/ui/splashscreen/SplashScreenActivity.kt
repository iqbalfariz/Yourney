package com.izo.yourney.ui.splashscreen

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowInsets
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.izo.yourney.R
import com.izo.yourney.data.local.StatePreference
import com.izo.yourney.ui.MainActivity
import com.izo.yourney.ui.ViewModelFactory
import com.izo.yourney.ui.launchscreen.LaunchScreenActivity
import com.izo.yourney.ui.onboarding.OnBoardingActivity
import com.izo.yourney.ui.onboarding.OnBoardingViewModel

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var splashScreenViewModel: SplashScreenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_splash_screen)

        setupViewModel()
        setUpView()
        val handler = Handler()
        handler.postDelayed({
            splashScreenViewModel.getState().observe(this) {state ->
                if (state.isEnter && state.isLogin) {
                    startActivity(Intent(applicationContext, MainActivity::class.java))
                    finish()
                } else if (state.isEnter) {
                    startActivity(Intent(applicationContext, LaunchScreenActivity::class.java))
                    finish()
                } else {
                    startActivity(Intent(applicationContext, OnBoardingActivity::class.java))
                    finish()
                }
//                if (state.isLogin) {
//                    startActivity(Intent(applicationContext, MainActivity::class.java))
//                    finish()
//                } else {
//                    startActivity(Intent(applicationContext, OnBoardingActivity::class.java))
//                    finish()
//                }
            }
        }, 3000L) //3000 L = 3 detik
    }

    private fun setupViewModel() {
        splashScreenViewModel = ViewModelProvider(
            this,
            ViewModelFactory(StatePreference.getInstance(dataStore))
        )[SplashScreenViewModel::class.java]
    }

    private fun setUpView() {
            @Suppress("DEPRECATION")
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                window.insetsController?.hide(WindowInsets.Type.statusBars())
            } else {
                window.setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN
                )
            }
            supportActionBar?.hide()
    }
}