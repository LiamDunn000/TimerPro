package com.timerpro.casualtimer.presentation.stopwatch_presentation.stopwatch_components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.timerpro.casualtimer.data.shared_data.Colors

@Composable
fun LapDisplayPanel(
    modifier: Modifier = Modifier,
    configuration: Configuration,
    index: Int,
    formattedIndex: String = "%02d".format(index),
    lapTime: String,
    overallTime: String
) {

    // Lap Display Panel Layout
    Row(
        modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        // Lap Display Panel Index Text
        LapDisplayListText(text = "  $formattedIndex ", configuration = configuration)

        // Lap Display Panel Lap Time Text
        LapDisplayListText(text = "$lapTime    ", configuration = configuration)

        // Lap Display Panel Overall Time Text
        LapDisplayListText(text = "$overallTime    ", color = Colors().black, configuration = configuration)
    }
}