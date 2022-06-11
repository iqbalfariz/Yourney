package com.izo.yourney.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.izo.yourney.data.local.StatePreference
import kotlinx.coroutines.launch

class LoginViewModel(private val pref: StatePreference) : ViewModel() {

    // simpan state login
    fun login() {
        viewModelScope.launch {
            pref.login()
        }
    }

}