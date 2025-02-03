package com.timerpro.casualtimer.presentation.timer_presentation.time_selection_screen.time_selection_screen_layouts

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.media.MediaPlayer
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.timerpro.casualtimer.data.shared_data.Colors
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
fun LandscapeTimeSelectionScreen(
    configuration: Configuration,
    dimensions: TimeSelectionScreenDimensions = TimeSelectionScreenDimensions(configuration),
    context: Context,
    alarmPlayer: MediaPlayer) {

    // Logic That Closes Application When Back Button Is Pressed
    BackHandler{ (context as? Activity)?.moveTaskToBack(true)}

    // Move Slide To Timer If Deep Link Is Clicked
    generalFunctionality.moveSliderToTimerIfDeepLinkIsClicked(context)

    AnimatedContent(targetState = timerStates.isTimerScreenVisible) { isTimerScreenActive ->

        // Conditional That Determines Which Screen Is Visible
        when {

            // Transitions To Landscape Count Down Timer Screen
            isTimerScreenActive -> CountDownTimerScreen(
                context = context,
                configuration = configuration,
                alarmPlayer = alarmPlayer)

            // Transitions To Landscape Time Selection Screen
            !isTimerScreenActive -> {
        Scaffold(

            // Landscape Time Selection Screen Top Bar
            topBar = {

                // Landscape Timer Selection Screen Top Bar Layout
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween) {

                    // Landscape Open Add Preset Time Dialog Button
                   TextOnlyButton(title = "Open Preset Time Dialog")

                    // Landscape Open Alarm Sound Selection List Button
                   TextOnlyButton(title = "Open Alarm Sound Selection Dialog")
                }}) {

            // Landscape Add Preset Time Dialog
            PresetTimeDialog(configuration = configuration)

            // Landscape Alarm Sound Selection Dialog
            AlarmSoundSelection()

            // Landscape Stopwatch Screen Layout
            Row(
                modifier = Modifier
                    .background(color = Colors().white)
                    .padding(vertical = dimensions.landscapeVerticalPadding)
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                // Left Landscape Time Selection Screen Panel
                Column(
                    modifier = Modifier
                        .width(dimensions.landscapePanelWidth.dp)
                        .fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {


                    // Landscape Time Selection Screen Text Field Panel
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(dimensions.timeSelectorSpacing),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        // Landscape Hours Selector
                        TimeSelector(
                            configuration = configuration,
                            title = "Hours Selector")

                        // Landscape Minutes Selector
                        TimeSelector(
                            configuration = configuration,
                            title = "Minutes Selector")


                        // Landscape Seconds Selector
                        TimeSelector(
                            configuration = configuration,
                            title = "Seconds Selector")
                    }

                    // Landscape Start Timer Button
                    GeneralPurposeButton(
                        configuration = configuration,
                        title = "Start Timer")
                    }


                // Landscape Right Time Selection Screen Panel
                PresetTimeList(
                    context = context,
                    configuration = configuration,
                    orientation = "Landscape")
                    }
                }
            }
        }
    }
}