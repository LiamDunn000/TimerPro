package com.timerpro.casualtimer.presentation.shared_presentation

import android.content.Context
import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import com.timerpro.casualtimer.data.shared_data.Colors
import com.timerpro.casualtimer.data.shared_data.ScreenDimensions
import com.timerpro.casualtimer.data.timer_data.timer_states.alarmPlayer
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates
import com.timerpro.casualtimer.functionality.general_functionality.generalFunctionality
import com.timerpro.casualtimer.functionality.timer_functionality.alarmStateFunctionality
import com.timerpro.casualtimer.functionality.timer_functionality.presetTimeFunctionality

@Composable
fun TextOnlyButton(
    context: Context = LocalContext.current,
    configuration: Configuration = LocalConfiguration.current,
    dimen: Int = ScreenDimensions(configuration).screenSize,
    title: String
) {

    Text(

        // Text
        text = when (title) {
            "Open Preset Time Dialog" -> "Add Preset Time"
            "Open Alarm Sound Selection Dialog" -> "Select Alarm Sound"
            "Save Alarm Sound" -> "Save"
            "Close Alarm Sound Selection Dialog" -> "Close"
            else -> title
        },
        modifier = Modifier

            // Padding
            .padding(
                when (title) {
                    "Save Alarm Sound", "Close Alarm Sound Selection Dialog" -> 0.dp
                    else -> dimen * 0.013.dp
                }
            )

            // On Click
            .clickable (
                onClick = {
                generalFunctionality.vibrateOnButtonClick(context = context)
                when (title) {
                    "Open Preset Time Dialog" -> presetTimeFunctionality.openCreatePresetTimeDialog()
                    "Open Alarm Sound Selection Dialog" -> alarmStateFunctionality.openAlarmSoundSelectionDialog(context = context)
                    "Save Alarm Sound" -> alarmStateFunctionality.saveAlarmSound(context = context)
                    "Close Alarm Sound Selection Dialog" -> alarmStateFunctionality.closeAlarmSoundSelectionDialog()
                    else -> {}
                }},
                enabled = when (title) {
                    "Save Alarm Sound" -> timerStates.areChangesMadeToAlarmSound
                    else -> true
                }
                ),

        // Color
        color = when (title) {
            "Open Preset Time Dialog", "Open Alarm Sound Selection Dialog" -> Colors().purple
            "Save Alarm Sound" -> if (timerStates.areChangesMadeToAlarmSound) Colors().darkGray else Colors().lightGray
            else -> Colors().darkGray
        },

        // Font Size
        fontSize = when (title) {
            "Save Alarm Sound", "Close Alarm Sound Selection Dialog" -> dimen * 0.018.sp
            else -> dimen * 0.013.sp
        },

        // Font Weight
        fontWeight = FontWeight.Medium
    )
}