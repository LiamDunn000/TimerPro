package com.timerpro.casualtimer.presentation.timer_presentation.alarm_sound_selection_dialog.alarm_sound_selection_dialog_layouts

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.timerpro.casualtimer.data.casual_timer_screen_data.casual_timer_datastore.CasualTimerDatastore
import com.timerpro.casualtimer.data.timer_data.timer_colors.timerColors
import com.timerpro.casualtimer.data.timer_data.timer_dimensions.alarm_sound_selection_dialog_dimensions.LandscapeAlarmSoundSelectionDialogDimensions
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates
import com.timerpro.casualtimer.presentation.timer_presentation.alarm_sound_selection_dialog.alarm_sound_selection_dialog_composables.AlarmSoundSelectionList
import com.timerpro.casualtimer.presentation.timer_presentation.alarm_sound_selection_dialog.alarm_sound_selection_dialog_composables.CloseAlarmSoundSelectionDialogButton

@Composable
fun LandscapeAlarmSoundSelectionDialog(
    configuration: Configuration,
    casualTimerDatastore: CasualTimerDatastore
) {

    // Conditional That Landscape Opens Alarm Sound Selection Dialog
    when {
        timerStates.isAlarmSoundSelectionDialogOpen ->

            // Landscape Alarm Sound Selection Dialog Layout
            Dialog(onDismissRequest = { timerStates.isAlarmSoundSelectionDialogOpen = false }) {

                Column(
                    modifier = Modifier
                        .background(
                            color = timerColors.alarmSoundSelectionDialogBackgroundColor
                        )
                        .width(width = LandscapeAlarmSoundSelectionDialogDimensions(configuration).landscapeAlarmSoundSelectionDialogWidth.dp)
                        .height(height = LandscapeAlarmSoundSelectionDialogDimensions(configuration).landscapeAlarmSoundSelectionDialogHeight.dp)
                        .padding(
                            horizontal = LandscapeAlarmSoundSelectionDialogDimensions(configuration).landscapeAlarmSoundSelectionDialogHorizontalPadding.dp,
                            vertical = LandscapeAlarmSoundSelectionDialogDimensions(configuration).landscapeAlarmSoundSelectionDialogVerticalPadding.dp
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {

                    Text(
                        text = "Select Alarm Sound",
                        fontSize = LandscapeAlarmSoundSelectionDialogDimensions(configuration).landscapeAlarmSoundSelectionDialogHeaderFontSize.sp,)

                    // Landscape Alarm Sound Selection List
                    AlarmSoundSelectionList(
                        fontSize = LandscapeAlarmSoundSelectionDialogDimensions(configuration).landscapeAlarmSoundNameFontSize,
                        buttonSize = LandscapeAlarmSoundSelectionDialogDimensions(configuration).landscapeAlarmSoundSelectionRadioButtonSize,
                        spacing = LandscapeAlarmSoundSelectionDialogDimensions(configuration).landscapeAlarmSoundSelectionListSpacing,
                        buttonBorderWidth = LandscapeAlarmSoundSelectionDialogDimensions(configuration).landscapeAlarmSoundSelectionRadioButtonBorderWidth,
                        casualTimerDatastore = casualTimerDatastore
                    )

                    // Portrait Close Alarm Sound Selection Dialog Button
                    CloseAlarmSoundSelectionDialogButton(
                        width = LandscapeAlarmSoundSelectionDialogDimensions(configuration).landscapeCloseAlarmSoundSelectionDialogButtonWidth,
                        height = LandscapeAlarmSoundSelectionDialogDimensions(configuration).landscapeCloseAlarmSoundSelectionDialogButtonHeight,
                        fontSize = LandscapeAlarmSoundSelectionDialogDimensions(configuration).landscapeCloseAlarmSoundSelectionDialogButtonFontSize
                    )
                }
                }}}