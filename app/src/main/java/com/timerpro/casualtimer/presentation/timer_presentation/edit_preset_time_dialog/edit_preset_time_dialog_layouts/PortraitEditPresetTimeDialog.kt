package com.timerpro.casualtimer.presentation.timer_presentation.edit_preset_time_dialog.edit_preset_time_dialog_layouts

import android.content.Context
import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
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
import com.timerpro.casualtimer.data.timer_data.timer_dimensions.edit_preset_time_dialog_dimensions.PortraitEditPresetTimeDialogDimensions
import com.timerpro.casualtimer.presentation.timer_presentation.add_preset_time_dialog.add_preset_time_dialog_composables.PresetHourSelector
import com.timerpro.casualtimer.presentation.timer_presentation.add_preset_time_dialog.add_preset_time_dialog_composables.PresetMinuteSelector
import com.timerpro.casualtimer.presentation.timer_presentation.add_preset_time_dialog.add_preset_time_dialog_composables.PresetSecondSelector
import com.timerpro.casualtimer.presentation.timer_presentation.add_preset_time_dialog.add_preset_time_dialog_composables.PresetTimeNameTextField
import com.timerpro.casualtimer.presentation.timer_presentation.edit_preset_time_dialog.edit_preset_time_dialog_composables.DeleteEditPresetTimeDialogButton
import com.timerpro.casualtimer.presentation.timer_presentation.edit_preset_time_dialog.edit_preset_time_dialog_composables.UpdatePresetTimeButton

@Composable
fun PortraitEditPresetTimeDialog(
    context: Context,
    configuration: Configuration,
    openBoolean: Boolean,
    expandedBoolean: Boolean,
    onUpdate: () -> Unit,
    onCancel: () -> Unit,
    onDismiss: () -> Unit
) {

    when { openBoolean ->

        // Portrait Edit Preset Time Dialog Layout
        Dialog(onDismissRequest = {onDismiss()}) {
            Column(
                modifier = Modifier
                    .background(color = timerColors.addPresetTimeDialogBackgroundColor)
                    .width(PortraitEditPresetTimeDialogDimensions(configuration).portraitEditPresetTimeDialogWidth.dp)
                    .height(
                        animateDpAsState(
                            when (expandedBoolean) {
                                true -> PortraitEditPresetTimeDialogDimensions(configuration).expandedPortraitEditPresetTimeDialogHeight.dp
                                false -> PortraitEditPresetTimeDialogDimensions(configuration).unexpandedPortraitEditPresetTimeDialogHeight.dp
                            },
                            animationSpec = tween(

                            )
                        ).value
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {

                AnimatedVisibility(visible = expandedBoolean) {

                    Row {

                        // Edit Preset Hour Selector
                        PresetHourSelector(
                            context = context,
                            verticalSpacing = PortraitEditPresetTimeDialogDimensions(configuration).portraitEditPresetTimeDialogTextFieldPanelVerticalSpacing,
                            size = PortraitEditPresetTimeDialogDimensions(configuration).portraitEditPresetTimeDialogTextFieldSize,
                            fontSize = PortraitEditPresetTimeDialogDimensions(configuration).portraitEditPresetTimeDialogTextFieldFontSize,
                            buttonSize = PortraitEditPresetTimeDialogDimensions(configuration).portraitIncrementAndDecrementButtonSize,
                            iconSize = PortraitEditPresetTimeDialogDimensions(configuration).portraitIncrementAndDecrementIconSize
                        )

                        // Edit Preset Minute Selector
                        PresetMinuteSelector(
                            context = context,
                            verticalSpacing = PortraitEditPresetTimeDialogDimensions(configuration).portraitEditPresetTimeDialogTextFieldPanelVerticalSpacing,
                            size = PortraitEditPresetTimeDialogDimensions(configuration).portraitEditPresetTimeDialogTextFieldSize,
                            fontSize = PortraitEditPresetTimeDialogDimensions(configuration).portraitEditPresetTimeDialogTextFieldFontSize,
                            buttonSize = PortraitEditPresetTimeDialogDimensions(configuration).portraitIncrementAndDecrementButtonSize,
                            iconSize = PortraitEditPresetTimeDialogDimensions(configuration).portraitIncrementAndDecrementIconSize
                        )

                        // Edit Preset Second Selector
                        PresetSecondSelector(
                            context = context,
                            verticalSpacing = PortraitEditPresetTimeDialogDimensions(configuration).portraitEditPresetTimeDialogTextFieldPanelVerticalSpacing,
                            size = PortraitEditPresetTimeDialogDimensions(configuration).portraitEditPresetTimeDialogTextFieldSize,
                            fontSize = PortraitEditPresetTimeDialogDimensions(configuration).portraitEditPresetTimeDialogTextFieldFontSize,
                            buttonSize = PortraitEditPresetTimeDialogDimensions(configuration).portraitIncrementAndDecrementButtonSize,
                            iconSize = PortraitEditPresetTimeDialogDimensions(configuration).portraitIncrementAndDecrementIconSize
                        )
                    }}

                // Edit Preset Time Name Text Field
                AnimatedVisibility(visible = expandedBoolean) {
                    PresetTimeNameTextField(
                        width = PortraitEditPresetTimeDialogDimensions(configuration).portraitEditPresetTimeNameTextFieldWidth,
                        height = PortraitEditPresetTimeDialogDimensions(configuration).portraitEditPresetTimeNameTextFieldHeight,
                        fontSize = PortraitEditPresetTimeDialogDimensions(configuration).portraitEditPresetTimeNameTextFieldFontSize,
                    )
                }


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {

                    // Portrait Update Preset Time Button
                    UpdatePresetTimeButton(
                        context = context,
                        onClick = { onUpdate() },
                        width = PortraitEditPresetTimeDialogDimensions(configuration).portraitEditPresetTimeDialogButtonWidth,
                        height = PortraitEditPresetTimeDialogDimensions(configuration).portraitEditPresetTimeDialogButtonHeight,
                        fontSize = PortraitEditPresetTimeDialogDimensions(configuration).portraitEditPresetTimeButtonFontSize
                    )

                    // Portrait Close Edit Preset Time Dialog Button
                    DeleteEditPresetTimeDialogButton(
                        context = context,
                        onClick = { onCancel() },
                        width = PortraitEditPresetTimeDialogDimensions(configuration).portraitEditPresetTimeDialogButtonWidth,
                        height = PortraitEditPresetTimeDialogDimensions(configuration).portraitEditPresetTimeDialogButtonHeight,
                        fontSize = PortraitEditPresetTimeDialogDimensions(configuration).portraitEditPresetTimeButtonFontSize
                    )
                }
            }
        }
    }
}