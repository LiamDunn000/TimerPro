package com.timerpro.casualtimer.functionality.shared_presentation_management

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.timerpro.casualtimer.data.shared_data.Colors
import com.timerpro.casualtimer.data.shared_data.FormattedText
import com.timerpro.casualtimer.data.stopwatch_data.stopwatch_states.stopwatchStates
import com.timerpro.casualtimer.data.timer_data.timer_room_data.PresetTimeInstance
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates
import com.timerpro.casualtimer.functionality.general_functionality.generalFunctionality
import com.timerpro.casualtimer.functionality.stopwatch_functionality.stopwatchCurrentTimeFunctionality
import com.timerpro.casualtimer.functionality.stopwatch_functionality.stopwatchLapTimeFunctionality
import com.timerpro.casualtimer.functionality.timer_functionality.alarmStateFunctionality
import com.timerpro.casualtimer.functionality.timer_functionality.presetTimeFunctionality
import com.timerpro.casualtimer.functionality.timer_functionality.timerStateFunctionality
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GeneralPurposeButtonManagement: ViewModel() {

    // BUTTON FUNCTIONALITY ------------------------------------------------------------------------
    fun determineButtonOnPressState(
        context: Context,
        buttonTitle: String,
        alarmPlayer: MediaPlayer) {

         buttonTitle.let { if (it == "Save Preset Time"|| it == "Close Preset Time Dialog"
            ) generalFunctionality.vibrateOnButtonClick(context = context)
             viewModelScope.launch {
                delay(1)
                presetTimeFunctionality.resetPresetTimeDialogState()
            }
         }

        when (buttonTitle) {
            "Toggle Stopwatch" -> stopwatchCurrentTimeFunctionality.manageToggleStopwatchButtonOnClickStates(context = context)
            "Lap And Reset Stopwatch" -> stopwatchLapTimeFunctionality.manageLapAndResetButtonOnClickStates(context = context)
            "Save Preset Time" -> presetTimeFunctionality.insertPresetTime(context = context, presetTime = PresetTimeInstance().presetTimeInstance)
            "Update Preset Time" -> presetTimeFunctionality.updatePresetTime(context = context)
            "Close Alarm Sound Selection Dialog" -> {timerStates.isAlarmSoundSelectionDialogOpen = false; generalFunctionality.vibrateOnButtonClick(context = context)}
            "Cancel Timer" -> timerStateFunctionality.cancelTimer(context = context)
            "Dismiss Alarm" -> alarmStateFunctionality.dismissAlarm(context = context, alarmPlayer = alarmPlayer)
        }
    }

    fun determineButtonOnTapState(
        context: Context,
        buttonTitle: String,
        alarmPlayer: MediaPlayer) {

        when (buttonTitle) {
            "Start Timer" -> timerStateFunctionality.startTimer(context = context)
            "Toggle Timer" -> timerStateFunctionality.toggleTimer(context = context)
            "Restart Timer" -> timerStateFunctionality.restartTimer(context = context, alarmPlayer = alarmPlayer)
        }
    }
    // ---------------------------------------------------------------------------------------------

    // BUTTON TEXT ---------------------------------------------------------------------------------
     fun determineButtonText(buttonTitle: String): String {
        return when (buttonTitle) {
            "Toggle Stopwatch" -> determineToggleStopwatchButtonText()
            "Lap And Reset Stopwatch" -> determineLapAndResetStopwatchButtonText()
            "Start Timer" -> "Start"
            "Save Preset Time" -> "Save"
            "Update Preset Time" -> "Update"
            "Close Preset Time Dialog" -> "Cancel"
            "Close Alarm Sound Selection Dialog" -> "Cancel"
            "Toggle Timer" -> determineToggleTimerButtonText()
            "Cancel Timer" -> "Cancel"
            "Dismiss Alarm" -> "Dismiss"
            "Restart Timer" -> "Restart"
            else -> ""
        }
    }

    private fun determineToggleStopwatchButtonText(): String {
        return if (!stopwatchStates.isStopwatchActive &&
            FormattedText().formattedCurrentStopwatchTimeText == FormattedText().formattedDefaultStopwatchText &&
            FormattedText().formattedCurrentStopwatchMillisecondsText == FormattedText().formattedDefaultMillisecondsText)
            "Start" else if (stopwatchStates.isStopwatchActive) "Pause" else "Resume"
    }

    private fun determineLapAndResetStopwatchButtonText(): String {
        return if (!stopwatchStates.isStopwatchActive || stopwatchStates.laps.size == 99)
            "Reset" else "Lap"
    }

    private fun determineToggleTimerButtonText(): String {
        return if (!timerStates.isTimerActive && timerStates.secondsRemaining != 0)
            "Resume" else "Pause"
    }

    // ---------------------------------------------------------------------------------------------

    // BUTTON BACKGROUND COLOR ---------------------------------------------------------------------
    fun determineButtonBackgroundColor(buttonTitle: String): Color {
        return when (buttonTitle) {
            "Toggle Stopwatch" -> determineToggleStopwatchButtonBackgroundColor()
            "Lap And Reset Stopwatch" -> determineLapAndResetStopwatchButtonBackgroundColor()
            "Start Timer" -> determineStartTimerButtonBackgroundColor()
            "Save Preset Time" -> Colors().lightBlue
            "Close Preset Time Dialog" -> Colors().lightRed
            "Close Alarm Sound Selection Dialog" -> Colors().lightRed
            "Toggle Timer" -> determineToggleTimerButtonBackgroundColor()
            "Cancel Timer" -> Colors().mediumDarkWhite
            "Dismiss Alarm" -> Colors().lightRed
        else -> Colors().lightBlue
        }
    }

    private fun determineToggleStopwatchButtonBackgroundColor(): Color {
        return if (!stopwatchStates.isStopwatchActive)
            Colors().lightBlue else Colors().lightRed
    }

    private fun determineLapAndResetStopwatchButtonBackgroundColor(): Color {
        return if (stopwatchStates.isStopwatchActive && stopwatchStates.laps.size != 99)
        Colors().lightBlue else Colors().lightRed
    }

    private fun determineStartTimerButtonBackgroundColor(): Color {
        return if (timerStates.isStartTimerButtonEnabled)
            Colors().lightBlue else Colors().heavyDarkWhite
    }

    private fun determineToggleTimerButtonBackgroundColor(): Color {
        return if (!timerStates.isTimerActive)
            Colors().lightBlue else Colors().lightRed
    }
    // ---------------------------------------------------------------------------------------------

    // BUTTON TEXT COLOR ---------------------------------------------------------------------------
    fun determineButtonTextColor(buttonTitle: String): Color {
        return when (buttonTitle) {
            "Start Timer" -> determineStartTimerButtonTextColor()
            "Cancel Timer" -> Colors().darkGray
        else -> Colors().white}
    }

    private fun determineStartTimerButtonTextColor(): Color {
        return if (timerStates.isStartTimerButtonEnabled)
            Colors().white else Colors().lightGray
    }
    // ---------------------------------------------------------------------------------------------

    fun manageStartTimerButtonEnabledState() {
        timerStates.let { it.isStartTimerButtonEnabled =
            it.secondInput.text != "00" &&
                    it.secondInput.text != "0" &&
                    it.secondInput.text.isNotEmpty() ||
                    it.minuteInput.text != "00" &&
                    it.minuteInput.text != "0" &&
                    it.minuteInput.text.isNotEmpty() ||
                    it.hourInput.text != "00" &&
                    it.hourInput.text != "0" &&
                    it.hourInput.text.isNotEmpty()
        }

        }
}