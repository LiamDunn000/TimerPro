package com.timerpro.casualtimer.presentation.shared_presentation

import android.content.res.Configuration
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.timerpro.casualtimer.data.shared_data.Colors
import com.timerpro.casualtimer.data.shared_data.dimensions.TimeSelectorDimensions
import com.timerpro.casualtimer.functionality.shared_presentation_management.TimeSelectorManagement

@Composable
fun TimeSelector(
    configuration: Configuration,
    dimensions: TimeSelectorDimensions = TimeSelectorDimensions(configuration),
    functionality: TimeSelectorManagement = TimeSelectorManagement(),
    title: String
) {

    // Manage TextField States
    functionality.determineTimeSelectorState(title = title)

    // Time Selector Layout
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(dimensions.verticalSpacing(title = title).dp)) {

        // Time Selector Increment Button
        ModifyTimeButton(
            configuration = configuration,
            title = title,
            action = "Increment",
        )

        // Time Selector TextField
        TextField(
            value = functionality.determineTextFieldValue(title = title),
            onValueChange = { newText ->
                functionality.determineOnValueChange(title = title, newText = newText)
            },

            singleLine = true,
            modifier = Modifier
                .size(dimensions.selectorSize(title = title).dp)
                .focusRequester(functionality.determineFocusRequester(title = title))
                .onFocusChanged { focusState ->
                    functionality.determineFocusState(title = title, focusState = focusState) },

            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number),

            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Colors().transparent,
                focusedContainerColor = Colors().transparent,
                unfocusedIndicatorColor = Colors().transparent,
                focusedIndicatorColor = Colors().transparent
            ),

            textStyle = TextStyle(
                fontSize = dimensions.fontSize(title = title).sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center))

        // Time Selector Decrement Button
        ModifyTimeButton(
            configuration = configuration,
            title = title,
            action = "Decrement",
        )
    }
}