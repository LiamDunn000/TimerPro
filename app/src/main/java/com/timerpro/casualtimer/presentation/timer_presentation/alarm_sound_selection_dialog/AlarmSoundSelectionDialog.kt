package com.timerpro.casualtimer.presentation.timer_presentation.alarm_sound_selection_dialog

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.timerpro.casualtimer.data.casual_timer_screen_data.casual_timer_datastore.CasualTimerDatastore
import com.timerpro.casualtimer.data.shared_data.Colors
import com.timerpro.casualtimer.data.timer_data.timer_dimensions.alarm_sound_selection_dialog_dimensions.AlarmSoundSelectionDialogDimensions
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates
import com.timerpro.casualtimer.presentation.shared_presentation.GeneralPurposeButton
import com.timerpro.casualtimer.presentation.timer_presentation.alarm_sound_selection_dialog.alarm_sound_selection_dialog_components.AlarmSoundSelectionList

@Composable
fun AlarmSoundSelectionDialog(
    configuration: Configuration,dimensions: AlarmSoundSelectionDialogDimensions = AlarmSoundSelectionDialogDimensions(configuration),
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
                            color = Colors().white
                        )
                        .size(dimensions.dialogSize)
                        .padding(
                            horizontal = dimensions.horizontalPadding.dp,
                            vertical = dimensions.verticalPadding.dp
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {

                    Text(
                        text = "Select Alarm Sound",
                        fontSize = dimensions.headerFontSize)

                    // Portrait Alarm Sound Selection List
                    AlarmSoundSelectionList(
                        configuration = configuration,
                        casualTimerDatastore = casualTimerDatastore
                    )

                    // Portrait Close Alarm Sound Selection Dialog Button
                    GeneralPurposeButton(
                        configuration = configuration,
                        title = "Close Alarm Sound Selection Dialog")
                }
}}}