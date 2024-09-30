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
import com.timerpro.casualtimer.data.timer_data.timer_dimensions.add_preset_time_dialog_dimensions.PortraitAddPresetTimeDialogDimensions
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates
import com.timerpro.casualtimer.presentation.timer_presentation.add_preset_time_dialog.add_preset_time_dialog_composables.CloseAddPresetTimeDialogButton
import com.timerpro.casualtimer.presentation.timer_presentation.add_preset_time_dialog.add_preset_time_dialog_composables.PresetHourSelector
import com.timerpro.casualtimer.presentation.timer_presentation.add_preset_time_dialog.add_preset_time_dialog_composables.PresetMinuteSelector
import com.timerpro.casualtimer.presentation.timer_presentation.add_preset_time_dialog.add_preset_time_dialog_composables.PresetSecondSelector
import com.timerpro.casualtimer.presentation.timer_presentation.add_preset_time_dialog.add_preset_time_dialog_composables.PresetTimeNameTextField
import com.timerpro.casualtimer.presentation.timer_presentation.add_preset_time_dialog.add_preset_time_dialog_composables.SavePresetTimeButton

@Composable
fun PortraitAddPresetTimeDialog(
    context: Context,
    onSave: () -> Unit,
    onCancel: () -> Unit,
    configuration: Configuration) {

    // Conditional That Opens Add Preset Time Dialog
    when { timerStates.isAddPresetTimeDialogOpen ->

        // Add Preset Time Dialog Layout
        Dialog(onDismissRequest = { timerStates.isAddPresetTimeDialogOpen = false }) {

            Column(
                modifier = Modifier
                    .background(
                        color = timerColors.addPresetTimeDialogBackgroundColor
                    )
                    .width(width = PortraitAddPresetTimeDialogDimensions(configuration).portraitAddPresetTimeDialogWidth.dp)
                    .height(height = PortraitAddPresetTimeDialogDimensions(configuration).portraitAddPresetTimeDialogHeight.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Row {

                    // Preset Hour Selector
                    PresetHourSelector(
                        context = context,
                        verticalSpacing = PortraitAddPresetTimeDialogDimensions(configuration).portraitAddPresetTimeDialogTextFieldPanelVerticalSpacing,
                        size = PortraitAddPresetTimeDialogDimensions(configuration).portraitAddPresetTimeDialogTextFieldSize,
                        fontSize = PortraitAddPresetTimeDialogDimensions(configuration).portraitAddPresetTimeDialogTextFieldFontSize,
                        buttonSize = PortraitAddPresetTimeDialogDimensions(configuration).portraitIncrementAndDecrementButtonSize,
                        iconSize = PortraitAddPresetTimeDialogDimensions(configuration).portraitIncrementAndDecrementIconSize
                    )

                    // Preset Minute Selector
                    PresetMinuteSelector(
                        context = context,
                        verticalSpacing = PortraitAddPresetTimeDialogDimensions(configuration).portraitAddPresetTimeDialogTextFieldPanelVerticalSpacing,
                        size = PortraitAddPresetTimeDialogDimensions(configuration).portraitAddPresetTimeDialogTextFieldSize,
                        fontSize = PortraitAddPresetTimeDialogDimensions(configuration).portraitAddPresetTimeDialogTextFieldFontSize,
                        buttonSize = PortraitAddPresetTimeDialogDimensions(configuration).portraitIncrementAndDecrementButtonSize,
                        iconSize = PortraitAddPresetTimeDialogDimensions(configuration).portraitIncrementAndDecrementIconSize
                    )

                    // Preset Second Selector
                    PresetSecondSelector(
                        context = context,
                        verticalSpacing = PortraitAddPresetTimeDialogDimensions(configuration).portraitAddPresetTimeDialogTextFieldPanelVerticalSpacing,
                        size = PortraitAddPresetTimeDialogDimensions(configuration).portraitAddPresetTimeDialogTextFieldSize,
                        fontSize = PortraitAddPresetTimeDialogDimensions(configuration).portraitAddPresetTimeDialogTextFieldFontSize,
                        buttonSize = PortraitAddPresetTimeDialogDimensions(configuration).portraitIncrementAndDecrementButtonSize,
                        iconSize = PortraitAddPresetTimeDialogDimensions(configuration).portraitIncrementAndDecrementIconSize
                    )
                }

                PresetTimeNameTextField(
                    width = PortraitAddPresetTimeDialogDimensions(configuration).portraitPresetTimeNameTextFieldWidth,
                    height = PortraitAddPresetTimeDialogDimensions(configuration).portraitPresetTimeNameTextFieldHeight,
                    fontSize = PortraitAddPresetTimeDialogDimensions(configuration).portraitPresetTimeNameTextFieldFontSize,
                )

                // Save Preset Time Button
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {

                    // Portrait Save Preset Time Button
                    SavePresetTimeButton(
                        context = context,
                        onClick = onSave,
                        width = PortraitAddPresetTimeDialogDimensions(configuration).portraitSavePresetTimeDialogButtonWidth,
                        height = PortraitAddPresetTimeDialogDimensions(configuration).portraitSavePresetTimeDialogButtonHeight,
                        fontSize = PortraitAddPresetTimeDialogDimensions(configuration).portraitSavePresetTimeButtonFontSize,
                        )

                    // Portrait Close Add Preset Time Dialog Button
                    CloseAddPresetTimeDialogButton(
                        context = context,
                        onClick = onCancel,
                        width = PortraitAddPresetTimeDialogDimensions(configuration).portraitSavePresetTimeDialogButtonWidth,
                        height = PortraitAddPresetTimeDialogDimensions(configuration).portraitSavePresetTimeDialogButtonHeight,
                        fontSize = PortraitAddPresetTimeDialogDimensions(configuration).portraitSavePresetTimeButtonFontSize,
                    )

                }
            }
        }
    }
}