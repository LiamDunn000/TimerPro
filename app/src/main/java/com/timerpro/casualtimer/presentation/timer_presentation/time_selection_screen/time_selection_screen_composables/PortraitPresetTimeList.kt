package com.timerpro.casualtimer.presentation.timer_presentation.time_selection_screen.time_selection_screen_composables

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.timerpro.casualtimer.data.timer_data.timer_dimensions.time_selection_screen_dimensions.PortraitTimeSelectionScreenDimensions
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates
import com.timerpro.casualtimer.functionality.casual_timer_screen_functionality.casualTimerScreenFunctionality
import com.timerpro.casualtimer.functionality.timer_functionality.presetTimeFunctionality
import com.timerpro.casualtimer.presentation.timer_presentation.edit_preset_time_dialog.edit_preset_time_dialog_layouts.PortraitEditPresetTimeDialog

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PortraitPresetTimeList(
    context: Context,
    configuration: Configuration) {

    // Retrieve All Preset Times
    presetTimeFunctionality.retrieveAllPresetTimes().observe(LocalLifecycleOwner.current) { timerStates.presetTimeList = it }

    //  Portrait Preset Time List
        LazyRow(
            modifier = Modifier.padding(top = 100.dp),
            horizontalArrangement = Arrangement.spacedBy(35.dp)
        ) {
            items(timerStates.presetTimeList) { presetTime ->

                // Edit Preset Time Dialog Variables
                var isEditPresetTimeDialogOpen by remember { mutableStateOf(false) }
                var isEditPresetTimeDialogExpanded by remember { mutableStateOf(false) }

                // Conditional That Loads Saved Preset Time Data Into Text Fields
                when {isEditPresetTimeDialogExpanded -> {
                    timerStates.presetTimeNameTextFieldValue = presetTime.name
                    timerStates.presetHourInput =
                        TextFieldValue(presetTime.hours.toString())
                    timerStates.presetMinuteInput =
                        TextFieldValue(presetTime.minutes.toString())
                    timerStates.presetSecondInput =
                        TextFieldValue(presetTime.seconds.toString()) }}

                // Conditional That Determines Delete And Cancel Button Text
                when (isEditPresetTimeDialogExpanded) {
                    false -> timerStates.deleteAndCancelPresetTimeButtonText = "Delete"
                    true -> timerStates.deleteAndCancelPresetTimeButtonText = "Cancel" }

                // Close Edit Preset Time Dialog
                fun closeEditPresetTimeDialog() {
                    isEditPresetTimeDialogOpen = false
                    isEditPresetTimeDialogExpanded = false }

                // Portrait Edit Preset Time Dialog
                PortraitEditPresetTimeDialog(
                    context = context,
                    configuration = configuration,
                    openBoolean = isEditPresetTimeDialogOpen,
                    expandedBoolean = isEditPresetTimeDialogExpanded,
                    onUpdate = {

                        // Vibrate On Button Click
                        casualTimerScreenFunctionality.vibrateOnButtonClick(context)

                        // Conditional That Determines Update Button Functionality
                        when (isEditPresetTimeDialogExpanded) {

                            // Expands Edit Preset Time Dialog
                            false -> isEditPresetTimeDialogExpanded = true

                            // Updates Preset Time Data And Closes Edit Preset Time Dialog
                            true -> {
                                presetTimeFunctionality.updatePresetTime(
                                    presetTime = presetTime.copy(
                                        name = timerStates.presetTimeNameTextFieldValue,
                                        seconds = timerStates.presetSecondInput.text.toInt(),
                                        minutes = timerStates.presetMinuteInput.text.toInt(),
                                        hours = timerStates.presetHourInput.text.toInt()))
                                isEditPresetTimeDialogOpen = false
                                isEditPresetTimeDialogExpanded = false}}},

                    onCancel = {

                        // Vibrate On Button Click
                        casualTimerScreenFunctionality.vibrateOnButtonClick(context)

                        // Conditional That Determines Delete Button Functionality
                        when (isEditPresetTimeDialogExpanded) {

                            // Closes Edit Preset Time Dialog
                            true -> {
                                isEditPresetTimeDialogOpen = false
                                isEditPresetTimeDialogExpanded = false}

                            // Deletes Preset Time Data And Closes Edit Preset Time Dialog
                            false -> {
                                presetTimeFunctionality.deletePresetTime(presetTime = presetTime)
                                isEditPresetTimeDialogOpen = false
                                isEditPresetTimeDialogExpanded = false }}
                        },
                    onDismiss = { closeEditPresetTimeDialog() }
                    )

                    // Portrait Preset Time Panel
                    PresetTimePanel(
                        nameFontSize = PortraitTimeSelectionScreenDimensions(configuration).portraitPresetTimeNameFontSize,
                        timeFontSize = PortraitTimeSelectionScreenDimensions(configuration).portraitPresetTimeFontSize,
                        name = presetTime.name,
                        seconds = presetTime.seconds,
                        minutes = presetTime.minutes,
                        hours = presetTime.hours,

                        // Opens Edit Preset Time Dialog When Long Clicked
                        onLongClick = {
                            isEditPresetTimeDialogOpen = true
                            casualTimerScreenFunctionality.vibrateOnButtonClick(context)}
                    )
                }
            }
        }