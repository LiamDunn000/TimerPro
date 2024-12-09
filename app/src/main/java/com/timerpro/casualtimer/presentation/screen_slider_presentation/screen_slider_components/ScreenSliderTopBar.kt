package com.timerpro.casualtimer.presentation.screen_slider_presentation.screen_slider_components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.timerpro.casualtimer.data.casual_timer_screen_data.casual_timer_screen_states.sharedStates
import com.timerpro.casualtimer.data.shared_data.Colors
import com.timerpro.casualtimer.data.shared_data.dimensions.ScreenSliderDimensions

@Composable
fun ScreenSliderTopBar(
    configuration: Configuration,
    dimensions: ScreenSliderDimensions = ScreenSliderDimensions(configuration),
    ) {

    // Screen Slider Top Bar Layout
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {

        // Screen Slider Top Bar Stopwatch Text
        ScreenSliderTopBarText(
            configuration = configuration,
            text = "Stopwatch",
            isScreenSliderClicked = !sharedStates.isScreenSliderClicked
        )

        // Screen Slider Top Bar Divider
        Box(
            modifier = Modifier
                .width(dimensions.dividerWidth)
                .height(dimensions.dividerHeight)
                .background(color = Colors().lightGray)
        )

        // Screen Slider Top Bar Timer Text
        ScreenSliderTopBarText(
            configuration = configuration,
            text = "    Timer    ",
            isScreenSliderClicked = sharedStates.isScreenSliderClicked)
    }
}
