package com.timerpro.casualtimer.functionality.stopwatch_functionality

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.timerpro.casualtimer.data.shared_data.FormattedText
import com.timerpro.casualtimer.data.stopwatch_data.stopwatch_data_classes.LapDisplayPanelData
import com.timerpro.casualtimer.data.stopwatch_data.stopwatch_states.StopwatchStates
import com.timerpro.casualtimer.data.stopwatch_data.stopwatch_states.stopwatchStates
import com.timerpro.casualtimer.functionality.general_functionality.generalFunctionality
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

val stopwatchLapTimeFunctionality = StopwatchLapTimeFunctionality()

class StopwatchLapTimeFunctionality(private val s: StopwatchStates = stopwatchStates): ViewModel() {

    /* MANAGE LAP AND RESET BUTTON ON TAP STATES
    ----------------------------------------------------------------------------------------------*/
    fun manageLapAndResetButtonOnClickStates(context: Context) {

        generalFunctionality.vibrateOnButtonClick(context = context)

        // Conditional That Determines Lap And Reset Button On CLick States
        if (
            // Reset Stopwatch
            !s.isStopwatchActive || s.laps.size == 99)
                stopwatchCurrentTimeFunctionality.resetStopwatch(context = context)

            // Start Lap Stopwatch
            else if (!s.isLapStopwatchVisible && s.laps.isEmpty())
                toggleLapStopwatch()

            else addItemToLapDisplayList()
    }
    //----------------------------------------------------------------------------------------------

    /* MANAGE LAP STOPWATCH STATE
    ----------------------------------------------------------------------------------------------*/
    fun toggleLapStopwatch() {

        // Conditional That Reveals Lap Stopwatch
        if (!s.isLapStopwatchVisible) s.isLapStopwatchVisible = true

        // Toggle Lap Stopwatch
        s.isLapStopwatchActive = !s.isLapStopwatchActive

        startLapStopwatch()

        // Conditional That Adds Item To Lap Display List
        if (s.laps.isEmpty()) addItemToLapDisplayList() }

    // Start Lap Stopwatch
    private fun startLapStopwatch() {

        viewModelScope.launch {

            // Increment Lap Stopwatch Milliseconds
            while (s.isLapStopwatchActive) {
                incrementLapStopwatchMilliseconds()
                delay(100)

                // Increment Lap Stopwatch Seconds
                while (s.lapStopwatchMilliseconds == 10) {
                    incrementLapStopwatchSeconds()

                    // Increment Lap Stopwatch Minutes
                    while (s.lapStopwatchSeconds == 60) {
                        incrementLapStopwatchMinutes()

                        // Increment Lap Stopwatch Hours
                        while (s.lapStopwatchMinutes == 60) {
                            incrementLapStopwatchHours()

                        resetLapStopwatchIfMaxTimeLimitIsReached()
                        }
                    }
                }
            }
        }
    }

    fun resetLapStopwatch() {

        // Stop Lap Stopwatch
        s.isLapStopwatchActive = false

        // Hide Lap Stopwatch Time Display
        s.isLapStopwatchVisible = false

        // Hide Lap And Reset Stopwatch Button
        s.isLapAndResetStopwatchButtonVisible = false

        // Reset Lap Time
        s.lapStopwatchHours = 0
        s.lapStopwatchMinutes = 0
        s.lapStopwatchSeconds = 0
        s.lapStopwatchMilliseconds = 0

        // Hide & Clear Lap Display List
        s.isLapTimeListVisible = false
        s.laps.clear()
    }

    private fun resetLapStopwatchIfMaxTimeLimitIsReached() {
        if (s.lapStopwatchHours > 99) resetLapStopwatch()
    }
    //----------------------------------------------------------------------------------------------

    /* INCREMENT LAP STOPWATCH TIME
    ----------------------------------------------------------------------------------------------*/
    private fun incrementLapStopwatchMilliseconds() {
        s.lapStopwatchMilliseconds++
    }

    private fun incrementLapStopwatchSeconds() {
        s.lapStopwatchSeconds++
        s.lapStopwatchMilliseconds = 0
    }

    private fun incrementLapStopwatchMinutes() {
        s.lapStopwatchMinutes++
        s.lapStopwatchSeconds = 0
    }

    private fun incrementLapStopwatchHours() {
        s.lapStopwatchHours++
        s.lapStopwatchMinutes = 0
    }
    //----------------------------------------------------------------------------------------------

    /* ADD ITEM TO LAP DISPLAY LIST
    ----------------------------------------------------------------------------------------------*/
    private fun addItemToLapDisplayList() {

        // Reveal Lap Display List
        s.isLapTimeListVisible = true

        // Conditional That Determines If Lap Display List Is Empty
        when {

            // Adds Item To Lap Display List If Empty
            s.laps.isEmpty() -> { addFirstItemToLapDisplayList() }

            // Adds Item To Lap Display List If Not Empty
            s.laps.isNotEmpty() -> { addRemainingItemsToLapDisplayList()
            }
        }
    }

    private fun addFirstItemToLapDisplayList() {
        s.laps.add(
            LapDisplayPanelData(
                index = s.laps.size + 1,
                lapTime = FormattedText().formattedCurrentStopwatchTimeText,
                overallTime = FormattedText().formattedCurrentStopwatchTimeText)) }

    private fun addRemainingItemsToLapDisplayList() {
        viewModelScope.launch {
        s.laps.add(
            LapDisplayPanelData(
                index = s.laps.size + 1,
                lapTime = FormattedText().formattedLapStopwatchTimeText,
                overallTime = FormattedText().formattedCurrentStopwatchTimeText))
            delay(1)
            // Reset Lap Stopwatch
            s.lapStopwatchMilliseconds = 0
            s.lapStopwatchSeconds = 0
            s.lapStopwatchMinutes = 0
            s.lapStopwatchHours = 0 }}
    //----------------------------------------------------------------------------------------------
}
