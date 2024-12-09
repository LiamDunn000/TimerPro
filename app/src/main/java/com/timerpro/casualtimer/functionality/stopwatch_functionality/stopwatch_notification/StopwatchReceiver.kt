package com.timerpro.casualtimer.functionality.stopwatch_functionality.stopwatch_notification

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.timerpro.casualtimer.functionality.stopwatch_functionality.stopwatchCurrentTimeFunctionality
import com.timerpro.casualtimer.functionality.stopwatch_functionality.stopwatchLapTimeFunctionality

class StopwatchReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        when(intent?.action) {
            Action.TOGGLE_STOPWATCH.name -> stopwatchCurrentTimeFunctionality.manageToggleStopwatchButtonOnClickStates(context)
            Action.LAP_AND_RESET_STOPWATCH.name -> stopwatchLapTimeFunctionality.manageLapAndResetButtonOnClickStates(context = context)}}

    // Stopwatch Service Actions
    enum class Action {
        TOGGLE_STOPWATCH,
        LAP_AND_RESET_STOPWATCH, }}