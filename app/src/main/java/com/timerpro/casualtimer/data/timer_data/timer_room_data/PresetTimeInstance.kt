package com.timerpro.casualtimer.data.timer_data.timer_room_data

import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates
import com.timerpro.timertest.data.PresetTime

class PresetTimeInstance{

    // Preset Time Instance
    val presetTimeInstance = PresetTime(
        name = timerStates.presetTimeTitleTextFieldValue,
        seconds = timerStates.presetSecondInput.text.toIntOrNull() ?: 0,
        minutes = timerStates.presetMinuteInput.text.toIntOrNull() ?: 0,
        hours = timerStates.presetHourInput.text.toIntOrNull() ?: 0)
}