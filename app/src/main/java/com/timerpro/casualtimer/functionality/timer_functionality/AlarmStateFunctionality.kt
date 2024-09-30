package com.timerpro.casualtimer.functionality.timer_functionality

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import androidx.core.net.toUri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.timerpro.casualtimer.data.casual_timer_screen_data.casual_timer_datastore.CasualTimerDatastore
import com.timerpro.casualtimer.data.timer_data.timer_states.alarmPlayer
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates
import com.timerpro.casualtimer.functionality.casual_timer_screen_functionality.casualTimerScreenFunctionality
import com.timerpro.casualtimer.functionality.timer_functionality.alarm_notification.AlarmNotificationFunctionality
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

val alarmStateFunctionality = AlarmStateFunctionality()

class AlarmStateFunctionality: ViewModel() {

    // Play Alarm
    fun playAlarm(context: Context, mediaPlayer: MediaPlayer) {

        // Conditional That Plays Alarm When Time Is Up
        when { timerStates.isTimeUp -> {
            mediaPlayer.prepare();mediaPlayer.start()
        AlarmNotificationFunctionality(context).startAlarmService(context)}}}

    // Dismiss Alarm
    fun dismissAlarm(context: Context, mediaPlayer: MediaPlayer) {

        // Vibrate On Button Click
        casualTimerScreenFunctionality.vibrateOnButtonClick(context = context)

        // Stop Alarm
        mediaPlayer.stop()

        // Return To Time Selection Screen
        returnToTimeSelectionScreen(boolean = false)

        // Stop Alarm Service
        AlarmNotificationFunctionality(context).stopAlarmService(context) }

    // Update Alarm Sound Uri
    private fun updateAlarmSoundUri(context: Context, uri: Uri){
        alarmPlayer.alarmPlayer.apply {
            reset()
            setDataSource(context, uri)
            isLooping = true }}

    // Determine Alarm Sound
    fun determineAlarmSound(context: Context, alarmSound: String) {

        // Conditional That Determines Alarm Sound
        when (alarmSound) {

            // Changes Alarm To Digital
            timerStates.alarmSoundNames[0] -> updateAlarmSoundUri(context, timerStates.digitalAlarmClockSoundEffectUri.toUri())

            // Changes Alarm To Vintage
            timerStates.alarmSoundNames[1] -> updateAlarmSoundUri(context, timerStates.vintageAlarmClockSoundEffectUri.toUri())

            // Changes Alarm To Classic
            timerStates.alarmSoundNames[2] -> updateAlarmSoundUri(context, timerStates.classicAlarmClockSoundEffectUri.toUri())

            // Changes Alarm To School
            timerStates.alarmSoundNames[3] -> updateAlarmSoundUri(context, timerStates.schoolBellSoundEffectUri.toUri())

            // Changes Alarm To Jingle
            timerStates.alarmSoundNames[4] -> updateAlarmSoundUri(context, timerStates.jingleBellsSoundEffectUri.toUri())}}

    // Save Alarm Sound
    fun saveAlarmSound(casualTimerDatastore: CasualTimerDatastore){
        viewModelScope.launch {
            casualTimerDatastore.saveAlarmSound(casualTimerDatastore.alarmSoundKey, timerStates.selectedAlarmSoundName) }}

    // Load Alarm Sound
    fun loadAlarmSound(alarmSound: String){
        timerStates.selectedAlarmSoundName = alarmSound }

    // Return To Time Selection Screen
    fun returnToTimeSelectionScreen(boolean: Boolean) {

        viewModelScope.launch {

            // Return To Time Selection Screen
            timerStates.isTimerScreenVisible = boolean
            timerStates.isTimeUp = false

            // Delay Between Dismiss Alarm & Reset Negative Timer
            delay(50)

            // Reset Negative Timer
            timerStates.secondsSinceTimerEnded = 0
            timerStates.minutesSinceTimerEnded = 0
            timerStates.hoursSinceTimerEnded = 0}}



}