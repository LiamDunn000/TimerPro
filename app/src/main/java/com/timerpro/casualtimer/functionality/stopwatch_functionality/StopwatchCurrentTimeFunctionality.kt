package com.timerpro.casualtimer.functionality.stopwatch_functionality

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.timerpro.casualtimer.data.stopwatch_data.stopwatch_states.stopwatchStates
import com.timerpro.casualtimer.functionality.casual_timer_screen_functionality.casualTimerScreenFunctionality
import com.timerpro.casualtimer.functionality.stopwatch_functionality.stopwatch_notification.StopwatchNotificationFunctionality
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// Global Instance Of Stopwatch Current Time Functionality
val stopwatchCurrentTimeFunctionality = StopwatchCurrentTimeFunctionality()

class StopwatchCurrentTimeFunctionality: ViewModel() {

    /* MANAGE TOGGLE STOPWATCH BUTTON ON TAP STOPWATCH STATE
    ----------------------------------------------------------------------------------------------*/
    // Manage Toggle Stopwatch Button On Tap States
    fun manageToggleStopwatchButtonOnClickStates(context: Context) {

        // Vibrate On Button Click
        casualTimerScreenFunctionality.vibrateOnButtonClick(context = context)

        // Toggle Stopwatch
        toggleStopwatch(context = context)

        // Conditional That Toggles Lap Stopwatch
        when {stopwatchStates.isLapStopwatchVisible -> {
            stopwatchLapTimeFunctionality.toggleLapStopwatch() }}}
    //----------------------------------------------------------------------------------------------

    /* MANAGE CURRENT STOPWATCH STATE
    ----------------------------------------------------------------------------------------------*/
    // Toggle Stopwatch
    private fun toggleStopwatch(context: Context) {

        // Toggle Stopwatch
        stopwatchStates.isStopwatchActive = !stopwatchStates.isStopwatchActive

        // Start Stopwatch
        startStopwatch(context = context)

        // Start Stopwatch Service
        StopwatchNotificationFunctionality(context).startStopwatchService(context)
        stopwatchStates.isStopwatchServiceActive = true

        // Conditional That Reveals Lap And Reset Stopwatch Button
        if (!stopwatchStates.isLapAndResetStopwatchButtonVisible) {
            stopwatchStates.isLapAndResetStopwatchButtonVisible = true}}

    // Start Stopwatch
    private fun startStopwatch(context: Context) {
        viewModelScope.launch {

            // Increment Current Stopwatch Milliseconds & Start Stopwatch Service
            while (stopwatchStates.isStopwatchActive) {
                incrementCurrentStopwatchMilliseconds()
                delay(100)

                // Increment Current Stopwatch Seconds
                 while (stopwatchStates.currentStopwatchMilliseconds == 10){
                    incrementCurrentStopwatchSeconds()
                    StopwatchNotificationFunctionality(context).startStopwatchService(context)

                    // Increment Current Stopwatch Minutes
                    while (stopwatchStates.currentStopwatchSeconds == 60) {
                        incrementCurrentStopwatchMinutes()

                        // Increment Current Stopwatch Hours
                        while (stopwatchStates.currentStopwatchMinutes == 60) {
                            incrementCurrentStopwatchHours()

                        // Reset Stopwatch If Max Time Limit Is Reached
                        resetStopwatchIfMaxTimeLimitIsReached(context = context) }}}}}}

    // Reset Stopwatch
    fun resetStopwatch(context: Context) {

        // Stop Stopwatch
        stopwatchStates.isStopwatchActive = false

        // Reset Current Time
        stopwatchStates.currentStopwatchHours = 0
        stopwatchStates.currentStopwatchMinutes = 0
        stopwatchStates.currentStopwatchSeconds = 0
        stopwatchStates.currentStopwatchMilliseconds = 0

        // Reset Lap Stopwatch
        stopwatchLapTimeFunctionality.resetLapStopwatch()

        // Stop Stopwatch Service
        StopwatchNotificationFunctionality(context).stopStopwatchService(context)
        stopwatchStates.isStopwatchServiceActive = false
    }

    // Reset Stopwatch If Max Time Limit Is Reached
    private fun resetStopwatchIfMaxTimeLimitIsReached(context: Context) {
        if (stopwatchStates.currentStopwatchHours > 99) {
            resetStopwatch(context = context)}}
    //----------------------------------------------------------------------------------------------

    /* INCREMENT CURRENT STOPWATCH TIME
    ----------------------------------------------------------------------------------------------*/
    // Increment Current Stopwatch Milliseconds
    private fun incrementCurrentStopwatchMilliseconds() {
        stopwatchStates.currentStopwatchMilliseconds++ }

    // Increment Current Stopwatch Seconds
    private fun incrementCurrentStopwatchSeconds() {
        stopwatchStates.currentStopwatchSeconds++
        stopwatchStates.currentStopwatchMilliseconds = 0 }

    // Increment Current Stopwatch Minutes
    private fun incrementCurrentStopwatchMinutes() {
        stopwatchStates.currentStopwatchMinutes++
        stopwatchStates.currentStopwatchSeconds = 0 }

    // Increment Current Hour Minutes
    private fun incrementCurrentStopwatchHours() {
        stopwatchStates.currentStopwatchHours++
        stopwatchStates.currentStopwatchMinutes = 0 }
    //----------------------------------------------------------------------------------------------

}