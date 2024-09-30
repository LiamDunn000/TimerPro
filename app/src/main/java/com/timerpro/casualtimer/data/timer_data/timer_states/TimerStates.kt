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
    val secondsFocusRequester =  FocusRequester()
    val minutesFocusRequester = FocusRequester()
    val hoursFocusRequester = FocusRequester()

    // Preset Time Text Field Focus Requesters
    val presetSecondFocusRequester = FocusRequester()
    val presetMinutesFocusRequester = FocusRequester()
    val presetHoursFocusRequester = FocusRequester()

    // Time Text Field Focus States
    var isSecondTextFieldFocused by  mutableStateOf(false)
    var isMinutesTextFieldFocused by mutableStateOf(false)
    var isHoursTextFieldFocused by mutableStateOf(false)

    // Preset Time Text Field Focus States
    var isPresetSecondTextFieldFocused by mutableStateOf(false)
    var isPresetMinutesTextFieldFocused by mutableStateOf(false)
    var isPresetHourTextFieldFocused by mutableStateOf(false)

    // Timer Button States
    var isStartTimerButtonEnabled by mutableStateOf(false)
    var isCancelButtonClicked by mutableStateOf(false)
    var toggleTimerButtonText by mutableStateOf("Pause")
    var isToggleTimerActionButtonPressed by mutableStateOf(false)

    // Preset Time Variables
    var isAddPresetTimeDialogOpen by mutableStateOf(false)
    var presetTimeNameTextFieldValue by mutableStateOf("")
    var presetTimeList by mutableStateOf(listOf<PresetTime>())

    // Edit Preset Time Variables
    var deleteAndCancelPresetTimeButtonText by mutableStateOf("Delete")

    // Sound Effect URIs
    val digitalAlarmClockSoundEffectUri = "android.resource://com.timerpro.casualtimer/raw/digital_alarm_clock_sound_effect"
    val vintageAlarmClockSoundEffectUri = "android.resource://com.timerpro.casualtimer/raw/vintage_alarm_clock_sound_effect"
    val classicAlarmClockSoundEffectUri = "android.resource://com.timerpro.casualtimer/raw/classic_alarm_clock_sound_effect"
    val schoolBellSoundEffectUri = "android.resource://com.timerpro.casualtimer/raw/school_bell_sound_effect"
    val jingleBellsSoundEffectUri = "android.resource://com.timerpro.casualtimer/raw/jingle_bells_sound_effect"

    // Alarm Variables
    var isAlarmSoundSelectionDialogOpen by mutableStateOf(false)
    var alarmSoundNames = listOf("Digital", "Vintage", "Classic", "School", "Jingle")
    var selectedAlarmSoundName by mutableStateOf(alarmSoundNames[0])
    var selectedAlarmSound by mutableStateOf(digitalAlarmClockSoundEffectUri)

}