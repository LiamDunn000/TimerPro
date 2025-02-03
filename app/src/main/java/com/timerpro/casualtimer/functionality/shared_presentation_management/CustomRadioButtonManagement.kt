package com.timerpro.casualtimer.functionality.shared_presentation_management

import androidx.compose.ui.graphics.Color
import com.timerpro.casualtimer.data.shared_data.Colors
import com.timerpro.casualtimer.data.timer_data.timer_states.AlarmSound
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates

class CustomRadioButtonManagement {

    fun determineButtonBorderColor(title: String, sound: AlarmSound, isSelected: Boolean): Color {
        return if (title == "Alarm Button" && sound == timerStates.selectedAlarmSound ||
            title == "Preset Time Button" && isSelected)
            Colors().lightBlue
        else if (title == "Preset Time Button" && timerStates.selectedPresetTimeList.isEmpty())
            Colors().transparent else Colors().lightGray
        }

    fun determineButtonIndicatorColor(title: String, sound: AlarmSound, isSelected: Boolean): Color {
        return if (title == "Alarm Button" && sound == timerStates.selectedAlarmSound ||
            title == "Preset Time Button" && isSelected)
            Colors().lightBlue else Colors().transparent }
}