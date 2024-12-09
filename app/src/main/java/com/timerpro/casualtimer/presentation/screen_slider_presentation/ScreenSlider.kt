package com.timerpro.casualtimer.presentation.screen_slider_presentation

import android.content.Context
import android.content.res.Configuration
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import com.timerpro.casualtimer.data.shared_data.dimensions.ScreenSliderDimensions
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates
import com.timerpro.casualtimer.presentation.screen_slider_presentation.screen_slider_components.ScreenSliderIndicator
import com.timerpro.casualtimer.presentation.screen_slider_presentation.screen_slider_components.ScreenSliderTopBar
import com.timerpro.casualtimer.presentation.timer_presentation.time_selection_screen.time_selection_screen_components.PresetTimeOptionPanel

@Composable
fun ScreenSlider(
    context: Context,
    configuration: Configuration,
    dimensions: ScreenSliderDimensions = ScreenSliderDimensions(configuration),
    onClick: () -> Unit) {

    // Screen Slider Layout
    if (timerStates.selectedPresetTimeList.isNotEmpty()) {
        PresetTimeOptionPanel(context = context, configuration = configuration)
    } else {
        Column(
            modifier = Modifier
                .pointerInput(Unit) {
                    detectTapGestures(

                        // Transition Between Screens
                        onPress = { onClick() })
                }

                .fillMaxWidth()
                .height(dimensions.screenSliderHeight),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly) {

            // Screen Slider Top Bar
             ScreenSliderTopBar(configuration = configuration)

            // Screen Slider Indicator
            ScreenSliderIndicator(configuration = configuration)
        }
    }
}