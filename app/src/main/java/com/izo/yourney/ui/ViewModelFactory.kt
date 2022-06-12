package com.izo.yourney.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.izo.yourney.data.local.StatePreference
import com.izo.yourney.ui.login.LoginViewModel
import com.izo.yourney.ui.main.MainViewModel
import com.izo.yourney.ui.onboarding.OnBoardingViewModel
import com.izo.yourney.ui.persona.AboutThreeViewModel
import com.izo.yourney.ui.splashscreen.SplashScreenViewModel

class ViewModelFactory(private val pref: StatePreference) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(SplashScreenViewModel::class.java) -> {
                SplashScreenViewModel(pref) as T
            }
            modelClass.isAssignableFrom(OnBoardingViewModel::class.java) -> {
                OnBoardingViewModel(pref) as T
            }
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
                LoginViewModel(pref) as T
            }
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(pref) as T
            }
            modelClass.isAssignableFrom(AboutThreeViewModel::class.java) -> {
                AboutThreeViewModel(pref) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
}