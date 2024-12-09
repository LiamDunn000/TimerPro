package com.timerpro.casualtimer.presentation.stopwatch_presentation.stopwatch_components

import android.content.res.Configuration
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import com.timerpro.casualtimer.data.shared_data.Colors
import com.timerpro.casualtimer.data.shared_data.FormattedText
import com.timerpro.casualtimer.data.stopwatch_data.stopwatch_dimensions.StopwatchScreenDimensions

@Composable
fun StopwatchTimeDisplay(
    configuration: Configuration,
    dimensions: StopwatchScreenDimensions = StopwatchScreenDimensions(configuration),
    timerType: String
    ) {

    // Current Stopwatch Time Display
    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(
                fontSize = if (timerType == "Current") dimensions.currentTimeFontSize
                else dimensions.lapTimeFontSize,
            ),
            ) {
                // Time Display
                append(if (timerType == "Current") FormattedText().formattedCurrentStopwatchTimeText
                else FormattedText().formattedLapStopwatchTimeText )
            }

            // Milliseconds Display
            append(
                if (timerType == "Current") FormattedText().formattedCurrentStopwatchMillisecondsText
                else FormattedText().formattedLapStopwatchMillisecondsText)
        },
        color =  if (timerType == "Current") Colors().black else Colors().gray,
        fontSize = if (timerType == "Current") dimensions.currentMillisecondsFontSize else dimensions.lapMillisecondsFontSize,
        fontWeight = FontWeight.SemiBold
    )
}