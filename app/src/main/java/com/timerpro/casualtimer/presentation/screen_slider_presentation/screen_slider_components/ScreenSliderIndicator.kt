package com.timerpro.casualtimer.presentation.screen_slider_presentation.screen_slider_components

import android.content.res.Configuration
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.timerpro.casualtimer.data.shared_data.Colors
import com.timerpro.casualtimer.data.shared_data.dimensions.ScreenSliderDimensions

@Composable
fun ScreenSliderIndicator(
    configuration: Configuration,
    dimensions: ScreenSliderDimensions = ScreenSliderDimensions(configuration),
) {

    // Screen Slider Indicator Layout
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(dimensions.indicatorHeight),
    ){

        // Screen Slider Indicator
        Box(
            modifier = Modifier

                // Conditional That Toggles Screen Slider Indicator Position
                .offset(x = animateDpAsState( targetValue = dimensions.indicatorOffset).value)

                .background(
                    color = Colors().lightBlue,
                    shape = RoundedCornerShape(dimensions.indicatorCornerRadius) )
                .fillMaxWidth(dimensions.indicatorWidth)
                .fillMaxHeight())
    }
}