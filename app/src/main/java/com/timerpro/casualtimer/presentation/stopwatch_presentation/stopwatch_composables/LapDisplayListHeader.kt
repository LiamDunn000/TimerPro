package com.timerpro.casualtimer.presentation.stopwatch_presentation.stopwatch_composables

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
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.timerpro.casualtimer.data.stopwatch_data.stopwatch_colors.StopwatchColors
import com.timerpro.casualtimer.data.stopwatch_data.stopwatch_states.stopwatchStates

@Composable
fun LapDisplayListHeader(
    width: Int,
    height: Int,
    fontSize: Int, ) {

    AnimatedVisibility(visible = stopwatchStates.isLapTimeListVisible,
        enter = slideInHorizontally(),
        exit = slideOutHorizontally()
    ) {

        // Lap Display List Header Layout
        Column(
            modifier = Modifier
                .width(width = width.dp)
                .height(height = height.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            // Lap Display List Header Text Panel Layout
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                // Lap Text Box
                LapDisplayListText(text = "Lap", fontSize = fontSize)

                // Lap Time Text Box
                LapDisplayListText(text = "Lap Time", fontSize = fontSize)

                // Overall Time Text Box
                LapDisplayListText(text = "Overall Time", fontSize = fontSize)
            }

            // Portrait Lap Display List Header Divider
            Box(
                modifier = Modifier
                    .background(color = StopwatchColors().lapDisplayListHeaderDividerColor)
                    .width(width = width.dp)
                    .height(height = (height * 0.05).toInt().dp) )}}}
