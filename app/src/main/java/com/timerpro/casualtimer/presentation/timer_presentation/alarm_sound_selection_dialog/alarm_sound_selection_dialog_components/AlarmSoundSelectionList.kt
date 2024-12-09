package com.timerpro.casualtimer.presentation.timer_presentation.alarm_sound_selection_dialog.alarm_sound_selection_dialog_components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.timerpro.casualtimer.data.casual_timer_screen_data.casual_timer_datastore.CasualTimerDatastore
import com.timerpro.casualtimer.data.timer_data.timer_dimensions.alarm_sound_selection_dialog_dimensions.AlarmSoundSelectionDialogDimensions
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates

@Composable
fun AlarmSoundSelectionList(
    configuration: Configuration,
    casualTimerDatastore: CasualTimerDatastore
) {

    // Alarm Sound Selection List Layout
    Column(
        verticalArrangement = Arrangement.spacedBy(space = AlarmSoundSelectionDialogDimensions(configuration).listSpacing.dp),
    ){
        timerStates.alarmSoundNames.forEach { selectedAlarmSound ->

            AlarmSoundSelectionListPanel(
                configuration = configuration,
                text = selectedAlarmSound,
                casualTimerDatastore = casualTimerDatastore)
    }
    }}