package com.timerpro.casualtimer.presentation.stopwatch_presentation.stopwatch_composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun LapDisplayPanel(
    modifier: Modifier,
    fontSize: Int,
    index: Int,
    formattedIndex: String = "%02d".format(index),
    lapTime: String,
    overallTime: String
) {

    // Lap Display Panel Layout
    Row(
        modifier = modifier
            .fillMaxWidth()
        ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        // Lap Display Panel Index Text
        LapDisplayListText(
            fontSize = fontSize,
            text = "  $formattedIndex ")

        // Lap Display Panel Lap Time Text
        LapDisplayListText(
            fontSize = fontSize,
            text = "$lapTime    ")

        // Lap Display Panel Overall Time Text
        LapDisplayListText(
            fontSize = fontSize,
            text = "$overallTime    ")
    }
}