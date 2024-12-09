package com.timerpro.casualtimer.presentation.stopwatch_presentation

import android.content.Context
import android.content.res.Configuration
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import com.timerpro.casualtimer.presentation.stopwatch_presentation.stopwatch_layouts.LandscapeStopwatchScreen
import com.timerpro.casualtimer.presentation.stopwatch_presentation.stopwatch_layouts.PortraitStopwatchScreen

@Composable
fun StopwatchScreen(
    context: Context,
    configuration: Configuration,
    screenOrientation: Int,
) {

    // Lap Display List State
    val lapDisplayListState = rememberLazyListState()

    // Conditional That Determines Screen Layout
    if (screenOrientation == Configuration.ORIENTATION_PORTRAIT) {
        PortraitStopwatchScreen(
            context = context,
            configuration = configuration,
            lapDisplayListState = lapDisplayListState
        )
    } else
        LandscapeStopwatchScreen(
        context = context,
        configuration = configuration,
        lapDisplayListState = lapDisplayListState
    )
}