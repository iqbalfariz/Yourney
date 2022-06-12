package com.izo.yourney.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StatePreference private constructor(private val dataStore: DataStore<Preferences>){

    fun getState(): Flow<StateModel> {
        return dataStore.data.map { preferences ->
            StateModel(
                preferences[USERNAME_KEY] ?: "",
                preferences[ENTER_KEY] ?: false,
                preferences[LOGIN_KEY] ?: false
            )
        }
    }

    suspend fun saveUsername(username: String?) {
        dataStore.edit { preferences ->
            preferences[USERNAME_KEY] = username!!
        }
    }

    suspend fun login() {
        dataStore.edit { preferences ->
            preferences[LOGIN_KEY] = true
        }
    }

    suspend fun enter() {
        dataStore.edit { preferences ->
            preferences[ENTER_KEY] = true
        }
    }

    suspend fun logout() {
        dataStore.edit { preferences ->
            preferences[LOGIN_KEY] = false
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: StatePreference? = null

        private val USERNAME_KEY = stringPreferencesKey("username")
        private val ENTER_KEY = booleanPreferencesKey("enter")
        private val LOGIN_KEY = booleanPreferencesKey("login")

        fun getInstance(dataStore: DataStore<Preferences>): StatePreference {
            return INSTANCE ?: synchronized(this) {
                val instance = StatePreference(dataStore)
                INSTANCE = instance
                instance
            }
        }
    }

}