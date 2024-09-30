package com.timerpro.casualtimer.functionality.timer_functionality.alarm_notification

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModel
import com.timerpro.casualtimer.data.casual_timer_screen_data.casual_timer_screen_states.casualTimerScreenStates

class AlarmNotificationFunctionality(context: Context): ViewModel() {

    /* ALARM SERVICE INTENTS
        ------------------------------------------------------------------------------------------*/
    // Initiate Intent
    private fun initiateAlarmIntent(context: Context, action: String) {
        Intent(context, AlarmService::class.java).also {
            it.action = action
            context.startService(it)}}

    // Start Stopwatch Service
    fun startAlarmService(context: Context) {
        initiateAlarmIntent(
            context = context,
            AlarmService.State.START_NEGATIVE_TIMER.name)}

    // Stop Stopwatch Service
    fun stopAlarmService(context: Context) {
        initiateAlarmIntent(
            context = context,
            AlarmService.State.STOP_NEGATIVE_TIMER.name)}
    //----------------------------------------------------------------------------------------------

    /* ALARM NOTIFICATION INTENTS & ACTION BUTTON INTENTS
    ----------------------------------------------------------------------------------------------*/
    // Timer Deep Link Intent & Pending Intent
    val timerDeepLinkIntent = Intent(Intent.ACTION_MAIN, Uri.parse(casualTimerScreenStates.fullTimeSelectionScreenDeepLinkUri))
    val timerDeepLinkPendingIntent: PendingIntent = PendingIntent.getActivity(context, 0, timerDeepLinkIntent, PendingIntent.FLAG_IMMUTABLE)

    // Toggle Timer Intent & Pending Intent
    private val dismissAlarmIntent = Intent(context, AlarmReceiver::class.java).apply { action = AlarmReceiver.Action.DISMISS_ALARM.name }
    val dismissAlarmPendingIntent: PendingIntent = PendingIntent.getBroadcast(context, 0, dismissAlarmIntent, PendingIntent.FLAG_IMMUTABLE)

    // Cancel Timer Intent & Pending Intent
    private val restartTimerIntent = Intent(context, AlarmReceiver::class.java).apply { action = AlarmReceiver.Action.RESTART_TIMER.name }
    val restartTimerPendingIntent: PendingIntent = PendingIntent.getBroadcast(context, 0, restartTimerIntent, PendingIntent.FLAG_IMMUTABLE)
    //----------------------------------------------------------------------------------------------
}