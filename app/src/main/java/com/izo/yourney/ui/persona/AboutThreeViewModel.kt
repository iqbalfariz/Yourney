package com.izo.yourney.ui.persona

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.izo.yourney.data.local.StatePreference
import kotlinx.coroutines.launch

class AboutThreeViewModel(private val pref: StatePreference) : ViewModel() {

    // simpan username
    fun saveUsername(username: String?) {
        viewModelScope.launch {
            pref.saveUsername(username)
        }
    }

}