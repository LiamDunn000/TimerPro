package com.timerpro.casualtimer.presentation.stopwatch_presentation.stopwatch_composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.timerpro.casualtimer.data.stopwatch_data.stopwatch_colors.StopwatchColors
import com.timerpro.casualtimer.data.shared_data.FormattedText

@Composable
fun CurrentStopwatchTimeDisplay(
    timeFontSize: Int,
    millisecondsFontSize: Int) {

    // Current Stopwatch Time Display
    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(
                fontSize = timeFontSize.sp
            ),
            ) {
                // Current Stopwatch Time Display
                append(FormattedText().formattedCurrentStopwatchTimeText)
            }

            // Current Stopwatch Milliseconds Display
            append(FormattedText().formattedCurrentStopwatchMillisecondsText)
        },
        color =  StopwatchColors().currentStopwatchTimeDisplayFontColor,
        fontSize = millisecondsFontSize.sp,
        fontWeight = FontWeight.SemiBold
    )
}