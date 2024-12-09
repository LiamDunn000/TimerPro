package com.timerpro.casualtimer.data.stopwatch_data.stopwatch_states

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.timerpro.casualtimer.data.stopwatch_data.stopwatch_data_classes.LapDisplayPanelData

val stopwatchStates = StopwatchStates()

class StopwatchStates: ViewModel() {

    // Stopwatch Active States
    var isStopwatchActive by mutableStateOf(false)
    var isLapStopwatchActive by mutableStateOf(false)
    var isLapStopwatchVisible by mutableStateOf(false)
    var isLapAndResetStopwatchButtonVisible by mutableStateOf(false)
    var isStopwatchServiceActive by mutableStateOf(false)

    // Lap List States
    val laps = mutableStateListOf<LapDisplayPanelData>()
    var isLapTimeListVisible by mutableStateOf(false)

    //  Current Stopwatch Time States
    var currentStopwatchMilliseconds by mutableIntStateOf(0)
    var currentStopwatchSeconds by mutableIntStateOf(0)
    var currentStopwatchMinutes by mutableIntStateOf(0)
    var currentStopwatchHours by mutableIntStateOf(0)

    // Lap Stopwatch Time States
    var lapStopwatchMilliseconds by mutableIntStateOf(0)
    var lapStopwatchSeconds by mutableIntStateOf(0)
    var lapStopwatchMinutes by mutableIntStateOf(0)
    var lapStopwatchHours by mutableIntStateOf(0)

}