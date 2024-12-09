package com.timerpro.casualtimer.data.timer_data.timer_dimensions.count_down_timer_dimensions

import android.content.res.Configuration
import com.timerpro.casualtimer.data.shared_data.ScreenDimensions

class CountDownTimerScreenDimensions(configuration: Configuration, dimensions: ScreenDimensions = ScreenDimensions(configuration)) {

    val countDownTimerFontSize = dimensions.screenSize * 0.055
    var initialTimeFontSize = dimensions.screenSize * 0.03
}