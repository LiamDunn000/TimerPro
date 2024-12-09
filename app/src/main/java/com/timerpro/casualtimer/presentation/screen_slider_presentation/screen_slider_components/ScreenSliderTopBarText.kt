package com.timerpro.casualtimer.presentation.screen_slider_presentation.screen_slider_components

import android.content.res.Configuration
import androidx.compose.animation.animateColorAsState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import com.timerpro.casualtimer.data.shared_data.Colors
import com.timerpro.casualtimer.data.shared_data.dimensions.ScreenSliderDimensions

@Composable
fun ScreenSliderTopBarText(
    configuration: Configuration,
    dimensions: ScreenSliderDimensions = ScreenSliderDimensions(configuration),
    text: String,
    isScreenSliderClicked: Boolean
) {

    Text(
        text = text,

        // Conditional That Determines Screen Slider Top Bar Font Color
        color = animateColorAsState(targetValue =
        when{ isScreenSliderClicked -> Colors().lightBlue else -> Colors().lightGray}).value,
        fontSize = dimensions.fontSize,
        fontWeight = FontWeight.SemiBold
    )

}