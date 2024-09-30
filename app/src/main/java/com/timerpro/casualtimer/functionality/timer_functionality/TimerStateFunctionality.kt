package com.timerpro.casualtimer.functionality.timer_functionality

import android.content.Context
import android.media.MediaPlayer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates
import com.timerpro.casualtimer.functionality.casual_timer_screen_functionality.casualTimerScreenFunctionality
import com.timerpro.casualtimer.functionality.timer_functionality.alarm_notification.AlarmNotificationFunctionality
import com.timerpro.casualtimer.functionality.timer_functionality.timer_notification.TimerNotificationFunctionality
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

val timerStateFunctionality = TimerStateFunctionality()

class TimerStateFunctionality: ViewModel() {

    /*COUNT DOWN TIMER FUNCTIONALITY
    ----------------------------------------------------------------------------------------------*/
    // Toggle Timer
    fun toggleTimer(context: Context) {

        // Vibrate On Button Click
        casualTimerScreenFunctionality.vibrateOnButtonClick(context = context)

        // Toggle Timer
        timerStates.isTimerActive = !timerStates.isTimerActive

        // Start Timer & Timer Service
        countDownTime(context = context)
        TimerNotificationFunctionality(context).startTimerService(context) }

    //  Start Timer
    fun startTimer(context: Context) {

        // Vibrate On Button Click
        casualTimerScreenFunctionality.vibrateOnButtonClick(context = context)

        // Start Timer & Transition To Timer Screen
        timerStates.isTimerActive = true
        timerStates.isTimerScreenVisible = true

        // Conditional That Transfers Time From Text Fields To Count Down Timer
            when {timerStates.isTimerActive -> {
            timerStates.secondsRemaining = timerStates.secondInput.text.toInt() + 1
            timerStates.minutesRemaining = timerStates.minuteInput.text.toInt()
            timerStates.hoursRemaining = timerStates.hourInput.text.toInt()
            countDownTime(context = context) }}}

    // Count Down Timer
    private fun countDownTime(context: Context) {
        when {timerStates.isTimerActive ->
            viewModelScope.launch {

                // Seconds Count Down
                while (
                    timerStates.isTimerActive &&
                    timerStates.secondsRemaining > 0) {
                    countDownSeconds()
                    TimerNotificationFunctionality(context).startTimerService(context = context)
                    delay(1000)

                    // Minutes Count Down
                    while (timerStates.minutesRemaining > 0 && timerStates.secondsRemaining == 0) {
                        countDownMinutes() }


                    // Hours Count Down
                    while (timerStates.hoursRemaining > 0 && timerStates.minutesRemaining == 0 && timerStates.secondsRemaining == 0) {
                        countDownHours() }}

                // Time Up Check
                checkIfTimeIsUp(context) }}}

    // Count Down Seconds
    private fun countDownSeconds() {
        timerStates.secondsRemaining--
    }

    // Count Down Minutes
    private fun countDownMinutes() {
        timerStates.minutesRemaining--
        timerStates.secondsRemaining = 60
    }

    // Count Down Hours
    private fun countDownHours() {
        timerStates.hoursRemaining--
        timerStates.minutesRemaining = 59
        timerStates.secondsRemaining = 60
    }

    // Check If Time Is Up
    private fun checkIfTimeIsUp(context: Context) {

        // Conditional That Stops Timer When Time Is Up
        when {
            timerStates.secondsRemaining == 0 &&
                    timerStates.minutesRemaining == 0 &&
                    timerStates.hoursRemaining == 0
            -> {

                // Stop Timer & Timer Service
                timerStates.isTimerActive = false
                TimerNotificationFunctionality(context).stopTimerService(context)

                // Nested Conditional That Checks If Cancel Button Was Clicked
                when {!timerStates.isCancelButtonClicked  -> { timerStates.isTimeUp = true }}

                // Start Negative Count Down Timer
                startNegativeCountDownTimer(context = context)

                timerStates.isCancelButtonClicked = false }}}

    // Cancel Timer
    fun cancelTimer(context: Context) {

        // Vibrate On Button Click
        casualTimerScreenFunctionality.vibrateOnButtonClick(context = context)

        viewModelScope.launch {

            // Reset Timer States
            timerStates.secondsRemaining = 0
            timerStates.minutesRemaining = 0
            timerStates.hoursRemaining = 0 }

        // Set Timer States To False
        timerStates.isTimerActive = false
        timerStates.isTimerScreenVisible = false
        timerStates.isTimeUp = false
        timerStates.isCancelButtonClicked = true

        // Stop Timer Service
        TimerNotificationFunctionality(context).stopTimerService(context = context)}

    // Restart Timer
    fun restartTimer(context: Context, mediaPlayer: MediaPlayer) {

        // Vibrate On Button Click
        casualTimerScreenFunctionality.vibrateOnButtonClick(context = context)

        // Reset Times Up State
        timerStates.isTimeUp = false

        // Start Timer
        startTimer(context = context)

        // Stop Alarm
        mediaPlayer.stop()

        // Return To Time Selection Screen
        alarmStateFunctionality.returnToTimeSelectionScreen(boolean = true)

        // Stop Alarm Service
        AlarmNotificationFunctionality(context).stopAlarmService(context = context)
    }
    // ---------------------------------------------------------------------------------------------

    /* NEGATIVE COUNT DOWN TIMER FUNCTIONALITY
    ----------------------------------------------------------------------------------------------*/
    // Start Negative Count Down Timer
    private fun startNegativeCountDownTimer(context: Context) {

        viewModelScope.launch {

            // Increment Seconds Since Timer Ended
            while (timerStates.isTimeUp) {
                timerStateFunctionality.incrementSecondsSinceTimerEnded()
                AlarmNotificationFunctionality(context).startAlarmService(context = context)
                delay(1000)

                // Increment Minutes Since Timer Ended
                while (timerStates.secondsSinceTimerEnded == 59) {
                    timerStateFunctionality.incrementMinutesSinceTimerEnded()

                    // Increment Hours Since Timer Ended
                    while (timerStates.minutesSinceTimerEnded == 59) {
                        timerStateFunctionality.incrementHoursSinceTimerEnded()

                        // Dismiss Alarm When Time Is Up
                        when {timerStates.hoursSinceTimerEnded > 99 ->
                            alarmStateFunctionality.returnToTimeSelectionScreen(boolean = false) }}}}}}

    // Increment Seconds Since Timer Ended
    private fun incrementSecondsSinceTimerEnded() {
        timerStates.secondsSinceTimerEnded++ }

    // Increment Minutes Since Timer Ended
    private fun incrementMinutesSinceTimerEnded() {
        timerStates.minutesSinceTimerEnded++
        timerStates.secondsSinceTimerEnded = 0 }

    // Increment Hours Since Timer Ended
    private fun incrementHoursSinceTimerEnded() {
        timerStates.hoursSinceTimerEnded++
        timerStates.minutesSinceTimerEnded = 0 }
    //----------------------------------------------------------------------------------------------
}
