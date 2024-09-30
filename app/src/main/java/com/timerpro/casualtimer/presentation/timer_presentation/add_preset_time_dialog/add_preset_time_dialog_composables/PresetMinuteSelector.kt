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
fun PresetMinuteSelector(
    context: Context,
    size: Int,
    fontSize: Int,
    buttonSize: Int,
    iconSize: Int,
    verticalSpacing: Int
) {

    // Manage Minute TextField States
    timerTextFieldStateFunctionality.managePresetMinuteTextFieldStates()

    // Preset Minute Selector Layout
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(verticalSpacing.dp)) {

        // Preset Minute Selector Increment Button
        IncrementTimeButton(
            onClick = { incrementAndDecrementTimeFunctionality.incrementPresetMinutes(context = context)},
            size = buttonSize,
            iconSize = iconSize)

        // Preset Minute Selector TextField
        TextField(
            value = timerStates.presetMinuteInput,
            onValueChange = { newMinutes ->

                // Conditional That Validates Preset Minutes Text Field
                when {

                    // Checks If Preset Minutes TextField Is Empty
                    newMinutes.text.isEmpty()
                    -> { timerStates.presetMinuteInput = TextFieldValue("") }

                    // Checks If Preset Minutes TextField Is Between 0 & 2 Digits
                    newMinutes.text.length in 0..2 &&

                            // Checks If Preset Minutes TextField Is Less Than 60
                            newMinutes.text.toInt() < 60 &&

                            // Checks If Preset Minutes TextField Is Only Digits
                            newMinutes.text.isDigitsOnly()
                    -> { timerStates.presetMinuteInput = newMinutes }}},

            modifier = Modifier
                .size(size.dp)
                .focusRequester(timerStates.presetMinutesFocusRequester)
                .onFocusChanged { focusState ->
                    timerStates.isPresetMinutesTextFieldFocused = focusState.isFocused },

            singleLine = true,
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

        // Preset Minute Selector Decrement Button
        DecrementTimeButton(
            onClick = { incrementAndDecrementTimeFunctionality.decrementPresetMinutes(context = context) },
            size = buttonSize,
            iconSize = iconSize
        )
    }
}