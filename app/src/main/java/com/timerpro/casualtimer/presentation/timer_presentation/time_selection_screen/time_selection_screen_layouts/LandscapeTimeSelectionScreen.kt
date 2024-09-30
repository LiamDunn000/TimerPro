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
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.timerpro.casualtimer.data.casual_timer_screen_data.casual_timer_datastore.CasualTimerDatastore
import com.timerpro.casualtimer.data.stopwatch_data.stopwatch_colors.StopwatchColors
import com.timerpro.casualtimer.data.timer_data.timer_dimensions.time_selection_screen_dimensions.LandscapeTimeSelectionScreenDimensions
import com.timerpro.casualtimer.data.timer_data.timer_room_data.PresetTimeInstance
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates
import com.timerpro.casualtimer.functionality.casual_timer_screen_functionality.casualTimerScreenFunctionality
import com.timerpro.casualtimer.functionality.timer_functionality.presetTimeFunctionality
import com.timerpro.casualtimer.presentation.timer_presentation.add_preset_time_dialog.add_preset_time_dialog_layouts.LandscapeAddPresetTimeDialog
import com.timerpro.casualtimer.presentation.timer_presentation.alarm_sound_selection_dialog.alarm_sound_selection_dialog_layouts.LandscapeAlarmSoundSelectionDialog
import com.timerpro.casualtimer.presentation.timer_presentation.count_down_timer_screen.count_down_timer_screen_layout.LandscapeCountDownTimerScreen
import com.timerpro.casualtimer.presentation.timer_presentation.time_selection_screen.time_selection_screen_composables.HourSelector
import com.timerpro.casualtimer.presentation.timer_presentation.time_selection_screen.time_selection_screen_composables.LandscapePresetTimeList
import com.timerpro.casualtimer.presentation.timer_presentation.time_selection_screen.time_selection_screen_composables.MinuteSelector
import com.timerpro.casualtimer.presentation.timer_presentation.time_selection_screen.time_selection_screen_composables.OpenAddPresetDialogButton
import com.timerpro.casualtimer.presentation.timer_presentation.time_selection_screen.time_selection_screen_composables.OpenAlarmSoundSelectionDialogButton
import com.timerpro.casualtimer.presentation.timer_presentation.time_selection_screen.time_selection_screen_composables.SecondSelector
import com.timerpro.casualtimer.presentation.timer_presentation.time_selection_screen.time_selection_screen_composables.StartTimerButton

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LandscapeTimeSelectionScreen(
    context: Context,
    configuration: Configuration,
    alarmPlayer: MediaPlayer,
    casualTimerDatastore: CasualTimerDatastore) {

    // Logic That Closes Application When Back Button Is Pressed
    BackHandler{ (context as? Activity)?.moveTaskToBack(true)}

    // Move Slide To Timer If Deep Link Is Clicked
    casualTimerScreenFunctionality.moveSliderToTimerIfDeepLinkIsClicked(context)

    AnimatedContent(targetState = timerStates.isTimerScreenVisible) { isTimerScreenActive ->

        // Conditional That Determines Which Screen Is Visible
        when {

            // Transitions To Landscape Count Down Timer Screen
            isTimerScreenActive -> LandscapeCountDownTimerScreen(
                context = context,
                configuration = configuration,
                mediaPlayer = alarmPlayer)

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
                    OpenAddPresetDialogButton(
                        context = context,
                        fontSize = LandscapeTimeSelectionScreenDimensions(configuration).landscapeTimeSelectionScreenTopAppBarButtonSize)

                    // Landscape Open Alarm Sound Selection List Button
                    OpenAlarmSoundSelectionDialogButton(
                        context = context,
                        fontSize = LandscapeTimeSelectionScreenDimensions(configuration).landscapeTimeSelectionScreenTopAppBarButtonSize)
                }}) {

            // Landscape Add Preset Time Dialog
            LandscapeAddPresetTimeDialog(
                context = context,
                configuration = configuration,
                onSave = { presetTimeFunctionality.insertPresetTime(presetTime = PresetTimeInstance().presetTimeInstance) },
                onCancel = {timerStates.isAddPresetTimeDialogOpen = false} )

            LandscapeAlarmSoundSelectionDialog(
                configuration = configuration,
                casualTimerDatastore = casualTimerDatastore)

            // Landscape Stopwatch Screen Layout
            Row(
                modifier = Modifier
                    .background(color = StopwatchColors().stopwatchScreenBackgroundColor)
                    .padding(
                        horizontal = LandscapeTimeSelectionScreenDimensions(configuration).landscapeTimeSelectionScreensHorizontalPadding.dp,
                        vertical = LandscapeTimeSelectionScreenDimensions(configuration).landscapeTimeSelectionScreensVerticalPadding.dp
                    )
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                // Left Landscape Stopwatch Screen Panel
                Column(
                    modifier = Modifier
                        .width(LandscapeTimeSelectionScreenDimensions(configuration).leftLandscapeTimeSelectionScreenPanelWidth.dp)
                        .fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {


                    // Landscape Time Selection Screen Text Field Panel
                    Row(
                        modifier = Modifier
                            .width(LandscapeTimeSelectionScreenDimensions(configuration).landscapeTimeSelectionScreenTextFieldPanelWidth.dp)
                            .height(LandscapeTimeSelectionScreenDimensions(configuration).landscapeTimeSelectionScreenTextFieldPanelHeight.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        // Landscape Hour Selector
                        HourSelector(
                            context = context,
                            size = LandscapeTimeSelectionScreenDimensions(configuration).landscapeTimeSelectionTextFieldSize,
                            fontSize = LandscapeTimeSelectionScreenDimensions(configuration).landscapeTimeSelectionTextFieldFontSize,
                            buttonSize = LandscapeTimeSelectionScreenDimensions(configuration).landscapeIncrementAndDecrementButtonSize,
                            iconSize = LandscapeTimeSelectionScreenDimensions(configuration).landscapeIncrementAndDecrementIconSize,
                            verticalSpacing = LandscapeTimeSelectionScreenDimensions(configuration).landscapeTimeSelectionScreenTextFieldPanelVerticalSpacing
                        )

                        // Landscape Minute Selector
                        MinuteSelector(
                            context = context,
                            size = LandscapeTimeSelectionScreenDimensions(configuration).landscapeTimeSelectionTextFieldSize,
                            fontSize = LandscapeTimeSelectionScreenDimensions(configuration).landscapeTimeSelectionTextFieldFontSize,
                            buttonSize = LandscapeTimeSelectionScreenDimensions(configuration).landscapeIncrementAndDecrementButtonSize,
                            iconSize = LandscapeTimeSelectionScreenDimensions(configuration).landscapeIncrementAndDecrementIconSize,
                            verticalSpacing = LandscapeTimeSelectionScreenDimensions(configuration).landscapeTimeSelectionScreenTextFieldPanelVerticalSpacing
                        )


                        // Landscape Second Selector
                        SecondSelector(
                            context = context,
                            size = LandscapeTimeSelectionScreenDimensions(configuration).landscapeTimeSelectionTextFieldSize,
                            fontSize = LandscapeTimeSelectionScreenDimensions(configuration).landscapeTimeSelectionTextFieldFontSize,
                            buttonSize = LandscapeTimeSelectionScreenDimensions(configuration).landscapeIncrementAndDecrementButtonSize,
                            iconSize = LandscapeTimeSelectionScreenDimensions(configuration).landscapeIncrementAndDecrementIconSize,
                            verticalSpacing = LandscapeTimeSelectionScreenDimensions(configuration).landscapeTimeSelectionScreenTextFieldPanelVerticalSpacing
                        )
                    }

                    // Landscape Time Selection Screen Button Panel
                    Box(
                        modifier = Modifier
                            .width(LandscapeTimeSelectionScreenDimensions(configuration).landscapeTimeSelectionScreenButtonPanelWidth.dp)
                            .height(LandscapeTimeSelectionScreenDimensions(configuration).landscapeTimeSelectionScreenButtonPanelHeight.dp),
                        contentAlignment = Alignment.Center,
                    ) {

                        // Landscape Start Timer Button
                        StartTimerButton(
                            context = context,
                            width = LandscapeTimeSelectionScreenDimensions(configuration).landscapeStartTimerButtonWidth,
                            height = LandscapeTimeSelectionScreenDimensions(configuration).landscapeStartTimerButtonHeight,
                            fontSize = LandscapeTimeSelectionScreenDimensions(configuration).landscapeStartTimerButtonFontSize
                        )

                    }
                }

                // Landscape Right Time Selection Screen Panel
                    Column(
                        modifier = Modifier
                            .width(LandscapeTimeSelectionScreenDimensions(configuration).rightLandscapeTimeSelectionScreenPanelWidth.dp)
                            .fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        LandscapePresetTimeList(
                            context = context,
                            configuration = configuration) }}}}}}}