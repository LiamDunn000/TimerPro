package com.timerpro.casualtimer.presentation.stopwatch_presentation.stopwatch_components

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.timerpro.casualtimer.data.shared_data.Colors
import com.timerpro.casualtimer.data.stopwatch_data.stopwatch_dimensions.StopwatchScreenDimensions

@Composable
fun LapDisplayListText(
    configuration: Configuration,
    dimensions: StopwatchScreenDimensions = StopwatchScreenDimensions(configuration),
    color: Color = Colors().gray,
    text: String
) {

        // Lap Display List Header Text
        Text(
            text = text,
            color = color,
            fontSize = dimensions.lapDisplayListFontSize,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(vertical = dimensions.lapDisplayListTextSpacing)) }
