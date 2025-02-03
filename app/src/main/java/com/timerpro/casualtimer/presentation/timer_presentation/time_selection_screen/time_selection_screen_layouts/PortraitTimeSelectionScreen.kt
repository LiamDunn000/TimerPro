package com.timerpro.casualtimer.presentation.timer_presentation.time_selection_screen.time_selection_screen_layouts

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.media.MediaPlayer
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.timerpro.casualtimer.data.timer_data.timer_dimensions.time_selection_screen_dimensions.TimeSelectionScreenDimensions
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates
import com.timerpro.casualtimer.functionality.general_functionality.generalFunctionality
import com.timerpro.casualtimer.presentation.shared_presentation.GeneralPurposeButton
import com.timerpro.casualtimer.presentation.shared_presentation.TextOnlyButton
import com.timerpro.casualtimer.presentation.shared_presentation.TimeSelector
import com.timerpro.casualtimer.presentation.timer_presentation.add_preset_time_dialog.PresetTimeDialog
import com.timerpro.casualtimer.presentation.timer_presentation.alarm_sound_selection_dialog.AlarmSoundSelection
import com.timerpro.casualtimer.presentation.timer_presentation.count_down_timer_screen.CountDownTimerScreen
import com.timerpro.casualtimer.presentation.timer_presentation.time_selection_screen.time_selection_screen_components.PresetTimeList

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PortraitTimeSelectionScreen(
    configuration: Configuration,
    modifier: Modifier = Modifier,
    dimensions: TimeSelectionScreenDimensions = TimeSelectionScreenDimensions(configuration),
    context: Context,
    alarmPlayer: MediaPlayer
) {

    // Logic That Closes Application When Back Button Is Pressed
    BackHandler { if (timerStates.selectedPresetTimeList.isNotEmpty())
        timerStates.selectedPresetTimeList = listOf() else
        (context as? Activity)?.moveTaskToBack(true) }

    // Move Slide To Timer If Deep Link Is Clicked
    generalFunctionality.moveSliderToTimerIfDeepLinkIsClicked(context)

    AnimatedContent(targetState = timerStates.isTimerScreenVisible,

    ) { isTimerScreenActive ->

        // Conditional That Determines Which Screen Is Visible
        when {

            // Transitions To Portrait Count Down Timer Screen
            isTimerScreenActive -> CountDownTimerScreen(
                context = context,
                configuration = configuration,
                alarmPlayer = alarmPlayer)

            // Transitions To Portrait Time Selection Screen
            !isTimerScreenActive ->
                Scaffold(

                    // Portrait Timer Selection Screen Top Bar
                    topBar = {

                        // Portrait Timer Selection Screen Top Bar Layout
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                            ) {

                            // Portrait Add Preset Time Button
                           TextOnlyButton(title = "Open Preset Time Dialog")

                            // Portrait Open Alarm Sound Selection Dialog Button
                            TextOnlyButton(title = "Open Alarm Sound Selection Dialog")

                             }}) {

                    // Portrait Add Preset Time Dialog
                    PresetTimeDialog(configuration = configuration)

                    // Portrait Alarm Sound Selection Dialog
                    AlarmSoundSelection()

                    // Portrait Timer Selection Screen Layout
                    Column(
                        modifier = Modifier
                            .padding(
                                horizontal = dimensions.portraitHorizontalPadding,
                                vertical = dimensions.portraitVerticalPadding
                            )
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween) {

                        // Portrait Time Selection Screen Top Spacer
                       Spacer(modifier.weight(dimensions.portraitTopSpacerWeight))

                         // Portrait Time Selection Panel
                         Row(
                             horizontalArrangement = Arrangement.spacedBy(dimensions.timeSelectorSpacing),
                             ) {

                             // Portrait Hours Selector
                             TimeSelector(
                                 configuration = configuration,
                                 title = "Hours Selector")

                             // Portrait Minutes Selector
                             TimeSelector(
                                 configuration = configuration,
                                 title = "Minutes Selector")

                             // Portrait Seconds Selector
                             TimeSelector(
                                 configuration = configuration,
                                 title = "Seconds Selector")
                         }

                        // Portrait Preset Time List
                        Box(
                            modifier
                                .weight(animateFloatAsState(targetValue = dimensions.portraitPresetTimeListWeight).value),
                            contentAlignment = Alignment.Center
                        ) {
                            PresetTimeList(
                                context = context,
                                configuration = configuration,
                                orientation = "Portrait")
                        }

                        // Portrait Start Timer Button
                        GeneralPurposeButton(
                            configuration = configuration,
                            title = "Start Timer")

                    }
                }
        }
    }
}