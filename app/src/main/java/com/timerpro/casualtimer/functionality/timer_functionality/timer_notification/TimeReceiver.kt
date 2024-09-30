package com.timerpro.casualtimer.functionality.timer_functionality.timer_notification

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.timerpro.casualtimer.functionality.timer_functionality.timerStateFunctionality

class TimerReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        when(intent?.action) {
            Action.TOGGLE_TIMER.name -> timerStateFunctionality.toggleTimer(context)
            Action.CANCEL_TIMER.name -> timerStateFunctionality.cancelTimer(context) }}

    // Stopwatch Service Actions
    enum class Action {

        TOGGLE_TIMER,
        CANCEL_TIMER}}