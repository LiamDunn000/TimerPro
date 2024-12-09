package com.timerpro.casualtimer.data.shared_data

import com.timerpro.casualtimer.data.stopwatch_data.stopwatch_states.StopwatchStates
import com.timerpro.casualtimer.data.stopwatch_data.stopwatch_states.stopwatchStates
import com.timerpro.casualtimer.data.timer_data.timer_states.TimerStates
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates

class FormattedText(s: StopwatchStates = stopwatchStates, t: TimerStates = timerStates) {

    private fun formattedTimeText(hours: Int, minutes: Int, seconds: Int): String {
        return "%02d:%02d:%02d".format(hours, minutes, seconds)
    }

    private fun formattedMillisecondsText(milliseconds: Int): String {
        return ".%02d".format(milliseconds)
    }

    // FORMATTED STOPWATCH TEXT --------------------------------------------------------------------

    // Current Stopwatch Time
    val formattedCurrentStopwatchTimeText = formattedTimeText(
        s.currentStopwatchHours, s.currentStopwatchMinutes, s.currentStopwatchSeconds)

    val formattedCurrentStopwatchMillisecondsText = formattedMillisecondsText(
        s.currentStopwatchMilliseconds)

    // Lap Stopwatch Time
    val formattedLapStopwatchTimeText = formattedTimeText(
        s.lapStopwatchHours, s.lapStopwatchMinutes, s.lapStopwatchSeconds)

    val formattedLapStopwatchMillisecondsText = formattedMillisecondsText(
        stopwatchStates.lapStopwatchMilliseconds)

    val formattedLapNumberText = formattedMillisecondsText(stopwatchStates.laps.size)

    // Default Stopwatch Text
    val formattedDefaultStopwatchText = "00:00:00"
    val formattedDefaultMillisecondsText = ".00"

    // FORMATTED TIMER TEXT -----------------------------------------------------------------------

    var formattedCountDownTimerText = formattedTimeText(
        t.hoursRemaining, t.minutesRemaining, t.secondsRemaining)

    var formattedInitialTimeText = formattedTimeText(
        t.hourInput.text.toInt(), t.minuteInput.text.toInt(), t.secondInput.text.toInt())

    var formattedNegativeCountDownTimerText = "-${formattedTimeText(
        t.hoursSinceTimerEnded, t.minutesSinceTimerEnded, t.secondsSinceTimerEnded)}"
}