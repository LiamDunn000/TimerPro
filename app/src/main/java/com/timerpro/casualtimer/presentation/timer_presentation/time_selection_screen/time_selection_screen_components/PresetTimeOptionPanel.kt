package com.timerpro.casualtimer.presentation.timer_presentation.time_selection_screen.time_selection_screen_components

import android.content.Context
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.timerpro.casualtimer.data.shared_data.Colors

@Composable
fun PresetTimeOptionPanel(
    context: Context,
    configuration: Configuration) {

    // Preset Time Option Panel
    Row (
        modifier = Modifier
            .background(Colors().transparent)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {

        // Edit Button
        PresetTimeOptionPanelButton(text = "Edit", context = context, configuration = configuration)

        // Delete Button
        PresetTimeOptionPanelButton(text = "Delete", context = context, configuration = configuration)

        // Close Button
        PresetTimeOptionPanelButton(text = "Close", context = context, configuration = configuration)
    }
}