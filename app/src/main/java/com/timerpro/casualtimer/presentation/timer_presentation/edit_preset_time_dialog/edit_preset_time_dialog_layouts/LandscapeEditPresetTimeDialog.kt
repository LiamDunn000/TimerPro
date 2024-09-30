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
import com.timerpro.casualtimer.data.timer_data.timer_dimensions.edit_preset_time_dialog_dimensions.LandscapeEditPresetTimeDialogDimensions
import com.timerpro.casualtimer.presentation.timer_presentation.add_preset_time_dialog.add_preset_time_dialog_composables.PresetHourSelector
import com.timerpro.casualtimer.presentation.timer_presentation.add_preset_time_dialog.add_preset_time_dialog_composables.PresetMinuteSelector
import com.timerpro.casualtimer.presentation.timer_presentation.add_preset_time_dialog.add_preset_time_dialog_composables.PresetSecondSelector
import com.timerpro.casualtimer.presentation.timer_presentation.add_preset_time_dialog.add_preset_time_dialog_composables.PresetTimeNameTextField
import com.timerpro.casualtimer.presentation.timer_presentation.edit_preset_time_dialog.edit_preset_time_dialog_composables.DeleteEditPresetTimeDialogButton
import com.timerpro.casualtimer.presentation.timer_presentation.edit_preset_time_dialog.edit_preset_time_dialog_composables.UpdatePresetTimeButton

@Composable
fun LandscapeEditPresetTimeDialog(
    context: Context,
    configuration: Configuration,
    openBoolean: Boolean,
    expandedBoolean: Boolean,
    onUpdate: () -> Unit,
    onCancel: () -> Unit,
    onDismiss: () -> Unit
) {

    when { openBoolean ->

        // Landscape Edit Preset Time Dialog Layout
        Dialog(onDismissRequest = {onDismiss()}) {
            Column(
                modifier = Modifier
                    .background(color = timerColors.addPresetTimeDialogBackgroundColor)
                    .width(LandscapeEditPresetTimeDialogDimensions(configuration).landscapeEditPresetTimeDialogWidth.dp)
                    .height(
                        animateDpAsState(
                            when (expandedBoolean) {
                                true -> LandscapeEditPresetTimeDialogDimensions(configuration).expandedLandscapeEditPresetTimeDialogHeight.dp
                                false -> LandscapeEditPresetTimeDialogDimensions(configuration).unexpandedLandscapeEditPresetTimeDialogHeight.dp
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
                            verticalSpacing = LandscapeEditPresetTimeDialogDimensions(configuration).landscapeEditPresetTimeDialogTextFieldPanelVerticalSpacing,
                            size = LandscapeEditPresetTimeDialogDimensions(configuration).landscapeEditPresetTimeDialogTextFieldSize,
                            fontSize = LandscapeEditPresetTimeDialogDimensions(configuration).landscapeEditPresetTimeDialogTextFieldFontSize,
                            buttonSize = LandscapeEditPresetTimeDialogDimensions(configuration).landscapeIncrementAndDecrementButtonSize,
                            iconSize = LandscapeEditPresetTimeDialogDimensions(configuration).landscapeIncrementAndDecrementIconSize
                        )

                        // Edit Preset Minute Selector
                        PresetMinuteSelector(
                            context = context,
                            verticalSpacing = LandscapeEditPresetTimeDialogDimensions(configuration).landscapeEditPresetTimeDialogTextFieldPanelVerticalSpacing,
                            size = LandscapeEditPresetTimeDialogDimensions(configuration).landscapeEditPresetTimeDialogTextFieldSize,
                            fontSize = LandscapeEditPresetTimeDialogDimensions(configuration).landscapeEditPresetTimeDialogTextFieldFontSize,
                            buttonSize = LandscapeEditPresetTimeDialogDimensions(configuration).landscapeIncrementAndDecrementButtonSize,
                            iconSize = LandscapeEditPresetTimeDialogDimensions(configuration).landscapeIncrementAndDecrementIconSize
                        )

                        // Edit Preset Second Selector
                        PresetSecondSelector(
                            context = context,
                            verticalSpacing = LandscapeEditPresetTimeDialogDimensions(configuration).landscapeEditPresetTimeDialogTextFieldPanelVerticalSpacing,
                            size = LandscapeEditPresetTimeDialogDimensions(configuration).landscapeEditPresetTimeDialogTextFieldSize,
                            fontSize = LandscapeEditPresetTimeDialogDimensions(configuration).landscapeEditPresetTimeDialogTextFieldFontSize,
                            buttonSize = LandscapeEditPresetTimeDialogDimensions(configuration).landscapeIncrementAndDecrementButtonSize,
                            iconSize = LandscapeEditPresetTimeDialogDimensions(configuration).landscapeIncrementAndDecrementIconSize
                        )
                    }
                }

                // Edit Preset Time Name Text Field
                AnimatedVisibility(visible = expandedBoolean) {
                    PresetTimeNameTextField(
                        width = LandscapeEditPresetTimeDialogDimensions(configuration).landscapeEditPresetTimeNameTextFieldWidth,
                        height = LandscapeEditPresetTimeDialogDimensions(configuration).landscapeEditPresetTimeNameTextFieldHeight,
                        fontSize = LandscapeEditPresetTimeDialogDimensions(configuration).landscapeEditPresetTimeNameTextFieldFontSize,
                    )
                }


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {

                    // Landscape Update Preset Time Button
                    UpdatePresetTimeButton(
                        context = context,
                        onClick = { onUpdate() },
                        width = LandscapeEditPresetTimeDialogDimensions(configuration).landscapeEditPresetTimeDialogButtonWidth,
                        height = LandscapeEditPresetTimeDialogDimensions(configuration).landscapeEditPresetTimeDialogButtonHeight,
                        fontSize = LandscapeEditPresetTimeDialogDimensions(configuration).landscapeEditPresetTimeButtonFontSize
                    )

                    // Landscape Close Edit Preset Time Dialog Button
                    DeleteEditPresetTimeDialogButton(
                        context = context,
                        onClick = { onCancel() },
                        width = LandscapeEditPresetTimeDialogDimensions(configuration).landscapeEditPresetTimeDialogButtonWidth,
                        height = LandscapeEditPresetTimeDialogDimensions(configuration).landscapeEditPresetTimeDialogButtonHeight,
                        fontSize = LandscapeEditPresetTimeDialogDimensions(configuration).landscapeEditPresetTimeButtonFontSize
                    )
                }
            }
        }
    }
}