package com.timerpro.casualtimer.presentation.timer_presentation.add_preset_time_dialog

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import com.timerpro.casualtimer.data.shared_data.Colors
import com.timerpro.casualtimer.data.timer_data.timer_dimensions.preset_time_dialog_dimensions.PresetTimeDialogDimensions
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates
import com.timerpro.casualtimer.presentation.shared_presentation.GeneralPurposeButton
import com.timerpro.casualtimer.presentation.shared_presentation.TimeSelector
import com.timerpro.casualtimer.presentation.timer_presentation.add_preset_time_dialog.add_preset_time_dialog_components.PresetTimeTitleTextField

@Composable
fun PresetTimeDialog(
    configuration: Configuration,
    dimensions: PresetTimeDialogDimensions = PresetTimeDialogDimensions(configuration),
    ) {

    // Conditional That Opens Add Preset Time Dialog
    when { timerStates.isAddPresetTimeDialogOpen ->

        // Add Preset Time Dialog Layout
        Dialog(onDismissRequest = { timerStates.isAddPresetTimeDialogOpen = false }) {

            Column(
                modifier = Modifier
                    .background(
                        color = Colors().white,
                        shape = RoundedCornerShape(dimensions.cornerRadius)
                    )
                    .size(dimensions.dialogSize)
                    .padding(
                        horizontal = dimensions.horizontalPadding,
                        vertical = dimensions.verticalPadding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row {

                    // Preset Hour Selector
                    TimeSelector(
                        configuration = configuration,
                        title = "Preset Hours Selector")

                    // Preset Minute Selector
                    TimeSelector(
                        configuration = configuration,
                        title = "Preset Minutes Selector")

                    // Preset Second Selector
                    TimeSelector(
                        configuration = configuration,
                        title = "Preset Seconds Selector")
                }

                PresetTimeTitleTextField(configuration = configuration)

                // Save Preset Time Button
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    // Save Or Update Preset Time Button
                    GeneralPurposeButton(
                        configuration = configuration,
                        title = if (timerStates.isPresetTimeBeingEdited)
                    "Update Preset Time" else "Save Preset Time")

                    // Close Add Preset Time Dialog Button
                    GeneralPurposeButton(
                        configuration = configuration,
                        title = "Close Preset Time Dialog")

                }
            }
        }
    }
}