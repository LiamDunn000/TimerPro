package com.timerpro.casualtimer.functionality.stopwatch_functionality

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.timerpro.casualtimer.data.stopwatch_data.stopwatch_data_classes.LapDisplayPanelData
import com.timerpro.casualtimer.data.stopwatch_data.stopwatch_states.stopwatchStates
import com.timerpro.casualtimer.data.shared_data.FormattedText
import com.timerpro.casualtimer.functionality.casual_timer_screen_functionality.casualTimerScreenFunctionality
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

val stopwatchLapTimeFunctionality = StopwatchLapTimeFunctionality()

class StopwatchLapTimeFunctionality: ViewModel() {

    /* MANAGE LAP AND RESET BUTTON ON TAP STATES
    ----------------------------------------------------------------------------------------------*/
    // Manage Lap And Reset Button On Tap States
    fun manageLapAndResetButtonOnClickStates(context: Context) {

        // Vibrate On Button Click
        casualTimerScreenFunctionality.vibrateOnButtonClick(context = context)

        // Conditional That Determines Lap And Reset Button On CLick States
        when {

            // Reset Stopwatch
            !stopwatchStates.isStopwatchActive || stopwatchStates.laps.size == 99 -> {
                stopwatchCurrentTimeFunctionality.resetStopwatch(context = context)
            }

            // Start Lap Stopwatch
            !stopwatchStates.isLapStopwatchVisible && stopwatchStates.laps.isEmpty() -> {
                toggleLapStopwatch()
            }

            // Add Item To Lap Display List
            else -> {
                addItemToLapDisplayList() }}}
    //----------------------------------------------------------------------------------------------

    /* MANAGE LAP STOPWATCH STATE
    ----------------------------------------------------------------------------------------------*/
    // Toggle Lap Stopwatch
    fun toggleLapStopwatch() {

        // Conditional That Reveals Lap Stopwatch
        when {!stopwatchStates.isLapStopwatchVisible -> stopwatchStates.isLapStopwatchVisible = true }

        // Toggle Lap Stopwatch
        stopwatchStates.isLapStopwatchActive = !stopwatchStates.isLapStopwatchActive

        // Start Lap Stopwatch
        startLapStopwatch()

        // Conditional That Adds Item To Lap Display List
        when { stopwatchStates.laps.isEmpty() -> addItemToLapDisplayList() }}

    // Start Lap Stopwatch
    private fun startLapStopwatch() {

        viewModelScope.launch {

            // Increment Lap Stopwatch Milliseconds
            while (stopwatchStates.isLapStopwatchActive) {
                incrementLapStopwatchMilliseconds()
                delay(100)

                // Increment Lap Stopwatch Seconds
                while (stopwatchStates.lapStopwatchMilliseconds == 10) {
                    incrementLapStopwatchSeconds()

                    // Increment Lap Stopwatch Minutes
                    while (stopwatchStates.lapStopwatchSeconds == 60) {
                        incrementLapStopwatchMinutes()

                        // Increment Lap Stopwatch Hours
                        while (stopwatchStates.lapStopwatchMinutes == 60) {
                            incrementLapStopwatchHours()

                        // Reset Lap Stopwatch If Max Time Limit Is Reached
                        resetLapStopwatchIfMaxTimeLimitIsReached() }}}}}}

    // Reset Stopwatch
    fun resetLapStopwatch() {

        // Stop Lap Stopwatch
        stopwatchStates.isLapStopwatchActive = false

        // Hide Lap Stopwatch Time Display
        stopwatchStates.isLapStopwatchVisible = false

        // Hide Lap And Reset Stopwatch Button
        stopwatchStates.isLapAndResetStopwatchButtonVisible = false

        // Reset Lap Time
        stopwatchStates.lapStopwatchHours = 0
        stopwatchStates.lapStopwatchMinutes = 0
        stopwatchStates.lapStopwatchSeconds = 0
        stopwatchStates.lapStopwatchMilliseconds = 0

        // Hide & Clear Lap Display List
        stopwatchStates.isLapTimeListVisible = false
        stopwatchStates.laps.clear() }

    // Reset Stopwatch If Max Time Limit Is Reached
    private fun resetLapStopwatchIfMaxTimeLimitIsReached() {
        when {stopwatchStates.lapStopwatchHours > 99 -> resetLapStopwatch() }}
    //----------------------------------------------------------------------------------------------

    /* INCREMENT LAP STOPWATCH TIME
    ----------------------------------------------------------------------------------------------*/
    // Increment Lap Stopwatch Milliseconds
    private fun incrementLapStopwatchMilliseconds() {
        stopwatchStates.lapStopwatchMilliseconds++
    }

    // Increment Lap Stopwatch Seconds
    private fun incrementLapStopwatchSeconds() {
        stopwatchStates.lapStopwatchSeconds++
        stopwatchStates.lapStopwatchMilliseconds = 0
    }

    // Increment Lap Stopwatch Minutes
    private fun incrementLapStopwatchMinutes() {
        stopwatchStates.lapStopwatchMinutes++
        stopwatchStates.lapStopwatchSeconds = 0
    }

    // Increment Lap Hour Minutes
    private fun incrementLapStopwatchHours() {
        stopwatchStates.lapStopwatchHours++
        stopwatchStates.lapStopwatchMinutes = 0
    }
    //----------------------------------------------------------------------------------------------

    /* ADD ITEM TO LAP DISPLAY LIST
    ----------------------------------------------------------------------------------------------*/
    // Add Item To Lap Display List
    private fun addItemToLapDisplayList() {

        // Reveal Lap Display List
        stopwatchStates.isLapTimeListVisible = true

        // Conditional That Determines If Lap Display List Is Empty
        when {

            // Adds Item To Lap Display List If Empty
            stopwatchStates.laps.isEmpty() -> { addFirstItemToLapDisplayList() }

            // Adds Item To Lap Display List If Not Empty
            stopwatchStates.laps.isNotEmpty() -> { addRemainingItemsToLapDisplayList() }}}

    // Add First Item To Lap Display List
    private fun addFirstItemToLapDisplayList() {
        stopwatchStates.laps.add(
            LapDisplayPanelData(
                index = stopwatchStates.laps.size + 1,
                lapTime = FormattedText().formattedCurrentStopwatchTimeText,
                overallTime = FormattedText().formattedCurrentStopwatchTimeText)) }

    // Add Remaining Items To Lap Display List
    private fun addRemainingItemsToLapDisplayList() {
        viewModelScope.launch {
        stopwatchStates.laps.add(
            LapDisplayPanelData(
                index = stopwatchStates.laps.size + 1,
                lapTime = FormattedText().formattedLapStopwatchTimeText,
                overallTime = FormattedText().formattedCurrentStopwatchTimeText))
        delay(1)
        stopwatchStates.lapStopwatchMilliseconds = 0
        stopwatchStates.lapStopwatchSeconds = 0
        stopwatchStates.lapStopwatchMinutes = 0
        stopwatchStates.lapStopwatchHours = 0 }}
    //----------------------------------------------------------------------------------------------
}
