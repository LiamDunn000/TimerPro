package com.timerpro.casualtimer.functionality.timer_functionality.alarm_notification

import android.app.Notification
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.lifecycle.ViewModel
import com.timerpro.casualtimer.data.shared_data.FormattedText
import com.timerpro.casualtimer.R

class AlarmNotification(context: Context): ViewModel(){

    // Timer Notification
    val alarmNotification = NotificationCompat.Builder(context, "casual_timer_channel")
        .setSmallIcon(R.drawable.alarm_clock)
        .setContentTitle("Times Up!")
        .setContentText(FormattedText().formattedNegativeCountDownTimerText)
        .setPriority(Notification.PRIORITY_MAX)

        // Intent That Sends User To Main Activity
        .setContentIntent(AlarmNotificationFunctionality(context).dismissAlarmPendingIntent)

        // Dismiss Alarm Action Button
        .addAction(

            // Dismiss Alarm Action Button Icon
            0,

            // Condition That Determines Toggle Stopwatch Action Button Text
            "Dismiss",

            // Dismiss Alarm Action Button PendingIntent
            AlarmNotificationFunctionality(context).dismissAlarmPendingIntent)

        // Restart Timer Action Button
        .addAction(

            // Restart Timer Action Button Icon
            0,

            // Restart Timer Action Button Text
            "Restart",

            // Restart Timer Action Button PendingIntent
            AlarmNotificationFunctionality(context).restartTimerPendingIntent)
        .build()
}
