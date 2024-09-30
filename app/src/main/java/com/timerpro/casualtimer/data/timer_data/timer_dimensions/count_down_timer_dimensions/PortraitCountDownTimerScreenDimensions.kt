package com.timerpro.casualtimer.data.timer_data.timer_dimensions.count_down_timer_dimensions

import android.content.res.Configuration
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.timerpro.casualtimer.data.shared_data.ScreenDimensions
import com.timerpro.casualtimer.data.timer_data.timer_dimensions.time_selection_screen_dimensions.PortraitTimeSelectionScreenDimensions

class PortraitCountDownTimerScreenDimensions(configuration: Configuration) {

    // Portrait Count Down Timer Font Size
    val portraitCountDownTimerFontSize by mutableIntStateOf((ScreenDimensions(configuration).screenWidth * 0.15).toInt())

    // Portrait Start Timer Button Dimensions
    var portraitCountDownTimerScreenButtonWidth by mutableIntStateOf(PortraitTimeSelectionScreenDimensions(configuration).portraitStartTimerButtonWidth)
    var portraitCountDownTimerScreenButtonHeight by mutableIntStateOf(PortraitTimeSelectionScreenDimensions(configuration).portraitStartTimerButtonHeight)
    var portraitCountDownTimerScreenButtonSpacing by mutableIntStateOf((ScreenDimensions(configuration).screenWidth * 0.035).toInt())
    var portraitCountDownTimerScreenButtonFontSize by mutableIntStateOf(PortraitTimeSelectionScreenDimensions(configuration).portraitStartTimerButtonFontSize)

    // Portrait Initial Time Font Size
    var portraitInitialTimeFontSize by mutableStateOf((ScreenDimensions(configuration).screenWidth * 0.08).toInt())
}