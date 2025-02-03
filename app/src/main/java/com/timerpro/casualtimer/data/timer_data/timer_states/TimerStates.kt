package com.timerpro.casualtimer.data.timer_data.timer_states

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import com.timerpro.timertest.data.PresetTime

val timerStates = TimerStates()

class TimerStates: ViewModel() {

    // Time Input Text Field Values
    var secondInput by  mutableStateOf(TextFieldValue("0"))
    var minuteInput by  mutableStateOf(TextFieldValue("0"))
    var hourInput by  mutableStateOf(TextFieldValue("0"))

    // Preset Time Input Text Field Values
    var presetSecondInput by  mutableStateOf(TextFieldValue("0"))
    var presetMinuteInput by  mutableStateOf(TextFieldValue("0"))
    var presetHourInput by  mutableStateOf(TextFieldValue("0"))

    // Time Remaining Variables
    var secondsRemaining by mutableIntStateOf(0)
    var minutesRemaining by mutableIntStateOf(0)
    var hoursRemaining by mutableIntStateOf(0)

    //  Negative Time Remaining Variables
    var secondsSinceTimerEnded by mutableIntStateOf(0)
    var minutesSinceTimerEnded by mutableIntStateOf(0)
    var hoursSinceTimerEnded by mutableIntStateOf(0)

    // Timer Variables
    var isTimerActive by mutableStateOf(false)
    var isTimerScreenVisible by mutableStateOf(false)
    var isTimeUp by mutableStateOf(false)

    // Time Text Field Focus Requesters
    var secondsFocusRequester =  FocusRequester()
    var minutesFocusRequester = FocusRequester()
    var hoursFocusRequester = FocusRequester()

    // Preset Time Text Field Focus Requesters
    var presetSecondsFocusRequester = FocusRequester()
    var presetMinutesFocusRequester = FocusRequester()
    var presetHoursFocusRequester = FocusRequester()

    // Time Text Field Focus States
    var isSecondsTextFieldFocused by  mutableStateOf(false)
    var isMinutesTextFieldFocused by mutableStateOf(false)
    var isHoursTextFieldFocused by mutableStateOf(false)

    // Preset Time Text Field Focus States
    var isPresetSecondsTextFieldFocused by mutableStateOf(false)
    var isPresetMinutesTextFieldFocused by mutableStateOf(false)
    var isPresetHoursTextFieldFocused by mutableStateOf(false)

    // Timer Button States
    var isStartTimerButtonEnabled by mutableStateOf(false)
    var isCancelButtonClicked by mutableStateOf(false)
    var isToggleTimerActionButtonPressed by mutableStateOf(false)

    // Preset Time Variables
    var isAddPresetTimeDialogOpen by mutableStateOf(false)
    var isPresetTimeOptionPanelVisible by mutableStateOf(false)
    var isPresetTimeBeingEdited by mutableStateOf(false)
    var areChangesMadeToPresetTime by mutableStateOf(false)
    var presetTimeTitleTextFieldValue by mutableStateOf("")
    var presetTimeList by mutableStateOf(listOf<PresetTime>())
    var selectedPresetTimeList by mutableStateOf(listOf<PresetTime>())

    // Default Alarm Sound
    val digitalAlarmClockSoundEffectUri = "android.resource://com.timerpro.casualtimer/raw/digital_alarm_clock_sound_effect"

    // Alarm Sound List
    var alarmSounds = mutableListOf(
        AlarmSound(path = "android.resource://com.timerpro.casualtimer/raw/digital_alarm_clock_sound_effect", name = "Digital"),
        AlarmSound(path = "android.resource://com.timerpro.casualtimer/raw/vintage_alarm_clock_sound_effect", name = "Vintage"),
        AlarmSound(path = "android.resource://com.timerpro.casualtimer/raw/classic_alarm_clock_sound_effect", name = "Classic"),
        AlarmSound(path = "android.resource://com.timerpro.casualtimer/raw/school_bell_sound_effect", name = "School"),
        AlarmSound(path = "android.resource://com.timerpro.casualtimer/raw/jingle_bells_sound_effect", name = "Jingle"))

    // Alarm Variables
    var isAlarmSoundSelectionDialogOpen by mutableStateOf(false)
    var selectedAlarmSound by mutableStateOf(AlarmSound())
    var areChangesMadeToAlarmSound by mutableStateOf(false)

}