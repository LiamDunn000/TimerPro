package com.timerpro.casualtimer.presentation.timer_presentation.time_selection_screen.time_selection_screen_layouts

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.media.MediaPlayer
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import com.timerpro.casualtimer.data.timer_data.timer_dimensions.time_selection_screen_dimensions.PortraitTimeSelectionScreenDimensions
import com.timerpro.casualtimer.data.timer_data.timer_room_data.PresetTimeInstance
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates
import com.timerpro.casualtimer.functionality.casual_timer_screen_functionality.casualTimerScreenFunctionality
import com.timerpro.casualtimer.functionality.timer_functionality.presetTimeFunctionality
import com.timerpro.casualtimer.presentation.timer_presentation.add_preset_time_dialog.add_preset_time_dialog_layouts.PortraitAddPresetTimeDialog
import com.timerpro.casualtimer.presentation.timer_presentation.alarm_sound_selection_dialog.alarm_sound_selection_dialog_layouts.PortraitAlarmSoundSelectionDialog
import com.timerpro.casualtimer.presentation.timer_presentation.count_down_timer_screen.count_down_timer_screen_layout.PortraitCountDownTimerScreen
import com.timerpro.casualtimer.presentation.timer_presentation.time_selection_screen.time_selection_screen_composables.HourSelector
import com.timerpro.casualtimer.presentation.timer_presentation.time_selection_screen.time_selection_screen_composables.MinuteSelector
import com.timerpro.casualtimer.presentation.timer_presentation.time_selection_screen.time_selection_screen_composables.OpenAddPresetDialogButton
import com.timerpro.casualtimer.presentation.timer_presentation.time_selection_screen.time_selection_screen_composables.OpenAlarmSoundSelectionDialogButton
import com.timerpro.casualtimer.presentation.timer_presentation.time_selection_screen.time_selection_screen_composables.PortraitPresetTimeList
import com.timerpro.casualtimer.presentation.timer_presentation.time_selection_screen.time_selection_screen_composables.SecondSelector
import com.timerpro.casualtimer.presentation.timer_presentation.time_selection_screen.time_selection_screen_composables.StartTimerButton

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PortraitTimeSelectionScreen(
    context: Context,
    configuration: Configuration,
    alarmPlayer: MediaPlayer,
    casualTimerDatastore: CasualTimerDatastore,
) {

    // Logic That Closes Application When Back Button Is Pressed
    BackHandler { (context as? Activity)?.moveTaskToBack(true) }

    // Move Slide To Timer If Deep Link Is Clicked
    casualTimerScreenFunctionality.moveSliderToTimerIfDeepLinkIsClicked(context)

    AnimatedContent(targetState = timerStates.isTimerScreenVisible,

    ) { isTimerScreenActive ->

        // Conditional That Determines Which Screen Is Visible
        when {

            // Transitions To Portrait Count Down Timer Screen
            isTimerScreenActive -> PortraitCountDownTimerScreen(
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
                            horizontalArrangement = Arrangement.SpaceBetween) {

                            // Portrait Open Add Preset Time Dialog Button
                            OpenAddPresetDialogButton(
                                context = context,
                                fontSize = PortraitTimeSelectionScreenDimensions(configuration).portraitTimeSelectionScreenTopAppBarButtonSize)

                            // Portrait Open Alarm Sound Selection Dialog Button
                            OpenAlarmSoundSelectionDialogButton(
                                context = context,
                                fontSize = PortraitTimeSelectionScreenDimensions(configuration).portraitTimeSelectionScreenTopAppBarButtonSize) }}) {

                    // Portrait Add Preset Time Dialog
                   PortraitAddPresetTimeDialog(
                       context = context,
                       onSave = {presetTimeFunctionality.insertPresetTime(presetTime = PresetTimeInstance().presetTimeInstance) },
                       onCancel = {timerStates.isAddPresetTimeDialogOpen = false},
                       configuration = configuration,
                       )

                    PortraitAlarmSoundSelectionDialog(
                        configuration = configuration,
                        casualTimerDatastore = casualTimerDatastore)

                    // Portrait Timer Selection Screen Layout
                    Column(
                        modifier = Modifier
                            .padding(
                                horizontal = PortraitTimeSelectionScreenDimensions(configuration).portraitTimeSelectionScreensHorizontalPadding.dp,
                                vertical = PortraitTimeSelectionScreenDimensions(configuration).portraitTimeSelectionScreensVerticalPadding.dp)
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center) {

                         // Portrait Timer Selection Screen Text Field Panel
                         Row(
                             modifier = Modifier
                                 .padding(bottom = PortraitTimeSelectionScreenDimensions(configuration).portraitTimeSelectionScreensComposablePadding.dp)
                                 .width(PortraitTimeSelectionScreenDimensions(configuration).portraitTimeSelectionScreenTextFieldPanelWidth.dp)
                                 .height(PortraitTimeSelectionScreenDimensions(configuration).portraitTimeSelectionScreenTextFieldPanelHeight.dp)
                                 .fillMaxWidth(),
                             horizontalArrangement = Arrangement.SpaceEvenly,
                             verticalAlignment = Alignment.CenterVertically) {

                             // Portrait Hour Selector
                             HourSelector(
                                 context = context,
                                 size = PortraitTimeSelectionScreenDimensions(configuration).portraitTimeSelectionTextFieldSize,
                                 fontSize = PortraitTimeSelectionScreenDimensions(configuration).portraitTimeSelectionTextFieldFontSize,
                                 buttonSize = PortraitTimeSelectionScreenDimensions(configuration).portraitIncrementAndDecrementButtonSize,
                                 iconSize = PortraitTimeSelectionScreenDimensions(configuration).portraitIncrementAndDecrementIconSize,
                                 verticalSpacing = PortraitTimeSelectionScreenDimensions(configuration).portraitTimeSelectionScreenTextFieldPanelVerticalSpacing)

                             // Portrait Minute Selector
                             MinuteSelector(
                                 context = context,
                                 size = PortraitTimeSelectionScreenDimensions(configuration).portraitTimeSelectionTextFieldSize,
                                 fontSize = PortraitTimeSelectionScreenDimensions(configuration).portraitTimeSelectionTextFieldFontSize,
                                 buttonSize = PortraitTimeSelectionScreenDimensions(configuration).portraitIncrementAndDecrementButtonSize,
                                 iconSize = PortraitTimeSelectionScreenDimensions(configuration).portraitIncrementAndDecrementIconSize,
                                 verticalSpacing = PortraitTimeSelectionScreenDimensions(configuration).portraitTimeSelectionScreenTextFieldPanelVerticalSpacing)

                             // Portrait Second Selector
                             SecondSelector(
                                 context = context,
                                 size = PortraitTimeSelectionScreenDimensions(configuration).portraitTimeSelectionTextFieldSize,
                                 fontSize = PortraitTimeSelectionScreenDimensions(configuration).portraitTimeSelectionTextFieldFontSize,
                                 buttonSize = PortraitTimeSelectionScreenDimensions(configuration).portraitIncrementAndDecrementButtonSize,
                                 iconSize = PortraitTimeSelectionScreenDimensions(configuration).portraitIncrementAndDecrementIconSize,
                                 verticalSpacing = PortraitTimeSelectionScreenDimensions(configuration).portraitTimeSelectionScreenTextFieldPanelVerticalSpacing) }

                         // Portrait Time Selection Screen Button Panel
                         Box(
                             modifier = Modifier
                                 .padding(top = PortraitTimeSelectionScreenDimensions(configuration).portraitTimeSelectionScreensComposablePadding.dp)
                                 .width(PortraitTimeSelectionScreenDimensions(configuration).portraitTimeSelectionScreenButtonPanelWidth.dp)
                                 .height(PortraitTimeSelectionScreenDimensions(configuration).portraitTimeSelectionScreenButtonPanelHeight.dp),
                             contentAlignment = Alignment.Center) {

                             // Portrait Start Timer Button
                             StartTimerButton(
                                 context = context,
                                 width = PortraitTimeSelectionScreenDimensions(configuration).portraitStartTimerButtonWidth,
                                 height = PortraitTimeSelectionScreenDimensions(configuration).portraitStartTimerButtonHeight,
                                 fontSize = PortraitTimeSelectionScreenDimensions(configuration).portraitStartTimerButtonFontSize)
                         }

                             // Portrait Preset Time List
                             PortraitPresetTimeList(
                                 context = context,
                                 configuration = configuration)

                         }}}}}