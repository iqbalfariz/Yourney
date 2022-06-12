package com.izo.yourney.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.izo.yourney.data.local.StateModel
import com.izo.yourney.data.local.StatePreference
import kotlinx.coroutines.launch

class MainViewModel (val pref: StatePreference) : ViewModel() {

    // hapus state login dan enter
    fun logout() {
        viewModelScope.launch {
            pref.logout()
        }
    }

    // ambil data user
    fun getState(): LiveData<StateModel> {
        return pref.getState().asLiveData()
    }



}