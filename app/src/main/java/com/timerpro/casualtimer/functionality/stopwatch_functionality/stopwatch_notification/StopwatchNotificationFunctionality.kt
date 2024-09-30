package com.timerpro.casualtimer.functionality.stopwatch_functionality.stopwatch_notification

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModel
import com.timerpro.casualtimer.data.casual_timer_screen_data.casual_timer_screen_states.casualTimerScreenStates

class StopwatchNotificationFunctionality(context: Context): ViewModel() {

    /* STOPWATCH SERVICE INTENTS
    ----------------------------------------------------------------------------------------------*/
    // Initiate Intent
    private fun initiateStopwatchIntent(context: Context, action: String) {
        Intent(context, StopwatchService::class.java).also {
            it.action = action
            context.startService(it)}}

    // Start Stopwatch Service
    fun startStopwatchService(context: Context) {
        initiateStopwatchIntent(
            context = context,
            StopwatchService.State.START_STOPWATCH.name)}

    // Stop Stopwatch Service
    fun stopStopwatchService(context: Context) {
        initiateStopwatchIntent(
            context = context,
            StopwatchService.State.STOP_STOPWATCH.name)}
    //----------------------------------------------------------------------------------------------

    /* STOPWATCH NOTIFICATION INTENTS & ACTION BUTTON INTENTS
    ----------------------------------------------------------------------------------------------*/
    // Stopwatch Deep Link Intent & Pending Intent
    val stopwatchDeepLinkIntent = Intent(Intent.ACTION_MAIN, Uri.parse(casualTimerScreenStates.fullStopwatchScreenDeepLinkUri))
    val stopwatchDeepLinkPendingIntent: PendingIntent = PendingIntent.getActivity(context, 0, stopwatchDeepLinkIntent, PendingIntent.FLAG_IMMUTABLE)

    // Toggle Timer Intent & Pending Intent
    private val toggleStopwatchIntent = Intent(context, StopwatchReceiver::class.java).apply { action = StopwatchReceiver.Action.TOGGLE_STOPWATCH.name }
    val toggleStopwatchPendingIntent: PendingIntent = PendingIntent.getBroadcast(context, 0, toggleStopwatchIntent, PendingIntent.FLAG_IMMUTABLE)

    // Lap Timer Intent & Pending Intent
    private val lapAndResetStopwatchIntent = Intent(context, StopwatchReceiver::class.java).apply { action = StopwatchReceiver.Action.LAP_AND_RESET_STOPWATCH.name }
    val lapAndResetStopwatchPendingIntent: PendingIntent = PendingIntent.getBroadcast(context, 0, lapAndResetStopwatchIntent, PendingIntent.FLAG_IMMUTABLE)

    //----------------------------------------------------------------------------------------------
}