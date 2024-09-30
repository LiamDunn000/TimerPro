package com.timerpro.casualtimer.functionality.casual_timer_screen_functionality

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.room.Room
import com.timerpro.casualtimer.data.timer_data.timer_states.AlarmPlayer
import com.timerpro.timertest.data.PresetTimeDatabase

class CasualTimerApplication: Application() {

        override fun onCreate() {
            super.onCreate()

            // Casual Timer Notification Channel
            val casualTimerNotificationChannel = NotificationChannel(
                "casual_timer_channel",
                "Casual Timer Notification",
                NotificationManager.IMPORTANCE_LOW)

            // Casual Timer Notification Manager
            val casualTimerNotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            casualTimerNotificationManager.createNotificationChannel(casualTimerNotificationChannel)

            // Preset Time Database Instance
            PresetTimeDatabase.instance = Room.databaseBuilder(
                this@CasualTimerApplication,
                PresetTimeDatabase::class.java,
                "note_database").build()

            // Alarm Player Instance
            AlarmPlayer.instance = AlarmPlayer()
        }
}
