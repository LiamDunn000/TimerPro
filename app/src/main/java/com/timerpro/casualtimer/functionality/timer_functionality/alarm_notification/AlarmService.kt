package com.timerpro.casualtimer.functionality.timer_functionality.alarm_notification

import android.app.Service
import android.content.Intent
import android.os.IBinder

class AlarmService(): Service() {

    override fun onBind(intent: Intent?): IBinder? {
        return null}

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        when(intent?.action) {
            State.START_NEGATIVE_TIMER.name -> startAlarmService()
            State.STOP_NEGATIVE_TIMER.name -> stopSelf()}

        return super.onStartCommand(intent, flags, startId)}

    // Start Stopwatch Service
    private fun startAlarmService() {

        startForeground(3, AlarmNotification(this@AlarmService).alarmNotification) }

    // Stopwatch Service States
    enum class State {
        START_NEGATIVE_TIMER,
        STOP_NEGATIVE_TIMER}}
