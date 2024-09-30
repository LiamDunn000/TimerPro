package com.timerpro.casualtimer.functionality.stopwatch_functionality

import androidx.lifecycle.ViewModel
import com.timerpro.casualtimer.data.stopwatch_data.stopwatch_states.stopwatchStates
import com.timerpro.casualtimer.data.shared_data.FormattedText

class StopwatchButtonStateFunctionality: ViewModel() {

    /* MANAGE STOPWATCH BUTTON TEXT
     ----------------------------------------------------------------------------------------------------------*/
    // Manage Toggle Stopwatch Button Text
    fun manageToggleStopwatchButtonText() {

        // Conditional That Determines Toggle Stopwatch Button Text
        when {

            // Change Toggle Stopwatch Button Text To "Start"
            !stopwatchStates.isStopwatchActive &&
                    FormattedText().formattedCurrentStopwatchTimeText == FormattedText().formattedDefaultStopwatchText &&
                    FormattedText().formattedCurrentStopwatchMillisecondsText == FormattedText().formattedDefaultMillisecondsText
            -> {
                stopwatchStates.toggleStopwatchButtonText = "Start"
            }

            // Change Toggle Stopwatch Button Text To "Pause"
            stopwatchStates.isStopwatchActive
            -> {
                stopwatchStates.toggleStopwatchButtonText = "Pause"
            }

            // Change Toggle Stopwatch Button Text To "Resume"
            else
            -> {
                stopwatchStates.toggleStopwatchButtonText = "Resume" }}}

    // Manage Lap And Reset Stopwatch Button Text
    fun manageLapAndResetStopwatchButtonText() {

        // Conditional That Determines Lap And Reset Stopwatch Button Text
        when {

            // Change Lap And Reset Stopwatch Button Text To "Reset"
            !stopwatchStates.isStopwatchActive || stopwatchStates.laps.size == 99 -> {
                stopwatchStates.lapAndResetStopwatchButtonText = "Reset"
            }

            // Change Lap And Reset Stopwatch Button Text To "Lap"
            else -> {
                stopwatchStates.lapAndResetStopwatchButtonText = "Lap" }}}

    //----------------------------------------------------------------------------------------------
}