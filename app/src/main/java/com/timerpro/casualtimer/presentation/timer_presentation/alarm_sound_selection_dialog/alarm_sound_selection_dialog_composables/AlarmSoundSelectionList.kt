package com.timerpro.casualtimer.presentation.timer_presentation.alarm_sound_selection_dialog.alarm_sound_selection_dialog_composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.timerpro.casualtimer.data.casual_timer_screen_data.casual_timer_datastore.CasualTimerDatastore
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates

@Composable
fun AlarmSoundSelectionList(
    fontSize: Int,
    buttonSize: Int,
    buttonBorderWidth: Int,
    spacing: Int,
    casualTimerDatastore: CasualTimerDatastore
) {

    // Alarm Sound Selection List Layout
    Column(
        verticalArrangement = Arrangement.spacedBy(space = spacing.dp),
    ){
        timerStates.alarmSoundNames.forEach { selectedAlarmSound ->

            AlarmSoundSelectionListPanel(
                text = selectedAlarmSound,
                fontSize = fontSize,
                buttonSize = buttonSize,
                buttonBorderWidth = buttonBorderWidth,
                casualTimerDatastore = casualTimerDatastore)
    }
    }}