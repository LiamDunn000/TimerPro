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
fun SecondSelector(
    context: Context,
    size: Int,
    fontSize: Int,
    buttonSize: Int,
    iconSize: Int,
    verticalSpacing: Int
) {

    // Manage Second TextField States
    timerTextFieldStateFunctionality.manageSecondTextFieldStates()

    // Second Selector Layout
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(verticalSpacing.dp)
    ) {

        // Second Selector Increment Button
        IncrementTimeButton(
            onClick = { incrementAndDecrementTimeFunctionality.incrementSeconds(context = context) },
            size = buttonSize,
            iconSize = iconSize)

        // Second Selector TextField
        TextField(
            value = timerStates.secondInput,
            onValueChange = { newSeconds ->

                // Conditional That Validates Second TextField
                when {

                    // Checks If The Second TextField Is Empty
                    newSeconds.text.isEmpty()
                    -> { timerStates.secondInput = TextFieldValue("") }

                    // Checks If Second Text Field Is Between 0 & 2 Digits
                    newSeconds.text.length in 0..2 &&

                            // Checks If Second Text Field Is Less Than 60
                            newSeconds.text.toInt() < 60 &&

                            // Checks If Second Text Field Is Only Digits
                            newSeconds.text.isDigitsOnly() -> {
                        timerStates.secondInput = newSeconds }}},

            modifier = Modifier
                .size(size =  size.dp)
                .focusRequester(timerStates.secondsFocusRequester)
                .onFocusChanged { focusState ->
                    timerStates.isSecondTextFieldFocused = focusState.isFocused },

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

        // Second Selector Decrement Button
        DecrementTimeButton(
            onClick = { incrementAndDecrementTimeFunctionality.decrementSeconds(context = context) },
            size = buttonSize,
            iconSize = iconSize) }
}