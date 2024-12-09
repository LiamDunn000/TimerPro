package com.timerpro.casualtimer.data.shared_data.dimensions

import android.content.res.Configuration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import com.timerpro.casualtimer.data.casual_timer_screen_data.casual_timer_screen_states.sharedStates
import com.timerpro.casualtimer.data.shared_data.ScreenDimensions

class ScreenSliderDimensions(
    configuration: Configuration,
    dimensions: ScreenDimensions = ScreenDimensions(configuration)) {

    val screenSliderHeight = dimensions.screenSize * 0.031.dp

    val fontSize  = dimensions.screenSize * 0.015.sp

    // Screen Slider Indicator Dimensions
    val indicatorWidth = 0.5f
    val indicatorHeight = dimensions.screenSize * 0.006.dp
    val indicatorCornerRadius = 50
    val indicatorOffset = if (sharedStates.isScreenSliderClicked)
        dimensions.screenWidth.dp * 0.5f else 0.dp

    // Screen Slider Divider Dimensions
    val dividerWidth = dimensions.screenSize * 0.002.dp
    val dividerHeight = dimensions.screenSize * 0.012.dp
}