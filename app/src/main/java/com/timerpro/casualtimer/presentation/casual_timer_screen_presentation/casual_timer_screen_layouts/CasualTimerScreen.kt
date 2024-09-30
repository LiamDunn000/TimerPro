package com.timerpro.casualtimer.presentation.casual_timer_screen_presentation.casual_timer_screen_layouts

import android.content.Context
import android.content.res.Configuration
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.timerpro.casualtimer.data.casual_timer_screen_data.casual_timer_datastore.CasualTimerDatastore
import com.timerpro.casualtimer.data.timer_data.timer_states.alarmPlayer
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates
import com.timerpro.casualtimer.functionality.timer_functionality.alarmStateFunctionality

@Composable
fun CasualTimerScreen(
    context: Context,
    configuration: Configuration,
    screenOrientation: Int) {

    // Nav Controller
    val navController = rememberNavController()

    // Casual Timer Datastore
    val casualTimerDatastore = CasualTimerDatastore(LocalContext.current)

    // Saved Alarm Sound
    val savedAlarmSound = casualTimerDatastore.loadAlarmSound(key = casualTimerDatastore.alarmSoundKey).collectAsState(initial = timerStates.alarmSoundNames[0])

    // Lap Display List State
    val lapDisplayListState = rememberLazyListState()

    // Determine Alarm Sound Uri
    alarmStateFunctionality.determineAlarmSound(context, savedAlarmSound.value)

    // Play Alarm
    alarmStateFunctionality.playAlarm(context = context, mediaPlayer = alarmPlayer.alarmPlayer)

    // Load Alarm Sound
    alarmStateFunctionality.loadAlarmSound(savedAlarmSound.value)

    // Conditional That Determines Screen Layout
    when (screenOrientation) {

        // Displays Portrait Screen
        Configuration.ORIENTATION_PORTRAIT -> {
            PortraitCasualTimerScreen(
                context = context,
                configuration = configuration,
                navController = navController,
                lapDisplayListState = lapDisplayListState,
                alarmPlayer = alarmPlayer.alarmPlayer,
                casualTimerDatastore = casualTimerDatastore) }

        // Displays Landscape Screen
        Configuration.ORIENTATION_LANDSCAPE -> {
            LandscapeCasualTimerScreen(
                context = context,
                configuration = configuration,
                navController = navController,
                lapDisplayListState = lapDisplayListState,
                alarmPlayer = alarmPlayer.alarmPlayer,
                casualTimerDatastore = casualTimerDatastore) }}}

