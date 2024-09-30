package com.timerpro.casualtimer.data.timer_data.timer_dimensions.count_down_timer_dimensions

import android.content.res.Configuration
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import com.timerpro.casualtimer.data.shared_data.ScreenDimensions
import com.timerpro.casualtimer.data.timer_data.timer_dimensions.time_selection_screen_dimensions.LandscapeTimeSelectionScreenDimensions

class LandscapeCountDownTimerScreenDimensions(configuration: Configuration) {

    // Landscape Count Down Timer Font Size
    val landscapeCountDownTimerFontSize by mutableIntStateOf((ScreenDimensions(configuration).screenWidth * 0.10).toInt())

    // Landscape Count Down Timer Screen Button Dimensions
    var landscapeCountDownTimerScreenButtonWidth by mutableIntStateOf(LandscapeTimeSelectionScreenDimensions(configuration).landscapeStartTimerButtonWidth)
    var landscapeCountDownTimerScreenButtonHeight by mutableIntStateOf(LandscapeTimeSelectionScreenDimensions(configuration).landscapeStartTimerButtonHeight)
    var landscapeCountDownTimerScreenButtonFontSize by mutableIntStateOf((LandscapeTimeSelectionScreenDimensions(configuration).landscapeStartTimerButtonFontSize))

    // Landscape Initial Time Font Size
    var landscapeInitialTimeFontSize by mutableIntStateOf((ScreenDimensions(configuration).screenWidth * 0.04).toInt())
}