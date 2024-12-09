package com.timerpro.casualtimer.data.timer_data.timer_dimensions.times_up_screen_dimensions

import android.content.res.Configuration
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import com.timerpro.casualtimer.data.shared_data.ScreenDimensions

class TimesUpScreenDimensions(configuration: Configuration, dimensions: ScreenDimensions = ScreenDimensions(configuration)) {

    // Times Up Screen Timer Font Sizes
    val negativeCountDownTimerFontSize by mutableIntStateOf((ScreenDimensions(configuration).screenSize * 0.05).toInt())
    var timesUpMessageFontSize by mutableIntStateOf((ScreenDimensions(configuration).screenSize * 0.045).toInt())
}