package com.timerpro.casualtimer.presentation.timer_presentation.time_selection_screen.time_selection_screen_composables

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

@Composable
fun MinuteSelector(
    context: Context,
    size: Int,
    fontSize: Int,
    buttonSize: Int,
    iconSize: Int,
    verticalSpacing: Int
) {

    // Manage Minute TextField States
    timerTextFieldStateFunctionality.manageMinuteTextFieldStates()

    // Minute Selector Layout
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(verticalSpacing.dp)) {

        // Minute Selector Increment Button
        IncrementTimeButton(
            onClick = { incrementAndDecrementTimeFunctionality.incrementMinutes(context = context) },
            size = buttonSize,
            iconSize = iconSize)

        // Minute Selector TextField
        TextField(
            value = timerStates.minuteInput,
            onValueChange = { newMinutes ->

                // Conditional That Validates Minutes Text Field
                when {

                    // Checks If Minutes TextField Is Empty
                    newMinutes.text.isEmpty()
                    -> { timerStates.minuteInput = TextFieldValue("") }

                    // Checks If Minutes TextField Is Between 0 & 2 Digits
                    newMinutes.text.length in 0..2 &&

                            // Checks If Minutes TextField Is Less Than 60
                            newMinutes.text.toInt() < 60 &&

                            // Checks If Minutes TextField Is Only Digits
                            newMinutes.text.isDigitsOnly()
                    -> { timerStates.minuteInput = newMinutes }}},

            modifier = Modifier
                .size(size = size.dp)
                .focusRequester(timerStates.minutesFocusRequester)
                .onFocusChanged { focusState ->
                    timerStates.isMinutesTextFieldFocused = focusState.isFocused },

            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number),

            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = timerColors.timerTextFieldColor,
                focusedContainerColor = timerColors.timerTextFieldColor,
                unfocusedIndicatorColor = timerColors.timerTextFieldColor,
                focusedIndicatorColor = timerColors.timerTextFieldColor,
                cursorColor = timerColors.timerTextFieldColor),

            textStyle = TextStyle(
                fontSize = fontSize.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center),)

        // Minute Selector Decrement Button
        DecrementTimeButton(
            onClick = { incrementAndDecrementTimeFunctionality.decrementMinutes(context = context) },
            size = buttonSize,
            iconSize = iconSize)
    }
}