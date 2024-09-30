package com.timerpro.casualtimer.presentation.casual_timer_screen_presentation.casual_timer_screen_composables

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
import androidx.compose.ui.unit.dp
import com.timerpro.casualtimer.data.casual_timer_screen_data.casual_timer_screen_states.casualTimerScreenStates
import com.timerpro.casualtimer.data.casual_timer_screen_data.casual_timer_screen_colors.CasualTimerScreenColors

@Composable
fun ScreenSliderTopBar(
    fontSize: Int,
    dividerWidth: Int,
    dividerHeight: Int) {

    // Screen Slider Top Bar Layout
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {

        // Screen Slider Top Bar Stopwatch Text
        ScreenSliderTopBarText(
            text = "Stopwatch",
            fontSize = fontSize,
            isScreenSliderClicked = !casualTimerScreenStates.isScreenSliderClicked
        )

        // Screen Slider Top Bar Divider
        Box(
            modifier = Modifier
                .width(dividerWidth.dp)
                .height(dividerHeight.dp)
                .background(color = CasualTimerScreenColors().screenSliderTopBarDividerColor)
        )

        // Screen Slider Top Bar Timer Text
        ScreenSliderTopBarText(
            text = "    Timer    ",
            fontSize = fontSize,
            isScreenSliderClicked = casualTimerScreenStates.isScreenSliderClicked)
    }
}
