package com.timerpro.casualtimer.data.casual_timer_screen_data.casual_timer_screen_colors

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class CasualTimerScreenColors: ViewModel() {

    // Screen Slider Colors
    var screenSliderIndicatorColor by mutableStateOf(Color(0xff455afd))
    var screenSliderTopBarDividerColor by mutableStateOf(Color(0xffb5b5b5))

    // Screen Slider Text Colors
    var screenSliderSelectedTextColor by mutableStateOf(Color(0xff455afd))
    var screenSliderUnselectedTextColor by mutableStateOf(Color(0xffb5b5b5))
}