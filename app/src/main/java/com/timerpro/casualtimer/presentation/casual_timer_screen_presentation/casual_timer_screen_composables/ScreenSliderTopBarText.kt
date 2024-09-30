package com.timerpro.casualtimer.presentation.casual_timer_screen_presentation.casual_timer_screen_composables

import androidx.compose.animation.animateColorAsState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.timerpro.casualtimer.data.casual_timer_screen_data.casual_timer_screen_colors.CasualTimerScreenColors

@Composable
fun ScreenSliderTopBarText(
    text: String,
    fontSize: Int,
    isScreenSliderClicked: Boolean
) {

    Text(
        text = text,

        // Conditional That Determines Screen Slider Top Bar Font Color
        color = animateColorAsState(targetValue =
        when{ isScreenSliderClicked -> CasualTimerScreenColors().screenSliderSelectedTextColor else -> CasualTimerScreenColors().screenSliderUnselectedTextColor}).value,
        fontSize = fontSize.sp,
        fontWeight = FontWeight.SemiBold
    )

}