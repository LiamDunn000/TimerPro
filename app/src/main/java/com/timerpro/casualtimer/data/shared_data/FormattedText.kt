package com.timerpro.casualtimer.data.shared_data

import com.timerpro.casualtimer.data.stopwatch_data.stopwatch_states.stopwatchStates
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates

class FormattedText {

    // Formatted Current Stopwatch Time Text
    var formattedCurrentStopwatchTimeText = "%02d:%02d:%02d".format(
        stopwatchStates.currentStopwatchHours,
        stopwatchStates.currentStopwatchMinutes,
        stopwatchStates.currentStopwatchSeconds,)

    // Formatted Current Stopwatch Milliseconds Text
    var formattedCurrentStopwatchMillisecondsText = ".%02d".format(
        stopwatchStates.currentStopwatchMilliseconds)

    // Formatted Lap Stopwatch Time Text
    val formattedLapStopwatchTimeText = "%02d:%02d:%02d".format(
        stopwatchStates.lapStopwatchHours,
        stopwatchStates.lapStopwatchMinutes,
        stopwatchStates.lapStopwatchSeconds)

    // Formatted Lap Stopwatch Milliseconds Text
    val formattedLapStopwatchMillisecondsText = ".%02d".format(
        stopwatchStates.lapStopwatchMilliseconds)

    //Formatted Lap Number
    val formattedLapNumberText = "%02d".format(stopwatchStates.laps.size)

    // Formatted Default Stopwatch Text
    val formattedDefaultStopwatchText = "00:00:00"
    val formattedDefaultMillisecondsText = ".00"

    // Formatted Timer Text
    var formattedCountDownTimerText = "%02d:%02d:%02d".format(timerStates.hoursRemaining, timerStates.minutesRemaining, timerStates.secondsRemaining)

    // Formatted Initial Time Text
    var formattedInitialTimeText = "%02d:%02d:%02d".format(timerStates.hourInput.text.toInt(), timerStates.minuteInput.text.toInt(), timerStates.secondInput.text.toInt())

    // Formatted Negative Timer Text
    var formattedNegativeCountDownTimerText = "-%02d:%02d:%02d".format(timerStates.hoursSinceTimerEnded, timerStates.minutesSinceTimerEnded, timerStates.secondsSinceTimerEnded)
}