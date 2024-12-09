package com.timerpro.casualtimer.presentation.timer_presentation.times_up_screen

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
import androidx.compose.ui.unit.sp
import com.timerpro.casualtimer.data.shared_data.Colors
import com.timerpro.casualtimer.data.shared_data.FormattedText
import com.timerpro.casualtimer.data.timer_data.timer_dimensions.times_up_screen_dimensions.TimesUpScreenDimensions
import com.timerpro.casualtimer.presentation.shared_presentation.GeneralPurposeButton

@Composable
fun TimesUpScreen(
    context: Context,
    configuration: Configuration,
    dimensions: TimesUpScreenDimensions = TimesUpScreenDimensions(configuration),
    alarmPlayer: MediaPlayer) {

    // Portrait Times Up Message Layout
    Column(
        modifier = Modifier
            .background(color = Colors().white)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Portrait Times Up Text
        Text(
            text = "Times Up!",
            color = Colors().black,
            fontSize = dimensions.timesUpMessageFontSize.sp,
            fontWeight = FontWeight.SemiBold)

        // Portrait Negative Count Down Timer
        Text(
            text = FormattedText().formattedNegativeCountDownTimerText,
            color = Colors().black,
            fontSize = dimensions.negativeCountDownTimerFontSize.sp,
            fontWeight = FontWeight.SemiBold)

        Row {

            //Dismiss Alarm Button
            GeneralPurposeButton(
                configuration = configuration, title = "Dismiss Alarm", alarmPlayer = alarmPlayer)

            //Restart Alarm Button
            GeneralPurposeButton(
                configuration = configuration, title = "Restart Timer", alarmPlayer = alarmPlayer
            )
        }
    }
}