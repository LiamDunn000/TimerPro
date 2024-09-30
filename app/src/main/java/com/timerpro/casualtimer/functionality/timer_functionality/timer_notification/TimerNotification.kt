package com.timerpro.casualtimer.functionality.timer_functionality.timer_notification

import android.app.Notification
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.lifecycle.ViewModel
import com.timerpro.casualtimer.data.shared_data.FormattedText
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates
import com.timerpro.casualtimer.R

class TimerNotification(context: Context): ViewModel(){

    // Timer Notification
    val timerNotification = NotificationCompat.Builder(context, "casual_timer_channel")
        .setSmallIcon(R.drawable.alarm_clock)
        .setContentTitle("Timer")
        .setContentText(FormattedText().formattedCountDownTimerText)
        .setPriority(Notification.PRIORITY_HIGH)
        .setSubText(

            // Condition That Determines Timer Notification Sub Text
            when {timerStates.isToggleTimerActionButtonPressed -> "Paused" else -> ""})

        // Intent That Sends User To Main Activity
        .setContentIntent(TimerNotificationFunctionality(context).timerDeepLinkPendingIntent)

        // Toggle Timer Action Button
        .addAction(

            // Toggle Timer Action Button Icon
            0,

            // Condition That Determines Toggle Stopwatch Action Button Text
            when { timerStates.isTimerActive -> "Pause" else -> "Resume"},

            // Toggle Stopwatch Action Button PendingIntent
            TimerNotificationFunctionality(context).toggleTimerPendingIntent)

        // Cancel Timer Action Button
        .addAction(

            // Cancel Timer Action Button Icon
            0,

            // Cancel Timer Action Button Text
            "Cancel",

            // Cancel Timer Action Button PendingIntent
            TimerNotificationFunctionality(context).cancelTimerPendingIntent)
        .build()
}
