package com.timerpro.casualtimer.presentation.stopwatch_presentation.stopwatch_components

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Ease
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.timerpro.casualtimer.data.stopwatch_data.stopwatch_states.stopwatchStates

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LapDisplayList(
    configuration: Configuration,
    lapDisplayListState: LazyListState
) {

    AnimatedVisibility(visible = stopwatchStates.isLapTimeListVisible,
        enter = slideInHorizontally(),
        exit = slideOutVertically()
    ) {

            // Lap Display List
            LazyColumn(
                state = lapDisplayListState,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                items(stopwatchStates.laps.reversed(), key = { it.index }) { lap ->
                    LapDisplayPanel(
                        modifier = Modifier.animateItemPlacement(
                            animationSpec = tween(
                                500,
                                easing = Ease)),
                        configuration = configuration,
                        index = lap.index,
                        lapTime = lap.lapTime,
                        overallTime = lap.overallTime) }}}}