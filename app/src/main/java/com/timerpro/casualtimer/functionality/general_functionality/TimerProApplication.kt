package com.timerpro.casualtimer.functionality.general_functionality

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.room.Room
import com.timerpro.casualtimer.data.timer_data.storage.alarm_sound_storage.AlarmSoundStorage
import com.timerpro.casualtimer.data.timer_data.timer_states.AlarmPlayer
import com.timerpro.timertest.data.PresetTimeDatabase

class TimerProApplication: Application() {

        override fun onCreate() {
            super.onCreate()

            // Timer Pro Notification Channel
            val timerProNotificationChannel = NotificationChannel(
                "casual_timer_channel",
                "Casual Timer Notification",
                NotificationManager.IMPORTANCE_LOW)

            // Timer Pro Notification Manager
            val timerProNotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            timerProNotificationManager.createNotificationChannel(timerProNotificationChannel)

            // Global Instance Of Preset Time Database
            PresetTimeDatabase.instance = Room.databaseBuilder(
                this@TimerProApplication,
                PresetTimeDatabase::class.java,
                "note_database").build()

            // Global Instance Of Alarm Sound Storage
            AlarmSoundStorage.instance = AlarmSoundStorage(context = applicationContext)

            // Global Instance Of Alarm Player
            AlarmPlayer.instance = AlarmPlayer()
        }
}
