package com.timerpro.casualtimer.functionality.timer_functionality

import android.content.Context
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.timerpro.casualtimer.data.timer_data.storage.alarm_sound_storage.AlarmSoundStorage
import com.timerpro.casualtimer.data.timer_data.storage.alarm_sound_storage.alarmSoundStorage
import com.timerpro.casualtimer.data.timer_data.timer_states.AlarmSound
import com.timerpro.casualtimer.data.timer_data.timer_states.TimerStates
import com.timerpro.casualtimer.data.timer_data.timer_states.alarmPlayer
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates
import com.timerpro.casualtimer.functionality.general_functionality.generalFunctionality
import com.timerpro.casualtimer.functionality.general_functionality.permissionFunctionality
import com.timerpro.casualtimer.functionality.timer_functionality.alarm_notification.AlarmNotificationFunctionality
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

val alarmStateFunctionality = AlarmStateFunctionality()

class AlarmStateFunctionality(private val t: TimerStates = timerStates, private val a: AlarmSoundStorage = alarmSoundStorage): ViewModel() {

    fun playAlarm(context: Context, mediaPlayer: MediaPlayer) {

        // Conditional That Plays Alarm When Time Is Up
        when { t.isTimeUp -> {
            try {

                val deserializedAlarmSound = a.gson.fromJson(alarmSoundStorage.alarmSoundFile.readText(), AlarmSound::class.java)

                // Reset Media Player
                mediaPlayer.reset()

                // Set Alarm Sound To Digital If No Alarm Sound Is Selected
                mediaPlayer.setDataSource(context, if (a.alarmSoundFile.readText() == "") t.digitalAlarmClockSoundEffectUri.toUri() else deserializedAlarmSound.path.toUri())

                // Prepare & Start Alarm
                mediaPlayer.prepare(); mediaPlayer.start()

                // Loop Alarm
                mediaPlayer.isLooping = true

                // Start Alarm Service
                AlarmNotificationFunctionality(context).startAlarmService(context)

            } catch (e: Exception) { generalFunctionality.showToast(context = context, message = "Audio Permission Denied") }
        }}}

    fun dismissAlarm(context: Context, alarmPlayer: MediaPlayer) {

        generalFunctionality.vibrateOnButtonClick(context = context)

        // Stop Alarm
        alarmPlayer.stop()

        returnToTimeSelectionScreen(boolean = false)

        // Stop Alarm Service
        AlarmNotificationFunctionality(context).stopAlarmService(context) }

    fun saveAlarmSound(context: Context) {

        try {
            val serializedAlarmSound = a.gson.toJson(t.selectedAlarmSound)
            a.alarmSoundFile.writeText(serializedAlarmSound)
            generalFunctionality.showToast(context = context, message = "Alarm Sound Saved")
        } catch (e: Exception) { generalFunctionality.showToast(context = context, message = "Alarm Sound Not Saved") }

        t.isAlarmSoundSelectionDialogOpen = false

        if (alarmPlayer.samplePlayer.isPlaying) {
            alarmPlayer.samplePlayer.stop()}
    }

    fun openAlarmSoundSelectionDialog(context: Context) {

        timerStates.areChangesMadeToAlarmSound = false

        // Request Permissions
        permissionFunctionality.manageAudioFilePermissionRequests(context = context)

        // Open Alarm Sound Selection Dialog
        t.isAlarmSoundSelectionDialogOpen = true

        // Load Alarm Sound
        t.selectedAlarmSound = if (a.alarmSoundFile.readText() == "") {
            AlarmSound(path = "android.resource://com.timerpro.casualtimer/raw/digital_alarm_clock_sound_effect", name = "Digital")
        } else {
            a.gson.fromJson(a.alarmSoundFile.readText(), AlarmSound::class.java)
        }

        // Query Alarm Sounds If Permission Granted
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU && ContextCompat.checkSelfPermission(context, android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
        {alarmStateFunctionality.queryAlarmSoundsFromStorage(context = context)}

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            queryAlarmSoundsFromStorage(context = context) }
    }

    fun closeAlarmSoundSelectionDialog() {
        timerStates.isAlarmSoundSelectionDialogOpen = false
        timerStates.areChangesMadeToAlarmSound = false
        alarmPlayer.samplePlayer.stop()
    }

    fun playAlarmSample(context: Context, mediaPlayer: MediaPlayer, path: String) {

        try {
            mediaPlayer.stop(); mediaPlayer.reset()
            mediaPlayer.setDataSource(context, Uri.parse(path))
            mediaPlayer.prepare()
            mediaPlayer.start()
        } catch (e: Exception) {
            generalFunctionality.showToast(context = context, message = "Audio Permission Denied") }
    }

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

    private fun queryAlarmSoundsFromStorage(context: Context) {

        val projection = arrayOf(
            MediaStore.Audio.Media._ID,
            MediaStore.Audio.Media.DATA,
            MediaStore.Audio.Media.DISPLAY_NAME
        )

        context.contentResolver.query(
            MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
            projection,
            null,
            null,
            null
        )?.use { cursor ->
            val idColumn = cursor.getColumnIndex(MediaStore.Audio.Media._ID)
            val pathColumn = cursor.getColumnIndex(MediaStore.Audio.Media.DATA)
            val nameColumn = cursor.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME)

            while (cursor.moveToNext()) {
                val id = cursor.getLong(idColumn)
                val path = cursor.getString(pathColumn)
                val name = cursor.getString(nameColumn)
                timerStates.alarmSounds += (AlarmSound(id, path?:"", name?:"")) }}}



}