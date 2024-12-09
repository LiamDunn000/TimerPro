package com.timerpro.casualtimer.functionality.stopwatch_functionality

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.timerpro.casualtimer.data.stopwatch_data.stopwatch_states.StopwatchStates
import com.timerpro.casualtimer.data.stopwatch_data.stopwatch_states.stopwatchStates
import com.timerpro.casualtimer.functionality.general_functionality.generalFunctionality
import com.timerpro.casualtimer.functionality.stopwatch_functionality.stopwatch_notification.StopwatchNotificationFunctionality
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// Global Instance Of Stopwatch Current Time Functionality
val stopwatchCurrentTimeFunctionality = StopwatchCurrentTimeFunctionality()

class StopwatchCurrentTimeFunctionality(private val s: StopwatchStates = stopwatchStates): ViewModel() {

    /* MANAGE TOGGLE STOPWATCH BUTTON ON TAP STOPWATCH STATE
    ----------------------------------------------------------------------------------------------*/
    fun manageToggleStopwatchButtonOnClickStates(context: Context) {

        generalFunctionality.vibrateOnButtonClick(context = context)

        toggleStopwatch(context = context)

        // Conditional That Toggles Lap Stopwatch
        if (s.isLapStopwatchVisible) stopwatchLapTimeFunctionality.toggleLapStopwatch()
    }
    //----------------------------------------------------------------------------------------------

    /* MANAGE CURRENT STOPWATCH STATE
    ----------------------------------------------------------------------------------------------*/
    // Toggle Stopwatch
    private fun toggleStopwatch(context: Context) {

        // Toggle Stopwatch
        s.isStopwatchActive = !s.isStopwatchActive

        // Start Stopwatch
        startStopwatch(context = context)

        // Start Stopwatch Service
        StopwatchNotificationFunctionality(context).startStopwatchService(context)
        s.isStopwatchServiceActive = true

        // Conditional That Reveals Lap And Reset Stopwatch Button
        if (!s.isLapAndResetStopwatchButtonVisible) {
            s.isLapAndResetStopwatchButtonVisible = true
        }
    }

    private fun startStopwatch(context: Context) {
        viewModelScope.launch {

            // Increment Current Stopwatch Milliseconds & Start Stopwatch Service
            while (s.isStopwatchActive) {
                incrementCurrentStopwatchMilliseconds()
                delay(100)

                // Increment Current Stopwatch Seconds
                 while (s.currentStopwatchMilliseconds == 10){
                    incrementCurrentStopwatchSeconds()
                    StopwatchNotificationFunctionality(context).startStopwatchService(context)

                    // Increment Current Stopwatch Minutes
                    while (s.currentStopwatchSeconds == 60) {
                        incrementCurrentStopwatchMinutes()

                        // Increment Current Stopwatch Hours
                        while (s.currentStopwatchMinutes == 60) {
                            incrementCurrentStopwatchHours()

                        // Reset Stopwatch If Max Time Limit Is Reached
                        resetStopwatchIfMaxTimeLimitIsReached(context = context)
                        }
                    }
                 }
            }
        }
    }

    fun resetStopwatch(context: Context) {

        // Stop Stopwatch
        s.isStopwatchActive = false

        // Reset Current Time
        s.currentStopwatchHours = 0
        s.currentStopwatchMinutes = 0
        s.currentStopwatchSeconds = 0
        s.currentStopwatchMilliseconds = 0

        // Reset Lap Stopwatch
        stopwatchLapTimeFunctionality.resetLapStopwatch()

        // Stop Stopwatch Service
        StopwatchNotificationFunctionality(context).stopStopwatchService(context)
        s.isStopwatchServiceActive = false
    }

    private fun resetStopwatchIfMaxTimeLimitIsReached(context: Context) {
        if (s.currentStopwatchHours > 99) {
            resetStopwatch(context = context)
        }
    }
    //----------------------------------------------------------------------------------------------

    /* INCREMENT CURRENT STOPWATCH TIME
    ----------------------------------------------------------------------------------------------*/
    // Increment Current Stopwatch Milliseconds
    private fun incrementCurrentStopwatchMilliseconds() {
        s.currentStopwatchMilliseconds++ }

    // Increment Current Stopwatch Seconds
    private fun incrementCurrentStopwatchSeconds() {
        s.currentStopwatchSeconds++
        s.currentStopwatchMilliseconds = 0 }

    // Increment Current Stopwatch Minutes
    private fun incrementCurrentStopwatchMinutes() {
        s.currentStopwatchMinutes++
        s.currentStopwatchSeconds = 0 }

    // Increment Current Hour Minutes
    private fun incrementCurrentStopwatchHours() {
        s.currentStopwatchHours++
        s.currentStopwatchMinutes = 0 }
    //----------------------------------------------------------------------------------------------

}