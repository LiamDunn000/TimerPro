package com.timerpro.casualtimer.data.casual_timer_screen_data.casual_timer_screen_states

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

// Global Instance Of Shared States
val sharedStates = SharedStates()

class SharedStates: ViewModel() {

    // Start Destination
    var startDestination by mutableStateOf("Stopwatch Screen")

    // Is Screen Slider Clicked
    var isScreenSliderClicked by mutableStateOf(false)

    // Deep Link Uris
    var casualTimerDeepLinkUri = "timer_pro"
    var timeSelectionScreenDeepLinkUri = "time_selection_screen"
    var stopwatchScreenDeepLinkUri = "stopwatch_screen"

    // Full Deep Link Uris
    var fullTimeSelectionScreenDeepLinkUri = "$casualTimerDeepLinkUri://$timeSelectionScreenDeepLinkUri"
    var fullStopwatchScreenDeepLinkUri = "$casualTimerDeepLinkUri://$stopwatchScreenDeepLinkUri"
}