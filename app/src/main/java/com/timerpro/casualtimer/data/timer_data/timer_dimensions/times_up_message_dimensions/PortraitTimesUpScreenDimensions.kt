package com.timerpro.casualtimer.data.timer_data.timer_dimensions.times_up_message_dimensions

import android.content.res.Configuration
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import com.timerpro.casualtimer.data.shared_data.ScreenDimensions
import com.timerpro.casualtimer.data.timer_data.timer_dimensions.time_selection_screen_dimensions.PortraitTimeSelectionScreenDimensions

class PortraitTimesUpScreenDimensions(configuration: Configuration) {

    // Portrait Times Up Screen Timer Font Sizes
    val portraitNegativeCountDownTimerFontSize by mutableIntStateOf((ScreenDimensions(configuration).screenWidth * 0.15).toInt())
    var portraitTimesUpMessageFontSize by mutableIntStateOf((ScreenDimensions(configuration).screenWidth * 0.12).toInt())

    // Portrait Times Up Screen Button Dimensions
    var portraitTimesUpScreenButtonWidth by mutableIntStateOf(PortraitTimeSelectionScreenDimensions(configuration).portraitStartTimerButtonWidth)
    var portraitTimesUpScreenButtonHeight by mutableIntStateOf(PortraitTimeSelectionScreenDimensions(configuration).portraitStartTimerButtonHeight)
    var portraitTimesUpScreenButtonSpacing by mutableIntStateOf((ScreenDimensions(configuration).screenWidth * 0.035).toInt())
    var portraitTimesUpScreenButtonFontSize by mutableIntStateOf((portraitTimesUpScreenButtonHeight * 0.40).toInt())

}