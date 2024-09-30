package com.timerpro.casualtimer.data.casual_timer_screen_data.casual_timer_screen_dimensions

import android.content.res.Configuration
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import com.timerpro.casualtimer.data.shared_data.ScreenDimensions

class LandscapeCasualTimerScreenDimensions(configuration: Configuration) {

    // Landscape Screen Slider Dimensions
    var landscapeScreenSliderWidth by mutableIntStateOf(ScreenDimensions(configuration).screenWidth)
    var landscapeScreenSliderHeight by mutableIntStateOf(((ScreenDimensions(configuration).screenHeight * 0.090).toInt()))
    var landscapeScreenSliderFontSize by mutableIntStateOf((landscapeScreenSliderHeight * 0.5).toInt())
    var landscapeScreenSliderIndicatorHeight by mutableIntStateOf((landscapeScreenSliderHeight * 0.15).toInt())

    // Landscape Screen Slider Top Bar Divider Dimensions
    var landscapeScreenSliderTopBarDividerWidth by mutableIntStateOf((landscapeScreenSliderWidth * 0.005).toInt())
    var landscapeScreenSliderTopBarDividerHeight by mutableIntStateOf((landscapeScreenSliderHeight * 0.45).toInt())
}