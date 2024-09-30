package com.timerpro.casualtimer.functionality.timer_functionality.timer_notification

import android.app.Service
import android.content.Intent
import android.os.IBinder

class TimerService: Service() {

    override fun onBind(intent: Intent?): IBinder? {
        return null}

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        when(intent?.action) {
            State.START_TIMER.name -> startTimerService()
            State.STOP_TIMER.name -> stopSelf()}

        return super.onStartCommand(intent, flags, startId)}

    // Start Stopwatch Service
    private fun startTimerService() {

        startForeground(2, TimerNotification(this@TimerService).timerNotification) }

    // Stopwatch Service States
    enum class State {
        START_TIMER,
        STOP_TIMER}}
