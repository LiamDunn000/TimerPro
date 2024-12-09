package com.timerpro.casualtimer.presentation.timer_presentation.alarm_sound_selection_dialog.alarm_sound_selection_dialog_components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.timerpro.casualtimer.data.casual_timer_screen_data.casual_timer_datastore.CasualTimerDatastore
import com.timerpro.casualtimer.data.shared_data.Colors
import com.timerpro.casualtimer.data.timer_data.timer_dimensions.alarm_sound_selection_dialog_dimensions.AlarmSoundSelectionDialogDimensions
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates
import com.timerpro.casualtimer.functionality.timer_functionality.alarmStateFunctionality
import com.timerpro.casualtimer.presentation.shared_presentation.CustomRadioButton

@Composable
fun AlarmSoundSelectionListPanel(
    configuration: Configuration,
    text: String,
    casualTimerDatastore: CasualTimerDatastore
) {

    // Alarm Sound Selection List Panel Layout
    Row(
        modifier = Modifier
            .selectable(
                selected = (text == timerStates.selectedAlarmSoundName),
                onClick = {
                    timerStates.selectedAlarmSoundName = text
                    alarmStateFunctionality.saveAlarmSound(casualTimerDatastore)})
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        // Alarm Sound Selection List Panel Text
        Text(
            text = text,
            fontSize = AlarmSoundSelectionDialogDimensions(configuration).alarmSoundNameFontSize,
            fontWeight = FontWeight.SemiBold,

            // Conditional That Determines Text Color
            color = when{ text == timerStates.selectedAlarmSoundName ->
                Colors().lightBlue
                else -> Colors().lightGray })


        CustomRadioButton(
            configuration = configuration,
            title = "Alarm Button",
            text = text)
    }
}