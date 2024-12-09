package com.timerpro.casualtimer.functionality.shared_presentation_management

import android.content.Context
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.TextFieldValue
import com.timerpro.casualtimer.data.timer_data.timer_states.TimerStates
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates
import com.timerpro.casualtimer.functionality.general_functionality.generalFunctionality
import com.timerpro.casualtimer.functionality.timer_functionality.presetTimeFunctionality

class ModifyTimeButtonManagement(val t: TimerStates = timerStates) {

    fun determineButtonFunctionality(context: Context, title: String, action: String) {
        if (action == "Increment") determineIncrementTime(context = context, title = title)
        else determineDecrementTime(context = context, title = title)
    }


    private fun determineIncrementTime(context: Context, title: String) {
        if (determineTimeValue(title).isNotEmpty() && determineTimeValue(title).toInt() < determineTimeValueLimit(title)) {
            generalFunctionality.vibrateOnButtonClick(context = context)
            presetTimeFunctionality.resetPresetTimeOptionPanelState()
            when (title) {
                "Seconds Selector" -> t.secondInput = TextFieldValue((t.secondInput.text.toInt() + 1).toString())
                "Minutes Selector" -> t.minuteInput = TextFieldValue((t.minuteInput.text.toInt() + 1).toString())
                "Hours Selector" -> t.hourInput = TextFieldValue((t.hourInput.text.toInt() + 1).toString())
                "Preset Seconds Selector" -> t.presetSecondInput = TextFieldValue((t.presetSecondInput.text.toInt() + 1).toString())
                "Preset Minutes Selector" -> t.presetMinuteInput = TextFieldValue((t.presetMinuteInput.text.toInt() + 1).toString())
                else -> t.presetHourInput = TextFieldValue((t.presetHourInput.text.toInt() + 1).toString())
            }
        }
    }

    private fun determineDecrementTime(context: Context, title: String) {
        if (determineTimeValue(title).isNotEmpty() && determineTimeValue(title).toInt() > 0) {
            generalFunctionality.vibrateOnButtonClick(context = context)
            presetTimeFunctionality.resetPresetTimeOptionPanelState()
            when (title) {
                "Seconds Selector" -> t.secondInput = TextFieldValue((t.secondInput.text.toInt() - 1).toString())
                "Minutes Selector" -> t.minuteInput = TextFieldValue((t.minuteInput.text.toInt() - 1).toString())
                "Hours Selector" -> t.hourInput = TextFieldValue((t.hourInput.text.toInt() - 1).toString())
                "Preset Seconds Selector" -> t.presetSecondInput = TextFieldValue((t.presetSecondInput.text.toInt() - 1).toString())
                "Preset Minutes Selector" -> t.presetMinuteInput = TextFieldValue((t.presetMinuteInput.text.toInt() - 1).toString())
                else -> t.presetHourInput = TextFieldValue((t.presetHourInput.text.toInt() - 1).toString())
            }
        }
    }

    private fun determineTimeValue(title: String): String {
        return when (title) {
            "Seconds Selector" -> t.secondInput.text
            "Minutes Selector" -> t.minuteInput.text
            "Hours Selector" -> t.hourInput.text
            "Preset Seconds Selector" -> t.presetSecondInput.text
            "Preset Minutes Selector" -> t.presetMinuteInput.text
            else -> t.presetHourInput.text
        }
    }

    private fun determineTimeValueLimit(title: String): Int {
        return if (title.contains("Hours")) 99 else 59
    }

    fun determineIcon(buttonAction: String): ImageVector {
        return if (buttonAction == "Increment") Icons.Default.KeyboardArrowUp
        else Icons.Default.KeyboardArrowDown
    }
}