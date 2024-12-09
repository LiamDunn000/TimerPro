package com.timerpro.casualtimer.presentation.timer_presentation.time_selection_screen.time_selection_screen_components

import android.content.Context
import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.timerpro.casualtimer.data.shared_data.Colors
import com.timerpro.casualtimer.data.timer_data.timer_dimensions.time_selection_screen_dimensions.TimeSelectionScreenDimensions
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates
import com.timerpro.casualtimer.functionality.general_functionality.generalFunctionality
import com.timerpro.casualtimer.functionality.timer_functionality.presetTimeFunctionality

@Composable
fun OpenDialogButton(
    configuration: Configuration,
    dimensions: TimeSelectionScreenDimensions = TimeSelectionScreenDimensions(configuration),
    context: Context,
    title: String
) {

    // Open Dialog Button
        Text(
            text = if (title == "Add Preset Time") "Add Preset Time" else "Select Alarm Sound",
            color = Colors().purple,
            fontSize = dimensions.openDialogButton,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(dimensions.openDialogButtonPadding)
                .clickable {
                generalFunctionality.vibrateOnButtonClick(context = context)
                    presetTimeFunctionality.resetPresetTimeOptionPanelState()
                if (title == "Add Preset Time") {
                    timerStates.let {
                        it.isPresetTimeBeingEdited = false
                        it.isAddPresetTimeDialogOpen = true
                        it.selectedPresetTimeList = listOf()
                    }
                    presetTimeFunctionality.resetAddPresetTimeDialogTextFieldValues()
                } else timerStates.isAlarmSoundSelectionDialogOpen = true }
        )
}