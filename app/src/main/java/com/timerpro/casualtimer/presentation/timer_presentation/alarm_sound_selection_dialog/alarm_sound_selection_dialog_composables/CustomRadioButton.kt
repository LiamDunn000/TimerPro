package com.timerpro.casualtimer.presentation.timer_presentation.alarm_sound_selection_dialog.alarm_sound_selection_dialog_composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.timerpro.casualtimer.data.timer_data.timer_colors.timerColors
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates

@Composable
fun CustomRadioButton(
    text: String,
    buttonSize: Int,
    buttonBorderWidth: Int
) {

    // Custom Radio Button Layout
    Box(modifier = Modifier
        .selectable(
            selected = (text == timerStates.selectedAlarmSoundName),
            onClick = { timerStates.selectedAlarmSoundName = text})
        .size(buttonSize.dp)
        .clip(shape = CircleShape)
        .border(

            // Conditional That Determines Border Color
            color =  when{ text == timerStates.selectedAlarmSoundName ->
                timerColors.selectedTextAndRadioButtonColor
                else -> timerColors.unselectedTextAndRadioButtonColor },

            width = buttonBorderWidth.dp,
            shape = CircleShape),
        contentAlignment = Alignment.Center){

        // Custom Radio Button Indicator
        Box(modifier = Modifier
            .background(

                // Conditional That Determines Indicator Color
                color = when{ text == timerStates.selectedAlarmSoundName ->
                    timerColors.selectedTextAndRadioButtonColor
                    else -> Color.Transparent },

                shape = CircleShape)
            .fillMaxSize(0.5f)) }}