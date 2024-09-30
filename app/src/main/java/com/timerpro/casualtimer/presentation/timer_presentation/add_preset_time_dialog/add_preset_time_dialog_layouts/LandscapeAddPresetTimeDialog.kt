package com.timerpro.casualtimer.presentation.timer_presentation.add_preset_time_dialog.add_preset_time_dialog_layouts

import android.content.Context
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.timerpro.casualtimer.data.timer_data.timer_colors.timerColors
import com.timerpro.casualtimer.data.timer_data.timer_dimensions.add_preset_time_dialog_dimensions.LandscapeAddPresetTimeDialogDimensions
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates
import com.timerpro.casualtimer.presentation.timer_presentation.add_preset_time_dialog.add_preset_time_dialog_composables.CloseAddPresetTimeDialogButton
import com.timerpro.casualtimer.presentation.timer_presentation.add_preset_time_dialog.add_preset_time_dialog_composables.PresetHourSelector
import com.timerpro.casualtimer.presentation.timer_presentation.add_preset_time_dialog.add_preset_time_dialog_composables.PresetMinuteSelector
import com.timerpro.casualtimer.presentation.timer_presentation.add_preset_time_dialog.add_preset_time_dialog_composables.PresetSecondSelector
import com.timerpro.casualtimer.presentation.timer_presentation.add_preset_time_dialog.add_preset_time_dialog_composables.PresetTimeNameTextField
import com.timerpro.casualtimer.presentation.timer_presentation.add_preset_time_dialog.add_preset_time_dialog_composables.SavePresetTimeButton

@Composable
fun LandscapeAddPresetTimeDialog(
    context: Context,
    configuration: Configuration,
    onSave: () -> Unit,
    onCancel: () -> Unit,
) {

    // Conditional That Opens Landscape Add Preset Time Dialog
    when { timerStates.isAddPresetTimeDialogOpen ->

            // Landscape Add Preset Time Dialog Layout
            Dialog(onDismissRequest = { timerStates.isAddPresetTimeDialogOpen = false }) {

                Column(
                    modifier = Modifier
                        .background(
                            color = timerColors.addPresetTimeDialogBackgroundColor
                        )
                        .width(width = LandscapeAddPresetTimeDialogDimensions(configuration).landscapeAddPresetTimeDialogWidth.dp)
                        .height(height = LandscapeAddPresetTimeDialogDimensions(configuration).landscapeAddPresetTimeDialogHeight.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Row {

                        // Landscape Preset Hour Selector
                        PresetHourSelector(
                            context = context,
                            verticalSpacing = LandscapeAddPresetTimeDialogDimensions(configuration).landscapeAddPresetTimeDialogTextFieldPanelVerticalSpacing,
                            size = LandscapeAddPresetTimeDialogDimensions(configuration).landscapeAddPresetTimeDialogTextFieldSize,
                            fontSize = LandscapeAddPresetTimeDialogDimensions(configuration).landscapeAddPresetTimeDialogTextFieldFontSize,
                            buttonSize = LandscapeAddPresetTimeDialogDimensions(configuration).landscapeIncrementAndDecrementButtonSize,
                            iconSize = LandscapeAddPresetTimeDialogDimensions(configuration).landscapeIncrementAndDecrementIconSize
                        )

                        // Landscape Preset Minute Selector
                        PresetMinuteSelector(
                            context = context,
                            verticalSpacing = LandscapeAddPresetTimeDialogDimensions(configuration).landscapeAddPresetTimeDialogTextFieldPanelVerticalSpacing,
                            size = LandscapeAddPresetTimeDialogDimensions(configuration).landscapeAddPresetTimeDialogTextFieldSize,
                            fontSize = LandscapeAddPresetTimeDialogDimensions(configuration).landscapeAddPresetTimeDialogTextFieldFontSize,
                            buttonSize = LandscapeAddPresetTimeDialogDimensions(configuration).landscapeIncrementAndDecrementButtonSize,
                            iconSize = LandscapeAddPresetTimeDialogDimensions(configuration).landscapeIncrementAndDecrementIconSize
                        )

                        // Landscape Preset Second Selector
                        PresetSecondSelector(
                            context = context,
                            verticalSpacing = LandscapeAddPresetTimeDialogDimensions(configuration).landscapeAddPresetTimeDialogTextFieldPanelVerticalSpacing,
                            size = LandscapeAddPresetTimeDialogDimensions(configuration).landscapeAddPresetTimeDialogTextFieldSize,
                            fontSize = LandscapeAddPresetTimeDialogDimensions(configuration).landscapeAddPresetTimeDialogTextFieldFontSize,
                            buttonSize = LandscapeAddPresetTimeDialogDimensions(configuration).landscapeIncrementAndDecrementButtonSize,
                            iconSize = LandscapeAddPresetTimeDialogDimensions(configuration).landscapeIncrementAndDecrementIconSize
                        )
                    }

                    // Landscape Preset Time Name Text Field
                    PresetTimeNameTextField(
                        width = LandscapeAddPresetTimeDialogDimensions(configuration).landscapePresetTimeNameTextFieldWidth,
                        height = LandscapeAddPresetTimeDialogDimensions(configuration).landscapePresetTimeNameTextFieldHeight,
                        fontSize = LandscapeAddPresetTimeDialogDimensions(configuration).landscapePresetTimeNameTextFieldFontSize,
                    )

                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly) {

                    // Landscape Save Preset Time Button
                    SavePresetTimeButton(
                        context = context,
                        onClick = {onSave()},
                        width = LandscapeAddPresetTimeDialogDimensions(configuration).landscapeSavePresetTimeDialogButtonWidth,
                        height = LandscapeAddPresetTimeDialogDimensions(configuration).landscapeSavePresetTimeDialogButtonHeight,
                        fontSize = LandscapeAddPresetTimeDialogDimensions(configuration).landscapeSavePresetTimeButtonFontSize)

                    CloseAddPresetTimeDialogButton(
                        context = context,
                        onClick = onCancel,
                        width = LandscapeAddPresetTimeDialogDimensions(configuration).landscapeSavePresetTimeDialogButtonWidth,
                        height = LandscapeAddPresetTimeDialogDimensions(configuration).landscapeSavePresetTimeDialogButtonHeight,
                        fontSize = LandscapeAddPresetTimeDialogDimensions(configuration).landscapeSavePresetTimeButtonFontSize,
                    )
                }}
            }
    }
}