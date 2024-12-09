package com.timerpro.casualtimer.functionality.stopwatch_functionality.stopwatch_notification

import android.app.Notification
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.lifecycle.ViewModel
import com.timerpro.casualtimer.data.stopwatch_data.stopwatch_states.stopwatchStates
import com.timerpro.casualtimer.data.shared_data.FormattedText
import com.timerpro.casualtimer.R
import com.timerpro.casualtimer.data.stopwatch_data.stopwatch_states.StopwatchStates

class StopwatchNotification(context: Context, s: StopwatchStates = stopwatchStates): ViewModel(){

    // Stopwatch Notification
    val stopwatchNotification = NotificationCompat.Builder(context, "casual_timer_channel")
        .setSmallIcon(R.drawable.stopwatch)
        .setContentTitle("Stopwatch")
        .setContentText(FormattedText().formattedCurrentStopwatchTimeText)
        .setPriority(Notification.PRIORITY_DEFAULT)
        .setSubText(

            // Condition That Determines Stopwatch Notification Sub Text
            when {

                // Changes Sub Text To "Paused"
                !s.isStopwatchActive -> {"Paused"}

                // Changes Sub Text To Formatted Lap Number
                s.laps.isNotEmpty() -> {"Lap ${FormattedText().formattedLapNumberText}"}

                // Changes Sub Text To An Empty String
                else -> ""})

        // Intent That Sends User To Main Activity
        .setContentIntent(StopwatchNotificationFunctionality(context).stopwatchDeepLinkPendingIntent)

        // Toggle Stopwatch Action Button
        .addAction(

            // Toggle Stopwatch Action Button Icon
            0,

            // Condition That Determines Toggle Stopwatch Action Button Text
            when {s.isStopwatchActive -> "Pause" else -> "Resume" },

            // Toggle Stopwatch Action Button PendingIntent
            StopwatchNotificationFunctionality(context).toggleStopwatchPendingIntent)

        // Lap And Reset Stopwatch Action Button
        .addAction(

            // Lap And Reset Stopwatch Action Button Icon
            0,

            // Condition That Determines Lap And Reset Stopwatch Action Button Text
            when {!s.isStopwatchActive && s.isStopwatchServiceActive || s.laps.size == 99 -> "Reset" else -> "Lap" },

            // Lap And Reset Stopwatch Action Button PendingIntent
            StopwatchNotificationFunctionality(context).lapAndResetStopwatchPendingIntent)
        .build()
}
