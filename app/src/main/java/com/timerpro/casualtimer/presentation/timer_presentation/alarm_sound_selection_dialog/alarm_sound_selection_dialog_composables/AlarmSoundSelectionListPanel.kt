package com.timerpro.casualtimer.presentation.timer_presentation.alarm_sound_selection_dialog.alarm_sound_selection_dialog_composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.timerpro.casualtimer.data.casual_timer_screen_data.casual_timer_datastore.CasualTimerDatastore
import com.timerpro.casualtimer.data.timer_data.timer_colors.timerColors
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates
import com.timerpro.casualtimer.functionality.timer_functionality.alarmStateFunctionality

@Composable
fun AlarmSoundSelectionListPanel(
    text: String,
    fontSize: Int,
    buttonSize: Int,
    buttonBorderWidth: Int,
    casualTimerDatastore: CasualTimerDatastore
) {

    // Alarm Sound Selection List Panel Layout
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        // Alarm Sound Selection List Panel Text
        Text(
            text = text,
            fontSize = fontSize.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .selectable(
                    selected = (text == timerStates.selectedAlarmSoundName),
                    onClick = {
                        timerStates.selectedAlarmSoundName = text
                        alarmStateFunctionality.saveAlarmSound(casualTimerDatastore)}),

            // Conditional That Determines Text Color
            color = when{ text == timerStates.selectedAlarmSoundName ->
                timerColors.selectedTextAndRadioButtonColor
                else -> timerColors.unselectedTextAndRadioButtonColor })


        CustomRadioButton(
            text = text,
            buttonSize = buttonSize,
            buttonBorderWidth = buttonBorderWidth) }}