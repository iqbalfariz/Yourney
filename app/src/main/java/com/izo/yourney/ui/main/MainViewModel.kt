package com.izo.yourney.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.izo.yourney.data.local.StatePreference
import kotlinx.coroutines.launch

class MainViewModel (private val pref: StatePreference) : ViewModel() {

    // hapus state login dan enter
    fun logout() {
        viewModelScope.launch {
            pref.logout()
        }
    }

}