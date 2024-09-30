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
fun HourSelector(
    context: Context,
    size: Int,
    fontSize: Int,
    buttonSize: Int,
    iconSize: Int,
    verticalSpacing: Int
) {

    // Manage Hour TextField States
    timerTextFieldStateFunctionality.manageHoursTextFieldStates()

    // Hour Selector Layout
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(verticalSpacing.dp)) {

        // Hour Selector Increment Button
       IncrementTimeButton(
           onClick = { incrementAndDecrementTimeFunctionality.incrementHours(context = context) },
           size = buttonSize,
           iconSize = iconSize)

        // Hour Selector TextField
        TextField(
            value = timerStates.hourInput,
            onValueChange = { newHours ->

                // Conditional That Validates Hour Text Field
                when {

                    // Checks If Hour Text Field Is Empty
                    newHours.text.isEmpty()
                    -> { timerStates.hourInput = TextFieldValue("")
                    }

                    // Checks If Hour Text Field Is Between 0 & 2 Digits
                    (newHours.text.length in 0..2 &&

                            // Checks If Hour Text Field Is Less Than 100
                            newHours.text.toInt() < 100 &&

                            // Checks If Hour Text Field Is Only Digits
                            newHours.text.isDigitsOnly())
                    -> { timerStates.hourInput = newHours }}},

            singleLine = true,
            modifier = Modifier
                .size(size = size.dp)
                .focusRequester(timerStates.hoursFocusRequester)
                .onFocusChanged { focusState ->
                    timerStates.isHoursTextFieldFocused = focusState.isFocused },

            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number),

            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = timerColors.timerTextFieldColor,
                focusedContainerColor = timerColors.timerTextFieldColor,
                unfocusedIndicatorColor = timerColors.timerTextFieldColor,
                focusedIndicatorColor = timerColors.timerTextFieldColor,
                cursorColor = timerColors.timerTextFieldColor
            ),

            textStyle = TextStyle(
                fontSize = fontSize.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center),)

        // Hour Selector Decrement Button
        DecrementTimeButton(
            onClick = { incrementAndDecrementTimeFunctionality.decrementHours(context = context) },
            size = buttonSize,
            iconSize = iconSize)
    }
}