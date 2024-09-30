package com.timerpro.casualtimer.data.timer_data.timer_states

import android.media.AudioManager
import android.media.MediaPlayer

// Alarm Player Instance
val alarmPlayer: AlarmPlayer by lazy { AlarmPlayer.instance }

class AlarmPlayer() {

    // Alarm Player
    val alarmPlayer = MediaPlayer()

    // Alarm Player Attributes
    init {
        alarmPlayer.setAudioStreamType(AudioManager.STREAM_ALARM)}

    // Alarm Player Instance
    companion object {
        lateinit var instance: AlarmPlayer
    }

}