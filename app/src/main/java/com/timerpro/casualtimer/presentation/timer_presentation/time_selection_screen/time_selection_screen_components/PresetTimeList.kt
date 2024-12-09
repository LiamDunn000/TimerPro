package com.timerpro.casualtimer.presentation.timer_presentation.time_selection_screen.time_selection_screen_components

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.timerpro.casualtimer.data.timer_data.timer_dimensions.time_selection_screen_dimensions.TimeSelectionScreenDimensions
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PresetTimeList(
    context: Context,
    configuration: Configuration,
    dimensions: TimeSelectionScreenDimensions = TimeSelectionScreenDimensions(configuration),
    orientation: String,
    ) {

    AnimatedVisibility(visible = timerStates.presetTimeList.isNotEmpty())  {
    if (orientation == "Portrait") {

        // Portrait Preset Time List
        LazyRow {
            items(timerStates.presetTimeList) { presetTime ->

                PresetTimePanel(
                    context = context,
                    configuration = configuration,
                    presetTime = presetTime,
                    orientation = orientation,
                )
            }
        }
    } else

        // Landscape Preset Time List
        Column(
            modifier = Modifier
                .width(dimensions.landscapePanelWidth.dp)
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            ) {
            LazyColumn{
                items(timerStates.presetTimeList) { presetTime ->

                    PresetTimePanel(
                        context = context,
                        configuration = configuration,
                        presetTime = presetTime,
                        orientation = orientation,
                    )
                }
            }
        }
    }
}