package com.timerpro.casualtimer.data.timer_data.timer_dimensions.times_up_message_dimensions

import android.content.res.Configuration
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import com.timerpro.casualtimer.data.shared_data.ScreenDimensions
import com.timerpro.casualtimer.data.timer_data.timer_dimensions.time_selection_screen_dimensions.LandscapeTimeSelectionScreenDimensions

class LandscapeTimesUpScreenDimensions(configuration: Configuration) {

    // Landscape Times Up Screen Font Sizes
    val landscapeNegativeCountDownTimerFontSize by mutableIntStateOf((ScreenDimensions(configuration).screenWidth * 0.10).toInt())
    var landscapeTimesUpMessageFontSize by mutableIntStateOf((ScreenDimensions(configuration).screenWidth * 0.10).toInt())

    // Landscape Count Down Timer Screen Button Dimensions
    var landscapeTimesUpScreenButtonWidth by mutableIntStateOf(LandscapeTimeSelectionScreenDimensions(configuration).landscapeStartTimerButtonWidth)
    var landscapeTimesUpScreenButtonHeight by mutableIntStateOf(LandscapeTimeSelectionScreenDimensions(configuration).landscapeStartTimerButtonHeight)
    var landscapeTimesUpScreenButtonFontSize by mutableIntStateOf((landscapeTimesUpScreenButtonHeight * 0.45).toInt())

}