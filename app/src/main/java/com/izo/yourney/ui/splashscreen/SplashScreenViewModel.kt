package com.izo.yourney.ui.splashscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.izo.yourney.data.local.StateModel
import com.izo.yourney.data.local.StatePreference

class SplashScreenViewModel (private val pref: StatePreference) : ViewModel() {

    // ambil data user
    fun getState(): LiveData<StateModel> {
        return pref.getState().asLiveData()
    }

}