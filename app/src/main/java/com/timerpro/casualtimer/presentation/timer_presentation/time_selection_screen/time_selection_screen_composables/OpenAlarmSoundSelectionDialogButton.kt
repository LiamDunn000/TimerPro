package com.timerpro.casualtimer.presentation.timer_presentation.time_selection_screen.time_selection_screen_composables

import android.content.Context
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates
import com.timerpro.casualtimer.functionality.casual_timer_screen_functionality.casualTimerScreenFunctionality

@Composable
fun OpenAlarmSoundSelectionDialogButton(
    context: Context,
    fontSize: Int) {

    // Open Alarm Sound Selection Dialog Button
    TextButton(onClick = {
        casualTimerScreenFunctionality.vibrateOnButtonClick(context = context)
        timerStates.isAlarmSoundSelectionDialogOpen = true

    }) {

        // Open Alarm Sound Selection Dialog Button Text
        Text(
            text = "Select Alarm Sound",
            fontSize = fontSize.sp)
    }
}