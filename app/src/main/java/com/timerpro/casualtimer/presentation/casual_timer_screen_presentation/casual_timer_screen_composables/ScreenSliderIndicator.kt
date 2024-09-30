package com.timerpro.casualtimer.presentation.casual_timer_screen_presentation.casual_timer_screen_composables

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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.timerpro.casualtimer.data.casual_timer_screen_data.casual_timer_screen_states.casualTimerScreenStates
import com.timerpro.casualtimer.data.casual_timer_screen_data.casual_timer_screen_colors.CasualTimerScreenColors

@Composable
fun ScreenSliderIndicator(
    width: Int,
    height: Int,
) {

    // Screen Slider Indicator Layout
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height.dp),
    ){

        // Screen Slider Indicator
        Box(
            modifier = Modifier

                // Conditional That Toggles Screen Slider Indicator Position
                .offset(x = animateDpAsState( targetValue =
                when { casualTimerScreenStates.isScreenSliderClicked ->
                    width.dp * 0.5f else -> 0.dp}).value)

                .clip(shape = RoundedCornerShape(10.dp))
                .background(color = CasualTimerScreenColors().screenSliderIndicatorColor)
                .fillMaxWidth(0.5f)
                .fillMaxHeight())
    }
}