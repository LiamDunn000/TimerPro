package com.timerpro.casualtimer.functionality.shared_presentation_management

import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.core.text.isDigitsOnly
import com.timerpro.casualtimer.data.timer_data.timer_states.TimerStates
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates
import com.timerpro.casualtimer.functionality.timer_functionality.presetTimeFunctionality

class TimeSelectorManagement(val t: TimerStates = timerStates) {

    fun determineTextFieldValue(title: String): TextFieldValue {
        return when (title) {
            "Seconds Selector" -> t.secondInput
            "Minutes Selector" -> t.minuteInput
            "Hours Selector" -> t.hourInput
            "Preset Seconds Selector" -> t.presetSecondInput
            "Preset Minutes Selector" -> t.presetMinuteInput
            else -> t.presetHourInput
            }
        }

    fun determineOnValueChange(title: String, newText: TextFieldValue) {

        // Conditional That Validates Text Field
        // Branch That Checks If Text Field Is Empty
        if (newText.text.isEmpty()) reassignTextFieldValue(title, newText = TextFieldValue(""))

        // Branch That Checks If Text Field Is Less Than 2 Digits
        else if (newText.text.length in 0..2 && newText.text.isDigitsOnly() &&

            // Nested Branch That Checks If Text Field Is For Hours
            if (title.contains("Hours")) newText.text.toInt() < 100
            else newText.text.toInt() < 60) reassignTextFieldValue(title = title, newText = newText)
        else TextFieldValue("")

        // Conditional That Checks If Changes Have Been Made To Preset Time
        if (title.contains("Preset") && timerStates.isPresetTimeBeingEdited)
            timerStates.areChangesMadeToPresetTime = true
    }

    private fun reassignTextFieldValue(title: String, newText: TextFieldValue) {
        when (title) {
            "Seconds Selector" -> t.secondInput = newText
            "Minutes Selector" -> t.minuteInput = newText
            "Hours Selector" -> t.hourInput = newText
            "Preset Seconds Selector" -> t.presetSecondInput = newText
            "Preset Minutes Selector" -> t.presetMinuteInput = newText
            else -> t.presetHourInput = newText
        }
    }

    fun determineFocusRequester(title: String): FocusRequester {
        return when (title) {
            "Seconds Selector" -> t.secondsFocusRequester
            "Minutes Selector" -> t.minutesFocusRequester
            "Hours Selector" -> t.hoursFocusRequester
            "Preset Seconds Selector" -> t.presetSecondsFocusRequester
            "Preset Minutes Selector" -> t.presetMinutesFocusRequester
            else -> t.presetHoursFocusRequester
        }
    }

    fun determineFocusState(title: String, focusState: FocusState) {
        when (title) {
            "Seconds Selector" -> t.isSecondsTextFieldFocused = focusState.isFocused
            "Minutes Selector" -> t.isMinutesTextFieldFocused = focusState.isFocused
            "Hours Selector" -> t.isHoursTextFieldFocused = focusState.isFocused
            "Preset Seconds Selector" -> t.isPresetSecondsTextFieldFocused = focusState.isFocused
            "Preset Minutes Selector" -> t.isPresetMinutesTextFieldFocused = focusState.isFocused
            else -> t.isPresetHoursTextFieldFocused = focusState.isFocused
        }
    }

    private fun determineFocusStateVariable(title: String): Boolean {
        return when (title) {
            "Seconds Selector" -> t.isSecondsTextFieldFocused
            "Minutes Selector" -> t.isMinutesTextFieldFocused
            "Hours Selector" -> t.isHoursTextFieldFocused
            "Preset Seconds Selector" -> t.isPresetSecondsTextFieldFocused
            "Preset Minutes Selector" -> t.isPresetMinutesTextFieldFocused
            else -> t.isPresetHoursTextFieldFocused
        }
    }

    private fun determineTextSelection(title: String) {
        when (title) {
            "Seconds Selector" -> t.secondInput = t.secondInput.copy(selection = TextRange(0, t.secondInput.text.length))
            "Minutes Selector" -> t.minuteInput = t.minuteInput.copy(selection = TextRange(0, t.minuteInput.text.length))
            "Hours Selector" -> t.hourInput = t.hourInput.copy(selection = TextRange(0, t.hourInput.text.length))
            "Preset Seconds Selector" -> t.presetSecondInput = t.presetSecondInput.copy(selection = TextRange(0, t.presetSecondInput.text.length))
            "Preset Minutes Selector" -> t.presetMinuteInput = t.presetMinuteInput.copy(selection = TextRange(0, t.presetMinuteInput.text.length))
            else -> t.presetHourInput = t.presetHourInput.copy(selection = TextRange(0, t.presetHourInput.text.length))
        }
    }

    fun determineTimeSelectorState(title: String) {

        // Conditional That Resets Preset Time Option Panel
        if (determineFocusStateVariable(title)) {
            presetTimeFunctionality.resetPresetTimeOptionPanelState()}

        // Conditional That Selects The Entire Value Of Second Text Field
        if (determineFocusStateVariable(title) && determineTextFieldValue(title).text.length > 1) {
            determineTextSelection(title = title)
        }

        // Conditional That Adds A Zero To Beginning Of Second Text Field
        if (!determineFocusStateVariable(title) && determineTextFieldValue(title).text.length == 1) {
            reassignTextFieldValue(title = title, newText = TextFieldValue("0${determineTextFieldValue(title).text}"))

            //  Conditional That Converts Empty Second Text Field To 00
        } else if (!determineFocusStateVariable(title) && determineTextFieldValue(title).text.isEmpty()) {
            reassignTextFieldValue(title = title, newText = TextFieldValue("00"))
        }
    }
}
