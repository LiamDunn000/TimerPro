package com.timerpro.casualtimer.functionality.timer_functionality

import android.content.Context
import android.media.MediaPlayer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.timerpro.casualtimer.data.timer_data.timer_states.TimerStates
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates
import com.timerpro.casualtimer.functionality.general_functionality.generalFunctionality
import com.timerpro.casualtimer.functionality.timer_functionality.alarm_notification.AlarmNotificationFunctionality
import com.timerpro.casualtimer.functionality.timer_functionality.timer_notification.TimerNotificationFunctionality
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

val timerStateFunctionality = TimerStateFunctionality()

class TimerStateFunctionality(val t: TimerStates = timerStates): ViewModel() {

    /*COUNT DOWN TIMER FUNCTIONALITY
    ----------------------------------------------------------------------------------------------*/
    fun toggleTimer(context: Context) {

        generalFunctionality.vibrateOnButtonClick(context = context)

        // Toggle Timer
        t.isTimerActive = !t.isTimerActive

        // Start Timer & Timer Service
        countDownTime(context = context)
        TimerNotificationFunctionality(context).startTimerService(context) }

    fun startTimer(context: Context) {

        generalFunctionality.vibrateOnButtonClick(context = context)

        presetTimeFunctionality.resetPresetTimeOptionPanelState()

        // Conditional That Starts Timer If Start Timer Button Is Enabled
        if (t.isStartTimerButtonEnabled) {

            // Start Timer & Transition To Timer Screen
            t.isTimerActive = true
            t.isTimerScreenVisible = true

            // Conditional That Transfers Time From Text Fields To Count Down Timer
            when {t.isTimerActive -> {
                t.secondsRemaining = t.secondInput.text.toInt() + 1
                t.minutesRemaining = t.minuteInput.text.toInt()
                t.hoursRemaining = t.hourInput.text.toInt()
                countDownTime(context = context) }}}}

    private fun countDownTime(context: Context) {
        when {t.isTimerActive ->
            viewModelScope.launch {

                // Seconds Count Down
                while (
                    t.isTimerActive &&
                    t.secondsRemaining > 0) {
                    countDownSeconds()
                    TimerNotificationFunctionality(context).startTimerService(context = context)
                    delay(1000)

                    // Minutes Count Down
                    while (t.minutesRemaining > 0 && t.secondsRemaining == 0) {
                        countDownMinutes() }


                    // Hours Count Down
                    while (t.hoursRemaining > 0 && t.minutesRemaining == 0 && t.secondsRemaining == 0) {
                        countDownHours() }}

                // Time Up Check
                checkIfTimeIsUp(context)
            }
        }
    }

    private fun countDownSeconds() {
        t.secondsRemaining--
    }

    private fun countDownMinutes() {
        t.minutesRemaining--
        timerStates.secondsRemaining = 60
    }

    private fun countDownHours() {
        t.hoursRemaining--
        t.minutesRemaining = 59
        t.secondsRemaining = 60
    }

    private fun checkIfTimeIsUp(context: Context) {

        // Conditional That Stops Timer When Time Is Up
        when {
            t.secondsRemaining == 0 &&
                    t.minutesRemaining == 0 &&
                    t.hoursRemaining == 0
            -> {

                // Stop Timer & Timer Service
                t.isTimerActive = false
                TimerNotificationFunctionality(context).stopTimerService(context)

                // Nested Conditional That Checks If Cancel Button Was Clicked
                when {!t.isCancelButtonClicked  -> { t.isTimeUp = true }}

                // Start Negative Count Down Timer
                startNegativeCountDownTimer(context = context)

                t.isCancelButtonClicked = false }}}

    fun cancelTimer(context: Context) {

        generalFunctionality.vibrateOnButtonClick(context = context)

        viewModelScope.launch {

            // Reset Timer States
            t.secondsRemaining = 0
            t.minutesRemaining = 0
            t.hoursRemaining = 0 }

        // Set Timer States To False
        t.isTimerActive = false
        t.isTimerScreenVisible = false
        t.isTimeUp = false
        t.isCancelButtonClicked = true

        // Stop Timer Service
        TimerNotificationFunctionality(context).stopTimerService(context = context)}

    fun restartTimer(context: Context, alarmPlayer: MediaPlayer) {

        generalFunctionality.vibrateOnButtonClick(context = context)

        // Reset Times Up State
        t.isTimeUp = false

        // Start Timer
        startTimer(context = context)

        // Stop Alarm
        alarmPlayer.stop()

        // Return To Time Selection Screen
        alarmStateFunctionality.returnToTimeSelectionScreen(boolean = true)

        // Stop Alarm Service
        AlarmNotificationFunctionality(context).stopAlarmService(context = context)
    }
    // ---------------------------------------------------------------------------------------------

    /* NEGATIVE COUNT DOWN TIMER FUNCTIONALITY
    ----------------------------------------------------------------------------------------------*/
    private fun startNegativeCountDownTimer(context: Context) {

        viewModelScope.launch {

            // Increment Seconds Since Timer Ended
            while (t.isTimeUp) {
                incrementSecondsSinceTimerEnded()
                AlarmNotificationFunctionality(context).startAlarmService(context = context)
                delay(1000)

                // Increment Minutes Since Timer Ended
                while (t.secondsSinceTimerEnded == 59) {
                    incrementMinutesSinceTimerEnded()

                    // Increment Hours Since Timer Ended
                    while (t.minutesSinceTimerEnded == 59) {
                        incrementHoursSinceTimerEnded()

                        // Dismiss Alarm When Time Is Up
                        when {t.hoursSinceTimerEnded > 99 ->
                            alarmStateFunctionality.returnToTimeSelectionScreen(boolean = false) }}}}}}

    private fun incrementSecondsSinceTimerEnded() {
        t.secondsSinceTimerEnded++ }

    private fun incrementMinutesSinceTimerEnded() {
        t.minutesSinceTimerEnded++
        t.secondsSinceTimerEnded = 0 }

    private fun incrementHoursSinceTimerEnded() {
        t.hoursSinceTimerEnded++
        t.minutesSinceTimerEnded = 0 }
    //----------------------------------------------------------------------------------------------
}
