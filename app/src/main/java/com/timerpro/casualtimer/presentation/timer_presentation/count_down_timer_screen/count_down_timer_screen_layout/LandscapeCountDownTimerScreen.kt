package com.timerpro.casualtimer.presentation.timer_presentation.count_down_timer_screen.count_down_timer_screen_layout

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.media.MediaPlayer
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
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
import com.timerpro.casualtimer.data.timer_data.timer_dimensions.count_down_timer_dimensions.LandscapeCountDownTimerScreenDimensions
import com.timerpro.casualtimer.data.timer_data.timer_dimensions.count_down_timer_dimensions.PortraitCountDownTimerScreenDimensions
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates
import com.timerpro.casualtimer.presentation.timer_presentation.count_down_timer_screen.count_down_timer_screen_composables.CancelTimerButton
import com.timerpro.casualtimer.presentation.timer_presentation.count_down_timer_screen.count_down_timer_screen_composables.ToggleTimerButton
import com.timerpro.casualtimer.presentation.timer_presentation.times_up_screen.times_up_screen_layouts.LandscapeTimesUpScreen

@Composable
fun LandscapeCountDownTimerScreen(
    context: Context,
    configuration: Configuration,
    mediaPlayer: MediaPlayer
) {

    // Logic That Closes Application When Back Button Is Pressed
    BackHandler{ (context as? Activity)?.moveTaskToBack(true)}

    // Animates Screen Transition
    AnimatedContent(targetState = timerStates.isTimeUp) { isTimeUp ->

        // Conditional That Determines Which Screen Is Visible
        when {isTimeUp ->{

            // Transitions To Landscape Times Up Screen
            LandscapeTimesUpScreen(
                context = context,
                configuration = configuration,
                mediaPlayer = mediaPlayer)

        } else -> {

            // Transitions To Landscape Count Down Timer Screen
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                // Landscape Initial Time
                Text(
                    text = FormattedText().formattedInitialTimeText,
                    fontSize = LandscapeCountDownTimerScreenDimensions(configuration).landscapeInitialTimeFontSize.sp
                )

                // Landscape Timer Text
                Text(
                    text = FormattedText().formattedCountDownTimerText,
                    fontSize = LandscapeCountDownTimerScreenDimensions(configuration).landscapeCountDownTimerFontSize.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(PortraitCountDownTimerScreenDimensions(configuration).portraitCountDownTimerScreenButtonSpacing.dp)
                ) {

                    // Landscape Toggle Timer Button
                    ToggleTimerButton(
                        context = context,
                        width = LandscapeCountDownTimerScreenDimensions(configuration).landscapeCountDownTimerScreenButtonWidth,
                        height = LandscapeCountDownTimerScreenDimensions(configuration).landscapeCountDownTimerScreenButtonHeight,
                        fontSize = LandscapeCountDownTimerScreenDimensions(configuration).landscapeCountDownTimerScreenButtonFontSize)

                    // Landscape Cancel Timer Button
                    CancelTimerButton(context = context,
                        width = LandscapeCountDownTimerScreenDimensions(configuration).landscapeCountDownTimerScreenButtonWidth,
                        height = LandscapeCountDownTimerScreenDimensions(configuration).landscapeCountDownTimerScreenButtonHeight,
                        fontSize = LandscapeCountDownTimerScreenDimensions(configuration).landscapeCountDownTimerScreenButtonFontSize) }
            }
        }}}
}