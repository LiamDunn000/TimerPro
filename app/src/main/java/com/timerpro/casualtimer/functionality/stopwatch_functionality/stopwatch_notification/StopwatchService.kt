package com.timerpro.casualtimer.functionality.stopwatch_functionality.stopwatch_notification

import android.app.Service
import android.content.Intent
import android.os.IBinder

class StopwatchService: Service() {

    override fun onBind(intent: Intent?): IBinder? {
        return null}

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        when(intent?.action) {
            State.START_STOPWATCH.name -> startStopwatchService()
            State.STOP_STOPWATCH.name -> stopSelf()}

        return super.onStartCommand(intent, flags, startId)}

    // Start Stopwatch Service
    private fun startStopwatchService() {

        startForeground(1, StopwatchNotification(this@StopwatchService).stopwatchNotification)}

    // Stopwatch Service States
    enum class State {
        START_STOPWATCH,
        STOP_STOPWATCH}}