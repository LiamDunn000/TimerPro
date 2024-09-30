package com.timerpro.casualtimer.functionality.timer_functionality

import androidx.lifecycle.ViewModel
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates

val timerButtonStateFunctionality = TimerButtonStateFunctionality()

class TimerButtonStateFunctionality: ViewModel() {

    // Manage Start Timer Button Enabled State
    fun manageStartTimerButtonEnabledState() {
        when {
            timerStates.secondInput.text != "00" &&
                    timerStates.secondInput.text != "0" &&
                    timerStates.secondInput.text.isNotEmpty() ||
                    timerStates.minuteInput.text != "00" &&
                    timerStates.minuteInput.text != "0" &&
                    timerStates.minuteInput.text.isNotEmpty() ||
                    timerStates.hourInput.text != "00" &&
                    timerStates.hourInput.text != "0" &&
                    timerStates.hourInput.text.isNotEmpty()
            -> timerStates.isStartTimerButtonEnabled = true

            else -> timerStates.isStartTimerButtonEnabled = false
        } }

    // Manage Toggle Timer Button Text
    fun manageToggleTimerButtonTextState() {

        // Conditional That Determines Toggle Timer Button Text
        when {

            // Change Toggle Timer Button Text To "Resume
            !timerStates.isTimerActive && timerStates.secondsRemaining != 0
            ->  timerStates.toggleTimerButtonText = "Resume"

            // Change Toggle Timer Button Text To "Pause
            else ->  timerStates.toggleTimerButtonText = "Pause"}
    }
}