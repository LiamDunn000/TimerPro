package com.timerpro.casualtimer.data.stopwatch_data.stopwatch_colors

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class StopwatchColors: ViewModel() {

        // Stopwatch Screen Background Color
        var stopwatchScreenBackgroundColor by mutableStateOf(Color.White)

        // Time Display Font Colors
        var currentStopwatchTimeDisplayFontColor by mutableStateOf(Color.Black)
        var lapStopwatchTimeDisplayFontColor by mutableStateOf(Color.Gray)

        // Toggle Button Background Colors
        var startStopwatchButtonBackgroundColor by mutableStateOf(Color(0xff455afd))
        var pauseStopwatchButtonBackgroundColor by mutableStateOf(Color(0xffff3e3e))

        // Lap And Reset Button Background Colors
        var lapStopwatchButtonBackgroundColor by mutableStateOf(Color(0xff455afd))
        var resetStopwatchButtonBackgroundColor by mutableStateOf(Color(0xffff3e3e))

        // Button Font Colors
        var stopwatchButtonFontColor by mutableStateOf(Color.White)

        var lapDisplayListHeaderDividerColor by mutableStateOf(Color.Gray)
}