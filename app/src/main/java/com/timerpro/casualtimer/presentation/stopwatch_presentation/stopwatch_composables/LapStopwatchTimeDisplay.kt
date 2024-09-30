package com.timerpro.casualtimer.presentation.stopwatch_presentation.stopwatch_composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.timerpro.casualtimer.data.stopwatch_data.stopwatch_colors.StopwatchColors
import com.timerpro.casualtimer.data.stopwatch_data.stopwatch_states.stopwatchStates
import com.timerpro.casualtimer.data.shared_data.FormattedText

@Composable
fun LapStopwatchTimeDisplay(
    timeFontSize: Int,
    millisecondsFontSize: Int,
    bottomPadding: Int) {

    // Lap Stopwatch Time Display
    AnimatedVisibility(visible = stopwatchStates.isLapStopwatchVisible) {
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(
                    fontSize = timeFontSize.sp),
                    ) {

                    // Lap Stopwatch Time Display
                    append(FormattedText().formattedLapStopwatchTimeText)
                }

                // Lap Stopwatch Milliseconds Display
                append(FormattedText().formattedLapStopwatchMillisecondsText)
            },
            modifier = Modifier.padding(bottom = bottomPadding.dp),
            color = StopwatchColors().lapStopwatchTimeDisplayFontColor,
            fontSize = millisecondsFontSize.sp,
            fontWeight = FontWeight.SemiBold) }}