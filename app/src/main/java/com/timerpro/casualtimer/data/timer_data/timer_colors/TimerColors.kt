package com.timerpro.casualtimer.data.timer_data.timer_colors

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

val timerColors = TimerColors()

class TimerColors: ViewModel() {

    // Start Timer Button Background Colors
    var enabledStartTimerButtonBackgroundColor by mutableStateOf(Color(0xff455afd))
    var disabledStartTimerButtonBackgroundColor by mutableStateOf(Color(0xffd6d6d6))

    // Start Timer Button Font Colors
    var enabledStartTimerButtonFontColor by mutableStateOf(Color(0xffffffff))
    var disabledStartTimerButtonFontColor by mutableStateOf(Color(0xffa3a3a3))

    // Increment & Decrement Button Colors
    var incrementAndDecrementButtonColor by mutableStateOf(Color(0xffffffff))
    var incrementAndDecrementButtonIconColor by mutableStateOf(Color.Black)
    var incrementAndDecrementButtonBorderColor by mutableStateOf(Color.Black)

    // Count Down Timer Button Background Colors
    var resumeTimerButtonBackgroundColor by mutableStateOf(Color(0xff455afd))
    var pauseAndCancelTimerButtonBackgroundColor by mutableStateOf(Color(0xffff3e3e))

    // Times Up Screen Button Background Colors
    var dismissAlarmButtonBackgroundColor by mutableStateOf(Color(0xff455afd))
    var restartTimerButtonFontColor by mutableStateOf(Color(0xffff3e3e))

    // Timer Text Field Color
    var timerTextFieldColor by mutableStateOf(Color.Transparent)

    // Times Up Screen Colors
    var timesUpScreenBackgroundColor by mutableStateOf(Color(0xffffffff))
    var timesUpScreenFontColor by mutableStateOf(Color.Black)

    // Add Preset Time Dialog Colors
    var addPresetTimeDialogBackgroundColor by mutableStateOf(Color(0xffffffff))

    // Add Preset Time Button Colors
    var savePresetTimeButtonBackgroundColor by mutableStateOf(Color(0xff455afd))
    var closeAddPresetTimeDialogButtonBackgroundColor by mutableStateOf(Color(0xffff3e3e))

    // Alarm Sound Selection Dialog Colors
    var alarmSoundSelectionDialogBackgroundColor by mutableStateOf(Color(0xffffffff))

    // Alarm Selection List Colors
    var unselectedTextAndRadioButtonColor by mutableStateOf(Color(0xffa3a3a3))
    var selectedTextAndRadioButtonColor by mutableStateOf(Color(0xff455afd))
}