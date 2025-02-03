package com.timerpro.casualtimer.data.timer_data.storage.alarm_sound_storage

import android.content.Context
import com.google.gson.Gson
import java.io.File

val alarmSoundStorage by lazy { AlarmSoundStorage.instance }

class AlarmSoundStorage(context: Context) {

    var alarmSoundDirectory = File(context.filesDir, "Alarm Sound Directory")
    var alarmSoundFile = File(alarmSoundDirectory, "Alarm Sound File")

    val gson = Gson()

    companion object {
        lateinit var instance: AlarmSoundStorage
    }

}