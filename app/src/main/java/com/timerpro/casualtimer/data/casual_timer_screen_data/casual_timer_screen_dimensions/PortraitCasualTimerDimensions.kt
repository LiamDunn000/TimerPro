package com.timerpro.casualtimer.data.casual_timer_screen_data.casual_timer_screen_dimensions

import android.content.res.Configuration
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import com.timerpro.casualtimer.data.shared_data.ScreenDimensions

class PortraitCasualTimerDimensions(configuration: Configuration) {

    // Portrait Screen Slider Dimensions
    var portraitScreenSliderWidth by mutableIntStateOf(ScreenDimensions(configuration).screenWidth)
    var portraitScreenSliderHeight by mutableIntStateOf(((ScreenDimensions(configuration).screenHeight * 0.045).toInt()))
    var portraitScreenSliderFontSize by mutableIntStateOf((portraitScreenSliderHeight * 0.5).toInt())
    var portraitScreenSliderIndicatorHeight by mutableIntStateOf((portraitScreenSliderHeight * 0.15).toInt())

    // Portrait Screen Slider Top Bar Divider Dimensions
    var portraitScreenSliderTopBarDividerWidth by mutableIntStateOf((portraitScreenSliderWidth * 0.005).toInt())
    var portraitScreenSliderTopBarDividerHeight by mutableIntStateOf((portraitScreenSliderHeight * 0.35).toInt())

}