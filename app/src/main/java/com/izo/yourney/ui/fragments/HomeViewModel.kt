package com.izo.yourney.ui.fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.izo.yourney.data.local.StatePreference
import kotlinx.coroutines.launch

class HomeViewModel (private val pref: StatePreference) : ViewModel() {

    // hapus state login dan enter
    fun logout() {
        viewModelScope.launch {
            pref.logout()
        }
    }

}