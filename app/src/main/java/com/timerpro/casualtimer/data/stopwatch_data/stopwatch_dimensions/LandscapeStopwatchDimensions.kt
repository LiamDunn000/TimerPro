package com.timerpro.casualtimer.data.stopwatch_data.stopwatch_dimensions

import android.content.res.Configuration
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.timerpro.casualtimer.data.shared_data.ScreenDimensions

class LandscapeStopwatchDimensions(configuration: Configuration): ViewModel() {

    // Landscape Stopwatch Screen Padding
    var landscapeStopwatchScreenHorizontalPadding by mutableIntStateOf(((ScreenDimensions(configuration).screenWidth * 0.030).toInt()))
    var landscapeStopwatchScreenVerticalPadding by mutableIntStateOf(((ScreenDimensions(configuration).screenHeight * 0.099).toInt()))

    // Landscape Stopwatch Screen Panel Dimensions
    var leftLandscapeStopwatchScreenPanelWidth by mutableIntStateOf((ScreenDimensions(configuration).screenWidth / 2))
    var rightLandscapeStopwatchScreenPanelWidth by mutableIntStateOf((ScreenDimensions(configuration).screenWidth / 2))
    var leftLandscapeStopwatchScreenPanelComposablePadding by mutableIntStateOf((leftLandscapeStopwatchScreenPanelWidth * 0.04).toInt())

    // Landscape Stopwatch Current Time Display Font Sizes
    var landscapeCurrentStopwatchTimeDisplayFontSize by mutableIntStateOf((leftLandscapeStopwatchScreenPanelWidth * 0.18).toInt())
    var landscapeCurrentStopwatchMillisecondsDisplayFontSize by mutableIntStateOf((landscapeCurrentStopwatchTimeDisplayFontSize * 0.5).toInt())

    // Stopwatch Lap Time Display Font Sizes
    var landscapeLapStopwatchTimeDisplayFontSize by mutableIntStateOf((landscapeCurrentStopwatchTimeDisplayFontSize * 0.7).toInt())
    var landscapeLapStopwatchMillisecondsDisplayFontSize by mutableIntStateOf((landscapeLapStopwatchTimeDisplayFontSize * 0.5).toInt())

    // Landscape Button Panel Dimensions
    var landscapeStopwatchButtonPanelWidth by mutableIntStateOf((leftLandscapeStopwatchScreenPanelWidth))
    var landscapeStopwatchButtonPanelHeight by mutableIntStateOf((landscapeStopwatchButtonPanelWidth * 0.14).toInt())

    // Landscape Button Dimensions
    var landscapeStopwatchButtonWidth by mutableIntStateOf((landscapeStopwatchButtonPanelWidth * 0.32).toInt())
    var landscapeStopwatchButtonHeight by mutableIntStateOf(landscapeStopwatchButtonPanelHeight)
    var landscapeStopwatchButtonPadding by mutableIntStateOf((landscapeStopwatchButtonPanelWidth * 0.05).toInt())
    var landscapeStopwatchButtonFontSize by mutableIntStateOf((landscapeStopwatchButtonHeight * 0.5).toInt())

    //  Landscape Lap Display List Header Dimensions
    var landscapeLapDisplayListHeaderWidth by mutableIntStateOf((leftLandscapeStopwatchScreenPanelWidth))
    var landscapeLapDisplayListHeaderHeight by mutableIntStateOf((landscapeLapDisplayListHeaderWidth * 0.15).toInt())

    // Landscape Lap Display List Dimensions
    var landscapeLapDisplayListFontSize by mutableIntStateOf((landscapeLapDisplayListHeaderHeight * 0.28).toInt())
}