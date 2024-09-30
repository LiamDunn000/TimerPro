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
import com.timerpro.casualtimer.data.timer_data.timer_dimensions.count_down_timer_dimensions.PortraitCountDownTimerScreenDimensions
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates
import com.timerpro.casualtimer.presentation.timer_presentation.count_down_timer_screen.count_down_timer_screen_composables.CancelTimerButton
import com.timerpro.casualtimer.presentation.timer_presentation.count_down_timer_screen.count_down_timer_screen_composables.ToggleTimerButton
import com.timerpro.casualtimer.presentation.timer_presentation.times_up_screen.times_up_screen_layouts.PortraitTimesUpScreen

@Composable
fun PortraitCountDownTimerScreen(
    context: Context,
    configuration: Configuration,
    alarmPlayer: MediaPlayer) {

    // Logic That Closes Application When Back Button Is Pressed
    BackHandler{ (context as? Activity)?.moveTaskToBack(true)}

    // Animates Screen Transition
    AnimatedContent(targetState = timerStates.isTimeUp) { isTimeUp ->

        // Conditional That Determines Which Screen Is Visible
        when {isTimeUp ->{

            // Transitions To Portrait Times Up Screen
            PortraitTimesUpScreen(
                context = context,
                configuration = configuration,
                alarmPlayer = alarmPlayer)

        } else -> {

            // Transitions To Portrait Count Down Timer Screen
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                // Portrait Initial Time
                Text(
                    text = FormattedText().formattedInitialTimeText,
                    fontSize = PortraitCountDownTimerScreenDimensions(configuration).portraitInitialTimeFontSize.sp
                )

                // Portrait Timer Text
                Text(
                    text = FormattedText().formattedCountDownTimerText,
                    fontSize = PortraitCountDownTimerScreenDimensions(configuration).portraitCountDownTimerFontSize.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(PortraitCountDownTimerScreenDimensions(configuration).portraitCountDownTimerScreenButtonSpacing.dp)) {

                    // Portrait Toggle Timer Button
                    ToggleTimerButton(
                        context = context,
                        width = PortraitCountDownTimerScreenDimensions(configuration).portraitCountDownTimerScreenButtonWidth,
                        height = PortraitCountDownTimerScreenDimensions(configuration).portraitCountDownTimerScreenButtonHeight,
                        fontSize = PortraitCountDownTimerScreenDimensions(configuration).portraitCountDownTimerScreenButtonFontSize)

                    // Portrait Cancel Timer Button
                    CancelTimerButton(context = context,
                        width = PortraitCountDownTimerScreenDimensions(configuration).portraitCountDownTimerScreenButtonWidth,
                        height = PortraitCountDownTimerScreenDimensions(configuration).portraitCountDownTimerScreenButtonHeight,
                        fontSize = PortraitCountDownTimerScreenDimensions(configuration).portraitCountDownTimerScreenButtonFontSize) }}}}}}