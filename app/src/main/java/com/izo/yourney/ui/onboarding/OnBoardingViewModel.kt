package com.izo.yourney.ui.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.izo.yourney.data.local.StatePreference
import kotlinx.coroutines.launch


class OnBoardingViewModel (private val pref: StatePreference) : ViewModel() {

    // simpan data enter
    fun enter() {
        viewModelScope.launch {
            pref.enter()
        }
    }

}