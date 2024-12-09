package com.timerpro.casualtimer.functionality.timer_functionality

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import androidx.core.net.toUri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.timerpro.casualtimer.data.casual_timer_screen_data.casual_timer_datastore.CasualTimerDatastore
import com.timerpro.casualtimer.data.timer_data.timer_states.TimerStates
import com.timerpro.casualtimer.data.timer_data.timer_states.alarmPlayer
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates
import com.timerpro.casualtimer.functionality.general_functionality.generalFunctionality
import com.timerpro.casualtimer.functionality.timer_functionality.alarm_notification.AlarmNotificationFunctionality
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

val alarmStateFunctionality = AlarmStateFunctionality()

class AlarmStateFunctionality(val t: TimerStates = timerStates): ViewModel() {

    fun playAlarm(context: Context, mediaPlayer: MediaPlayer) {

        // Conditional That Plays Alarm When Time Is Up
        when { t.isTimeUp -> {
            mediaPlayer.prepare();mediaPlayer.start()
        AlarmNotificationFunctionality(context).startAlarmService(context)}}}

    fun dismissAlarm(context: Context, alarmPlayer: MediaPlayer) {

        generalFunctionality.vibrateOnButtonClick(context = context)

        // Stop Alarm
        alarmPlayer.stop()

        returnToTimeSelectionScreen(boolean = false)

        // Stop Alarm Service
        AlarmNotificationFunctionality(context).stopAlarmService(context) }

    private fun updateAlarmSoundUri(context: Context, uri: Uri){
        alarmPlayer.alarmPlayer.apply {
            reset()
            setDataSource(context, uri)
            isLooping = true }}

    fun determineAlarmSound(context: Context, alarmSound: String) {

        // Conditional That Determines Alarm Sound
        when (alarmSound) {

            // Digital
            t.alarmSoundNames[0] -> updateAlarmSoundUri(context, t.digitalAlarmClockSoundEffectUri.toUri())

            // Vintage
            t.alarmSoundNames[1] -> updateAlarmSoundUri(context, t.vintageAlarmClockSoundEffectUri.toUri())

            // Classic
            t.alarmSoundNames[2] -> updateAlarmSoundUri(context, t.classicAlarmClockSoundEffectUri.toUri())

            // School
            t.alarmSoundNames[3] -> updateAlarmSoundUri(context, t.schoolBellSoundEffectUri.toUri())

            // Jingle
            t.alarmSoundNames[4] -> updateAlarmSoundUri(context, t.jingleBellsSoundEffectUri.toUri())}}

    fun saveAlarmSound(casualTimerDatastore: CasualTimerDatastore){
        viewModelScope.launch {
            casualTimerDatastore.saveAlarmSound(casualTimerDatastore.alarmSoundKey, t.selectedAlarmSoundName) }}

    fun loadAlarmSound(alarmSound: String){
        t.selectedAlarmSoundName = alarmSound }

    fun returnToTimeSelectionScreen(boolean: Boolean) {

        viewModelScope.launch {

            // Return To Time Selection Screen
            t.isTimerScreenVisible = boolean
            t.isTimeUp = false

            // Delay Between Dismiss Alarm & Reset Negative Timer
            delay(50)

            // Reset Negative Timer
            t.secondsSinceTimerEnded = 0
            t.minutesSinceTimerEnded = 0
            t.hoursSinceTimerEnded = 0}}



}