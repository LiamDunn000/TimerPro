package com.timerpro.casualtimer.functionality.timer_functionality.timer_notification

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModel
import com.timerpro.casualtimer.data.casual_timer_screen_data.casual_timer_screen_states.casualTimerScreenStates

class TimerNotificationFunctionality(context: Context): ViewModel() {

    /* STOPWATCH SERVICE INTENTS
        ------------------------------------------------------------------------------------------*/
    // Initiate Intent
    private fun initiateTimerIntent(context: Context, action: String) {
        Intent(context, TimerService::class.java).also {
            it.action = action
            context.startService(it)}}

    // Start Stopwatch Service
    fun startTimerService(context: Context) {
        initiateTimerIntent(
            context = context,
            TimerService.State.START_TIMER.name)}

    // Stop Stopwatch Service
    fun stopTimerService(context: Context) {
        initiateTimerIntent(
            context = context,
            TimerService.State.STOP_TIMER.name)}
    //----------------------------------------------------------------------------------------------

    /* STOPWATCH NOTIFICATION INTENTS & ACTION BUTTON INTENTS
    ----------------------------------------------------------------------------------------------*/
    // Timer Deep Link Intent & Pending Intent
    val timerDeepLinkIntent = Intent(Intent.ACTION_MAIN, Uri.parse(casualTimerScreenStates.fullTimeSelectionScreenDeepLinkUri))
    val timerDeepLinkPendingIntent: PendingIntent = PendingIntent.getActivity(context, 0, timerDeepLinkIntent, PendingIntent.FLAG_IMMUTABLE)

    // Toggle Timer Intent & Pending Intent
    private val toggleTimerIntent = Intent(context, TimerReceiver::class.java).apply { action = TimerReceiver.Action.TOGGLE_TIMER.name }
    val toggleTimerPendingIntent: PendingIntent = PendingIntent.getBroadcast(context, 0, toggleTimerIntent, PendingIntent.FLAG_IMMUTABLE)

    // Cancel Timer Intent & Pending Intent
    private val cancelTimerIntent = Intent(context, TimerReceiver::class.java).apply { action = TimerReceiver.Action.CANCEL_TIMER.name }
    val cancelTimerPendingIntent: PendingIntent = PendingIntent.getBroadcast(context, 0, cancelTimerIntent, PendingIntent.FLAG_IMMUTABLE)
    //----------------------------------------------------------------------------------------------
}