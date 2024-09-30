package com.timerpro.casualtimer.presentation.timer_presentation.add_preset_time_dialog.add_preset_time_dialog_composables

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.timerpro.casualtimer.data.timer_data.timer_colors.timerColors
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates

@Composable
fun PresetTimeNameTextField(
    width: Int,
    height: Int,
    fontSize: Int
) {

    TextField(
        value = timerStates.presetTimeNameTextFieldValue,
        onValueChange = { timerStates.presetTimeNameTextFieldValue = it},
        textStyle = TextStyle(
            fontSize = fontSize.sp,
        ),
        placeholder = {
            Text("Preset Time Name",
            fontSize = fontSize.sp)},
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = timerColors.timerTextFieldColor,
            focusedContainerColor = timerColors.timerTextFieldColor,
        ),
        singleLine = true,
        modifier = Modifier
            .width(width = width.dp)
            .height(height = height.dp)
    )
}