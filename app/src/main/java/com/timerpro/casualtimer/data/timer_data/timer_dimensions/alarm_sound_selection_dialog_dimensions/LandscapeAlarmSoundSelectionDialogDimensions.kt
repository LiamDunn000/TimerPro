package com.timerpro.casualtimer.data.timer_data.timer_dimensions.alarm_sound_selection_dialog_dimensions

import android.content.res.Configuration
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import com.timerpro.casualtimer.data.shared_data.ScreenDimensions

class LandscapeAlarmSoundSelectionDialogDimensions(configuration: Configuration) {

    // Portrait Alarm Sound Selection Dialog Dimensions
    var landscapeAlarmSoundSelectionDialogWidth by mutableIntStateOf((ScreenDimensions(configuration).screenWidth * 0.85).toInt())
    var landscapeAlarmSoundSelectionDialogHeight by mutableIntStateOf((landscapeAlarmSoundSelectionDialogWidth * 0.50).toInt())

    // Landscape Alarm Sound Selection Dialog Padding
    var landscapeAlarmSoundSelectionDialogHorizontalPadding by mutableIntStateOf((landscapeAlarmSoundSelectionDialogWidth * 0.09).toInt())
    var landscapeAlarmSoundSelectionDialogVerticalPadding by mutableIntStateOf((landscapeAlarmSoundSelectionDialogHeight * 0.01).toInt())

    // Landscape Alarm Sound Selection Dialog Font Dimensions
    var landscapeAlarmSoundSelectionDialogHeaderFontSize by mutableIntStateOf((landscapeAlarmSoundSelectionDialogWidth * 0.026).toInt())
    var landscapeAlarmSoundNameFontSize by mutableIntStateOf((landscapeAlarmSoundSelectionDialogWidth * 0.028).toInt())

    // Landscape Alarm Sound Selection Dialog Radio Button Dimensions
    var landscapeAlarmSoundSelectionRadioButtonSize by mutableIntStateOf((ScreenDimensions(configuration).screenWidth * 0.033).toInt())
    var landscapeAlarmSoundSelectionRadioButtonBorderWidth by mutableIntStateOf((landscapeAlarmSoundSelectionRadioButtonSize * 0.13).toInt())

    // Landscape Alarm Sound Selection List Spacing
    var landscapeAlarmSoundSelectionListSpacing by mutableIntStateOf((landscapeAlarmSoundSelectionDialogHeight * 0.04).toInt())

    // Landscape Close Alarm Sound Selection Dialog Button Dimensions
    var landscapeCloseAlarmSoundSelectionDialogButtonWidth by mutableIntStateOf((landscapeAlarmSoundSelectionDialogWidth * 0.25).toInt())
    var landscapeCloseAlarmSoundSelectionDialogButtonHeight by mutableIntStateOf((landscapeCloseAlarmSoundSelectionDialogButtonWidth * 0.25).toInt())
    var landscapeCloseAlarmSoundSelectionDialogButtonFontSize by mutableIntStateOf((landscapeCloseAlarmSoundSelectionDialogButtonHeight * 0.38).toInt())
}