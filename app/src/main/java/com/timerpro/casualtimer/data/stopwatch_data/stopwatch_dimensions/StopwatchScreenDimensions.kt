package com.timerpro.casualtimer.data.stopwatch_data.stopwatch_dimensions

import android.content.res.Configuration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import com.timerpro.casualtimer.data.shared_data.ScreenDimensions
import com.timerpro.casualtimer.data.stopwatch_data.stopwatch_states.stopwatchStates

class StopwatchScreenDimensions(
    configuration: Configuration,
    dimensions: ScreenDimensions = ScreenDimensions(configuration)) {

    // Portrait Stopwatch Screen Dimensions
    val portraitVerticalPadding = dimensions.screenSize * 0.05.dp
    val portraitHorizontalPadding = dimensions.screenSize * 0.03.dp
    val portraitTopSpacerWeight = if (stopwatchStates.isLapStopwatchVisible) 0.5f else 1.4f

    // Landscape Stopwatch Screen Dimensions
    val landscapePanelWidth = dimensions.screenWidth / 2
    val landscapeVerticalPadding = dimensions.screenSize * 0.04.dp

    // Stopwatch Current Time Font Dimensions
    val currentTimeFontSize = dimensions.screenSize * 0.053.sp
    val currentMillisecondsFontSize = dimensions.screenSize * 0.025.sp

    // Stopwatch Lap Time Font Dimensions
    val lapTimeFontSize = dimensions.screenSize * 0.04.sp
    val lapMillisecondsFontSize = dimensions.screenSize * 0.017.sp

    // Lap Display List Dimensions
    val lapDisplayListWeight = 1.9f
    val lapDisplayListFontSize = dimensions.screenSize * 0.0145.sp
    val lapDisplayListTextSpacing = dimensions.screenSize * 0.01.dp
    val lapDisplayListHeaderDividerHeight = dimensions.screenSize * 0.001.dp
}