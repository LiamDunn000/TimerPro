package com.timerpro.casualtimer.presentation.timer_presentation.count_down_timer_screen

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
import androidx.compose.ui.unit.sp
import com.timerpro.casualtimer.data.shared_data.FormattedText
import com.timerpro.casualtimer.data.timer_data.timer_dimensions.count_down_timer_dimensions.CountDownTimerScreenDimensions
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates
import com.timerpro.casualtimer.presentation.shared_presentation.GeneralPurposeButton
import com.timerpro.casualtimer.presentation.timer_presentation.times_up_screen.TimesUpScreen

@Composable
fun CountDownTimerScreen(
    context: Context,
    configuration: Configuration,
    dimensions: CountDownTimerScreenDimensions = CountDownTimerScreenDimensions(configuration),
    alarmPlayer: MediaPlayer) {

    // Logic That Closes Application When Back Button Is Pressed
    BackHandler{ (context as? Activity)?.moveTaskToBack(true)}

    // Animates Screen Transition
    AnimatedContent(targetState = timerStates.isTimeUp) { isTimeUp ->

        // Conditional That Determines Which Screen Is Visible
        when {isTimeUp ->{

            // Transitions To Portrait Times Up Screen
            TimesUpScreen(
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
                    fontSize = dimensions.initialTimeFontSize.sp
                )

                // Portrait Timer Text
                Text(
                    text = FormattedText().formattedCountDownTimerText,
                    fontSize = dimensions.countDownTimerFontSize.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Row()
                {

                    // Portrait Toggle Timer Button
                    GeneralPurposeButton(
                        configuration = configuration,
                        title = "Toggle Timer"
                    )

                    // Portrait Cancel Timer Button
                    GeneralPurposeButton(
                        configuration = configuration,
                        title = "Cancel Timer"
                    )

                }}}}}}