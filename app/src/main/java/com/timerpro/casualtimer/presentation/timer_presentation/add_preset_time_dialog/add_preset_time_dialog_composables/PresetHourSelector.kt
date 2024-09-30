package com.timerpro.casualtimer.presentation.timer_presentation.add_preset_time_dialog.add_preset_time_dialog_composables

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import com.timerpro.casualtimer.data.timer_data.timer_colors.timerColors
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates
import com.timerpro.casualtimer.functionality.timer_functionality.incrementAndDecrementTimeFunctionality
import com.timerpro.casualtimer.functionality.timer_functionality.timerTextFieldStateFunctionality
import com.timerpro.casualtimer.presentation.timer_presentation.time_selection_screen.time_selection_screen_composables.DecrementTimeButton
import com.timerpro.casualtimer.presentation.timer_presentation.time_selection_screen.time_selection_screen_composables.IncrementTimeButton

@Composable
fun PresetHourSelector(
    context: Context,
    size: Int,
    fontSize: Int,
    buttonSize: Int,
    iconSize: Int,
    verticalSpacing: Int
) {

    // Manage Hour TextField States
    timerTextFieldStateFunctionality.managePresetHoursTextFieldStates()

    // Preset Hour Selector Layout
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(verticalSpacing.dp)) {

        // Preset Hour Selector Increment Button
        IncrementTimeButton(
            onClick = { incrementAndDecrementTimeFunctionality.incrementPresetHours(context = context) },
            size = buttonSize,
            iconSize = iconSize)

        // Preset Hour Selector TextField
        TextField(
            value = timerStates.presetHourInput,
            onValueChange = { newHours ->

                // Conditional That Validates Hour Text Field
                when {

                // Checks If Preset Hour Text Field Is Empty
                    newHours.text.isEmpty()
                    -> { timerStates.presetHourInput = TextFieldValue("")}

                    // Checks If Preset Hour Text Field Is Between 0 & 2 Digits
                    newHours.text.length in 0..2 &&

                    // Checks If Preset Hour Text Field Is Less Than 100
                    newHours.text.toInt() < 100 &&

                    // Checks If Preset Hour Text Field Is Only Digits
                    newHours.text.isDigitsOnly()
                    -> { timerStates.presetHourInput = newHours }}},

            singleLine = true,
            modifier = Modifier
                .size(size.dp)
                .focusRequester(timerStates.presetHoursFocusRequester)
                .onFocusChanged { focusState ->
                    timerStates.isPresetHourTextFieldFocused = focusState.isFocused },

            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number),

            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = timerColors.timerTextFieldColor,
                focusedContainerColor = timerColors.timerTextFieldColor,
                unfocusedIndicatorColor = timerColors.timerTextFieldColor,
                focusedIndicatorColor = timerColors.timerTextFieldColor
            ),

            textStyle = TextStyle(
                fontSize = fontSize.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center),)

        // Preset Hour Selector Decrement Button
        DecrementTimeButton(
            onClick = { incrementAndDecrementTimeFunctionality.decrementPresetHours(context = context) },
            size = buttonSize,
            iconSize = iconSize
        )
    }
}