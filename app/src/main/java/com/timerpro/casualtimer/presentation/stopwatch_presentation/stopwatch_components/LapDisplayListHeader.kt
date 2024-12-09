package com.timerpro.casualtimer.presentation.stopwatch_presentation.stopwatch_components

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.timerpro.casualtimer.data.shared_data.Colors
import com.timerpro.casualtimer.data.stopwatch_data.stopwatch_dimensions.StopwatchScreenDimensions
import com.timerpro.casualtimer.data.stopwatch_data.stopwatch_states.stopwatchStates

@Composable
fun LapDisplayListHeader(
    configuration: Configuration,
    dimensions: StopwatchScreenDimensions = StopwatchScreenDimensions(configuration),
    ) {

    AnimatedVisibility(visible = stopwatchStates.isLapTimeListVisible,
        enter = slideInHorizontally(),
        exit = slideOutHorizontally(targetOffsetX = {-it})
    ) {

        // Lap Display List Header Layout
        Column(verticalArrangement = Arrangement.SpaceEvenly
        ) {

            // Lap Display List Header Text Panel Layout
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                // Lap Number
                LapDisplayListText(text = "Lap", configuration = configuration)

                // Lap Time
                LapDisplayListText(text = "Lap Time", configuration = configuration)

                // Overall Time
                LapDisplayListText(text = "Overall Time", configuration = configuration)
            }

            // Lap Display List Header Divider
            Box(
                modifier = Modifier
                    .background(color = Colors().gray)
                    .fillMaxWidth()
                    .height(dimensions.lapDisplayListHeaderDividerHeight) )}}}
