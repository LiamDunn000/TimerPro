package com.timerpro.casualtimer.functionality.timer_functionality.alarm_notification

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.timerpro.casualtimer.data.timer_data.timer_states.alarmPlayer
import com.timerpro.casualtimer.functionality.timer_functionality.alarmStateFunctionality
import com.timerpro.casualtimer.functionality.timer_functionality.timerStateFunctionality

class AlarmReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        when(intent?.action) {
            Action.DISMISS_ALARM.name -> alarmStateFunctionality.dismissAlarm(context, alarmPlayer.alarmPlayer)
            Action.RESTART_TIMER.name -> timerStateFunctionality.restartTimer(context, alarmPlayer.alarmPlayer) }}

    // Stopwatch Service Actions
    enum class Action {

        DISMISS_ALARM,
        RESTART_TIMER}}