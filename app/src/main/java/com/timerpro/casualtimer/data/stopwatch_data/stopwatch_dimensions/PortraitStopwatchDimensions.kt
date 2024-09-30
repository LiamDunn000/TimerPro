package com.timerpro.casualtimer.data.stopwatch_data.stopwatch_dimensions

import android.content.res.Configuration
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.timerpro.casualtimer.data.shared_data.ScreenDimensions

class PortraitStopwatchDimensions(configuration: Configuration): ViewModel() {

    // Portrait Stopwatch Screen Padding
    var portraitStopwatchScreenHorizontalPadding by mutableIntStateOf(((ScreenDimensions(configuration).screenHeight * 0.030).toInt()))
    var portraitStopwatchScreenVerticalPadding by mutableIntStateOf(((ScreenDimensions(configuration).screenHeight * 0.030).toInt()))

    // Portrait Stopwatch Composable Padding
    var portraitStopwatchComposablePadding by mutableIntStateOf(((ScreenDimensions(configuration).screenHeight * 0.020).toInt()))

    // Portrait Top Spacer Height
    var portraitTopSpacerHeight by mutableIntStateOf((ScreenDimensions(configuration).screenHeight * 0.15).toInt())

    // Portrait Stopwatch Current Time Display Font Sizes
    var portraitCurrentStopwatchTimeDisplayFontSize by mutableIntStateOf(((ScreenDimensions(configuration).screenWidth * 0.16).toInt()))
    var portraitCurrentStopwatchMillisecondsDisplayFontSize by mutableIntStateOf((portraitCurrentStopwatchTimeDisplayFontSize * 0.5).toInt())

    // Portrait Stopwatch Lap Time Display Font Sizes
    var portraitLapStopwatchTimeDisplayFontSize by mutableIntStateOf(((portraitCurrentStopwatchTimeDisplayFontSize * 0.7).toInt()))
    var portraitLapStopwatchMillisecondsDisplayFontSize by mutableIntStateOf((portraitLapStopwatchTimeDisplayFontSize * 0.5).toInt())

    // Portrait Stopwatch Button Panel Dimensions
    var portraitStopwatchButtonPanelWidth by mutableIntStateOf((ScreenDimensions(configuration).screenWidth))
    var portraitStopwatchButtonPanelHeight by mutableIntStateOf((portraitStopwatchButtonPanelWidth * 0.13).toInt())

    // Portrait Stopwatch Button Dimensions
    var portraitStopwatchButtonWidth by mutableIntStateOf((portraitStopwatchButtonPanelWidth * 0.32).toInt())
    var portraitStopwatchButtonHeight by mutableIntStateOf(portraitStopwatchButtonPanelHeight)
    var portraitStopwatchButtonPadding by mutableIntStateOf((portraitStopwatchButtonPanelWidth * 0.05).toInt())
    var portraitStopwatchButtonFontSize by mutableIntStateOf((portraitStopwatchButtonHeight * 0.5).toInt())

    //  Portrait Lap Display List Header Dimensions
    var portraitLapDisplayListHeaderWidth by mutableIntStateOf((ScreenDimensions(configuration).screenWidth))
    var portraitLapDisplayListHeaderHeight by mutableIntStateOf((portraitLapDisplayListHeaderWidth * 0.15).toInt())

    // Portrait Lap Display List Dimensions
    var portraitLapDisplayListContainerWidth by mutableIntStateOf(ScreenDimensions(configuration).screenWidth)
    var portraitLapDisplayListContainerHeight by mutableIntStateOf((ScreenDimensions(configuration).screenHeight * 0.35).toInt())
    var portraitLapDisplayListFontSize by mutableIntStateOf((portraitLapDisplayListHeaderHeight * 0.28).toInt())

}