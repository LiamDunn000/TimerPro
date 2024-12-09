package com.timerpro.casualtimer.presentation.timer_presentation.time_selection_screen

import android.content.Context
import android.content.res.Configuration
import android.media.MediaPlayer
import androidx.compose.runtime.Composable
import com.timerpro.casualtimer.data.casual_timer_screen_data.casual_timer_datastore.CasualTimerDatastore
import com.timerpro.casualtimer.presentation.timer_presentation.time_selection_screen.time_selection_screen_layouts.LandscapeTimeSelectionScreen
import com.timerpro.casualtimer.presentation.timer_presentation.time_selection_screen.time_selection_screen_layouts.PortraitTimeSelectionScreen

@Composable
fun TimeSelectionScreen(
    context: Context,
    configuration: Configuration,
    screenOrientation: Int,
    alarmPlayer: MediaPlayer,
    casualTimerDatastore: CasualTimerDatastore
) {

    // Conditional That Determines Screen Layout
    if (screenOrientation == Configuration.ORIENTATION_PORTRAIT) {
        PortraitTimeSelectionScreen(
            context = context,
            configuration = configuration,
            alarmPlayer = alarmPlayer,
            casualTimerDatastore = casualTimerDatastore
        )
    } else
        LandscapeTimeSelectionScreen(
            context = context,
            configuration = configuration,
            alarmPlayer = alarmPlayer,
            casualTimerDatastore = casualTimerDatastore
        )
}