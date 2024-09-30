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
import com.timerpro.casualtimer.data.timer_data.timer_dimensions.alarm_sound_selection_dialog_dimensions.PortraitAlarmSoundSelectionDialogDimensions
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates
import com.timerpro.casualtimer.presentation.timer_presentation.alarm_sound_selection_dialog.alarm_sound_selection_dialog_composables.AlarmSoundSelectionList
import com.timerpro.casualtimer.presentation.timer_presentation.alarm_sound_selection_dialog.alarm_sound_selection_dialog_composables.CloseAlarmSoundSelectionDialogButton

@Composable
fun PortraitAlarmSoundSelectionDialog(
    configuration: Configuration,
    casualTimerDatastore: CasualTimerDatastore
) {

    // Conditional That Portrait Opens Alarm Sound Selection Dialog
    when {
        timerStates.isAlarmSoundSelectionDialogOpen ->

            // Portrait Alarm Sound Selection Dialog Layout
            Dialog(onDismissRequest = { timerStates.isAlarmSoundSelectionDialogOpen = false }) {

                Column(
                    modifier = Modifier
                        .background(
                            color = timerColors.alarmSoundSelectionDialogBackgroundColor
                        )
                        .width(width = PortraitAlarmSoundSelectionDialogDimensions(configuration).portraitAlarmSoundSelectionDialogWidth.dp)
                        .height(height = PortraitAlarmSoundSelectionDialogDimensions(configuration).portraitAlarmSoundSelectionDialogHeight.dp)
                        .padding(
                            horizontal = PortraitAlarmSoundSelectionDialogDimensions(configuration).portraitAlarmSoundSelectionDialogHorizontalPadding.dp,
                            vertical = PortraitAlarmSoundSelectionDialogDimensions(configuration).portraitAlarmSoundSelectionDialogVerticalPadding.dp
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {

                    Text(
                        text = "Double Tap To Select Alarm Sound",
                        fontSize = PortraitAlarmSoundSelectionDialogDimensions(configuration).portraitAlarmSoundSelectionDialogHeaderFontSize.sp,)

                    // Portrait Alarm Sound Selection List
                    AlarmSoundSelectionList(
                        fontSize = PortraitAlarmSoundSelectionDialogDimensions(configuration).portraitAlarmSoundNameFontSize,
                        buttonSize = PortraitAlarmSoundSelectionDialogDimensions(configuration).portraitAlarmSoundSelectionRadioButtonSize,
                        spacing = PortraitAlarmSoundSelectionDialogDimensions(configuration).portraitAlarmSoundSelectionListSpacing,
                        buttonBorderWidth = PortraitAlarmSoundSelectionDialogDimensions(configuration).portraitAlarmSoundSelectionRadioButtonBorderWidth,
                        casualTimerDatastore = casualTimerDatastore
                    )

                    // Portrait Close Alarm Sound Selection Dialog Button
                    CloseAlarmSoundSelectionDialogButton(
                        width = PortraitAlarmSoundSelectionDialogDimensions(configuration).portraitCloseAlarmSoundSelectionDialogButtonWidth,
                        height = PortraitAlarmSoundSelectionDialogDimensions(configuration).portraitCloseAlarmSoundSelectionDialogButtonHeight,
                        fontSize = PortraitAlarmSoundSelectionDialogDimensions(configuration).portraitCloseAlarmSoundSelectionDialogButtonFontSize
                    )
                }
}}}