package com.timerpro.casualtimer.data.casual_timer_screen_data.casual_timer_datastore

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore("Casual Timer Datastore")

class CasualTimerDatastore(private val context: Context) {

    // Alarm Sound Key
    val alarmSoundKey = stringPreferencesKey("Alarm Sound Key")

    // Load Alarm Sound
    fun loadAlarmSound(key: Preferences.Key<String>): Flow<String> = context.dataStore.data.map { preferences ->
        preferences[key] ?: timerStates.alarmSoundNames[0] }

    // Save Alarm Sound
    suspend fun saveAlarmSound(key: Preferences.Key<String>, data: String) {
        context.dataStore.edit { preferences ->
            preferences[key] = data }}

}