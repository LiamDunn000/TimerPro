package com.timerpro.casualtimer.presentation.timer_presentation.times_up_screen.times_up_screen_layouts

import android.content.Context
import android.content.res.Configuration
import android.media.MediaPlayer
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.timerpro.casualtimer.data.shared_data.FormattedText
import com.timerpro.casualtimer.data.timer_data.timer_colors.timerColors
import com.timerpro.casualtimer.data.timer_data.timer_dimensions.times_up_message_dimensions.LandscapeTimesUpScreenDimensions
import com.timerpro.casualtimer.data.timer_data.timer_dimensions.times_up_message_dimensions.PortraitTimesUpScreenDimensions
import com.timerpro.casualtimer.functionality.timer_functionality.alarmStateFunctionality
import com.timerpro.casualtimer.functionality.timer_functionality.timerStateFunctionality
import com.timerpro.casualtimer.presentation.timer_presentation.times_up_screen.times_up_screen_composables.DismissAlarmButton
import com.timerpro.casualtimer.presentation.timer_presentation.times_up_screen.times_up_screen_composables.RestartTimerButton

@Composable
fun LandscapeTimesUpScreen(
    context: Context,
    configuration: Configuration,
    mediaPlayer: MediaPlayer
) {

    // Landscape Times Up Message Layout
    Column(
        modifier = Modifier
            .background(color = timerColors.timesUpScreenBackgroundColor)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Landscape Times Up Text
        Text(
            text = "Times Up!",
            color = timerColors.timesUpScreenFontColor,
            fontSize = LandscapeTimesUpScreenDimensions(configuration).landscapeTimesUpMessageFontSize.sp,
            fontWeight = FontWeight.SemiBold)

        // Landscape Negative Count Down Timer
        Text(
            text = FormattedText().formattedNegativeCountDownTimerText,
            color = timerColors.timesUpScreenFontColor,
            fontSize = LandscapeTimesUpScreenDimensions(configuration).landscapeNegativeCountDownTimerFontSize.sp,
            fontWeight = FontWeight.SemiBold)

        Row(
            horizontalArrangement = Arrangement.spacedBy(PortraitTimesUpScreenDimensions(configuration).portraitTimesUpScreenButtonSpacing.dp)
        ) {

            // Landscape Dismiss Alarm Button
            DismissAlarmButton(
                onClick = { alarmStateFunctionality.dismissAlarm(context, mediaPlayer) },
                width = LandscapeTimesUpScreenDimensions(configuration).landscapeTimesUpScreenButtonWidth,
                height = LandscapeTimesUpScreenDimensions(configuration).landscapeTimesUpScreenButtonHeight,
                fontSize = LandscapeTimesUpScreenDimensions(configuration).landscapeTimesUpScreenButtonFontSize)

            // Landscape Restart Alarm Button
            RestartTimerButton(
                onClick = { timerStateFunctionality.restartTimer(context, mediaPlayer) },
                width = LandscapeTimesUpScreenDimensions(configuration).landscapeTimesUpScreenButtonWidth,
                height = LandscapeTimesUpScreenDimensions(configuration).landscapeTimesUpScreenButtonHeight,
                fontSize = LandscapeTimesUpScreenDimensions(configuration).landscapeTimesUpScreenButtonFontSize)
        }
    }
}